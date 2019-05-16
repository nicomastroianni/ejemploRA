package ar.com.supervielle.api.personas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.OutputStream;


import ar.com.supervielle.api.entidades.ErroresAP;
import ar.com.supervielle.api.entidades.ErroresGral;
import ar.com.supervielle.api.entidades.Persona;

import com.google.gson.Gson;
import com.main.bin.Log;

public class AP_Patch {

	/**
	 * @param args
	 */
	//public static void main(String[] args) throws Exception {
	public static Persona PATCH(String urlDinamic,String canal,String usuario,Persona persona,String UUID){	
//		String canal="CRM";
//		String usuario="nm32202";
//		int id=7;
//		
		String url=urlDinamic+"/"+persona.getId();
		
		
		System.out.println("Inicio: apiPersonasPATCH");
		Log.logloggerIID_info(UUID+";Java;AP_GetBANTOTAL;"+"URL: " + url);
        HttpURLConnection con = null;
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
        String aplicacion = "application/json";
        ArrayList<ErroresAP> errores = new ArrayList<ErroresAP>();
        //para que funque :
        //String personaJson ="{ \"apellido\": \"555\", \"codigo_pais\": \"80\", \"codigo_sucursal\": \"1\", \"es_titular\": true, \"estado_civil\": \"2\", \"fecha_nacimiento\": \"10-10-1995\", \"genero\": \"M\", \"nombre\": \"alejandro\", \"numero_documento\": \"912\", \"numero_tributario\": \"1\", \"oficial_propietario\": \"nicolas\", \"oficial_referente\": \"11\", \"segmento_potencial\": \"8\", \"tipo_tributario\": \"1\"}";
        //para error : 
        //String personaJson = "{ \"apellido\": \"string\", \"codigo_pais\": \"string\", \"codigo_sucursal\": \"string\", \"estado_civil\": \"string\", \"fecha_nacimiento\": \"string\", \"genero\": \"string\", \"nombre\": \"string\", \"numero_documento\": \"string\", \"numero_tributario\": \"string\", \"oficial_propietario\": \"string\", \"oficial_referente\": \"string\", \"segmento_potencial\": \"string\", \"tipo_documento\": \"string\", \"tipo_tributario\": 0}";  
        		
        try{
        	//Methods.allowMethods("PATCH");
        	
        	System.out.println("Entro al try");
        	URL obj = new URL(url);
        	con = (HttpURLConnection) obj.openConnection();
           //setMetodo(con, "PATCH");
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("X-Canal", canal);
            con.setRequestProperty("X-Usuario", usuario);
            con.setRequestProperty("Content-Type",aplicacion);
        	System.out.println("Insertando PATCH");
        	 con.setRequestMethod("POST");
             con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
           // con.setDoOutput(true);
         	System.out.println("finalizando connection");
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            
            System.out.println("El chabon dice:"+con.getRequestMethod());
            
            System.out.println("Paso los requestMethod");
            Gson gson = new Gson();
            String personaJson = gson.toJson(persona);
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
                    Log.logloggerIID_debug(UUID+";Java;AP_Patch;"+"Respuesta: "+respuesta);
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
            	
            		Bad_request = Erroresgson.fromJson(respuesta, ErroresGral.class);
            		Log.logloggerIID_debug(UUID+";Java;AP_Patch;"+"Error: "+respuesta);
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
            		
            	
            
           
            
            
            //https://stackoverflow.com/questions/9623158/curl-and-httpurlconnection-post-json-data        
            }
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
	private static void setMetodo(final HttpURLConnection c,final String value) {
		   try {
		       final Object target;
		    
		           Field delegate = HttpURLConnection.class.getDeclaredField("delegate");
		           delegate.setAccessible(true);
		           target = delegate.get(c);
		 
		       final Field f = HttpURLConnection.class.getDeclaredField("method");
		       f.setAccessible(true);
		       f.set(target, value);
		   } catch (IllegalAccessException | NoSuchFieldException ex) {
		       throw new AssertionError(ex);
		   }
		}

}
