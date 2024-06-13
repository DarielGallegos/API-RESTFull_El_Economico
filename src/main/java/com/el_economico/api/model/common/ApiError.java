package com.el_economico.api.model.common;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiError {
    private Date timestamp;
    private HttpStatus status;
    private Map<String, Object> errors;

    public ApiError(HttpStatus status, List<Object> err) {
        this.init(status, err);
    }

    public void init(HttpStatus status, List<Object> err) {
        this.timestamp = new Date();
        this.status = status;
        this.errors = new LinkedHashMap();
        this.errors.put("timestamp", this.timestamp.toString());
        this.errors.put("status", status);
        this.errors.put("Errors", err);
    }
}
