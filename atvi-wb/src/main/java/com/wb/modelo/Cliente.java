package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public String nomeSocial;
	private CPF cpf;
	private List<RG> rgs;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private String genero;

	public Cliente(String nome, String nomeSocial, CPF cpf, String genero) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.genero = genero;
		this.rgs = new ArrayList<>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<>();
	}

	public String getNome() { return nome; }
	public String getNomeSocial() { return nomeSocial; }
	public CPF getCpf() { return cpf; }
	public List<RG> getRgs() { return rgs; }
	public LocalDate getDataCadastro() { return dataCadastro; }
	public List<Telefone> getTelefones() { return telefones; }
	public String getGenero() { return genero; }

	public void setNome(String nome) { this.nome = nome; }
	public void setNomeSocial(String nomeSocial) { this.nomeSocial = nomeSocial; }
	public void setCpf(CPF cpf) { this.cpf = cpf; }
	public void setRgs(List<RG> rgs) { this.rgs = rgs; }
	public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
	public void setTelefones(List<Telefone> telefones) { this.telefones = telefones; }
	public void setGenero(String genero) { this.genero = genero; }
}