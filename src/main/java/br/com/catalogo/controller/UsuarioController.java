package br.com.catalogo.controller;

import br.com.catalogo.acore.controller.AbstractController;
import br.com.catalogo.model.Usuario;
import br.com.catalogo.model.dto.Anexo;
import br.com.catalogo.model.dto.UsuarioDTO;
import br.com.catalogo.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping(value = UsuarioController.PATH)
public class UsuarioController extends AbstractController<Usuario, UsuarioDTO> {
    static final String PATH = "usuarios";

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
    }

    @GetMapping(params = "resumo")
    public Page<Usuario> Resumir(UsuarioDTO usuarioDTO, Pageable page) {
        return this.usuarioService.Filtrando(usuarioDTO, page);
    }

    @PostMapping("/anexo")
    public Anexo uploadAnexo(@RequestParam MultipartFile anexo) {
        //return this.service.SalvarNaAmazon(anexo);
        return null;
    }
}
