package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Categoria;
import beans.Producto;
import beans.Producto_Cantidad;
import beans.Usuario;
import excepciones.ExcepcionDomain;
import interfaces.ICategoriaSERVICE;
import interfaces.IUsuarioSERVICE;
import services.CategoriaSERVICE;
import services.UsuarioSERVICE;

/**
 * Servlet implementation class S_index
 */
@WebServlet("/S_index")
public class S_index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			IUsuarioSERVICE usuarioservice = new UsuarioSERVICE();
			ICategoriaSERVICE catservice = new CategoriaSERVICE();
			String siguientepagina= "";
			String mensaje = "";
			String id_usuario= request.getParameter("id_usuario");
			String password = request.getParameter("password");
			Vector<Categoria>listado_categorias = catservice.listarcategorias();
			Usuario aux = usuarioservice.buscarnombre(id_usuario);
			Vector<Producto_Cantidad> listado_productos_añadidos = new Vector();
			String email = aux.getEmail();
			String recordar = request.getParameter("recordar");
			if (recordar == null) {
				recordar="";
			}
			if(recordar.equals("recordar")) {
				Cookie cusuario = new Cookie("usuario",id_usuario);
				Cookie cpassword = new Cookie("password",password);
				cusuario.setMaxAge(3600);
				cpassword.setMaxAge(3600);
				response.addCookie(cusuario);
				response.addCookie(cpassword);
			}
			System.out.println(aux);
			session.setAttribute("id_usuario", id_usuario);
		
			
			if(aux==null) {
				siguientepagina = "index.jsp";
				mensaje="El usuario no existe, seleccione la opción "+"Registrarse "+" para crear un nuevo usuario.";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
				rd.forward(request, response);
			}
			//String id_usuario_intro = aux.getId_usuario();
			//String password_intro = aux.getPassword();
			
			
			if ((id_usuario.equals(aux.getId_usuario()))&&(password.equals(aux.getPassword()))) {
				siguientepagina= "categorias.jsp";
				session.setAttribute("listado_categorias", listado_categorias);
				session.setAttribute("id_usuario", id_usuario);
				session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
				session.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
				rd.forward(request, response);
			}else {
				siguientepagina = "index.jsp";
				mensaje="Password incorrecta.";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
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
