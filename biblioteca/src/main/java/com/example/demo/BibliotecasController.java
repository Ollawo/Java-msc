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
public class BibliotecasController {
	@Autowired
	BibliotecasRepository brepository;
	
	@GetMapping("/bibliotecas")
	public List<Bibliotecas> getAllBibliotecas(){
		return brepository.findAll();
	}
	@GetMapping ("/bibliotecas/{id}")
	public Bibliotecas getBibliotecasPorId(@PathVariable Long id) {
		return brepository.findById(id).get();
	}
	@PostMapping("/bibliotecas")
	public Bibliotecas saveBibliotecas(@RequestBody Bibliotecas bibliotecas) {
		return brepository.save(bibliotecas);
	}
	@DeleteMapping("/bibliotecas/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deleteBibliotecas(@PathVariable Long id) {
		brepository.deleteById(id);
	}
}
