package com.el_economico.api.client;

import com.el_economico.api.client.src.Rutes;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.Duration;
import java.util.List;

@Component
public class ClientIntern<T> {
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

    public ApiResponse post(String uri, T e){
        try{
            return this.client.post()
                    .uri(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(e)
                    .retrieve()
                    .bodyToMono(ApiResponse.class)
                    .timeout(Duration.ofSeconds(10))
                    .block();
        }catch (WebClientResponseException ex){
            return new ApiResponse((HttpStatus)ex.getStatusCode(), List.of(ex.getMessage()), null);
        }catch (HttpMessageNotReadableException ex) {
            return new ApiResponse(HttpStatus.BAD_REQUEST, List.of(ex.getMessage()), null);
        }
    }
}
