package com.zxclown.learning.statemachine.config;

import com.zxclown.learning.statemachine.listener.LocalPersistStateChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

/**
 * The type Claim config.
 */
@Configuration
@Slf4j
public class ClaimConfig {


    @Bean
    public Action<String, String> action() {
        return stateContext -> log.info("=================Do Action : {} -- {} --> {} ", stateContext.getSource().getId(), stateContext.getEvent(), stateContext.getTarget().getId());
    }

    @Bean
    public PersistStateMachineHandler.PersistStateChangeListener persistStateChangeListener() {
        return new LocalPersistStateChangeListener();
    }
}
