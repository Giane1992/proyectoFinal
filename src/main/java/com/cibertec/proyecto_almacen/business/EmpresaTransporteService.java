package com.cibertec.proyecto_almacen.business;

import java.util.List;

import com.cibertec.proyecto_almacen.model.EmpresaTransporte;



public interface EmpresaTransporteService {
	
	List<EmpresaTransporte> listaEmpresaTransporte();
	void registrarEmpresaTransporte(EmpresaTransporte empresa);
	EmpresaTransporte listaEmpresaTransportePorId(int id);
	void eliminarEmpresaTransporte(int id);

}
