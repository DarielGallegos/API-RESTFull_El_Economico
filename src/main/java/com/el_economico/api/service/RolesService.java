package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.Rol;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


public interface RolesService {

    @Transactional
    ResponseEntity<ApiResponse> getRoles();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertRol(Rol e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putRol(Rol e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(Rol e, int id);
}
