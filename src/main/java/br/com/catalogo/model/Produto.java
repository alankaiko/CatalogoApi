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

    @Column(length = 800)
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<Imagem> imagems;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conjugue_id", referencedColumnName = "codigo")
    private Grupo grupo;
}
