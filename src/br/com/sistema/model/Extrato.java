package br.com.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extrato")
public class Extrato {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "contaOrigem")
private String contaOrigem;

@Column(name = "contaDestino")
private String contaDestino;
	
@Column
private Double valor;

@Column
private String dataExtrato;
	
@Column
private String transacao;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public String getContaOrigem() {
	return contaOrigem;
}

public void setContaOrigem(String contaOrigem) {
	this.contaOrigem = contaOrigem;
}

public String getContaDestino() {
	return contaDestino;
}

public void setContaDestino(String contaDestino) {
	this.contaDestino = contaDestino;
}


public String getDataExtrato() {
	return dataExtrato;
}

public void setDataExtrato(String dataExtrato) {
	this.dataExtrato = dataExtrato;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}

public String getTransacao() {
	return transacao;
}

public void setTransacao(String transacao) {
	this.transacao = transacao;
}

@Override
public String toString() {
	return "Transação: " + transacao + "\n" +
		   "Data : " + dataExtrato + "\n" +
		   "Conta Origem: " + contaOrigem + "\n" +
		   "Conta Destino: " + contaDestino + "\n" +
		   "Valor: " + valor +  "\n";
}



}
