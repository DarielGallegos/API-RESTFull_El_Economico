package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.RolPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


public interface RolesService {

    @Transactional
    ResponseEntity<ApiResponse> getRoles();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertRol(RolPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putRol(RolPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(RolPOST e, int id);
}
