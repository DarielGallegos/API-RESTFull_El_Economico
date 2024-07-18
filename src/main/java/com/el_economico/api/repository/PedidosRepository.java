package com.el_economico.api.repository;

import com.el_economico.api.model.DTO.REQUEST.CabeceraPedidoReq;
import com.el_economico.api.model.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    @Procedure("pedidosGetAll")
    List<Pedidos> getAll();

    @Procedure("pedidosInsert")
    void pedidosInsert( @Param("i_id_usuario") int idUsuario, @Param("i_id_cliente") int idCliente,
                         @Param("i_id_producto") int idProducto, @Param("i_destino") String destino,
                         @Param("i_cantidad") int cantidad, @Param("i_monto") float monto,
                         @Param("i_id_impuesto") int idImpuesto, @Param("i_subtotal") float subtotal,
                         @Param("i_envio") float envio, @Param("i_total") float total,
                         @Param("i_estado_pedido") String estadoPedido, @Param("i_creado_por") String creadoPor,
                         @Param("i_estado") int estado);


    @Transactional
    @Modifying
    @Procedure("pedidosInsertC")
    void pedidosInsertC( @Param("i_pedido_numero") int numPedido,
                        @Param("i_id_usuario") int idUsuario, @Param("i_id_cliente") int idCliente,
                       @Param("i_id_producto") int idProducto, @Param("i_destino") String destino,
                       @Param("i_cantidad") int cantidad, @Param("i_monto") float monto,
                       @Param("i_id_impuesto") int idImpuesto, @Param("i_subtotal") float subtotal,
                       @Param("i_envio") float envio, @Param("i_total") float total,
                       @Param("i_estado_pedido") String estadoPedido, @Param("i_creado_por") String creadoPor,
                       @Param("i_estado") int estado);

    @Transactional(noRollbackFor = Exception.class)
    @Procedure("getLastId")
    int pedidoLastId();

    @Procedure("getPedidosActivos")
    List<Object[]> pedidosGetByClient(@Param("i_id_cliente") int idCliente);
}
