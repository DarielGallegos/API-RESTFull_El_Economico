package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.ProductosPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ProductosService {
    @Transactional
    ResponseEntity<ApiResponse> getAll();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertProductos(ProductosPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putProductos(ProductosPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(ProductosPOST e, int id);

}
