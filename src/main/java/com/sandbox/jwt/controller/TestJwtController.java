package com.sandbox.jwt.controller;

import com.sandbox.jwt.models.TokenResponse;
import com.sandbox.jwt.service.TestJwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-jwt")
public class TestJwtController {

    private final TestJwtService service;

    public TestJwtController(TestJwtService service) {
        this.service = service;
    }

    @GetMapping(produces = {"application/json"}, value = {"/tokens"})
    public ResponseEntity<TokenResponse> getToken() {
        return ResponseEntity.ok(new TokenResponse(service.getToken()));
    }


}
