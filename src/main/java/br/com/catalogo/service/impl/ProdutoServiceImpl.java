package br.com.catalogo.service.impl;

import br.com.catalogo.acore.service.impl.AbstractServiceImpl;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import br.com.catalogo.repository.ProdutoRepository;
import br.com.catalogo.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdutoServiceImpl extends AbstractServiceImpl<Produto, ProdutoDTO> implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        super(produtoRepository);
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Page<Produto> Filtrando(ProdutoDTO produtoDTO, Pageable pageable) {
        return this.produtoRepository.Filtrando(produtoDTO, pageable);
    }
}
