package com.example.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    private static final Logger log = LoggerFactory.getLogger(EmployeeConfig.class);
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repo){
        return args -> {
            log.info("Preloading " + repo.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repo.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}
