package com.cibertec.proyecto_almacen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.proyecto_almacen.business.ProductoService;
import com.cibertec.proyecto_almacen.model.Producto;
import com.cibertec.proyecto_almacen.repository.ProductoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{
	
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public void registrarProducto(Producto producto) {
		repository.save(producto);
		
	}

	@Override
	public Producto listaProductoPorId(int id) {
		Optional<Producto> objeto = repository.findById(id);
		Producto producto = null;
		
		if(objeto.isPresent()) {
			producto = objeto.get();
		}else {
			throw new RuntimeException("Producto con el id" + id +"no fue encontrada");
		}
		return producto;
	}

	@Override
	public void eliminarProducto(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Producto buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listaProducto(String palabraClave) {
		if(palabraClave != null) {
    		return repository.findAll(palabraClave);
    	}
		return repository.findAll();
    }
	
}


