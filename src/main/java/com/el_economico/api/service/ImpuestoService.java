package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.ImpuestoPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface ImpuestoService {
    @Transactional
    ResponseEntity<ApiResponse> getAll();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertImpuesto(ImpuestoPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putImpuesto(ImpuestoPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(ImpuestoPOST e, int id);
}
