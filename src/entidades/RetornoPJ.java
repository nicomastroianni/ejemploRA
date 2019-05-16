package ar.com.supervielle.api.entidades;

import java.util.ArrayList;

public class RetornoPJ {

	private ArrayList<PersonaJuridica> personasJuridicas = new ArrayList<PersonaJuridica>();
	private ErroresGral error = new ErroresGral();
	public ArrayList<PersonaJuridica> getPersonasJuridicas() {
		return personasJuridicas;
	}
	public void setPersonasJuridicas(ArrayList<PersonaJuridica> personasJuridicas) {
		this.personasJuridicas = personasJuridicas;
	}
	public ErroresGral getError() {
		return error;
	}
	public void setError(ErroresGral error) {
		this.error = error;
	}
	
}
