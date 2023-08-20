package com.cibertec.proyecto_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.business.MarcaService;
import com.cibertec.proyecto_almacen.model.Marca;



@Controller

public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@RequestMapping("/a/marca")
	public String principal() {
		return "index1";
	}
	
	@GetMapping("/marca")
	public String listadoMarca(Model model) {
		model.addAttribute("listadoMarca",service.listaMarca());
		return "listaMarca";
	}
	
	@GetMapping("/nuevoMarca")
	public String registrarMarca(Model model) {
		Marca marca = new Marca();
		model.addAttribute("marca", marca);
		return "registrarMarca";
	}
	
	@PostMapping("guardarMarca")
	public String registrarMarca(@ModelAttribute("marca") Marca marca) {
		service.registrarMarca(marca);
		return "redirect:/marca";
	}
	
	@GetMapping("/actualizarMarca/{idmarca}")
	public String actualizarMarca(@PathVariable(value ="idmarca") int id, Model model) {
		Marca marca = service.listaMarcaPorId(id);
		model.addAttribute("marca", marca);
		return "actualizarMarca";
	}
	
	@GetMapping("eliminarMarca/{idmarca}")
	public String eliminarMarca(@PathVariable(value ="idmarca") int id) {
		service.eliminarMarca(id);
		return "redirect:/marca";
	}

}
