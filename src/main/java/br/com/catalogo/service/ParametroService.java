package br.com.catalogo.service;

import br.com.catalogo.acore.service.AbstractService;
import br.com.catalogo.model.Parametro;
import br.com.catalogo.model.dto.ParametroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParametroService extends AbstractService<Parametro, ParametroDTO> {
    Page<Parametro> Filtrando(ParametroDTO parametroDTO, Pageable pageable);
}
