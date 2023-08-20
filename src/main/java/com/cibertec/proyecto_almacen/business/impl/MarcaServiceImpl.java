package com.cibertec.proyecto_almacen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.proyecto_almacen.business.MarcaService;
import com.cibertec.proyecto_almacen.model.Marca;
import com.cibertec.proyecto_almacen.repository.CargoRepository;
import com.cibertec.proyecto_almacen.repository.MarcaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService{
	
	private MarcaRepository repository;

	@Override
	public List<Marca> listaMarca() {
		return repository.findAll();
	}

	@Override
	public void registrarMarca(Marca marca) {
		repository.save(marca);
		
	}

	@Override
	public Marca listaMarcaPorId(int id) {
		Optional<Marca> objeto = repository.findById(id);
		Marca marca = null;
		
		if(objeto.isPresent()) {
			marca = objeto.get();
		}else {
			throw new RuntimeException("Marca con el id" + id +"no fue encontrada");
		}
		return marca;
	}

	@Override
	public void eliminarMarca(int id) {
		repository.deleteById(id);
		
	}

}
