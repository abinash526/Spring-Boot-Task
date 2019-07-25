package com.stackroute.springBoot;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironComponent implements EnvironmentAware {
    private String message;

    public String getMessage() {
        return message;
    }

    public EnvironComponent setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.message= environment.getProperty("spring.datasource.url");

    }
}
