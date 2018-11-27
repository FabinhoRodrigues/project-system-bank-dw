package br.com.sistema.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saque")
public class Saque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer num_saque;
	@Column
	private String agencia;
	@Column
	private String num_conta;
	@Column
	private String valor;
	@Column
	private Date data_saque;

	public Integer getNum_saque() {
		return num_saque;
	}

	public void setNum_saque(Integer num_saque) {
		this.num_saque = num_saque;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getData_saque() {
		return data_saque;
	}

	public void setData_saque(Date data_saque) {
		this.data_saque = data_saque;
	}

	@Override
	public String toString() {
		return "Saque [num_saque=" + num_saque + ", agencia=" + agencia + ", num_conta=" + num_conta + ", valor="
				+ valor + ", data_saque=" + data_saque + "]";
	}

}
