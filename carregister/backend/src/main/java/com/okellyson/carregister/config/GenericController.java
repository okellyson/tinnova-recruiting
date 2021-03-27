package com.okellyson.carregister.config;

import org.springframework.http.ResponseEntity;

public class GenericController {

    private static final String HEADER_CORS = "Access-Control-Allow-Origin";
    private static final String URL_FRONT = "http://localhost:8080";

    public ResponseEntity.BodyBuilder ok() {

        return ResponseEntity.ok();
                //.header(HEADER_CORS, URL_FRONT);
    }

}
