package br.com.catalogo.service;

import br.com.catalogo.acore.service.AbstractService;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrupoService extends AbstractService<Grupo, GrupoDTO> {
    Page<Grupo> Filtrando(GrupoDTO grupoDTO, Pageable pageable);
}
