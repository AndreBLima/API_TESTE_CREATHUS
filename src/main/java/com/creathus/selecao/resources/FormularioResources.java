package com.creathus.selecao.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creathus.selecao.form.PessoaForms;
import com.creathus.selecao.models.Formulario;
import com.creathus.selecao.repository.FormularioRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class FormularioResources {

	@Autowired
	FormularioRepository formularioRepository;

	@GetMapping("/formulario")
	public List<Formulario> listaPessoas(){
		return formularioRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	public Formulario pessoa(@PathVariable(value="id") long id){
		return formularioRepository.findById(id);
	}

	@PostMapping("/formulario")
	public Formulario SalvaPessoa(@RequestBody @Valid PessoaForms pessoa){
		Formulario formulario= pessoa.converter();
		return formularioRepository.save(formulario);

	}

	@DeleteMapping("/formulario")
	public void deletaPessoa(@RequestBody Formulario pessoa) {
		formularioRepository.delete(pessoa);
	}

	@PutMapping("/formulario")
	public Formulario AtualizaPessoa(@RequestBody @Valid PessoaForms pessoa) {
		Formulario formulario = pessoa.converter();
		return formularioRepository.save(formulario);
	}

	// inicio foto

	// fim foto

}
