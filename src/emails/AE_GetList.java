package ar.com.supervielle.api.emails;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




import ar.com.supervielle.api.entidades.*;

import com.google.gson.Gson;
import com.main.bin.Log;


public class AE_GetList {
//problema con el default de errores, (****se generan listas de listas???****)
	public static RetornoDeEmails obtenerListaEmail(String URLDinamic, String canal,String usuario, int idPersona, String UUID){

		String url=URLDinamic+"/"+idPersona+"/emails/";
		Log.logloggerIID_debug(UUID+";Java;AE_GetList;"+"URL: "+url);
        System.out.println("Inicio: Inicia GetListEmail");
        System.out.println("url: " + url);
        
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
        
        RetornoDeEmails retorno= new RetornoDeEmails();
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
 	

    	
       try{
        	System.out.println("Entro al try");
        	//hago conexion
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("X-Canal", canal);
            con.setRequestProperty("X-Usuario", usuario);
            con.setRequestMethod("GET");

             
        	System.out.println("Paso los setRequestMethod");
        
        	int responseCode = con.getResponseCode();
            codigoError = "" + con.getResponseCode();
            mensajeError = con.getResponseMessage();
            System.out.println("responseCode: " + responseCode);
            System.out.println("codigoError: " + codigoError);
            System.out.println("mensajeError: " + mensajeError);
        	
            switch(responseCode) {
            
            case 200:
            
          //lectura de la url
            InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8" );
			
        	System.out.println("Paso el inputStream");

			//lectura del buffer
			BufferedReader reader;
			String line = null;
			reader = new BufferedReader(isr);
			System.out.println("Paso el buffer");
			
			while ((line = reader.readLine()) != null) {
	        	System.out.println("Response: " + line);
				sb.append(line);
			}

			Gson gson = new Gson();
			Email[] emails = gson.fromJson(sb.toString(), Email[].class);
			respuesta=sb.toString();
			Log.logloggerIID_debug(UUID+";Java;AE_GetList;"+"Respuesta: "+respuesta);
			reader.close();
			
			for(int i=0;i<emails.length;i++){
				retorno.getEmails().add(emails[i]);	
			}
			
			break;
            
	
            default:
        		
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
                
        		System.out.println(responseCode);
        		System.out.println(respuesta);

        		Gson Erroresgson = new Gson();
        		ErroresGral Bad_request= new ErroresGral();
        		Bad_request = Erroresgson.fromJson(respuesta, ErroresGral.class);
        		Log.logloggerIID_debug(UUID+";Java;AE_GetList;"+"Respuesta: "+respuesta);
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
        		
            }

        }
	        catch(Exception e){
	        	ErroresAP err = new ErroresAP();
	        	e.printStackTrace();
		        err.setMessage("Fallo la conexion con APIPersonas");
	    		err.setField("APIPersonas");
	    		retorno.getError().getSub_errors().add(err);
	    		return retorno;
        }

     
       return retorno;
       
	}
		
	}

