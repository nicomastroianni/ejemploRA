package ar.com.supervielle.api.personas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.OutputStream;


import ar.com.supervielle.api.entidades.ErroresAP;
import ar.com.supervielle.api.entidades.ErroresGral;
import ar.com.supervielle.api.entidades.Persona;

import com.google.gson.Gson;
import com.main.bin.Log;


public class AP_Post {

	/**
	 * @param args
	 */
	//public static void main(String[] args) throws Exception {
	public static Persona POST(String urlDinamic,String canal, String usuario, Persona persona,String UUID){	
	
		System.out.println("Inicio: apiPersonasPOST_1");
		Log.logloggerIID_debug(UUID+";Java;AP_Post;"+"URL: " + urlDinamic);
		
        HttpURLConnection con = null;
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
        String aplicacion = "application/json";
        ArrayList<ErroresAP> errores = new ArrayList<ErroresAP>();

        
        
        try{
        	System.out.println("Entro al try");
        	URL obj = new URL(urlDinamic);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("X-Canal", canal);
            con.setRequestProperty("X-Usuario", usuario);
            con.setRequestProperty("Content-Type",aplicacion);
            con.setDoOutput(true);
            
            
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            
            System.out.println("Paso los requestMethod");

            Gson gson = new Gson();
           String personaJson = gson.toJson(persona);//(sb.toString(), persona.class);
           Log.logloggerIID_debug(UUID+";Java;AP_Post;"+"Request: "+personaJson);
            osw.write(personaJson);
            osw.flush();
            osw.close();
            
            System.out.println("Escribio el json");
            
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
                	Gson personaJSON = new Gson();
                	
                	Log.logloggerIID_debug(UUID+";Java;AP_Post;"+"Response "+responseCode+": "+respuesta);
                	persona = personaJSON.fromJson(respuesta, Persona.class);
            		break;
	  
            	default:
            		try{
            			InputStream isError = con.getErrorStream();
                		System.out.println(isError);
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
                	
                		Log.logloggerIID_error(UUID+";Java;AP_Post;"+"Error "+responseCode+": "+respuesta);
                		if(!Bad_request.getSub_errors().isEmpty()){
                			for(int i=0;i<Bad_request.getSub_errors().size();i++){
                				ErroresAP err = new ErroresAP();
                    			System.out.println(Bad_request.getSub_errors().get(i).getField()+" - "+Bad_request.getSub_errors().get(i).getMessage());
                    			err.setMessage(Bad_request.getSub_errors().get(i).getMessage());
                        		err.setField(Bad_request.getSub_errors().get(i).getField());
                				errores.add(err);
                        		persona.setErrores(errores);
                    		}
                		}else{
                			ErroresAP err = new ErroresAP();
                			err.setMessage(Bad_request.getMessage());
                    		err.setField(responseCode+"");
            				errores.add(err);
                    		persona.setErrores(errores);
                			
                		}
            			
            		}catch(Exception e){
            			ErroresAP err = new ErroresAP();
                    	//e.printStackTrace();
            	        err.setMessage("Algún parametro requerido no esta presente, o no cumple con el formato válido o el canal enviado es inválido");
                		err.setField("APIPersonas");
            			errores.add(err);
                		persona.setErrores(errores);
                		return persona;
            		}
            		
//            		Las clases BAD_REQUESTsub_errors.java y personaGET_1BAD_REQUEST.java fueron creadas con el fin
//            		de futura implementacion de manejo de errores.
            		
            	}
            
           
            
            
            //https://stackoverflow.com/questions/9623158/curl-and-httpurlconnection-post-json-data        
        	
        }
        catch(Exception e){
        	ErroresAP err = new ErroresAP();
        	//e.printStackTrace();
	        err.setMessage("Fallo la conexion con APIPersonas");
    		err.setField("APIPersonas");
			errores.add(err);
    		persona.setErrores(errores);
    		return persona;
        }
        
   
    	//Log.logloggerIID_debug("FINALIZO METODO POST");
    	return persona;
	}

}
