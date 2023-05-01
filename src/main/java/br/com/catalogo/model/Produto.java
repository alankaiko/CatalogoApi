package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Produto extends AbstractEntity {
    @Column(length = 60)
    private String nome;

    @Column(length = 200)
    private String descricao;
}
