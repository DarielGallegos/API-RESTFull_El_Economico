package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.RolPOST;
import com.el_economico.api.model.DTO.REQUEST.RolReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.entity.Roles;
import com.el_economico.api.model.mapper.RolMapper;
import com.el_economico.api.repository.RolesRepository;
import com.el_economico.api.service.RolesService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl<T> implements RolesService {

    private final RolesRepository repository;
    private final RolMapper mapper;

    public RolesServiceImpl(@Lazy RolesRepository repository, @Lazy RolMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getRoles() {
        List<Roles> list = this.repository.getAllProcedure();
        List<RolReq> roles = this.mapper.toRol(list);
        List<String> msg = List.of("Registros encontrados");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, roles));
    }

    @Override
    public ResponseEntity<ApiResponse> insertRol(RolPOST e) {
        List<String> msg = List.of("Registro insertado correctamente");
        this.repository.insertProcedure(e.getNombre(), e.getCreadoPor(), e.getEstado());
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, msg, null));
    }
    @Override
    public ResponseEntity<ApiResponse> putRol(RolPOST e, int id) {
        List<String> msg = new ArrayList<>();
       if(this.repository.existsById(id)){
           msg.add("Registro encontrado");
           msg.add("Estado del registro modificado correctamente");
           this.repository.putProcedure(e.getNombre(), e.getModificadoPor(), e.getEstado(), id);
           return ResponseEntity.ok().body(new ApiResponse(HttpStatus.NOT_FOUND, msg, null));
        }else{
           msg.add("Registro no encontrado");
           msg.add("No se pudo modificar el estado del registro");
           return ResponseEntity.ok().body(new ApiResponse(HttpStatus.NOT_FOUND, msg, null));
        }
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(RolPOST e, int id) {
        List<String> msg = new ArrayList<>();
        if(this.repository.existsById(id)){
            msg.add("Registro encontrado");
            msg.add("Estado del registro modificado correctamente");
            this.repository.changeStatus(e.getModificadoPor(), e.getEstado(), id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, null));
        }else{
            msg.add("Registro no encontrado");
            msg.add("No se pudo modificar el estado del registro");
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.NOT_FOUND, msg, null));
        }
    }
}
