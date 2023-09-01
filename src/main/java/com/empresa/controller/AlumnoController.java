package com.empresa.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	 //LLAMANDO AL SERVICE 
	@Autowired //autocompleta solo, spring inyecta el new 
	private AlumnoService service;
	
	
	@GetMapping(value = "/verAlumno" )
	public String ver() {
		return "registraAlumno";
	}
	
	//Registra Alumno
	@PostMapping("/registraAlumno")
	
        //public String registra(Alumno obj) { //obj recibe todo el formulario
	    //FORMATO JASON 
		 public ResponseEntity<?> registra(Alumno obj) { //obj recibe todo el formulario
		
		HashMap<String, String> salida = new HashMap<>();
		
		//service.insertaAlumno(obj);
		Alumno objSalida = service.insertaAlumno(obj);
		if(objSalida == null) {
			 salida.put("MENSAJE", "Error en el Registro");
		}else {
			salida.put("MENSAJE", "Registro Exitoso");
		}
		
    	//return "registraAlumno";
    	return ResponseEntity.ok(salida);
    }
}
