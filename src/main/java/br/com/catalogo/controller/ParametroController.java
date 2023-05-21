package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Parametro;
import br.com.catalogo.model.dto.ParametroDTO;
import br.com.catalogo.service.ParametroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = ParametroController.PATH)
public class ParametroController extends AbstractController<Parametro, ParametroDTO> {
    static final String PATH = "parametros";

    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        super(parametroService);
        this.parametroService = parametroService;
    }

    @GetMapping(params = "resumo")
    public Page<Parametro> Resumir(ParametroDTO parametroDTO, Pageable page) {
        return this.parametroService.Filtrando(parametroDTO, page);
    }
}
