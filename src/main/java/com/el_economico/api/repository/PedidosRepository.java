package com.el_economico.api.repository;

import com.el_economico.api.model.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    @Procedure("pedidosGetAll")
    List<Pedidos> getAll();
}
