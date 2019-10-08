package br.com.bandtec.bora.core.repositorio;

import br.com.bandtec.bora.core.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Long> {

	Usuario findByApelido(String apelido);

}
