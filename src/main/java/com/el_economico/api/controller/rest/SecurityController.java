package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.CredencialesLogin;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.CredencialesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/security")
public class SecurityController {

    @Autowired
    private CredencialesServiceImpl service;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> login(@RequestBody CredencialesLogin e){
        return this.service.login(e);
    }
}
