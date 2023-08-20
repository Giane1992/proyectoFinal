package com.cibertec.proyecto_almacen.business;

import java.util.List;


import com.cibertec.proyecto_almacen.model.Marca;

public interface MarcaService {
	
	List<Marca> listaMarca();
	void registrarMarca(Marca marca);
	Marca listaMarcaPorId(int id);
	void eliminarMarca(int id);

}
