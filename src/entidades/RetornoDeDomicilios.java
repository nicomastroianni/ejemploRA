package ar.com.supervielle.api.entidades;

import java.util.ArrayList;

import ar.com.supervielle.api.entidades.*;




public class RetornoDeDomicilios {
	private ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();
	private ErroresGral error = new ErroresGral();
	public ArrayList<Domicilio> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(ArrayList<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}
	public ErroresGral getError() {
		return error;
	}
	public void setError(ErroresGral error) {
		this.error = error;
	}
}
