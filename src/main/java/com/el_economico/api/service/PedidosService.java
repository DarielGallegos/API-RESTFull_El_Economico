package com.el_economico.api.service;

import com.el_economico.api.model.DTO.POST.PedidoPOST;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface PedidosService<T> {
    @Transactional
    ResponseEntity<T> getAll();

    @Transactional
    @Modifying
    ResponseEntity<T> insertPedido(PedidoPOST e);

    @Transactional
    ResponseEntity<T> getPedidoById(int id);

    @Transactional
    ResponseEntity<T> getDetallePedido(int pedidoNumero);

    @Transactional
    ResponseEntity<T> getPedidosUnsigned();

    @Transactional
    ResponseEntity<T> getCabeceraPedido(int pedidoNumero);

    @Transactional
    ResponseEntity<T> getAllPedidoForRepartidor(int idUsuario);

    @Transactional
    @Modifying
    ResponseEntity<T> pedidosChangeUser(int idPedido, int idUsuario);

    @Transactional
    @Modifying
    ResponseEntity<T> pedidoFinalizado(int numPedido);

    @Transactional
    @Modifying
    ResponseEntity<T> pedidosChangeState(int idPedido);

    @Transactional
    ResponseEntity<T> getPedidosEntregados();

    @Transactional
    ResponseEntity<T> getPedidosPendientes();
    
    @Transactional
    ResponseEntity<T> getPedidosSValorar(int idCliente);
}
