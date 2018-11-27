package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.servico.ServicoConta;

/**
 * Servlet implementation class TransferenciaServlet
 */
@WebServlet("/TransferenciaServlet")
public class TransferenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferenciaServlet() {
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
		
		String contaOrigem = request.getParameter("contaOrigem");
		String contaDestino = request.getParameter("contaDestino");
		@SuppressWarnings("unused")
		String descricao = request.getParameter("descricao");
		String valor = request.getParameter("valor");
		String data = request.getParameter("data");
		
		ServicoConta servico = new ServicoConta();
		String retorno = servico.transferencia(contaOrigem, contaDestino, valor, data);
		
		if(retorno.equals("Operação não realizada")  ||  retorno.equals("Transferencia indisponivel")){
			request.getRequestDispatcher("erroTransferencia.jsp").forward(request, response);
			
		}
		if(retorno.equals("ok")){
		request.getRequestDispatcher("sucessoTransferencia.jsp").forward(request, response);
		}
	}

}
