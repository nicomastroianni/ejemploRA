package ar.com.supervielle.api.personasJuridicas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import ar.com.supervielle.api.*;
import ar.com.supervielle.api.entidades.ErroresAP;
import ar.com.supervielle.api.entidades.ErroresGral;
import ar.com.supervielle.api.entidades.PersonaJuridica;
import ar.com.supervielle.api.entidades.RetornoPJ;

import com.google.gson.Gson;

public class APJ_Post {
	
	public static RetornoPJ POST(String canal,String usuario,PersonaJuridica personaJuridica){ 
		String url="http://apiperds-01:9091/v1.0/juridicas";
		RetornoPJ retorno = new RetornoPJ();
		
		System.out.println("Inicio: APJ_Post");
		
        HttpURLConnection con = null;
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
        String aplicacion = "application/json";	        
        
        try{
        	System.out.println("Entro al try");
        	URL obj = new URL(url);
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
            String personajuridicaJson = gson.toJson(personaJuridica);//(sb.toString(), persona.class);
            
            osw.write(personajuridicaJson);
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
                	Gson json= new Gson();
                	personaJuridica = json.fromJson(respuesta, PersonaJuridica.class);
                	retorno.getPersonasJuridicas().add(personaJuridica);
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
                		err.setField("APJ_Post");
                		retorno.getError().getSub_errors().add(err);
                		
                		return retorno;
            		}
            	}
       }
        catch(Exception e){
        	ErroresAP err = new ErroresAP();
            err.setMessage("Fallo la conexion con APIPersonas");
    		err.setField("APJ_Post");
    		retorno.getError().getSub_errors().add(err);
    		return retorno;
        }
           
    	System.out.println("FINALIZO METODO POST");
    	return retorno;
	}

}
