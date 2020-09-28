package com.zxclown.learning.statemachine.controller;

import com.zxclown.learning.statemachine.bean.StateFlow;
import com.zxclown.learning.statemachine.builder.ClaimMachineBuilder;
import com.zxclown.learning.statemachine.dao.StateFlowDao;
import com.zxclown.learning.statemachine.listener.LocalPersistStateChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {
    @Autowired
    private ClaimMachineBuilder claimMachineBuilder;
    @Autowired
    private StateFlowDao stateFlowDao;
    @Autowired
    private PersistStateMachineHandler.PersistStateChangeListener listener;

    @PostMapping("start/{bizNo}")
    public Long start(@PathVariable String bizNo) {
        StateMachine<String, String> claimMachine = null;
        try {
            claimMachine = claimMachineBuilder.build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        if (claimMachine != null) {
            StateFlow stateFlow = new StateFlow();
            stateFlow.setBizNo(bizNo);
            stateFlow.setMachineId(claimMachine.getId());
            stateFlow.setState(claimMachine.getState().getId());
            StateFlow save = stateFlowDao.save(stateFlow);
            return save.getId();
        }
        return 0L;
    }

    @PostMapping("/process/{id}/{event}")
    public String process(@PathVariable Long id, @PathVariable String event) {
        Optional<StateFlow> optional = stateFlowDao.findById(id);
        if (optional.isPresent()) {
            StateFlow stateFlow = optional.get();
            try {
                StateMachine<String, String> machine = claimMachineBuilder.build();
                PersistStateMachineHandler persistStateMachineHandler = new PersistStateMachineHandler(machine);
                persistStateMachineHandler.afterPropertiesSet();
                persistStateMachineHandler.start();
                persistStateMachineHandler.addPersistStateChangeListener(listener);
                persistStateMachineHandler.handleEventWithState(MessageBuilder.withPayload(event)
                        .setHeader("stateFlow", stateFlow)
                        .build(), stateFlow.getState());
                return machine.getState().getId();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "failed";
    }
}
