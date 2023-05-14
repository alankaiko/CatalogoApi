package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.ProdutoDTO;
import br.com.catalogo.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ProdutoController.PATH)
public class ProdutoController extends AbstractController<Produto, ProdutoDTO> {
    static final String PATH = "produtos";

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super(produtoService);
        this.produtoService = produtoService;
    }
}
