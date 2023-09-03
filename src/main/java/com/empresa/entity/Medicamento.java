package com.empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "medicamento")
public class Medicamento {
   
	@Id//para decir que es PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Forma del Pk identity
	private int idMedicamento;
	private String nombre;
	private Double precio;
	private int stock;
	private String laboratorio;
	
	
}
