package br.com.catalogo.acore.service;

import br.com.catalogo.acore.model.AbstractDTO;
import br.com.catalogo.acore.model.AbstractEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AbstractService<T extends AbstractEntity, D extends AbstractDTO> {
    T salvar(T entidade);

    void deletar(Long codigo);

    T buscarId(Long codigo);

    List<T> listar();

    Page listarPaginado(D filtro);
}
