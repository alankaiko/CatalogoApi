package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Imagem extends AbstractEntity {
    private String caminho;
    private String nomeimagem;
    private String extensao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_produto_id", referencedColumnName = "codigo")
    private Produto produto;
}
