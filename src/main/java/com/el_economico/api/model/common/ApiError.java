package com.el_economico.api.model.common;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiError<T> {
    private HttpStatus status;
    private int statusCode;
    private Map<String, Object> errors = new LinkedHashMap<>();
    private Date timestamp;

    public ApiError(HttpStatus status, List<Object> err, List<T> content){
        this.init(status, err, content);
    }

    public void init(HttpStatus status, List<Object> err, List<T> content){
        this.timestamp = new Date();
        this.status = status;
        this.statusCode = status.value();
        this.errors.put("msg", status);
        this.errors.put("Errors", err);
    }
}
