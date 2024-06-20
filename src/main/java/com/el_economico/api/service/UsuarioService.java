package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.UsuarioPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UsuarioService {

    @Transactional
    ResponseEntity<ApiResponse> getAll();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertUsuario(UsuarioPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putUsuario(UsuarioPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(UsuarioPOST e, int id);


}
