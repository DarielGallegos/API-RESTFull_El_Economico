package com.el_economico.api.service.impl;

import com.el_economico.api.model.DTO.POST.CredencialesLogin;
import com.el_economico.api.model.DTO.REQUEST.Credenciales;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.service.CredencialesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialesServiceImpl implements CredencialesService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public ResponseEntity<ApiResponse> login(CredencialesLogin e) {
        //loginUsuario
        //loginClientes
        Query query = (e.getClient()) ? manager.createNativeQuery("CALL loginClientes(:usuario, :passwd)") : manager.createNativeQuery("CALL loginUsuario(:usuario, :passwd)");
        query.setParameter("usuario", e.getUsuario());
        query.setParameter("passwd", e.getPassword());
        List<Object[]> rawResultList = query.getResultList();
            Credenciales credenciales = new Credenciales();
            Object[] rawResult = rawResultList.get(0);
            if(rawResult[0] != null){
                credenciales.setId((int) rawResult[0]);
                credenciales.setNombre((String) rawResult[1]);
                credenciales.setUsuario((String) rawResult[2]);
                credenciales.setTelefono((String) rawResult[3]);
                credenciales.setRol((String) rawResult[4]);
                credenciales.setCorreo((String) rawResult[5]);
                credenciales.setEmpleado(!e.getClient());
                return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, List.of("Credenciales Validas"), List.of(credenciales)));

            }
        return ResponseEntity.ok(new ApiResponse(HttpStatus.UNAUTHORIZED, List.of("Credenciales Invalidas"), null));
    }

    @Override
    public ResponseEntity<ApiResponse> resetPassword(String email, String passwd) {
        Query query = manager.createNativeQuery("CALL actualizarPass(:email, :passwd)");
        query.setParameter("email", email);
        query.setParameter("passwd", passwd);
        if(!email.trim().isEmpty() || !passwd.trim().isEmpty()){
            Object rawResult = query.getSingleResult();
            if(rawResult != null){
                return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, List.of((String) rawResult), null));
            }
        }
        return ResponseEntity.ok(new ApiResponse(HttpStatus.BAD_REQUEST, List.of("Datos Invalidos"), null));
    }
}
