package br.com.catalogo.service.impl;

import br.com.catalogo.acore.service.impl.AbstractServiceImpl;
import br.com.catalogo.model.Imagem;
import br.com.catalogo.model.dto.ImagemDTO;
import br.com.catalogo.repository.ImagemRepository;
import br.com.catalogo.service.ImagemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImagemServiceImpl extends AbstractServiceImpl<Imagem, ImagemDTO> implements ImagemService {
    private final ImagemRepository imagemRepository;

    public ImagemServiceImpl(ImagemRepository imagemRepository) {
        super(imagemRepository);
        this.imagemRepository = imagemRepository;
    }
}
