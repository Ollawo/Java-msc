package com.example.demo;
import config.SecurityConfig;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import lombok.AllArgsConstructor;

@RestController
//@RequestMapping(value = "/livro")
public class LivroController {
	
	@Autowired
	LivroRepository repository;
	
	@GetMapping("/livro")
	public List<Livro> getAllLivros(){
		return repository.findAll();
	}
	@GetMapping ("/livro/{id}")
	public Livro getLivroPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	@PostMapping("/livro")
	@PreAuthorize("hasRole('ADMIN')")
	public Livro saveLivro(@RequestBody Livro livro) {
		return repository.save(livro);
	}
	@DeleteMapping("/livro/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteLivro(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}
