package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Grupo extends AbstractEntity {
    private String nome;
    private String descricao;
}
