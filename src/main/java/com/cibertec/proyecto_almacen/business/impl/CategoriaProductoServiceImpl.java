package com.cibertec.proyecto_almacen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.proyecto_almacen.business.CategoriaProductoService;
import com.cibertec.proyecto_almacen.model.CategoriaProducto;
import com.cibertec.proyecto_almacen.repository.CategoriaProductoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaProductoServiceImpl implements CategoriaProductoService {
	
	private CategoriaProductoRepository repository;

	@Override
	public List<CategoriaProducto> listCategoriaProducto() {
		return repository.findAll();
	}

	@Override
	public void registrarCategoriaProducto(CategoriaProducto catprod) {
		repository.save(catprod);
		
	}

	@Override
	public CategoriaProducto listaCategoriaProductoPorId(int id) {
		Optional<CategoriaProducto> objeto = repository.findById(id);
		CategoriaProducto catprod=null;
		
		if(objeto.isPresent()) {
			catprod = objeto.get();
		}else {
			throw new RuntimeException("Categoria Producto con el id" + id +"no fue encontrada");
		}
		
		return catprod;
	}

	@Override
	public void eliminarCategoriaProducto(int id) {
		repository.deleteById(id);
		
	}
	
	

}
