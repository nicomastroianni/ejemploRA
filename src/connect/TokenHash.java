package ar.com.supervielle.api.connect;


public class TokenHash {
	public  String token_type;
	public  String access_token;
	public  String expires_in;
	public  String consented_on;
	public  String scope;
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getConsented_on() {
		return consented_on;
	}
	public void setConsented_on(String consented_on) {
		this.consented_on = consented_on;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
}
