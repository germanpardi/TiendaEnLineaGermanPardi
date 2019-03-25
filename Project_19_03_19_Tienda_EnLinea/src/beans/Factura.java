package beans;

public class Factura {
	
	private int id_factura;
	private String id_usuario;
	
	public Factura(int id_factura, String id_usuario) {
		super();
		this.id_factura = id_factura;
		this.id_usuario = id_usuario;
	}
	
	public Factura() {
		super();
	}
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	public String getid_usuario() {
		return id_usuario;
	}
	public void setid_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	@Override
	public String toString() {
		return "Factura [id_factura=" + id_factura + ", id_usuario=" + id_usuario + "]";
	}
	

}
