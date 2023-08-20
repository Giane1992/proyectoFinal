package com.cibertec.proyecto_almacen.business;

import java.util.List;

import com.cibertec.proyecto_almacen.model.Producto;

public interface ProductoService {
	
	List<Producto> listaProducto();
	void registrarProducto(Producto producto);
	Producto listaProductoPorId(int id);
	void eliminarProducto(int id);
	Producto buscarPorId(int id);
    List<Producto> listaProducto(String palabraClave);
    

}
