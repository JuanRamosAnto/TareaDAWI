package com.empresa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter//crea los getter
@Setter//crea los setter
@Entity //para que sea una entidad 
@Table(name = "alumno")//se relaciona con la tabla alumno


public class Alumno {
	@Id//para decir que es PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Forma del Pk identity
	private int idAlumno;
	private String dni;
	private String nombre;
	private String correo;
	@Temporal(TemporalType.DATE)//forma de la fecha
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date fechaNacimiento;
	private String estado;

}
