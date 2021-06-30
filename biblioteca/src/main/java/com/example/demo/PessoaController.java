package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PessoaController {
	@Autowired
	PessoaRepository repository;
	
	@GetMapping("/pessoa")
	public List<Pessoa> getAllPessoa(){
		return repository.findAll();
	}
	@GetMapping ("/pessoa/{id}")
	public Pessoa getPessoaPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	@PostMapping("/pessoa")
	public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}
	@DeleteMapping("/pessoa/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deletePessoa(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
