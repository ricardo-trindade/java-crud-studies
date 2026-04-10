package com.back.security.controllers;

import com.back.security.DTO.UsuarioRequestDTO;
import com.back.security.DTO.UsuarioResponseDTO;
import com.back.security.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("users")
    public ResponseEntity criarUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(service.criarUsuario(dto));
    }

    @GetMapping("/admin")
    public String admin() {
        return "Acesso ADMIN";
    }



}
