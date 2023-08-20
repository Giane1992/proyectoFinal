package com.cibertec.proyecto_almacen.business;

import java.util.List;

import com.cibertec.proyecto_almacen.model.CategoriaProducto;

public interface CategoriaProductoService {
	
  List<CategoriaProducto> listCategoriaProducto();
  void registrarCategoriaProducto(CategoriaProducto catprod);
  CategoriaProducto listaCategoriaProductoPorId(int id);
  void eliminarCategoriaProducto(int id);
	

}
