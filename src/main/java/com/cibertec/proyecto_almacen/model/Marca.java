package com.cibertec.proyecto_almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "marca" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmarca")
	private int idmarca;
	private String nommarca;
	
	

}
