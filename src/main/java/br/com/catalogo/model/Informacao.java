package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Informacao extends AbstractEntity {
    private String titulo;

    @Column(length = 2000)
    private String texto;


    @OneToOne
    @JoinColumn(name = "tbl_imagem_id", referencedColumnName = "codigo")
    private Imagem imagem;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(optional = false)
    private Parametro parametro;
}
