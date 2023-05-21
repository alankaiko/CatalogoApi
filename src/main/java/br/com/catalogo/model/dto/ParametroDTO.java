package br.com.catalogo.model.dto;

import br.com.catalogo.acore.model.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParametroDTO extends AbstractDTO {
    private String nome;
}
