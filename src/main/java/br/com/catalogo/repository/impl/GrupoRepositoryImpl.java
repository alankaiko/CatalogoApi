package br.com.catalogo.repository.impl;

import br.com.catalogo.acore.repository.impl.AbstractRepositoryImpl;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import br.com.catalogo.repository.GrupoRepository;
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
public class GrupoRepositoryImpl extends AbstractRepositoryImpl<Grupo, GrupoDTO, Long> implements GrupoRepository {
    private final EntityManager entityManager;

    public GrupoRepositoryImpl(EntityManager entityManager) {
        super(Grupo.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<Grupo> Filtrando(GrupoDTO grupoDTO, Pageable pageable) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Grupo> query = builder.createQuery(Grupo.class);
        Root<Grupo> root = query.from(Grupo.class);

        query.orderBy(builder.asc(root.get("codigo")));
        Predicate[] predicato = AdicionarRestricoes(builder, grupoDTO, root);
        query.where(predicato);

        TypedQuery<Grupo> tiped = this.entityManager.createQuery(query);
        AdicionarPaginacao(tiped, pageable);

        return new PageImpl<>(tiped.getResultList(), pageable, Total(grupoDTO));
    }

    private Predicate[] AdicionarRestricoes(CriteriaBuilder builder, GrupoDTO grupoDTO, Root<Grupo> root) {
        List<Predicate> lista= new ArrayList<>();

        if(!StringUtils.isEmpty(grupoDTO.getNome()))
            lista.add(builder.like(builder.lower(root.get("nome")), "%"+ grupoDTO.getNome().toLowerCase()+"%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

    private void AdicionarPaginacao(TypedQuery<?> tiped, Pageable page) {
        int paginaatual = page.getPageNumber();
        int totalporpagina = page.getPageSize();
        int primeiroRegistroDaPagina = paginaatual * totalporpagina;

        tiped.setFirstResult(primeiroRegistroDaPagina);
        tiped.setMaxResults(totalporpagina);
    }

    private Long Total(GrupoDTO grupoDTO) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Grupo> root = query.from(Grupo.class);

        Predicate[] predicato = AdicionarRestricoes(builder, grupoDTO, root);
        query.where(predicato);
        query.select(builder.count(root));
        return this.entityManager.createQuery(query).getSingleResult();
    }
}
