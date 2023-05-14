package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GrupoRepository extends AbstractRepository<Grupo, GrupoDTO, Long> {
}
