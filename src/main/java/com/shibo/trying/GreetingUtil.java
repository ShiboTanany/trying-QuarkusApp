package com.shibo.trying;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingUtil {
    @ConfigProperty(name = "greeting.name", defaultValue = "shibo")
    String greeting;


    public String getGreeting() {
        return "hello " + greeting;
    }
}


