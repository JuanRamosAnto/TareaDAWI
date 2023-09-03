package com.empresa.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;


@Controller
public class MedicamentoController {
	
	 //LLAMANDO AL SERVICE 
	@Autowired //autocompleta solo, spring inyecta el new 
	private MedicamentoService service;
	
	@GetMapping(value ="/verMedicamento")
	public String verMedicamento() {
		return "registraMedicamento";
	}
	@PostMapping("/registraMedicamento")
	@ResponseBody
        public HashMap<String,String> registra(Medicamento obj) { //obj recibe todo el formulario
		
		HashMap<String, String> salida = new HashMap<>();
		Medicamento objSalida = service.insertaMedicamento(obj);
		if(objSalida == null) {
			 salida.put("MENSAJE", "Error en el Registro");
		}else {
			salida.put("MENSAJE", "Registro Exitoso");
		}
		return salida;
	}
}
