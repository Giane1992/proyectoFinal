package com.cibertec.proyecto_almacen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.proyecto_almacen.business.EmpresaTransporteService;
import com.cibertec.proyecto_almacen.model.EmpresaTransporte;
import com.cibertec.proyecto_almacen.repository.EmpresaTransporteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaTransporteServiceImpl implements EmpresaTransporteService {
	
	private EmpresaTransporteRepository repository;
	
	@Override
	public List<EmpresaTransporte> listaEmpresaTransporte() {
		
		return repository.findAll();
	}

	@Override
	public void registrarEmpresaTransporte(EmpresaTransporte empresa) {
		repository.save(empresa);
		
	}

	@Override
	public EmpresaTransporte listaEmpresaTransportePorId(int id) {
		Optional<EmpresaTransporte> objeto = repository.findById(id);
		EmpresaTransporte empresa = null;
		
		if(objeto.isPresent()) {
			empresa = objeto.get();
		}else {
			throw new RuntimeException("Empresa de Transporte con el id" + id +"no fue encontrada");
		}
		return empresa;
	}

	@Override
	public void eliminarEmpresaTransporte(int id) {
		repository.deleteById(id);
		
	}

}
