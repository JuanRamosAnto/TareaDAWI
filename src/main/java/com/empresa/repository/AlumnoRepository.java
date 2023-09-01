package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;
//los metodos se hereddan del japRepository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

	
}
