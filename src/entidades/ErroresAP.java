package ar.com.supervielle.api.entidades;

public class ErroresAP {
	private String message;
	private String field;
	private String rejected_value;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getRejected_value() {
		return rejected_value;
	}
	public void setRejected_value(String rejected_value) {
		this.rejected_value = rejected_value;
	}
	

}
