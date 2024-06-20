package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.ProductosPOST;
import com.el_economico.api.model.DTO.REQUEST.ProductosReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.entity.Productos;
import com.el_economico.api.model.mapper.ProductosMapper;
import com.el_economico.api.repository.ProductosRepository;
import com.el_economico.api.service.ProductosService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {
    private ProductosRepository repository;
    private ProductosMapper mapper;
    public ProductosServiceImpl(@Lazy ProductosRepository repository, @Lazy ProductosMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<ProductosReq> list = mapper.toProductosReq(this.repository.getAll());
        List<String> msg = new ArrayList<>();
        if (list.size() > 0){
            msg.add("Registros encontrados");
        }else{
            msg.add("NO SE ENCONTRARON REGISTROS");
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertProductos(ProductosPOST e) {
        this.repository.productosInsert(e.getProducto(),
                e.getCod_producto(),
                e.getId_categoria(),
                e.getMarca(),
                e.getFoto(),
                e.getPrecio(),
                e.getStock_min(),
                e.getStock_max(),
                e.getCreado_por(),
                e.getEstado());
        List<String> msg = List.of("SE HA INSERTADO CORRECTAMENTE");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, msg, null));

    }

    @Override
    public ResponseEntity<ApiResponse> putProductos(ProductosPOST e, int id) {
        if (this.repository.existsById(id)){
            this.repository.productosPut(e.getProducto(),
                    e.getCod_producto(),
                    e.getId_categoria(),
                    e.getMarca(),
                    e.getFoto(),
                    e.getPrecio(),
                    e.getStock_min(),
                    e.getStock_max(),
                    e.getModificado_por(),
                    e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado correctamente."), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el regiatro"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(ProductosPOST e, int id) {
        if (this.repository.existsById(id)){
            this.repository.productosChangeStatus(e.getModificado_por(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha cambiado el estado correctamente."), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el regiatro"), null));

    }

}
