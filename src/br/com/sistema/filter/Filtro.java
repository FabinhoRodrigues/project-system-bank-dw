package br.com.sistema.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.model.Cliente;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {

	
    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		Cliente cliente = (Cliente) session.getAttribute("clienteAutenticado");
		
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length()).replaceAll("[/]+$", ""); 
		
		if (path.equals("/login.jsp") || path.equals("/erroLogin.jsp") || path.equals("/Autenticar")
				|| path.equals("/criaConta.jsp")|| path.equals("/sucesso.jsp")|| path.equals("/erroConta.jsp")
				|| path.equals("/CriaClienteServlet")) {
		      chain.doFilter(request, response);
		      return;
		 }if ( cliente != null) {
             chain.doFilter(request, response);
             
		 }else {
		        request.getRequestDispatcher("erroLogin.jsp").forward(httpRequest, httpResponse);
		 }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
