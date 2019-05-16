package ar.com.supervielle.api.personasJuridicas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;


import ar.com.supervielle.api.entidades.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.main.bin.Log;
import commonj.sdo.DataObject;



public class APJ_GetID {

	public static PersonaJuridica GETID(String urlDinamic,String canal,String usuario,int id) {

		urlDinamic = "http://apiperds-01:9091/v1.0/juridicas";
		 
		String url = urlDinamic+"/"+id;
        System.out.println("Inicio: Persona Juridica GETID");
        System.out.println("url: " + url);
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
        
        PersonaJuridica persona= new PersonaJuridica();
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
    	ArrayList<ErroresAP> errores = new ArrayList<ErroresAP>();
    	
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

			//line="{\"declarado\":\"string\",\"direccion\":\"string\",\"fecha_creacion\":\"string\",\"fecha_modificacion\":\"string\",\"id\": 0,\"normalizado\":\"string\",\"origen_contacto\":\"DESCONOCIDO\",\"tipo_contacto\":\"string\"}";
			//line="{\"barrio\":\"sarasa\",\"calle\":\"string\",\"codigo_localidad\":\"string\",\"codigo_pais\":\"string\",\"codigo_postal\":\"string\",\"codigo_postal_adicional\":\"string\",\"codigo_provincia\":\"string\",\"departamento\":\"string\",\"fecha_creacion\":\"string\",\"fecha_modificacion\":\"string\",\"id\": 0,\"normalizado\":\"string\",\"numero\":\"string\",\"origen_contacto\":\"string\",\"partido\":\"string\",\"piso\":\"string\",\"tipo_contacto\":\"string\"}";
			//line ="{\"compania\":\"CLARO\",\"declarado\":\"string\",\"fecha_creacion\":\"string\",\"fecha_modificacion\":\"string\",\"id\": 0,\"no_llame\":\"string\",\"normalizado\":\"string\",\"numero\":\"string\",\"origen_contacto\":\"DESCONOCIDO\",\"tipo_contacto\":\"LABORAL\",\"tipo_telefono\":\"FIJO\"}";
			//line="{\"id\":78,\"nombre\":\"JUAN JOSE\",\"apellido\":\"ESPINOSA\",\"emails\":[],\"telefonos\":[],\"domicilios\":[],\"genero\":\"M\",\"oficial_referente\":null,\"oficial_propietario\":null,\"canal_creacion\":null,\"tipo_documento\":\"4\",\"numero_documento\":\"10137782\",\"codigo_pais\":\"80\",\"codigo_sucursal\":\"14\",\"fecha_creacion\":null,\"fecha_modificacion\":null,\"fecha_nacimiento\":\"29-07-1953\",\"segmento_potencial\":\"1\",\"tipo_tributario\":null,\"numero_tributario\":\"20101377823\",\"estado_civil\":\"2\",\"es_titular\":true}";

			Gson gson = new Gson();
			persona = gson.fromJson(sb.toString(), PersonaJuridica.class);
			
			reader.close();
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
        		
        		if(!Bad_request.getSub_errors().isEmpty()){
        			for(int i=0;i<Bad_request.getSub_errors().size();i++){
        				ErroresAP err = new ErroresAP();
            			System.out.println(Bad_request.getSub_errors().get(i).getMessage());
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
        		
        		break;
        		
            }
            
            
            
            
        }
	        catch(Exception e){
	        	ErroresAP err = new ErroresAP();
	        	e.printStackTrace();
		        err.setMessage("Fallo la conexion con APIPersonas");
	    		err.setField("APIPersonas");
				errores.add(err);
	    		persona.setErrores(errores);
	    		return persona;
        }
        //Log.logloggerIID_debug(sb.toString());
     
        return persona;
       
	}
	
}

//https://stackoverflow.com/questions/18636567/converting-curl-request-to-http-request-java
//https://stackoverflow.com/questions/9623158/curl-and-httpurlconnection-post-json-data
//https://crunchify.com/java-url-example-getting-text-from-url/


 