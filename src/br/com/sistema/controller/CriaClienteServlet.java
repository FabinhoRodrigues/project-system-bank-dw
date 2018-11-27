package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.Conta;
import br.com.sistema.repository.ContaEntity;
import br.com.sistema.servico.ServicoConta;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/CriaClienteServlet")
public class CriaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaClienteServlet() {
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
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String cSenha = request.getParameter("cSenha");
		
		ServicoConta servico = new ServicoConta();
		
		
		if(!senha.contains(cSenha)){
				request.getRequestDispatcher("erroConta.jsp").forward(request, response);
				
		}
		String numero = servico.abreConta(nome, cpf, endereco, email, cSenha);
		ContaEntity contaEntity = new ContaEntity();
		
		Conta conta = contaEntity.busca(numero);
		request.setAttribute("numero",conta.getNumero());
		request.setAttribute("agencia",conta.getAgencia());
		request.setAttribute("cliente",conta.getCpf_cliente());
		
		request.getRequestDispatcher("sucesso.jsp").forward(request, response);
	}

}
