package com.creathus.selecao.repository;

//LONG

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creathus.selecao.models.Formulario;
@Repository
public interface FormularioRepository extends JpaRepository<Formulario, String>{

	Formulario findById(long id);

}
