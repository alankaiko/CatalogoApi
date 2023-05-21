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
public class Parametro extends AbstractEntity {
    @Column(length = 60)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "parametro")
    List<Informacao> informacoes;
}
