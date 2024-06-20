package com.el_economico.api.repository;

import com.el_economico.api.model.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
    @Procedure("almacenGetAll")
    List<Almacen> getAll();

    @Procedure("almacenInsert")
    void almacenInsert(@Param("i_id_producto") int idProducto, @Param("i_cantidad") int cantidad,
                        @Param("i_creado_por") String creadoPor, @Param("i_estado") int estado);

    @Procedure("almacenPut")
    void almacenPut(@Param("p_id_producto") int idProducto, @Param("p_cantidad") int cantidad,
                    @Param("p_modificado_por") String modificadoPor, @Param("p_estado") int estado, @Param("p_id") int id);

    @Procedure("almacenChangeStatus")
    void almacenChangeStatus(@Param("p_modificado_por") String modificadoPor, @Param("p_estado") int estado, @Param("p_id") int id);
}
