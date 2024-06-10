package com.el_economico.api.service.impl;

import com.el_economico.api.model.entity.Roles;
import com.el_economico.api.repository.RolesRepository;
import com.el_economico.api.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository repository;
    private final RolesService service;

    public RolesServiceImpl(@Lazy RolesRepository repository, @Lazy RolesService service){
        this.repository = repository;
        this.service = service;
    }

    @Override
    public ResponseEntity<Iterable<Roles>> getRoles() {
        return ResponseEntity.ok().body(this.repository.findAll());
    }
}
