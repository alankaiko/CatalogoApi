package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import br.com.catalogo.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProdutoRepositoryImpl extends AbstractRepositoryImpl<Produto, ProdutoDTO, Long> implements ProdutoRepository {
    private final EntityManager entityManager;

    public ProdutoRepositoryImpl(EntityManager entityManager) {
        super(Produto.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<Produto> Filtrando(ProdutoDTO produtoDTO, Pageable pageable) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);

        query.orderBy(builder.asc(root.get("codigo")));
        Predicate[] predicato = AdicionarRestricoes(builder, produtoDTO, root);
        query.where(predicato);

        TypedQuery<Produto> tiped = this.entityManager.createQuery(query);
        AdicionarPaginacao(tiped, pageable);

        return new PageImpl<>(tiped.getResultList(), pageable, Total(produtoDTO));
    }

    private Predicate[] AdicionarRestricoes(CriteriaBuilder builder, ProdutoDTO produtoDTO, Root<Produto> root) {
        List<Predicate> lista= new ArrayList<>();

        if(!StringUtils.isEmpty(produtoDTO.getNome()))
            lista.add(builder.like(builder.lower(root.get("nome")), "%"+ produtoDTO.getNome().toLowerCase()+"%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

    private void AdicionarPaginacao(TypedQuery<?> tiped, Pageable page) {
        int paginaatual = page.getPageNumber();
        int totalporpagina = page.getPageSize();
        int primeiroRegistroDaPagina = paginaatual * totalporpagina;

        tiped.setFirstResult(primeiroRegistroDaPagina);
        tiped.setMaxResults(totalporpagina);
    }

    private Long Total(ProdutoDTO produtoDTO) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Produto> root = query.from(Produto.class);

        Predicate[] predicato = AdicionarRestricoes(builder, produtoDTO, root);
        query.where(predicato);
        query.select(builder.count(root));
        return this.entityManager.createQuery(query).getSingleResult();
    }
}
