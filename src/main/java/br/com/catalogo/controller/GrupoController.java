package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import br.com.catalogo.service.GrupoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = GrupoController.PATH)
public class GrupoController extends AbstractController<Grupo, GrupoDTO> {
    static final String PATH = "grupos";
    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        super(grupoService);
        this.grupoService = grupoService;
    }

    @GetMapping(params = "resumo")
    public Page<Grupo> Resumir(GrupoDTO grupoDTO, Pageable page) {
        return this.grupoService.Filtrando(grupoDTO, page);
    }


}
