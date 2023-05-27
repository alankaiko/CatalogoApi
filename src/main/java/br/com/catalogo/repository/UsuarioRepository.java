
package br.com.catalogo.repository;

import br.com.catalogo.acore.repository.AbstractRepository;
import br.com.catalogo.model.Usuario;
import br.com.catalogo.model.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UsuarioRepository extends AbstractRepository<Usuario, UsuarioDTO, Long> {
    Page<Usuario> Filtrando(UsuarioDTO usuarioDTO, Pageable pageable);
    Usuario findByLogin(String login);
}
