package ar.com.supervielle.api.entidades;

import java.util.ArrayList;

public class RetornoDeTelefono {
	
	private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	private ErroresGral error = new ErroresGral();
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public ErroresGral getError() {
		return error;
	}
	public void setError(ErroresGral error) {
		this.error = error;
	}

}
