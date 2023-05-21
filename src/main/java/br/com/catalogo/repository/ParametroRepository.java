package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Parametro;
import br.com.catalogo.model.dto.ParametroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ParametroRepository extends AbstractRepository<Parametro, ParametroDTO, Long> {
    Page<Parametro> Filtrando(ParametroDTO parametroDTO, Pageable pageable);
}
