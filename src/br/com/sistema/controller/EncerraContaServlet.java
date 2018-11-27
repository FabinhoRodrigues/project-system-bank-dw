package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Conta;
import br.com.sistema.repository.ContaEntity;
import br.com.sistema.servico.ServicoConta;

/**
 * Servlet implementation class encerraContaServlet
 */
@WebServlet("/EncerraContaServlet")
public class EncerraContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncerraContaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session  = request.getSession();
		Cliente cliente = (Cliente)session.getAttribute("clienteAutenticado");
		System.out.println("Encerramento de conta " + cliente.getNome());
		ContaEntity contaEntity = new ContaEntity();
		Conta conta = contaEntity.buscaCpf(cliente.getCpf());
		System.out.println("Encerramento de conta " + conta.getNumero());
		
		
		String senha = request.getParameter("senha");
		String cSenha = request.getParameter("cSenha");
		
		ServicoConta servico = new ServicoConta();
		
		if(!senha.equals(cSenha)){
				request.getRequestDispatcher("erroConta.jsp").forward(request, response);
		}
		String resposta = servico.fechaConta(conta.getNumero(), senha);
			if(resposta.contains("Senha inválida")){
				request.getRequestDispatcher("erroConta.jsp").forward(request, response);
				
			}
			if(!resposta.contains("Senha inválida")){
				request.getRequestDispatcher("sucessoEncerra.jsp").forward(request, response);
				response.getWriter();
			}
	}

}
