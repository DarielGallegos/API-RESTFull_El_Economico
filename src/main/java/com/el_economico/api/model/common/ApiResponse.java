package com.el_economico.api.model.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ApiResponse<T> {
    private HttpStatus status;
    private int statusCode;
    private Map<String, Object> data = new LinkedHashMap<>();
    private Date timestamp;


    public ApiResponse(HttpStatus status, List<String> msgs, List<T> content) {
        this.init(status, msgs, content);
    }

    public void init(HttpStatus status, List<String> msgs, List<T> content) {
        this.timestamp = new Date();
        this.status = status;
        this.timestamp = new Date();
        this.status = status;
        this.statusCode = status.value();
        this.data.put("msg", msgs);
        this.data.put("content", content);
    }
}
