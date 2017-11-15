package br.com.models;

public class Conta {
	private int numero;
	private int agencia;
	private float saldo;
	private int cliente;
	private int tipo;
	
	public Conta(){
		
	}

	public Conta(int conta, int agencia, float saldo, int cliente) {
		super();
		this.numero = conta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int conta) {
		this.numero = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		String dados = "Nº da conta: " + this.numero +
				"\nAgência: " + this.agencia + 
				"\nSaldo: " + this.saldo;
		return dados;
	}
	

}
