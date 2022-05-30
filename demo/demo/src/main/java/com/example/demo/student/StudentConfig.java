package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student arpit=new Student("Arpit", LocalDate.of(2001, Month.MAY,20),"setharpit11@gmail.com");
            Student raghav=new Student("Raghav", LocalDate.of(2002, Month.JUNE,19),"hello@gmail.com");
            repository.saveAll(List.of(arpit,raghav));
        };
    }
}
