package com.shibo.trying;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusApp implements QuarkusApplication {
    GreetingUtil greetingUtil;

    public QuarkusApp(GreetingUtil greetingUtil) {
        this.greetingUtil = greetingUtil;
    }


    @Override
    public int run(String... args) throws Exception {
        System.out.println(this.greetingUtil.getGreeting());

        return 0;
    }
}
