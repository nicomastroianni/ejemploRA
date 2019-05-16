package ar.com.supervielle.api.domicilios;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import ar.com.supervielle.api.entidades.*;

import com.google.gson.Gson;
import com.main.bin.Log;

public class AD_Get {
	
	public static RetornoDeDomicilios obtenerDomicilio(String urlDinamic,String canal,String usuario, int idDomicilio, int idPersona, String UUID){
//		String url = urlDinamic+"/"+id;
		String url=urlDinamic+"/"+idPersona+"/domicilios/"+idDomicilio;
		Log.logloggerIID_debug(UUID+";Java;AD_Get;"+"URL: "+url);
        System.out.println("Inicio: Inicia GetDomicilio");
        System.out.println("url: " + url);
        
        RetornoDeDomicilios retorno = new RetornoDeDomicilios();
        //devuelve la primer posicion como caso 200 de la lista de domicilios.
        
        
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
        
       	Domicilio domicilio = new Domicilio();
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
			domicilio = gson.fromJson(sb.toString(), Domicilio.class);
			
			Log.logloggerIID_debug(UUID+";Java;AD_Get;"+"Respuesta: "+sb.toString());
			reader.close();

			//agrego domicilio a lista de retorno 
			retorno.getDomicilios().add(domicilio);

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
        		//Log.logloggerIID_debug("error: "+respuesta);
        		
        		Gson Erroresgson = new Gson();
        		ErroresGral Bad_request= new ErroresGral();
        		Bad_request = Erroresgson.fromJson(respuesta, ErroresGral.class);

        		Log.logloggerIID_debug(UUID+";Java;AD_Get;"+"Respuesta: "+respuesta);
        		if(!Bad_request.getSub_errors().isEmpty()){
        			for(int i=0;i<Bad_request.getSub_errors().size();i++){
        				ErroresAP err = new ErroresAP();
            			System.out.println(Bad_request.getSub_errors().get(i).getMessage());
            			err.setMessage(Bad_request.getSub_errors().get(i).getMessage());
                		err.setField(Bad_request.getSub_errors().get(i).getField());
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
      
        //Log.logloggerIID_debug(sb.toString());
     
        return retorno;
       
	}

}
