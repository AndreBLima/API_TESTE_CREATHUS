package com.creathus.selecao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creathus.selecao.models.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long>{

	Formulario findById(long id);

}
