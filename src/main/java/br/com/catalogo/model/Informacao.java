package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Informacao extends AbstractEntity {
    @Column(length = 2000)
    private String texto;


    @OneToOne
    @JoinColumn(name = "tbl_imagem_id", referencedColumnName = "codigo")
    private Imagem imagem;

    @ManyToOne
    private Parametro parametro;
}
