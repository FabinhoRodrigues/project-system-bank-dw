package br.com.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conta")
public class Conta {

@Id
@Column	
private String numero;
@Column
private String agencia;
@Column
private Double saldo;
@Column
private String cpf_cliente;
@Column
private String senha;


public String getNumero() {
	return numero;
}


public void setNumero(String numero) {
	this.numero = numero;
}


public String getAgencia() {
	return agencia;
}


public void setAgencia(String agencia) {
	this.agencia = agencia;
}



public Double getSaldo() {
	return saldo;
}


public void setSaldo(Double saldo) {
	this.saldo = saldo;
}


public String getCpf_cliente() {
	return cpf_cliente;
}


public void setCpf_cliente(String cpf_cliente) {
	this.cpf_cliente = cpf_cliente;
}


public String getSenha() {
	return senha;
}


public void setSenha(String senha) {
	this.senha = senha;
}


@Override
public String toString() {
	return "Conta [numero=" + numero + ", agencia=" + agencia + ", saldo=" + saldo + ", cpf_cliente=" + cpf_cliente
			+ ", senha=" + senha + "]";
}





	

}
