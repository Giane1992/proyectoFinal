package com.cibertec.proyecto_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.business.CargoService;
import com.cibertec.proyecto_almacen.model.Cargo;

@Controller
public class CargoController {

	@Autowired
	private CargoService service;
	
	
	@RequestMapping("/a/cargo")
	public String principal() {
		return "index1";
	}
	
	@GetMapping("/cargo")
	public String listadoCargo(Model model) {
		model.addAttribute("listadoCargo",service.listaCargo());
		return "listaCargo";
	}
	
	@GetMapping("/nuevoCargo")
	public String registrarCargo(Model model) {
		Cargo cargo = new Cargo();
		model.addAttribute("cargo", cargo);
		return "registrarCargo";
	}
	
	@PostMapping("guardarCargo")
	public String registrarCargo(@ModelAttribute("cargo") Cargo cargo) {
		service.registrarCargo(cargo);
		return "redirect:/a/cargo";
	}
	
	@GetMapping("/actualizarCargo/{idcargo}")
	public String actualizarCargo(@PathVariable(value ="idcargo") int id, Model model) {
		Cargo cargo = service.listaCargoPorId(id);
		model.addAttribute("cargo", cargo);
		return "actualizarCargo";
	}
	
	@GetMapping("eliminarCargo/{idcargo}")
	public String eliminarCargo(@PathVariable(value ="idcargo") int id) {
		service.eliminarCargo(id);
		return "redirect:/a/cargo";
	}

}
