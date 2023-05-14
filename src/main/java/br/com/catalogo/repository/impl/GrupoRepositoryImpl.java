package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import br.com.catalogo.repository.GrupoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class GrupoRepositoryImpl extends AbstractRepositoryImpl<Grupo, GrupoDTO, Long> implements GrupoRepository {
    public GrupoRepositoryImpl(EntityManager entityManager) {
        super(Grupo.class, entityManager);
    }
}
