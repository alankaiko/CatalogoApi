package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Produto;
import br.com.catalogo.model.dto.Anexo;
import br.com.catalogo.model.dto.ProdutoDTO;
import br.com.catalogo.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping(value = ProdutoController.PATH)
public class ProdutoController extends AbstractController<Produto, ProdutoDTO> {
    static final String PATH = "produtos";

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super(produtoService);
        this.produtoService = produtoService;
    }

    @GetMapping(params = "resumo")
    public Page<Produto> Resumir(ProdutoDTO produtoDTO, Pageable page) {
        return this.produtoService.Filtrando(produtoDTO, page);
    }

    @PostMapping("/anexo")
    public Anexo uploadAnexo(@RequestParam MultipartFile[] anexo)  {
        //return this.service.SalvarNaAmazon(anexo);
        return null;
    }
}
