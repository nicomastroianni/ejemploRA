package ar.com.supervielle.api.personas;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import ar.com.supervielle.api.entidades.ErroresAP;
import ar.com.supervielle.api.entidades.ErroresGral;
import ar.com.supervielle.api.entidades.Persona;
import com.google.gson.Gson;
import com.main.bin.Log;


public class AP_GetBANTOTAL {

	public static Persona GETBANTOTAL(String urlDinamic,String canal,String usuario,String codigoPais, String numeroDocumento, String tipoDocumento,String UUID) {

		String url = urlDinamic+"?codigo_pais="+codigoPais+"&numero_documento="+numeroDocumento+"&tipo_documento="+tipoDocumento;
        System.out.println("Inicio: ApiPersonasBantotal");
        Log.logloggerIID_debug(UUID+";Java;AP_GetBANTOTAL;"+"URL: " + url);
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(); //para conseguir lo que me trae el servicio
     
        Persona persona= new Persona();
        String codigoError = "";
        String mensajeError = "";
        String respuesta = "";
    	ArrayList<ErroresAP> errores = new ArrayList<ErroresAP>();
    	
        String personaSinCorchetes="";
        try{
        	System.out.println("Entro al try");
        	//hago conexion
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("X-Canal", canal);
            con.setRequestProperty("X-Usuario", usuario);
            //FALTA TokenHash
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
			System.out.println("Paso el buffer del 200");
			
			
			while ((line = reader.readLine()) != null) {
	        	System.out.println("Response: " + line);
				sb.append(line);
			}
			//sb.delete(1, sb.length()-1);
			
			personaSinCorchetes = sb.substring(1, sb.length()-1);
			System.out.println("formateado: "+personaSinCorchetes);
			
			Gson gson = new Gson();
			Log.logloggerIID_debug(UUID+";Java;AP_GetBANTOTAL;"+"Response "+responseCode+": "+personaSinCorchetes);
		    persona = gson.fromJson(personaSinCorchetes, Persona.class);
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
        		System.out.println(responseCode+"");
        		System.out.println(respuesta);
        		
        		Gson Erroresgson = new Gson();
        		ErroresGral Bad_request= new ErroresGral();
        		
        		Log.logloggerIID_error(UUID+";Java;AP_GetBANTOTAL;"+"Error "+responseCode+": "+respuesta);
        		
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
       // Log.logloggerIID_debug(sb.toString());
      
        //return persona;
        return persona;
	}
	
}

//https://stackoverflow.com/questions/18636567/converting-curl-request-to-http-request-java
//https://stackoverflow.com/questions/9623158/curl-and-httpurlconnection-post-json-data
//https://crunchify.com/java-url-example-getting-text-from-url/


 