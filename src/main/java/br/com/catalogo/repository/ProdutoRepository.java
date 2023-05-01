package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProdutoRepository extends AbstractRepository<Produto, ProdutoDTO, Long> {
}
