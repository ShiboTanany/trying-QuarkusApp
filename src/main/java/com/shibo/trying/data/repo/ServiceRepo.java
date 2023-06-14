package com.shibo.trying.data.repo;

import com.shibo.trying.data.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceRepo implements PanacheRepository<Service> {

}
