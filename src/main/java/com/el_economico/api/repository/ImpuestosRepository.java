package com.el_economico.api.repository;


import com.el_economico.api.model.entity.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpuestosRepository extends JpaRepository<Impuesto, Integer> {
    @Procedure("impuestosGetAll")
    List<Impuesto> getAll();

    @Procedure("impuestosInsert")
    int impuestosInsert(@Param("i_nombre") String nombre, @Param("i_impuestos") float impuestos, @Param("i_creador_por") String creadoPor, @Param("i_estado") int estado);

    @Procedure("impuestosPut")
    void impuestosPut(@Param("p_nombre") String nombres, @Param("p_impuestos") float impuestos, @Param("p_modificado_por") String modificadoPor, @Param("p_estado") int estado, @Param("p_id") int id);

    @Procedure("impuestosChangeStatus")
    void impuestosChangeStatus(@Param("c_modificado_por") String modificadoPor, @Param("c_estado") int estado, @Param("c_id") int id);
}
