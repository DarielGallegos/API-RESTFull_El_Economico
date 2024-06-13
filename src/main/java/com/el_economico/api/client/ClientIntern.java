package com.el_economico.api.client;

import com.el_economico.api.client.src.Rutes;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ClientIntern {
    private Rutes RUTES;

    private final WebClient client;
    public ClientIntern(){
        this.client = WebClient.create(RUTES.BASE_URL.getUrl() + RUTES.VERSION_API.getUrl());
    }

    public ApiResponse get(String uri){
        return this.client.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();
    }
}
