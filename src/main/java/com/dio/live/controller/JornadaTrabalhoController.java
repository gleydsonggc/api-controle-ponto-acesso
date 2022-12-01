package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/jornada")
@RequiredArgsConstructor
public class JornadaTrabalhoController {

	private final JornadaService jornadaService;

	@PostMapping
	public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(jornadaService.saveJornada(jornadaTrabalho));
	}

	@GetMapping
	public List<JornadaTrabalho> getJornadaList() {
		return jornadaService.findAll();
	}

	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) {
		return jornadaService.getById(idJornada)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping
	public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaService.getById(jornadaTrabalho.getId())
				.map(jornadaService::updateJornada)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idJornada}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByID(@PathVariable("idJornada") Long idJornada) {
		jornadaService.deleteJornada(idJornada);
	}

}
