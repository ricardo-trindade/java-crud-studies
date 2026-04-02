package com.back.security.DTO;

import com.back.security.entities.enums.Role;

public record UsuarioResponseDTO(
        String nome,
        String email,
        Role role
) {
}
