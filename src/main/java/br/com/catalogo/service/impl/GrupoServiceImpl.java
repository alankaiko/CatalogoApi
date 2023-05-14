package br.com.catalogo.service.impl;

import br.com.catalogo.acore.service.impl.AbstractServiceImpl;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import br.com.catalogo.repository.GrupoRepository;
import br.com.catalogo.service.GrupoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GrupoServiceImpl extends AbstractServiceImpl<Grupo, GrupoDTO> implements GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        super(grupoRepository);
        this.grupoRepository = grupoRepository;
    }
}
