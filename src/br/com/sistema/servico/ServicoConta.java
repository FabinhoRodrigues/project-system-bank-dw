package br.com.sistema.servico;

import java.text.NumberFormat;
import java.util.Random;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Conta;
import br.com.sistema.model.Extrato;
import br.com.sistema.repository.ClienteEntity;
import br.com.sistema.repository.ContaEntity;
import br.com.sistema.repository.ExtratoEntity;

public class ServicoConta {

	public String abreConta(String nome,String cpf,String endereco,String email, String senha){
		
		Cliente cliente = new Cliente();
		Conta conta = new Conta();
		
		Random gerador = new Random();
		int num = gerador.nextInt(9999999);
		String numConta = NumberFormat.getInstance().format(num);
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		conta.setAgencia("0476");
		conta.setNumero(numConta);
		conta.setCpf_cliente(cliente.getCpf());
		conta.setSaldo(0.0);
		conta.setSenha(cliente.getSenha());
		
		ClienteEntity clienteEntity =  new ClienteEntity();
		ContaEntity contaEntity =  new ContaEntity();
		
		clienteEntity.salva(cliente);
		System.out.println("Cliente salvo com sucesso!");
		contaEntity.salva(conta);
		System.out.println("Conta aberta com sucesso!");
		
		return numConta;
	}
	public String fechaConta(String numero, String senha){
		ContaEntity contaEntity =  new ContaEntity();
		ClienteEntity clienteEntity =  new ClienteEntity();
		Conta conta = contaEntity.busca(numero);
		Cliente cliente = clienteEntity.busca(conta.getCpf_cliente());
		
		if(conta.getSenha().equals(senha)){
			
			contaEntity.deleta(conta);
			clienteEntity.deleta(cliente);
			System.out.println("Cliente e Conta deletada com sucesso!");
			return "ok";
		}
		return "Senha inválida";
	}
	public String deposito(String numero,String valor, String data){
		
		ContaEntity contaEntity =  new ContaEntity();
		Conta conta = contaEntity.busca(numero);
		Extrato extrato = new Extrato();
		ExtratoEntity entity = new ExtratoEntity();
		Double valorDeposito = Double.parseDouble(valor);
		
		if(conta != null){
			Double saldoAtual = conta.getSaldo();
			Double saldoFinal = valorDeposito + saldoAtual;
			conta.setSaldo(saldoFinal);
			contaEntity.atualiza(conta);
			
			
			String num = "0";
			extrato.setContaOrigem(conta.getNumero());
			extrato.setContaDestino(num);
			extrato.setTransacao("DEPÓSITO");
			extrato.setValor(valorDeposito);
			extrato.setDataExtrato(data);
			entity.salva(extrato);
			
			return "ok";
			
		}
		return "Operação não realizada";
	}
	public String saque(String numero,String valor ,String data){
		
		ContaEntity contaEntity =  new ContaEntity();
		Conta conta = contaEntity.busca(numero);
		Double valorSaque = Double.parseDouble(valor);
		
		if(conta != null){
			Double saldoAtual = conta.getSaldo();
			if(saldoAtual > valorSaque){
			Double saldoFinal = saldoAtual - valorSaque;
			conta.setSaldo(saldoFinal);
			contaEntity.atualiza(conta);
			
			Extrato extrato = new Extrato();
			ExtratoEntity entity = new ExtratoEntity();
			
			String num = "0";
			extrato.setContaOrigem(conta.getNumero());
			extrato.setContaDestino(num);
			extrato.setTransacao("SAQUE");
			extrato.setValor(valorSaque);
			extrato.setDataExtrato(data);
			entity.salva(extrato);
			
			
			return "ok";
			}
			return "Saque indisponivel";
		}
		return "Operação não realizada";
	}
public String transferencia(String numeroOrigem,String numeroDestino,String valor, String data){
		
		ContaEntity contaEntity =  new ContaEntity();
		Conta contaOrigem = contaEntity.busca(numeroOrigem);
		Conta contaDestino = contaEntity.busca(numeroDestino);
		Double valorTransferencia = Double.parseDouble(valor);
		
		if(contaOrigem != null){
			Double saldoAtual = contaOrigem.getSaldo();
			if(saldoAtual > valorTransferencia){
			Double saldoFinal = saldoAtual - valorTransferencia;
			contaOrigem.setSaldo(saldoFinal);
			contaEntity.atualiza(contaOrigem);
			Double saldoDestino = contaDestino.getSaldo();
			contaDestino.setSaldo(saldoDestino + valorTransferencia);
			contaEntity.atualiza(contaDestino);
			
			Extrato extrato = new Extrato();
			ExtratoEntity entity = new ExtratoEntity();
			
			extrato.setContaOrigem(contaOrigem.getNumero());
			extrato.setContaDestino(contaDestino.getNumero());
			extrato.setTransacao("TRANSFERENCIA");
			extrato.setValor(valorTransferencia);
			extrato.setDataExtrato(data);
		
			entity.salva(extrato);
			
			return "ok";
			}
			return "Transferencia indisponivel";
		}
		return "Operação não realizada";
	}
public String extrato(Cliente cliente){
	
	 
	ContaEntity contaEntity = new ContaEntity();
	ExtratoEntity extrato= new ExtratoEntity();
	Conta conta = new Conta();


	conta = contaEntity.buscaCpf(cliente.getCpf());
	
	return "Cliente: " + cliente.getNome( )+ "Cliente: " + cliente.getNome();

}

}
