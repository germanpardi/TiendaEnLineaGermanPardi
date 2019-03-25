package beans;

public class Categoria {
	private int idCategorias;
	private String Descripcion;
	
	
	public int getIdCategorias() {
		return idCategorias;
	}
	public void setIdCategorias(int idCategorias) {
		this.idCategorias = idCategorias;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [idCategorias=" + idCategorias + ", Descripcion=" + Descripcion + "]";
	}
	public Categoria() {
		super();
	}
	public Categoria(int idCategorias, String descripcion) {
		super();
		this.idCategorias = idCategorias;
		Descripcion = descripcion;
	}
		
	

}
