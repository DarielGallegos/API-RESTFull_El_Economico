package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.AlmacenPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AlmacenService {
    @Transactional
    ResponseEntity<ApiResponse> getAll();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertAlmacen(AlmacenPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putAlmacen(AlmacenPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(AlmacenPOST e, int id);
}
