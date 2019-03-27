package br.com.db1.conta.bancaria;

public enum ContaBancariaTipo {
	POUPANCA("0013"), CORRENTE("0001");
	
	/*numero e atributo da classe*/
	private String numero;
	
	private ContaBancariaTipo(String numero){
		/*joga o atributo nome desse escopo menor para o atributo numero do escopo da classe*/
		this.numero = numero;	
	}
	
	public String getNumero(){
		return this.numero;
	}

}
