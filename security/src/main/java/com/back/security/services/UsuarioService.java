package com.back.security.services;

import com.back.security.DTO.UsuarioRequestDTO;
import com.back.security.DTO.UsuarioResponseDTO;
import com.back.security.entities.Usuario;
import com.back.security.entities.enums.Role;
import com.back.security.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository repository;

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }



    @Transactional
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        usuario.setRole(Role.ROLE_USER);

        repository.save(usuario);

        return toResponse(usuario);
    }




}
