package br.com.catalogo.model.dto;

import br.com.catalogo.acore.model.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends AbstractDTO {
    private String nome;
    private String sobrenome;
    private String login;
}
