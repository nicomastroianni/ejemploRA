package ar.com.supervielle.api.entidades;

public class Email {

	private String declarado;
    private String direccion;
    private String fecha_creacion;
    private String fecha_modificacion;
    private int id;
    private String normalizado;
    private String origen_contacto;
    private String tipo_contacto;
	
    public String getDeclarado() {
		return declarado;
	}
	public void setDeclarado(String declarado) {
		this.declarado = declarado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNormalizado() {
		return normalizado;
	}
	public void setNormalizado(String normalizado) {
		this.normalizado = normalizado;
	}
	public String getOrigen_contacto() {
		return origen_contacto;
	}
	public void setOrigen_contacto(String origen_contacto) {
		this.origen_contacto = origen_contacto;
	}
	public String getTipo_contacto() {
		return tipo_contacto;
	}
	public void setTipo_contacto(String tipo_contacto) {
		this.tipo_contacto = tipo_contacto;
	}

}
