package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Imagem;
import br.com.catalogo.model.dto.ImagemDTO;
import br.com.catalogo.repository.ImagemRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class ImagemRepositoryImpl extends AbstractRepositoryImpl<Imagem, ImagemDTO, Long> implements ImagemRepository {
    public ImagemRepositoryImpl(EntityManager entityManager) {
        super(Imagem.class, entityManager);
    }
}
