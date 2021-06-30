package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BibliotecasController {
	@Autowired
	BibliotecasRepository repository;
	
	@GetMapping("/bibliotecas")
	public List<Bibliotecas> getAllBibliotecas(){
		return repository.findAll();
	}
	@GetMapping ("/bibliotecas/{id}")
	public Bibliotecas getBibliotecasPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	@PostMapping("/bibliotecas")
	public Bibliotecas saveBibliotecas(@RequestBody Bibliotecas bibliotecas) {
		return repository.save(bibliotecas);
	}
	@DeleteMapping("/bibliotecas/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deleteBibliotecas(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
