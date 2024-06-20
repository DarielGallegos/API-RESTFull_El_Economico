package com.el_economico.api.repository;

import com.el_economico.api.model.entity.Categoria_Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Categoria_ProductosRepository extends JpaRepository<Categoria_Productos, Integer> {
    @Procedure("categoriaGetAll")
    List<Categoria_Productos> getAll();

    @Procedure("categoriaInsert")
    void categoriaInsert(@Param("i_nombre") String nombre, @Param("i_creado_por") String creado_por,@Param("i_estado") Integer estado);

    @Procedure("categoriaPut")
    void categoriaPut(@Param("p_nombre")String nombre, @Param("p_modificado_por") String modificado_por, @Param("p_estado") Integer estado, @Param("p_id") Integer id);

    @Procedure("categoriaChangeStatus")
    void categoriaChangeStatus(@Param("c_modificado_por") String modificado_por,@Param("c_estado") Integer estado,@Param("c_id") Integer id);
}
