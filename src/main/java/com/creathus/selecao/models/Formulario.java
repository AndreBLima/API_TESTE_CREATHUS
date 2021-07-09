package com.creathus.selecao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="TB_FORMULARIO")
public class Formulario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false)
	private String email;
	
	@Lob
	private String foto;
	
	@Column(nullable = false)
	private String escolaridade;

		

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Formulario() {}

	public Formulario(String nome,Integer idade,String email, String foto, String escolaridade) {
		this.nome=nome;
		this.idade=idade;
		this.email=email;
		this.foto=foto;
		this.escolaridade=escolaridade;
	}


}
