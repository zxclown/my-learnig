package com.zxclown.learning.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author za-zhangxin002
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zxclown.learning.statemachine.dao")
@EntityScan(basePackages = "com.zxclown.learning.statemachine.bean")
public class LearningSpringStatemachineApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningSpringStatemachineApplication.class, args);
    }
}
