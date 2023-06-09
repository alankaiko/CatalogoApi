package br.com.catalogo.model;

import br.com.catalogo.acore.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Produto extends AbstractEntity {
    @Column(length = 60)
    private String nome;

    @Column(length = 300)
    private String descricao;

    @Column(length = 2000)
    private String informacao;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<Imagem> imagems;

    @OneToOne
    @JoinColumn(name = "tbl_grupo_id", referencedColumnName = "codigo")
    private Grupo grupo;
}
