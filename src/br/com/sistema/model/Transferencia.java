package br.com.sistema.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer num_transferencia;
	@Column
	private String num_conta_origem;
	@Column
	private String num_conta_destino;
	@Column
	private String valor;
	@Column
	private Date data_transferencia;

	public Integer getNum_transferencia() {
		return num_transferencia;
	}

	public void setNum_transferencia(Integer num_transferencia) {
		this.num_transferencia = num_transferencia;
	}

	public String getNum_conta_origem() {
		return num_conta_origem;
	}

	public void setNum_conta_origem(String num_conta_origem) {
		this.num_conta_origem = num_conta_origem;
	}

	public String getNum_conta_destino() {
		return num_conta_destino;
	}

	public void setNum_conta_destino(String num_conta_destino) {
		this.num_conta_destino = num_conta_destino;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(Date data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	@Override
	public String toString() {
		return "Transferencia [num_transferencia=" + num_transferencia + ", num_conta_origem=" + num_conta_origem
				+ ", num_conta_destino=" + num_conta_destino + ", valor=" + valor + ", data_transferencia="
				+ data_transferencia + "]";
	}

}
