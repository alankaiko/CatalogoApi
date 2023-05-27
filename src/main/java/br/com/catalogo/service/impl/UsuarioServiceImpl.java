package br.com.catalogo.service.impl;

import br.com.catalogo.acore.service.impl.AbstractServiceImpl;
import br.com.catalogo.model.Usuario;
import br.com.catalogo.model.dto.UsuarioDTO;
import br.com.catalogo.repository.UsuarioRepository;
import br.com.catalogo.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl extends AbstractServiceImpl<Usuario, UsuarioDTO> implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Page<Usuario> Filtrando(UsuarioDTO usuarioDTO, Pageable pageable) {
        return this.usuarioRepository.Filtrando(usuarioDTO, pageable);
    }
}
