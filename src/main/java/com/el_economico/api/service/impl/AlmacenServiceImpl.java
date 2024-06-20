package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.AlmacenPOST;
import com.el_economico.api.model.DTO.REQUEST.AlmacenReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.AlmacenMapper;
import com.el_economico.api.model.mapper.ProductosMapper;
import com.el_economico.api.repository.AlmacenRepository;
import com.el_economico.api.repository.ProductosRepository;
import com.el_economico.api.service.AlmacenService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AlmacenServiceImpl implements AlmacenService {
    private AlmacenRepository repository;
    private AlmacenMapper mapper;
    public AlmacenServiceImpl(@Lazy AlmacenRepository repository, @Lazy AlmacenMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll(){
        List<AlmacenReq> list = mapper.toAlmacenReq(this.repository.getAll());
        List<String> msg = new ArrayList<>();
        if (list.size() > 0){
            msg.add("REGISTROS ENCONTRADOS");
        }else {
            msg.add("NO SE ENCONTRARON REGISTROS");
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertAlmacen(AlmacenPOST e) {
        this.repository.almacenInsert(e.getIdProducto(), e.getCantidad(), e.getCreadoPor(), e.getEstado());
        List<String> msg = List.of("SE HA INSERTADO CORRECTAMENTE");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, msg, null));
    }

    @Override
    public ResponseEntity<ApiResponse> putAlmacen(AlmacenPOST e, int id) {
        if(this.repository.existsById(id)){
            this.repository.almacenPut(e.getIdProducto(), e.getCantidad(), e.getModificadoPor(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado correctamente"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));

    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(AlmacenPOST e, int id) {
        if(this.repository.existsById(id)){
            this.repository.almacenChangeStatus(e.getModificadoPor(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado correctamente"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));

    }
}
