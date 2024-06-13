package com.el_economico.api.repository;

import com.el_economico.api.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolesRepository  extends JpaRepository<Roles, Integer>{

    @Procedure("rolGetAll")
    List<Roles> getAllProcedure();

    @Procedure("rolInsert")
    void insertProcedure(@Param("i_nombre") String nombre, @Param("i_creado") String creadoPor, @Param("i_estado") int estado);

    @Procedure("rolPut")
    void putProcedure(@Param("p_nombre") String nombre, @Param("p_modificado_por") String modificadoPor, @Param("p_estado") int estado, @Param("p_id") int id);

    @Procedure("rolChangeStatus")
    void changeStatus(@Param("c_modificado_por") String modificadoPor, @Param("c_estado") int estado, @Param("c_id") int id);
}
