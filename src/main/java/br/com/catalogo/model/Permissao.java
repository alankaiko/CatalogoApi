package br.com.catalogo.model;


import br.com.catalogo.acore.model.AbstractEntity;
import br.com.catalogo.model.enuns.EnumPermissao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Permissao extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumPermissao descricao;
}
