package com.cibertec.proyecto_almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "producto" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private int idproducto;
	private String nomproducto;
	private int idmarca;
	private String modeloproducto;
	private int cantproducto;
	private int idcategoria;
	private double costoalmacenaje;
	
	
	

}
