package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.UsuarioPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> getAll(){return this.service.getAll();}

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> insertUsuario(@RequestBody UsuarioPOST e){
        return this.service.insertUsuario(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> putUsuario(@PathVariable("id") int id, @RequestBody UsuarioPOST e){
        return this.service.putUsuario(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> changeStatus(@PathVariable("id") int id, @RequestBody UsuarioPOST e){
        return this.service.changeStatus(e, id);
    }

}
