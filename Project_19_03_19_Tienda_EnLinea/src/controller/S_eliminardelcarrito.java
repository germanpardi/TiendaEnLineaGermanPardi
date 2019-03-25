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
import beans.Producto_Cantidad;
import interfaces.IProductoSERVICE;
import services.ProductoSERVICE;

/**
 * Servlet implementation class S_eliminardelcarrito
 */
@WebServlet("/S_eliminardelcarrito")
public class S_eliminardelcarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_eliminardelcarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String siguientepagina= "carrito.jsp";
		//boolean repetido = false;
		//boolean repetido = false;
		
		Vector<Producto_Cantidad> listado_productos_añadidos =(Vector<Producto_Cantidad>)session.getAttribute("listado_productos_añadidos");
		String id_producto = request.getParameter("id_producto");
		String cantidad = request.getParameter("cantidad");
		
		IProductoSERVICE proservice = new ProductoSERVICE();
		//Producto producto = proservice.buscarnombre(Integer.parseInt(id_producto));
		//Producto_Cantidad pcant = new Producto_Cantidad(producto.getId_producto(),producto.getIdCategorias(),producto.getDescripcion(),producto.getPrecio(),producto.getStock(),Integer.parseInt(cantidad));
		/*if(listado_productos_añadidos.size()==1) {
			listado_productos_añadidos.clear();
		}*/
		
		for (Producto_Cantidad pc : listado_productos_añadidos) {
			
			if(Integer.parseInt(id_producto)==pc.getId_producto() && Integer.parseInt(cantidad)>1) {
				pc.setCantidad(pc.getCantidad()-1);
				session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
				RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
				rd.forward(request, response);
				
				
			}if(Integer.parseInt(id_producto)==pc.getId_producto() && Integer.parseInt(cantidad)==1) {
				int i= listado_productos_añadidos.indexOf(pc);
				listado_productos_añadidos.remove(i);
				session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
				RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
				rd.forward(request, response);
			  }
		}
		/*
		session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
		RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
		rd.forward(request, response);
		*/
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
