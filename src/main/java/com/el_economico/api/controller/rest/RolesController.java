package com.el_economico.api.controller.rest;

import com.el_economico.api.model.DTO.POST.RolPOST;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController<T> {
    @Autowired
    private RolesServiceImpl service;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<T> getAll(){
        return this.service.getRoles();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insertRol(@RequestBody RolPOST e){
        return this.service.insertRol(e);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> updateRol(@PathVariable("id") int id, @RequestBody RolPOST e){
        return this.service.putRol(e, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> changeStatus(@PathVariable("id") int id, @RequestBody RolPOST e){
        return this.service.changeStatus(e, id);
    }
}
