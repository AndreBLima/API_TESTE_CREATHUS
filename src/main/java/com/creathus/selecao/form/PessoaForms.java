package com.creathus.selecao.form;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.creathus.selecao.models.Formulario;


public class PessoaForms {


	@NotBlank(message = "Campo Nome nao pode ser vazio!")
	@Length(min= 5, max = 255,message = "Campo Nome tem que conter 5 caracteres no minino!")
	private String nome;

	@Min(value = 0L, message = "Idade tem que conterapensa valores positivos")
	@Max(value = 100, message = "Idade nao pode ser maior que 100")
	@NotNull(message="Campo Idade nao pode ser vazio!")
	private Integer idade;

	@Email(message = "Insira Email valido!")
	private String email;
	
	@Lob
	private String foto;
	
	@NotBlank(message = "Campo Escolaridade nao pode ser vazio!")
	private String escolaridade;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Formulario converter() {
		return new Formulario(nome, idade, email, foto, escolaridade);
	}

}
