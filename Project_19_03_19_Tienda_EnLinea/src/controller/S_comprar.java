package controller;
import javax.mail.*;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.Factura;
import beans.Posicion;
import beans.Producto_Cantidad;
import interfaces.ICab_facturaSERVICE;
import interfaces.IPosicionSERVICE;
import interfaces.IProductoSERVICE;
import interfaces.IUsuarioSERVICE;
import services.FacturaSERVICE;
import services.PosicionSERVICE;
import services.ProductoSERVICE;
import services.UsuarioSERVICE;
import beans.EnviarMail;
/**
 * Servlet implementation class S_comprar
 */
@WebServlet("/S_comprar")
public class S_comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String siguientepagina= "index.jsp";
		
		/// MONTAR EN MySQL LA CABECERA CON ID_USUARIO Y ID_FACTURA///
		Factura factura = new Factura();
		ICab_facturaSERVICE facservice = new FacturaSERVICE();
		String id_usuario= (String) session.getAttribute("id_usuario");
		String email = (String)session.getAttribute("email");
		factura.setid_usuario(id_usuario);
		facservice.altausuario(factura);
		int id_factura = facservice.buscarMAX();
		
		
		//// RESTAR DEL STOCK ////
		Vector<Producto_Cantidad> listado_productos_añadidos =(Vector<Producto_Cantidad>)session.getAttribute("listado_productos_añadidos");
		String id_producto = request.getParameter("id_producto");
		//String cantidad = request.getParameter("cantidad");
		//String stock = session.getAttribute("stock");
		IProductoSERVICE proservice = new ProductoSERVICE();
		for (Producto_Cantidad pc : listado_productos_añadidos) {
			
			pc.setStock(pc.getStock()- pc.getCantidad());
			proservice.modificarusuario(pc);	
		}
		
		///SUBIR LA POSICION DE FACTURAS A MYSQL///
		IPosicionSERVICE posicionservice = new PosicionSERVICE();
		Posicion posicion = new Posicion();
		int pos_factura=1;
		Vector<Posicion> posiciones_factura = new Vector();
		for (Producto_Cantidad pcant : listado_productos_añadidos) {
			
			posicion.setCantidad(pcant.getCantidad());
			posicion.setId_factura(id_factura);
			posicion.setId_producto(pcant.getId_producto());
			posicion.setPos_factura(pos_factura);
			posicionservice.altausuario(posicion);
			posiciones_factura.add(posicion);
			pos_factura+=1;
		}
		
		posiciones_factura.toString();
		
		
		
		////SEND EMAIL////
		String contenido = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"es\">\r\n" + 
				" <head>\r\n" + 
				"  <title>Factura</title>\r\n" + 
				"  <link rel=\"stylesheet\" href=\"factura.css\" >\r\n" + 
				" </head>\r\n" + 
				" <body>\r\n" + 
				"  <h1>Factura</h1>\r\n" + 
				"  <table>\r\n" + 
				"   <tr>\r\n" + 
				"    <th>Producto</th>\r\n" + 
				"    <th>Precio</th>\r\n" + 
				"    <th>Cantidad</th>\r\n" + 
				"    <th>Total</th>\r\n" + 
				"   </tr>";
		int total=0;
		for(listado_productos_añadidos.size(); listado_productos_añadidos.size() > 0;) {
			//System.out.println("ENTRO EN LA VERRGA ESTA");
			Producto_Cantidad producto = listado_productos_añadidos.firstElement();
			//String mensaje = producto.toString();
			String mensaje = "<th><h2>"+ producto.getDescripcion()+"</th></h2>\n" + "<th><h2>"+ 
			 producto.totalPrecio(producto.getCantidad(), producto.getPrecio())+"</th></h2>\n"+producto.getCantidad()+"</th></h2>\n"+ "<th><h2>";
			total+=producto.totalPrecio(producto.getCantidad(), producto.getPrecio());
			
			listado_productos_añadidos.remove(0);
			contenido += "<tr>" + mensaje + "</tr>\r\n";
		}
		contenido += "<th><h2>"+ total + "</th>+</h2>"+"</table>\r\n" + "</body>\r\n" + "</html>";
		

	
		EnviarMail emailcompra = new EnviarMail();
		emailcompra.enviarConGMail(email, "Factura GerTECH", contenido);
		
		
		
		session.setAttribute("posiciones_factura", posiciones_factura);
		session.setAttribute("id_usuario", id_usuario);
		session.setAttribute("listado_productos_añadidos", listado_productos_añadidos);
		session.setAttribute("id_factura", id_factura);
		
		
		session.invalidate();
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
