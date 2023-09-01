package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

//clsae implementada de alumnoService
@Service
public class AlumnoServiceImpl implements AlumnoService{

	//llmando al alumno repository
	@Autowired
	private AlumnoRepository repository;
	
	
	@Override
	public Alumno insertaAlumno(Alumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
		//usa el metodo save del alumnoRepository
		
	}

}
