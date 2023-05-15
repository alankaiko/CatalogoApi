package br.com.catalogo.service;

import br.com.catalogo.acore.service.AbstractService;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService extends AbstractService<Produto, ProdutoDTO> {
    Page<Produto> Filtrando(ProdutoDTO produtoDTO, Pageable pageable);
}
