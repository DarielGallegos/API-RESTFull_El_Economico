package com.el_economico.api.repository;

import com.el_economico.api.model.entity.Impuesto;
import com.el_economico.api.model.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    @Procedure("productosGetAll")
    List<Productos> getAll();

    @Procedure("productosInsert")
    void productosInsert(@Param("i_producto") String producto,
                @Param("i_cod_producto") String cod_producto,
                @Param("i_id_categoria") int id_categoria,
                @Param("i_marca") String marca,
                @Param("i_foto") String foto,
                @Param("i_precio") float precio,
                @Param("i_stock_min") int stock_min,
                @Param("i_stock_max") int stock_max,
                @Param("i_creado_por") String creado_por,
                @Param("i_estado") int estado,
                         @Param("i_descripcion") String descripcion);

    @Procedure("productosPut")
    void productosPut(@Param("p_producto") String producto, @Param("p_cod_producto") String cod_producto,
                      @Param("p_id_categoria") int id_categoria, @Param("p_marca") String marca,
                      @Param("p_foto") String foto,
                      @Param("p_precio") float precio,
                      @Param("p_stock_min") int stock_min, @Param("p_stock_max") int stock_max,
                      @Param("p_modificado_por") String modificado_por, @Param("p_estado") int estado,
                      @Param("p_id") int id,
                      @Param("p_descripcion") String descripcion);

    @Procedure("productosChangeStatus")
    void productosChangeStatus( @Param("p_modificado_por") String modificado_por,
                                @Param("p_estado") int estado,
                                @Param("p_id") int id);


}


