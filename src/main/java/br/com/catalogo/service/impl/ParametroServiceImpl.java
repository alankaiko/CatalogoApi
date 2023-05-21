package br.com.catalogo.service.impl;

import br.com.catalogo.acore.service.impl.AbstractServiceImpl;
import br.com.catalogo.model.Parametro;
import br.com.catalogo.model.dto.ParametroDTO;
import br.com.catalogo.repository.ParametroRepository;
import br.com.catalogo.service.ParametroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParametroServiceImpl extends AbstractServiceImpl<Parametro, ParametroDTO> implements ParametroService {
    private final ParametroRepository parametroRepository;

    public ParametroServiceImpl(ParametroRepository parametroRepository) {
        super(parametroRepository);
        this.parametroRepository = parametroRepository;
    }

    @Override
    public Page<Parametro> Filtrando(ParametroDTO parametroDTO, Pageable pageable) {
        return this.parametroRepository.Filtrando(parametroDTO, pageable);
    }
}
