package br.com.catalogo.acore.controller;

import br.com.catalogo.acore.model.AbstractDTO;
import br.com.catalogo.acore.model.AbstractEntity;
import br.com.catalogo.acore.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T extends AbstractEntity, D extends AbstractDTO> {
    private final AbstractService<T, D> service;

    public AbstractController(AbstractService<T, D> service) {
        this.service = service;
    }

    @PostMapping
    public T salvar(@RequestBody T entidade) {
        return this.service.salvar(entidade);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long codigo) {
        this.service.deletar(codigo);
    }

    @GetMapping({"{codigo}"})
    public T buscarId(@PathVariable Long codigo) {
        return this.service.buscarId(codigo);
    }

    @GetMapping
    public List<T> listar() {
        return this.service.listar();
    }

    @PostMapping({"listar-paginado"})
    public Page listarPaginado(@RequestBody(required = false) D filtro) {
        return this.service.listarPaginado(filtro);
    }
}