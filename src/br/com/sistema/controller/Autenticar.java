package br.com.sistema.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.model.Cliente;
import br.com.sistema.repository.AutenticaEntity;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		System.out.println("entrou doGet");
		
		if(sessao != null){
			sessao.invalidate();
		}
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println(email);
		System.out.println(senha);
		
		Cliente cliente = new Cliente();
		
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		Cliente clienteAutenticado = null;
		AutenticaEntity entity = new AutenticaEntity();
		String controle = null;
		
						try {
							 clienteAutenticado = entity.autentica(cliente);
							
							request.getSession().setAttribute("clienteAutenticado", clienteAutenticado);
					        
							System.out.println("Entrou no try");
							controle = "ok";
							
						
						} catch (NoResultException | SQLException  e) {
							e.getMessage();
							System.out.println("Entrou no catch");
							controle = "negado";
							
						}
						if(controle == "ok"){
							request.getRequestDispatcher("home.jsp").forward(request, response);
						}if(controle == "negado"){	
						request.getSession().invalidate();	
						request.getRequestDispatcher("erroLogin.jsp").forward(request, response);	
						}
					
	}
}
