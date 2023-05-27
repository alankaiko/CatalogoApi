package br.com.catalogo.service;

import br.com.catalogo.acore.service.AbstractService;
import br.com.catalogo.model.Usuario;
import br.com.catalogo.model.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService extends AbstractService<Usuario, UsuarioDTO> {
    Page<Usuario> Filtrando(UsuarioDTO usuarioDTO, Pageable pageable);
}
