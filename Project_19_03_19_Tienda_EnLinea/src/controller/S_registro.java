package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import excepciones.ExcepcionDomain;
import interfaces.IUsuarioSERVICE;

import services.UsuarioSERVICE;

/**
 * Servlet implementation class S_registro
 */
@WebServlet("/S_registro")
public class S_registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(true);
		try {
			//int alta = 0;
			String siguientepagina= "index.jsp";
			String mensaje = "";
			String id_usuario= request.getParameter("id_usuario");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			Usuario usuario = new Usuario();
			IUsuarioSERVICE usuarioservice = new UsuarioSERVICE();
			usuario.setId_usuario(id_usuario);
			usuario.setPassword(password);
			usuario.setEmail(email);
			
			Usuario aux = usuarioservice.buscarnombre(id_usuario);
			
			if (aux == null) {
				usuarioservice.altausuario(usuario);
				//alta = 1;
				mensaje = "El usuario se ha creado correctamente";
				//session.setAttribute("email", email );
				
				//session.setAttribute("cliente", cliente );//SUBO SESION
			}else {
				mensaje = "El usuario ya existe";
			}
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
			rd.forward(request, response);
		}catch(ExcepcionDomain e){
			request.setAttribute("errores", e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("registrarse.jsp");//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
			rd.forward(request, response);
		    }
		//request.setAttribute("mensaje", mensaje);
		//RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
		//rd.forward(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
