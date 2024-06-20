package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.ClientePOST;
import com.el_economico.api.model.DTO.REQUEST.ClienteReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.ClienteMapper;
import com.el_economico.api.repository.ClienteRepository;
import com.el_economico.api.service.ClienteService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;
    private ClienteMapper mapper;

    public ClienteServiceImpl(@Lazy ClienteRepository repository,
                              @Lazy ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<ClienteReq> list= mapper.toClientesReq(this.repository.getAll());
        List<String> msg=new ArrayList<>();
        if(list.size()>0){
            msg.clear();
            msg.add("Registro encontrado");
        }else {
            msg= List.of("No hay registro encontrado");
        }
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK, msg, list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertCliente(ClientePOST e) {
        this.repository.clientesInsert(e.getNombres(), e.getApellidos(), e.getFecha_nac(), e.getGenero(),
                                       e.getCorreo(),e.getTelefono(), e.getFoto(), e.getUsuario(),
                                       e.getPasswd(), e.getId_rol(),e.getCreado_por(),e.getEstado());

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("Registro insertado exitosamente"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> putCliente(ClientePOST e, int id) {
       if(this.repository.existsById(id)){
           this.repository.clientesPut(e.getNombres(), e.getApellidos(), e.getFecha_nac(), e.getGenero(),
                                       e.getCorreo(),e.getTelefono(), e.getFoto(), e.getUsuario(),
                                       e.getPasswd(), e.getId_rol(),e.getModificado_por(),e.getEstado(), id);
           return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha actualizado el registro"), null));
       }

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED,List.of("No se ha encontrado el registro"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(ClientePOST e, int id) {
       if(this.repository.existsById(id)){
           this.repository.clientesChangeStatus(e.getModificado_por(), e.getEstado(), id);
           return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha cambiado el estado del registro"), null));
       }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }
}
