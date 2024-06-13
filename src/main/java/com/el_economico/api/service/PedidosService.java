package com.el_economico.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface PedidosService<T> {
    @Transactional
    ResponseEntity<T> getAll();
}
