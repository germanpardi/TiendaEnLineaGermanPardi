package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Producto;
import interfaces.IProductoSERVICE;
import services.ProductoSERVICE;

/**
 * Servlet implementation class S_categorias
 */
@WebServlet("/S_categorias")
public class S_categorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_categorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String siguientepagina= "productos.jsp";
		String descripcionCategoria = request.getParameter("descripcion");
		IProductoSERVICE proservice = new ProductoSERVICE();
		Vector<Producto>listado_productos_categoria = proservice.listado_productos_por_descripcion(descripcionCategoria);
		session.setAttribute("listado_productos_categoria", listado_productos_categoria);
		RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
		rd.forward(request, response);										// ^^^^^^^^^^
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
