package com.cibertec.proyecto_almacen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.proyecto_almacen.business.CargoService;
import com.cibertec.proyecto_almacen.model.Cargo;
import com.cibertec.proyecto_almacen.repository.CargoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService{
	
	private CargoRepository repository;

	@Override
	public List<Cargo> listaCargo() {
		return repository.findAll();
	}

	@Override
	public void registrarCargo(Cargo cargo) {
	   repository.save(cargo);
		
	}

	@Override
	public Cargo listaCargoPorId(int id) {
		Optional<Cargo> objeto = repository.findById(id);
		Cargo cargo=null;
		
		if(objeto.isPresent()) {
			cargo = objeto.get();
		}else {
			throw new RuntimeException("Cargo con el id" + id +"no fue encontrada");
		}
		return cargo;
	}

	@Override
	public void eliminarCargo(int id) {
		repository.deleteById(id);
		
	}

}
