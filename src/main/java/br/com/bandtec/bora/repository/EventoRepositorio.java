package br.com.bandtec.bora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.bandtec.bora.model.entity.Evento;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long>{
	
	List<Evento> findByNome(String nomeEvento);

	List<Evento> findByOrganizador(String organizador);
	
	@Query(value = "SELECT u FROM Evento u INNER JOIN Categoria c ON c.id = u.id INNER JOIN Subcategoria a ON a.id = c.id where a.nome <=:subcategoria")
	Evento buscarEventoPorSubCategoria(String subcategoria);

}
