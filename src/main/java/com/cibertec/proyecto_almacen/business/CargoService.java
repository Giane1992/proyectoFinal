package com.cibertec.proyecto_almacen.business;

import java.util.List;

import com.cibertec.proyecto_almacen.model.Cargo;

public interface CargoService {
	
	List<Cargo> listaCargo();
	void registrarCargo(Cargo cargo);
	Cargo listaCargoPorId(int id);
	void eliminarCargo(int id);
}
