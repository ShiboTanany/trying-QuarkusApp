package com.shibo.trying;

import com.shibo.trying.data.entity.Service;
import com.shibo.trying.data.repo.ServiceRepo;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.stream.Stream;

@QuarkusMain
public class QuarkusApp implements QuarkusApplication {
    GreetingUtil greetingUtil;
    ServiceRepo serviceRepo;

    public QuarkusApp(GreetingUtil greetingUtil, ServiceRepo serviceRepo) {
        this.greetingUtil = greetingUtil;
        this.serviceRepo = serviceRepo;
    }

    @ActivateRequestContext
    @Override
    @Transactional
    public int run(String... args) throws Exception {
        System.out.println(this.greetingUtil.getGreeting());
        System.out.println(serviceRepo.count());
        //serviceRepo.getAllServices().forEach(System.out::println);
        serviceRepo.findAll().list().forEach(System.out::println);
        Service service = new Service();
        service.setName("test");
        service.setPrice(BigDecimal.valueOf(6.5));
        serviceRepo.persist(Stream.of(service));

        System.out.println(serviceRepo.count());
        return 0;
    }
}
