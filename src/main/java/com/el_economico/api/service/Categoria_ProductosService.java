package com.el_economico.api.service;


import com.el_economico.api.model.DTO.POST.Categoria_ProductosPOST;
import com.el_economico.api.model.common.ApiResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface Categoria_ProductosService {
    @Transactional
    ResponseEntity<ApiResponse> getAll();

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> insertCategoria(Categoria_ProductosPOST e);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> putCategoria(Categoria_ProductosPOST e, int id);

    @Transactional
    @Modifying
    ResponseEntity<ApiResponse> changeStatus(Categoria_ProductosPOST e, int id);

}
