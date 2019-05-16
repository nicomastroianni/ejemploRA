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

public class AP_Put {

	/**
	 * @param args
	 */
	//public static void main(String[] args) throws Exception {
	public static Persona PUT(String UrlDinamic,String canal,String usuario,Persona persona,String UUID){	
		String url=UrlDinamic+"/"+persona.getId();
		System.out.println("Inicio: apiPersonasPUT");
		
		Log.logloggerIID_debug(UUID+";Java;AP_Put;"+"URL: " + url);
        HttpURLConnection con = null;
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
        String aplicacion = "application/json";
        ArrayList<ErroresAP> errores = new ArrayList<ErroresAP>();
        //para que funque :
      //  String personaJson = "{ \"apellido\": \"alejandroSS\", \"codigo_pais\": \"11\", \"codigo_sucursal\": \"3\", \"estado_civil\": \"3\", \"fecha_nacimiento\": \"20-09-1994\", \"genero\": \"F\", \"nombre\": \"nico\", \"numero_documento\": \"333\", \"numero_tributario\": \"2\", \"oficial_propietario\": \"alejandro\", \"oficial_referente\": \"10\", \"segmento_potencial\": \"7\", \"tipo_documento\": \"1\", \"tipo_tributario\": \"1\"}";
        //para error : 
        //String personaJson = "{ \"apellido\": \"string\", \"codigo_pais\": \"string\", \"codigo_sucursal\": \"string\", \"estado_civil\": \"string\", \"fecha_nacimiento\": \"string\", \"genero\": \"string\", \"nombre\": \"string\", \"numero_documento\": \"string\", \"numero_tributario\": \"string\", \"oficial_propietario\": \"string\", \"oficial_referente\": \"string\", \"segmento_potencial\": \"string\", \"tipo_documento\": \"string\", \"tipo_tributario\": 0}";  
        		
        try{
        	System.out.println("Entro al try");
        	URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("X-Canal", canal);
            con.setRequestProperty("X-Usuario", usuario);
            con.setRequestProperty("Content-Type",aplicacion);
            con.setDoOutput(true);
            
            
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            
            System.out.println("Paso los requestMethod");
            Gson gson = new Gson();
            String personaJson = gson.toJson(persona);
            Log.logloggerIID_debug(UUID+";Java;AP_Put;"+"Request: "+personaJson);
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
                   
                    Log.logloggerIID_debug(UUID+";Java;AP_Put;"+"Response "+responseCode+": "+respuesta);
                	persona = personaJSON.fromJson(respuesta, Persona.class);
            		break;
	  
            	default:
            		
            		try{
                		InputStream isError = con.getErrorStream();
                		System.out.println(isError);
                		InputStreamReader isrError = new InputStreamReader(isError, "UTF-8" );
                		System.out.println(isrError);
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
                		
                		Log.logloggerIID_error(UUID+";Java;AP_Put;"+"Error "+responseCode+": "+respuesta);
                		Bad_request = Erroresgson.fromJson(respuesta, ErroresGral.class);
                		
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
        
        return persona;
	}

}
