package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {
	@Autowired
	PessoaRepository prepository;
	
	@GetMapping("/pessoa")
	public List<Pessoa> getAllPessoa(){
		return prepository.findAll();
	}
	@GetMapping ("/pessoa/{id}")
	public Pessoa getPessoaPorId(@PathVariable Long id) {
		return prepository.findById(id).get();
	}
	@PostMapping("/pessoa")
	public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
		return prepository.save(pessoa);
	}
	@DeleteMapping("/pessoa/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deletePessoa(@PathVariable Long id) {
		prepository.deleteById(id);
	}
}
