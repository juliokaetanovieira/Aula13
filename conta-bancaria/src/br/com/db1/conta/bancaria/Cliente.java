package br.com.db1.conta.bancaria;

public class Cliente {
	
	private String nome;
	
	private String cpf;
	
	public Cliente(String nome, String cpf){
		if(nome == null){
			throw new RuntimeException("Nome é obrigatório");
		}
		
		if(nome.length() < 5){
			throw new RuntimeException("Nome deve ser maior ou igual a 5");
		}
		
		if(cpf == null){
			throw new RuntimeException("Cpf é obrigatório");
		}
		
		if(cpf.length() != 11){
			throw new RuntimeException("CPF inválido");
		}		
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCpf(){
		return this.cpf;
	}

}
