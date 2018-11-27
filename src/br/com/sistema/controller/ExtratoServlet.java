package br.com.sistema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Conta;
import br.com.sistema.model.Extrato;
import br.com.sistema.repository.ClienteEntity;
import br.com.sistema.repository.ContaEntity;
import br.com.sistema.repository.ExtratoEntity;

/**
 * Servlet implementation class ExtratoServlet
 */
@WebServlet("/ExtratoServlet")
public class ExtratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtratoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("clienteAutenticado");
		ContaEntity contaEntity = new ContaEntity();
		
		System.out.println(cliente.getNome());
		
		Conta conta = contaEntity.buscaCpf(cliente.getCpf());
		ExtratoEntity extratoEntity = new ExtratoEntity();
		
		session.setAttribute("nome", cliente.getNome());
		session.setAttribute("cpf", cliente.getCpf());
		session.setAttribute("agencia", conta.getAgencia());
		session.setAttribute("conta", conta.getNumero());
		session.setAttribute("saldo", conta.getSaldo());
		
		List<Extrato> lista = extratoEntity.busca(conta.getNumero());
		
		session.setAttribute("lista", lista); 
		
		request.getRequestDispatcher("extrato.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
