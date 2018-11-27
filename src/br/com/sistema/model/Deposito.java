package br.com.sistema.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deposito")
public class Deposito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer num_deposito;
	@Column
	private String agencia;
	@Column
	private String num_conta;
	@Column
	private String valor;
	@Column
	private Date data_deposito;

	public Integer getNum_deposito() {
		return num_deposito;
	}

	public void setNum_deposito(Integer num_deposito) {
		this.num_deposito = num_deposito;
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

	public Date getData_deposito() {
		return data_deposito;
	}

	public void setData_deposito(Date data_deposito) {
		this.data_deposito = data_deposito;
	}

	@Override
	public String toString() {
		return "Deposito [num_deposito=" + num_deposito + ", agencia=" + agencia + ", num_conta=" + num_conta
				+ ", valor=" + valor + ", data_deposito=" + data_deposito + "]";
	}

}
