package ar.com.supervielle.api.entidades;

public class EstadoPersonaExpuestaPoliticamenteDto {
private boolean esta_expuesta;
private String fecha_ultimo_cambio_pep;
public boolean isEsta_expuesta() {
	return esta_expuesta;
}
public void setEsta_expuesta(boolean esta_expuesta) {
	this.esta_expuesta = esta_expuesta;
}
public String getFecha_ultimo_cambio_pep() {
	return fecha_ultimo_cambio_pep;
}
public void setFecha_ultimo_cambio_pep(String fecha_ultimo_cambio_pep) {
	this.fecha_ultimo_cambio_pep = fecha_ultimo_cambio_pep;
}
}
