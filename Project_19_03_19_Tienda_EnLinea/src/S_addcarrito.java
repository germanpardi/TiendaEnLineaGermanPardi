

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
 * Servlet implementation class S_addcarrito
 */
@WebServlet("/S_addcarrito")
public class S_addcarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_addcarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String siguientepagina= "productos.jsp";
		Vector<Producto_Cantidad> listado_productos_añadidos =(Vector<Producto_Cantidad>)session.getAttribute("listado_productos_añadidos");
		String id_producto = request.getParameter("id_producto");
		String cantidad = request.getParameter("cantidad");
		boolean repetido = false;
		
		IProductoSERVICE proservice = new ProductoSERVICE();
		Producto producto = proservice.buscarnombre(Integer.parseInt(id_producto));
		Producto_Cantidad pc = new Producto_Cantidad(producto.getId_producto(),producto.getIdCategorias(),producto.getDescripcion(),producto.getPrecio(),producto.getStock(),1);
		
		
		for (Producto_Cantidad pcant : listado_productos_añadidos) {
			
			if(pc.getId_producto()== pcant.getId_producto() && !repetido) {
				pcant.setCantidad(pcant.getCantidad()+1);
				//pcant.setCantidad(Integer.parseInt(cantidad));
				repetido = true;
			}
		}
		if(!repetido) {
			listado_productos_añadidos.add(pc);
		}
		
		session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
		RequestDispatcher rd = request.getRequestDispatcher(siguientepagina);//ACA EN ESTAS DOS LINEAS REENVIAMOS A SIGUIENTE PAGINA
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
