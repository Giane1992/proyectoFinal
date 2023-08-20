package com.cibertec.proyecto_almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.business.CategoriaProductoService;
import com.cibertec.proyecto_almacen.business.MarcaService;
import com.cibertec.proyecto_almacen.business.ProductoService;
import com.cibertec.proyecto_almacen.model.CategoriaProducto;
import com.cibertec.proyecto_almacen.model.Marca;
import com.cibertec.proyecto_almacen.model.Producto;

@Controller

public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private CategoriaProductoService categoriaService;
	
	@RequestMapping("/a/producto")
	public String principal() {
		return "index1";
	}

	@GetMapping("/producto")
	public String listaProducto(Model model) {
		List<Producto> listProducto = service.listaProducto();

		model.addAttribute("listaProducto", listProducto);
		model.addAttribute("marcaService", marcaService);
		model.addAttribute("categoriaService", categoriaService);
		return "listaProducto";
	}
	
	@GetMapping("/nuevoProducto")
	public String registrarProducto(Model model) {
		Producto producto = new Producto();
		List<Marca> listMarca = marcaService.listaMarca();
		List<CategoriaProducto> listCate = categoriaService.listCategoriaProducto();
		model.addAttribute("producto", producto);
		model.addAttribute("marca", listMarca);
		model.addAttribute("categoriaProducto", listCate);
		return "registrarProducto";
	}
	
	@PostMapping("guardarProducto")
	public String registrarProducto(@ModelAttribute("producto") Producto producto) {
		service.registrarProducto(producto);
		return "redirect:/producto";
	}
	
	@GetMapping("/actualizarProducto/{idproducto}")
	public String actualizarProducto(@PathVariable(value ="idproducto") int id, Model model) {
		Producto producto = service.listaProductoPorId(id);
		List<Marca> listMarca = marcaService.listaMarca();
		List<CategoriaProducto> listCate = categoriaService.listCategoriaProducto();
	
		model.addAttribute("producto", producto);
		model.addAttribute("marca", listMarca);
		model.addAttribute("categoriaProducto", listCate);
		return "actualizarProducto";
	}
	
	@GetMapping("eliminarProducto/{idproducto}")
	public String eliminarProducto(@PathVariable(value ="idproducto") int id) {
		service.eliminarProducto(id);
		return "redirect:/producto";
	}
	
	@GetMapping("/consultaproducto")
	public String consultaProducto(Model model,@Param("palabraClave") String palabraClave) {
		List<Producto> listProducto = service.listaProducto(palabraClave);

		model.addAttribute("listaProducto", listProducto);
		model.addAttribute("marcaService", marcaService);
		model.addAttribute("categoriaService", categoriaService);
		model.addAttribute("palabraClave",palabraClave);
		return "consultaProducto";
	}
	

	

}
