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
	private String id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false)
	private String email;
	
	private String escolaridade;

	private String nome_arquivo;
	
	private String tipo_arquivo;
	
	@Lob
	private byte[] data;
	
			

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getTipo_arquivo() {
		return tipo_arquivo;
	}

	public void setTipo_arquivo(String tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	public Formulario() {}
	
	public Formulario(String nome,Integer idade,String email, String escolaridade, String nome_arquivo, String tipo_arquivo, byte[] data) {
		this.nome=nome;
		this.idade=idade;
		this.email=email;
		this.escolaridade=escolaridade;
		this.nome_arquivo=nome_arquivo;
		this.tipo_arquivo=tipo_arquivo;
		this.data=data;
	}


}
