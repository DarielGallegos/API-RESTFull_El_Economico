package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.CredencialesLogin;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface CredencialesService {
    @Transactional
    ResponseEntity<ApiResponse> login(CredencialesLogin e);
}
