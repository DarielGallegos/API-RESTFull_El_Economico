package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.ImpuestoPOST;
import com.el_economico.api.model.DTO.REQUEST.ImpuestoReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.ImpuestoMapper;
import com.el_economico.api.repository.ImpuestosRepository;
import com.el_economico.api.service.ImpuestoService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpuestoServiceImpl implements ImpuestoService {
    private ImpuestosRepository repository;
    private ImpuestoMapper mapper;
    public ImpuestoServiceImpl(@Lazy ImpuestosRepository repository, @Lazy ImpuestoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<ImpuestoReq> list = mapper.toImpuestoReq(this.repository.getAll());
        List<String> msg = new ArrayList<>();
        if(list.size() > 0){
            msg.add("Registros encontrados");
        }else{
            msg.add("No se encontraron registros");
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertImpuesto(ImpuestoPOST e) {
        int id = this.repository.impuestosInsert(e.getNombre(), e.getImpuesto(), e.getCreadoPor(), e.getEstado());
        List<String> msg = List.of("Se ha insertado correctamente");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, msg, List.of(id)));
    }

    @Override
    public ResponseEntity<ApiResponse> putImpuesto(ImpuestoPOST e, int id) {
        if(this.repository.existsById(id)){
            this.repository.impuestosPut(e.getNombre(), e.getImpuesto(), e.getModificadoPor(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado correctamente"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(ImpuestoPOST e, int id) {
        if(this.repository.existsById(id)){
            this.repository.impuestosChangeStatus(e.getModificadoPor(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha cambiado el estado del registro"), null));
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }
}
