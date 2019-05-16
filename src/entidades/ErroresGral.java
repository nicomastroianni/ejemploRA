package ar.com.supervielle.api.entidades;

import java.util.ArrayList;
import java.util.List;

public class ErroresGral {
	private String status;
	private String timestap;
	private String message;
	private List<ErroresAP> sub_errors= new ArrayList<ErroresAP>();
	private String path;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestap() {
		return timestap;
	}
	public void setTimestap(String timestap) {
		this.timestap = timestap;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ErroresAP> getSub_errors() {
		return sub_errors;
	}
	public void setSub_errors(List<ErroresAP> sub_errors) {
		this.sub_errors = sub_errors;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
