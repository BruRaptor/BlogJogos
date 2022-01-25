package com.noticias.jogos.BlogJogos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticias.jogos.BlogJogos.model.Tema;
import com.noticias.jogos.BlogJogos.repository.TemaRepository;

public class PostagemController {

	@RestController
	@RequestMapping("/postagemjogos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class TemaController {

		@Autowired
		private TemaRepository repository;

		@GetMapping("/select")
		public ResponseEntity<List<Tema>> getAll() {
			return ResponseEntity.ok(repository.findAll());
		}

		@PostMapping("/insert")
		public ResponseEntity<Tema> saveTema(@Valid @RequestBody Tema tema) {
			return ResponseEntity.status(201).body(repository.save(tema));
		}

		@PutMapping("/put")
		public ResponseEntity<Tema> put(@RequestBody Tema tema) {
			return ResponseEntity.ok(repository.save(tema));
		}

		@DeleteMapping("delete{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
	}
}
