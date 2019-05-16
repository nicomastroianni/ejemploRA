package ar.com.supervielle.api.emails;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;



import ar.com.supervielle.api.entidades.*;

import com.google.gson.Gson;
import com.main.bin.Log;





public class AE_Delete {

		public static RetornoDeEmails AP_DeleteEmail(String urlDinamic,String canal,String usuario,String idPersona,int idEmail,String UUID){ 
			String url=urlDinamic+"/"+idPersona+"/emails/"+idEmail;
			Log.logloggerIID_debug(UUID+";Java;AE_Delete;"+"URL: "+url);
			RetornoDeEmails retorno = new RetornoDeEmails();
			Email email = new Email();
			
			
			System.out.println("Inicio: AP_DeleteEmail");
			
	        HttpURLConnection con = null;
	        String codigoError = "";
	        String mensajeError = "";
	        String respuesta = "";
	        Log.logloggerIID_debug(UUID+";Java;AE_Get;"+"Request: idPersona: "+idPersona+" - idEmail: "+idEmail);
	        try{
	        	System.out.println("Entro al try");
	        	URL obj = new URL(url);
	            con = (HttpURLConnection) obj.openConnection();
	            con.setRequestMethod("DELETE");
	            con.setRequestProperty("accept", "*/*");
	            con.setRequestProperty("X-Canal", canal);
	            con.setRequestProperty("X-Usuario", usuario);
	            con.setDoOutput(true);
	            
	            
	            OutputStream os = con.getOutputStream();
	            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
	            
	            System.out.println("Paso los requestMethod");

	            int responseCode = con.getResponseCode();
	            codigoError = "" + con.getResponseCode();
	            mensajeError = con.getResponseMessage();
	            System.out.println("responseCode: " + responseCode);
	            System.out.println("codigoError: " + codigoError);
	            System.out.println("mensajeError: " + mensajeError);
	            
	            System.out.println("Paso la asignacion de errores");
	            System.out.println(responseCode);
	            	
	            switch(responseCode) {
	            	
	            	case 200:
	            		InputStream is = con.getInputStream();
	            		InputStreamReader isr = new InputStreamReader(is, "UTF-8" );
	                      
	                    String inputLine;
	                    StringBuilder response = new StringBuilder();
	                    BufferedReader in;
	                    in = new BufferedReader(isr);
	                    System.out.println("paso el buffer");
	                    while ((inputLine = in.readLine()) != null) {
	                    	response.append(inputLine);
	                    }
	                    respuesta = response.toString();
	                    System.out.println("Asigno una respuesta");
	                    in.close();
	                    System.out.println(respuesta);
	                    Log.logloggerIID_debug(UUID+";Java;AE_Delete;"+"Respuesta: "+respuesta);
	                    retorno.getEmails().add(email);
	                	retorno.getEmails().get(0).setId(idEmail);
	                	Log.logloggerIID_debug("paso");
	        			// se cargo el idEMail en el primer elemento de la lista para tener como
	                	// retorno de respuesta en caso exitoso
	                	
	                	
	            		break;
	            		
	            	case 204:
	            		 is = con.getInputStream();
	            		 isr = new InputStreamReader(is, "UTF-8" );
	                        
	                    response = new StringBuilder();
	                    
	                    in = new BufferedReader(isr);
	                    System.out.println("paso el buffer");
	                    while ((inputLine = in.readLine()) != null) {
	                    	response.append(inputLine);
	                    }
	                    respuesta = "Se elimino correctamente email id: "+ idEmail;
	                    System.out.println("Asigno una respuesta");
	                    in.close();
	                    System.out.println(respuesta);
	                    Log.logloggerIID_debug(UUID+";Java;AE_Delete;"+"Respuesta: "+respuesta);
	                    retorno.getEmails().add(email);
	                    retorno.getEmails().get(0).setId(idEmail);
	        			// se cargo el idEMail en el primer elemento de la lista para tener como
	                	// retorno de respuesta en caso exitoso
	                		                	
	            		break;
		  
	            	default:
	            		try{
	            			InputStream isError = con.getErrorStream();
	                		InputStreamReader isrError = new InputStreamReader(isError, "UTF-8" );
	                        
	                        String inputLineError;
	                        StringBuilder responseError = new StringBuilder();
	                        BufferedReader inError;
	                        inError= new BufferedReader(isrError);
	                        System.out.println("paso el buffer");
	                        while ((inputLineError = inError.readLine()) != null) {
	                        	responseError.append(inputLineError);
	                        }
	                        respuesta = responseError.toString();
	                        System.out.println("Asigno una respuesta");
	                        inError.close();
	                		System.out.println(responseCode+"");
	                		System.out.println(respuesta);
	                		
	                		Gson Erroresgson = new Gson();
	                		ErroresGral Bad_request= new ErroresGral();
	                		Bad_request = Erroresgson.fromJson(respuesta, ErroresGral.class);
	                		Log.logloggerIID_debug(UUID+";Java;AE_Delete;"+"Respuesta: "+respuesta);
	                		if(( !Bad_request.getSub_errors().isEmpty()) || (!Bad_request.getStatus().isEmpty()) ){

	                			for(int i=0;i<Bad_request.getSub_errors().size();i++){
	                				ErroresAP err = new ErroresAP();
	                			    System.out.println(Bad_request.getSub_errors().get(i).getMessage());
	                    			err.setMessage(Bad_request.getSub_errors().get(i).getMessage());
	                        		err.setField(Bad_request.getSub_errors().get(i).getField());
	                        		retorno.getError().getSub_errors().add(err);
	                        	}
	                			if(Bad_request.getSub_errors().isEmpty()){
	                    			ErroresAP err = new ErroresAP();
	            					err.setMessage(Bad_request.getMessage());
	                        		err.setField(Bad_request.getStatus());
	                        		retorno.getError().getSub_errors().add(err);
	                				
	            				}
	                			
	                		}else{
	                			ErroresAP err = new ErroresAP();
	                			err.setMessage(Bad_request.getMessage());
	                    		err.setField(responseCode+"");
	                    		retorno.getError().getSub_errors().add(err);
	                		}

	                		break;

	            		}catch(Exception e){
	            			ErroresAP err = new ErroresAP();
	            	        err.setMessage("Alg�n parametro requerido no esta presente, o no cumple con el formato v�lido o el canal enviado es inv�lido");
	                		err.setField("AP_DeleteEmail");
	                		retorno.getError().getSub_errors().add(err);
	                		
	                		return retorno;
	            		}
	            	}

	            //https://stackoverflow.com/questions/9623158/curl-and-httpurlconnection-post-json-data        
	        	
	        }
	        catch(Exception e){
	        	ErroresAP err = new ErroresAP();
		        err.setMessage("Fallo la conexion con APIPersonas");
	    		err.setField("AP_DeleteEmail");
	    		retorno.getError().getSub_errors().add(err);
	    		return retorno;
	        }
	        
	   
	    	System.out.println("FINALIZO METODO DELETE");
	    	return retorno;
		}
	
}
