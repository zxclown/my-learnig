package com.zxclown.learning.statemachine.builder;

import com.zxclown.learning.statemachine.constants.ClaimEvents;
import com.zxclown.learning.statemachine.constants.ClaimStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClaimMachineBuilder {
    public static final String MACHINE_ID = "claimMachine";
    @Autowired
    private Action<String, String> action;

    public StateMachine<String, String> build() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();
        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINE_ID)
                .autoStartup(true);
        builder.configureStates()
                .withStates()
                .initial(ClaimStates.IN_REPORTING)
                .end(ClaimStates.END)
                .states(ClaimStates.STATES);
        builder.configureTransitions()
                .withInternal().source(ClaimStates.IN_REPORTING)
                .event(ClaimEvents.REPORT_APPLICATION_TEMP_SAVE).action(action)
                .and()
                .withExternal().source(ClaimStates.IN_REPORTING).target(ClaimStates.REPORTED)
                .event(ClaimEvents.REPORT_APPLICATION).action(action)
                .and()
                .withExternal().source(ClaimStates.REPORTED).target(ClaimStates.IN_REGISTERING)
                .event(ClaimEvents.REGISTER_APPLICATION_TEMP_SAVE).action(action)
                .and()
                .withInternal().source(ClaimStates.IN_REGISTERING)
                .event(ClaimEvents.REGISTER_APPLICATION_TEMP_SAVE).action(action)
                .and()
                .withExternal().source(ClaimStates.IN_REGISTERING).target(ClaimStates.REGISTERED)
                .event(ClaimEvents.REGISTER_APPLICATION).guard(registerGuard()).action(action)
                .and()
                .withExternal().source(ClaimStates.CANCELED).target(ClaimStates.END)
                .event(ClaimEvents.END);
        return builder.build();
    }

    public Guard<String, String> registerGuard(){
        return stateContext -> {
            log.info("==================== guard");
            return false;
        };
    }
}
