package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Imagem;
import br.com.catalogo.model.dto.ImagemDTO;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ImagemRepository extends AbstractRepository<Imagem, ImagemDTO, Long> {
}
