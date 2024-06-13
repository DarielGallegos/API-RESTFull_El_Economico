package com.el_economico.api.client.src;

public enum Rutes {
    BASE_URL("http://localhost:14000/api/"),
    VERSION_API("v1/");

    private String url;

    Rutes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
