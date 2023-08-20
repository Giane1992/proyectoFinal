package com.cibertec.proyecto_almacen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
	
	private int idusuario;
	private String nomusuario;
	private String passusuario;

}
