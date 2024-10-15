package org.serratec.cadastro.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "cadastros")
public class Cadastrar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	@Enumerated(EnumType.STRING)
	private Vaga vagaDesejada;
	@Enumerated(EnumType.STRING)
	private Status statusCurriculo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Vaga getVagaDesejada() {
		return vagaDesejada;
	}
	public void setVagaDesejada(Vaga vagaDesejada) {
		this.vagaDesejada = vagaDesejada;
	}
	public Status getStatusCurriculo() {
		return statusCurriculo;
	}
	public void setStatusCurriculo(Status statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	
	

}
