package ar.com.supervielle.api.entidades;

public class Estado {

	private Boolean esta_expuesta;
	private String fecha_ultimo_cambio_pep;
	public Boolean getEsta_expuesta() {
		return esta_expuesta;
	}
	public void setEsta_expuesta(Boolean esta_expuesta) {
		this.esta_expuesta = esta_expuesta;
	}
	public String getFecha_ultimo_cambio_pep() {
		return fecha_ultimo_cambio_pep;
	}
	public void setFecha_ultimo_cambio_pep(String fecha_ultimo_cambio_pep) {
		this.fecha_ultimo_cambio_pep = fecha_ultimo_cambio_pep;
	}
}
