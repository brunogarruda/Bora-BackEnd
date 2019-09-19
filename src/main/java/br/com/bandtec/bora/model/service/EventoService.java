package br.com.bandtec.bora.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bandtec.bora.model.entity.Evento;

@Service
public interface EventoService {
	
	Evento cadastrarEvento(Evento evento);
	
	Evento atualizarEvento(Long idEvento, Evento evento);

	List<Evento> buscarEventoPorNome(String nomeEvento);
}
