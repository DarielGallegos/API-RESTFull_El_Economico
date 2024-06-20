package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.Categoria_ProductosPOST;
import com.el_economico.api.model.DTO.REQUEST.Categoria_ProductosReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.Categoria_ProductosMapper;
import com.el_economico.api.repository.Categoria_ProductosRepository;
import com.el_economico.api.service.Categoria_ProductosService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Categoria_ProductosServiceImpl implements Categoria_ProductosService {

    private Categoria_ProductosRepository repository;
    private Categoria_ProductosMapper mapper;

    public Categoria_ProductosServiceImpl (@Lazy Categoria_ProductosRepository repository,
                                           @Lazy Categoria_ProductosMapper mapper){
    this.repository = repository;
    this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<Categoria_ProductosReq> list= mapper.toCategoria_ProductosReq(this.repository.getAll());
        List<String> msg=new ArrayList<>();
        if(list.size()>0){
            msg.clear();
            msg.add("Registro encontrado");
        }else{
            msg= List.of("No hay registro encontrado");
        }
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK, msg,list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertCategoria(Categoria_ProductosPOST e) {
        this.repository.categoriaInsert(e.getNombre(), e.getCreado_por(),e.getEstado());

        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.CREATED, List.of("Registro insertado exitosamente"),null));
    }

    @Override
    public ResponseEntity<ApiResponse> putCategoria(Categoria_ProductosPOST e, int id) {
        if(this.repository.existsById(id)){
            this.repository.categoriaPut(e.getNombre(), e.getModificado_por(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado el registro"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(Categoria_ProductosPOST e, int id) {
        if (this.repository.existsById(id)) {
            this.repository.categoriaChangeStatus(e.getModificado_por(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha cambiado el estado del registro"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }
}
