package com.cibertec.proyecto_almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.proyecto_almacen.model.Usuario;

@Controller
public class UsuarioController {
	
	@GetMapping("/")
	public String mostarUsuario() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute("loginFormulario")Usuario usuario, Model model){
				String nomusuario = usuario.getNomusuario();
				String passusuario = usuario.getPassusuario();
				if (nomusuario != null && passusuario != null) {
			        if (nomusuario.equals("admin") && passusuario.equals("123456")) {
			            model.addAttribute("usuario", nomusuario);
			            return "index1";
			        } else {
			            model.addAttribute("error", "Usuario y/o Clave incorrectos..");
			            return "login";
			        }
			    } else {
			        model.addAttribute("error", "Campos de usuario y/o contraseña vacíos.");
			        return "login";
			    }
	

	}
}
