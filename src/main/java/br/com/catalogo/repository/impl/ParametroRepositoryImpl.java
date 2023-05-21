package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Parametro;
import br.com.catalogo.model.dto.ParametroDTO;
import br.com.catalogo.repository.ParametroRepository;
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
public class ParametroRepositoryImpl extends AbstractRepositoryImpl<Parametro, ParametroDTO, Long> implements ParametroRepository {
    private final EntityManager entityManager;

    public ParametroRepositoryImpl(EntityManager entityManager) {
        super(Parametro.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<Parametro> Filtrando(ParametroDTO parametroDTO, Pageable pageable) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Parametro> query = builder.createQuery(Parametro.class);
        Root<Parametro> root = query.from(Parametro.class);

        query.orderBy(builder.asc(root.get("codigo")));
        Predicate[] predicato = AdicionarRestricoes(builder, parametroDTO, root);
        query.where(predicato);

        TypedQuery<Parametro> tiped = this.entityManager.createQuery(query);
        AdicionarPaginacao(tiped, pageable);

        return new PageImpl<>(tiped.getResultList(), pageable, Total(parametroDTO));
    }

    private Predicate[] AdicionarRestricoes(CriteriaBuilder builder, ParametroDTO parametroDTO, Root<Parametro> root) {
        List<Predicate> lista= new ArrayList<>();

        if(!StringUtils.isEmpty(parametroDTO.getNome()))
            lista.add(builder.like(builder.lower(root.get("nome")), "%"+ parametroDTO.getNome().toLowerCase()+"%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

    private void AdicionarPaginacao(TypedQuery<?> tiped, Pageable page) {
        int paginaatual = page.getPageNumber();
        int totalporpagina = page.getPageSize();
        int primeiroRegistroDaPagina = paginaatual * totalporpagina;

        tiped.setFirstResult(primeiroRegistroDaPagina);
        tiped.setMaxResults(totalporpagina);
    }

    private Long Total(ParametroDTO parametroDTO) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Parametro> root = query.from(Parametro.class);

        Predicate[] predicato = AdicionarRestricoes(builder, parametroDTO, root);
        query.where(predicato);
        query.select(builder.count(root));
        return this.entityManager.createQuery(query).getSingleResult();
    }
}
