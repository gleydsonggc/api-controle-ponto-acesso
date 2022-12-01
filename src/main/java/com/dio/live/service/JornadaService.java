package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JornadaService {

	private final JornadaRepository jornadaRepository;

	@NonNull
	public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaRepository.findAll();
	}

	public Optional<JornadaTrabalho> getById(Long idJornada) {
		return jornadaRepository.findById(idJornada);
	}

	public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);
	}

	public void deleteJornada(Long idJornada) {
		jornadaRepository.deleteById(idJornada);
	}

}
