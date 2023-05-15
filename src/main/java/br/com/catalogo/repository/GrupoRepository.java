package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GrupoRepository extends AbstractRepository<Grupo, GrupoDTO, Long> {
    Page<Grupo> Filtrando(GrupoDTO grupoDTO, Pageable pageable);
}
