package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProdutoRepository extends AbstractRepository<Produto, ProdutoDTO, Long> {
    Page<Produto> Filtrando(ProdutoDTO produtoDTO, Pageable pageable);
}
