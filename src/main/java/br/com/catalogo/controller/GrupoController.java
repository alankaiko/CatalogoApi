package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Grupo;
import br.com.catalogo.model.dto.GrupoDTO;
import br.com.catalogo.service.GrupoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GrupoController.PATH)
public class GrupoController extends AbstractController<Grupo, GrupoDTO> {
    static final String PATH = "grupos";
    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        super(grupoService);
        this.grupoService = grupoService;
    }
}
