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
@Table( name = "empresa_transporte" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpresaTransporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresatransporte")
	private int idempresatransporte;
	private String razonsocialtransporte;
	private String ruc;

}
