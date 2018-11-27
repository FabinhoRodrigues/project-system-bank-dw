package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.servico.ServicoConta;

/**
 * Servlet implementation class SaqueServlet
 */
@WebServlet("/SaqueServlet")
public class SaqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaqueServlet() {
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
	
		String conta = request.getParameter("conta");
		String valor = request.getParameter("valor");
		String data = request.getParameter("data");
		
		ServicoConta servico = new ServicoConta();
		String retorno = servico.saque(conta, valor,data);
		
		if(retorno.equals("Operação não realizada")  ||  retorno.equals("Saque indisponivel")){
			request.getRequestDispatcher("erroSaque.jsp").forward(request, response);
			
		}
		if(retorno.equals("ok")){
		request.getRequestDispatcher("sucessoSaque.jsp").forward(request, response);
		}
	}


}
