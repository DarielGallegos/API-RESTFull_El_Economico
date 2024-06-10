package com.el_economico.api.service;

import com.el_economico.api.model.entity.Roles;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RolesService {
    ResponseEntity<Iterable<Roles>> getRoles();
}
