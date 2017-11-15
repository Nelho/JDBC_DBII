package br.com.models;

public class Agencia {
	private int numero;
	private String endereco;
	private String nome_gerente;
	
	
	public Agencia(){
		this(0, "", "");
	}

	public Agencia(int numero, String endereco, String nome_gerente) {
		super();
		this.numero = numero;
		this.endereco = endereco;
		this.nome_gerente = nome_gerente;
	}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNome_gerente() {
		return nome_gerente;
	}


	public void setNome_gerente(String nome_gerente) {
		this.nome_gerente = nome_gerente;
	}
	
	@Override
	public String toString() {
		return "Agencia: " + this.numero;
	}
	

}
