package com.cibertec.proyecto_almacen.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.business.CategoriaProductoService;
import com.cibertec.proyecto_almacen.model.CategoriaProducto;

@Controller
public class CategoriaProductoController {
	
	@Autowired
	private CategoriaProductoService service;
	
	@GetMapping("/listar")
	public String listadoCategoriaProducto(Model model) {
		model.addAttribute("listaCategoriaProducto", service.listCategoriaProducto());
		return "index";
	}
	
	@GetMapping("/a")
	public String principal() {
		return "index1";
	}
	
	
	@GetMapping("/nuevaCategoriaProducto")
	public String registrarCategoriaProducto(Model model) {
		CategoriaProducto catProd = new CategoriaProducto();
		model.addAttribute("categoriaProducto", catProd);
		return "registrarCategoriaProducto";
	}
	
	@PostMapping("guardarCategoriaProducto")
	public String registrarCategoriaProducto(@ModelAttribute("categoriaProducto") CategoriaProducto catProd) {
		service.registrarCategoriaProducto(catProd);
		return "redirect:/listar";
	}
	
	@GetMapping("/actualizarCategoriaProducto/{idcategoria}")
	public String actualizarCategoriaProducto(@PathVariable(value ="idcategoria") int id, Model model) {
		CategoriaProducto catProd = service.listaCategoriaProductoPorId(id);
		model.addAttribute("categoriaProducto", catProd);
		return "actualizarCategoriaProducto";
	}
	
	@GetMapping("eliminarCategoriaProducto/{idcategoria}")
	public String eliminarCategoriaProducto(@PathVariable(value ="idcategoria") int id) {
		service.eliminarCategoriaProducto(id);
		return "redirect:/listar";
	}
	
	
	
	
	
	

}
