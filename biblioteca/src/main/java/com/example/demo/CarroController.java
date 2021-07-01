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
public class CarroController {
	@Autowired
	CarroRepository crepository;
	
	@GetMapping("/carro")
	public List<Carro> getAllCarros(){
		return crepository.findAll();
	}
	@GetMapping ("/carro/{id}")
	public Carro getCarroPorId(@PathVariable Long id) {
		return crepository.findById(id).get();
	}
	@PostMapping("/carro")
	public Carro saveCarro(@RequestBody Carro carro) {
		return crepository.save(carro);
	}
	@DeleteMapping("/carro/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public void deleteCarro(@PathVariable Long id) {
		crepository.deleteById(id);
	}
}
