package ar.com.supervielle.api.entidades;

import java.util.ArrayList;

import ar.com.supervielle.api.entidades.*;



public class RetornoDeEmails {
	
	private ArrayList<Email> emails = new ArrayList<Email>();
	private ErroresGral error = new ErroresGral();
	
	public ArrayList<Email> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<Email> emails) {
		this.emails = emails;
	}
	public ErroresGral getError() {
		return error;
	}
	public void setError(ErroresGral error) {
		this.error = error;
	}


}
