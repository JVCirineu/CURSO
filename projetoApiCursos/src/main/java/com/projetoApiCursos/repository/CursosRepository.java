package com.projetoApiCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoApiCursos.entities.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

}
