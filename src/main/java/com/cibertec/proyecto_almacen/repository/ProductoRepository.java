package com.cibertec.proyecto_almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.proyecto_almacen.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

	
	@Query("SELECT p FROM Producto p WHERE " + "CONCAT(p.idproducto,p.nomproducto,p.modeloproducto) LIKE %?1%")
	public List<Producto> findAll(String palabraClave);
}
