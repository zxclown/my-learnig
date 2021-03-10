package com.zxclown.learning.statemachine.listener;

import com.zxclown.learning.statemachine.bean.StateFlow;
import com.zxclown.learning.statemachine.dao.StateFlowDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

/**
 * @author za-zhangxin002
 */
@Slf4j
public class LocalPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {
    @Autowired
    private StateFlowDao stateFlowDao;

    @Override
    public void onPersist(State<String, String> state, Message<String> message, Transition<String, String> transition, StateMachine<String, String> stateMachine) {
        if (message != null && message.getHeaders().containsKey("stateFlow")) {
            StateFlow stateFlow = message.getHeaders().get("stateFlow", StateFlow.class);
            stateFlow.setState(state.getId());
            stateFlowDao.saveAndFlush(stateFlow);
        }
    }
}
