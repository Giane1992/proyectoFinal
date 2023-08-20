package com.cibertec.proyecto_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.business.EmpresaTransporteService;
import com.cibertec.proyecto_almacen.model.EmpresaTransporte;



@Controller

public class EmpresaTransporteController {

	@Autowired
	private EmpresaTransporteService service;
	

	@RequestMapping("/a/empresa")
	public String principal() {
		return "index1";
	}
	
	
	@GetMapping("/empresa")
	public String listadoEmpresaTransporte(Model model) {
		model.addAttribute("listadoEmpresaTransporte",service.listaEmpresaTransporte());
		return "listaEmpresaTransporte";
	}
	
	@GetMapping("/nuevoEmpresaTransporte")
	public String registrarEmpresaTransporte(Model model) {
		EmpresaTransporte empresa = new EmpresaTransporte();
		model.addAttribute("empresaTransporte", empresa);
		return "registrarEmpresaTransporte";
	}
	
	@PostMapping("guardarEmpresaTransporte")
	public String registrarEmpresaTransporte(@ModelAttribute("empresaTransporte") EmpresaTransporte empresa) {
		service.registrarEmpresaTransporte(empresa);
		return "redirect:/empresa";
	}
	
	@GetMapping("/actualizarEmpresaTransporte/{idempresatransporte}")
	public String actualizarEmpresaTransporte(@PathVariable(value ="idempresatransporte") int id, Model model) {
		EmpresaTransporte empresa = service.listaEmpresaTransportePorId(id);
		model.addAttribute("empresaTransporte", empresa);
		return "actualizarEmpresaTransporte";
	}
	
	@GetMapping("eliminarEmpresaTransporte/{idempresatransporte}")
	public String eliminarEmpresaTransporte(@PathVariable(value ="idempresatransporte") int id) {
		service.eliminarEmpresaTransporte(id);
		return "redirect:/empresa";
	}

}
