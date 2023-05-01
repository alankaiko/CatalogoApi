package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import br.com.catalogo.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class ProdutoRepositoryImpl extends AbstractRepositoryImpl<Produto, ProdutoDTO, Long> implements ProdutoRepository {
    public ProdutoRepositoryImpl(EntityManager entityManager) {
        super(Produto.class, entityManager);
    }
}
