package com.el_economico.api.service.impl;


import com.el_economico.api.model.DTO.POST.UsuarioPOST;
import com.el_economico.api.model.DTO.REQUEST.UsuarioReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.UsuarioMapper;
import com.el_economico.api.repository.UsuarioRepository;
import com.el_economico.api.service.UsuarioService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;
    private UsuarioMapper mapper;

    public UsuarioServiceImpl(@Lazy UsuarioRepository repository,
                              @Lazy UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<UsuarioReq> list= mapper.toUsuarioReq(this.repository.getAll());
        List<String> msg=new ArrayList<>();
        if(list.size()>0){
            msg.clear();
            msg.add("Registro encontrado");
        }
        else{
            msg= List.of("No hay registro encontrado");
        }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, list));
    }

    @Override
    public ResponseEntity<ApiResponse> insertUsuario(UsuarioPOST e) {
       this.repository.usuarioInsert(e.getNombres(),e.getApellidos(),e.getDni(),e.getFecha_nac(),
                                     e.getGenero(),e.getCorreo(),e.getTelefono(),e.getFoto(),
                                     e.getUsuario(),e.getPasswd(),e.getId_rol(),e.getCreado_por(),
                                     e.getEstado());

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED,List.of("Registro insertado exitosamente"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> putUsuario(UsuarioPOST e, int id) {
        if(repository.existsById(id)){
            this.repository.usuarioPut(e.getNombres(),e.getApellidos(),e.getDni(),e.getFecha_nac(),
                                       e.getGenero(),e.getCorreo(),e.getTelefono(),e.getFoto(),
                                       e.getUsuario(),e.getPasswd(),e.getId_rol(),e.getModificado_por(),
                                       e.getEstado(),id);
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK,List.of("Se ha actualizado el registro"), null));
        }

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> changeStatus(UsuarioPOST e, int id) {
       if(repository.existsById(id)){
           this.repository.usuarioChangeStatus(e.getModificado_por(),e.getEstado(), id);
           return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Se ha cambiado el estado del registro"), null));
       }
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("No se ha encontrado el registro"), null));
    }
}
