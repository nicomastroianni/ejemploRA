package ar.com.supervielle.api.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class pruebasMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date tiempo = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fecha = formatter.format(tiempo);
		System.out.println(fecha);
//String url =  "http://apiperds-01:9091/v1.0/personas";
	//apiPersonasGET_1.pruebasApiPersonas("CRM","nm32202",777);
		//apiPersonasPUT.apiPersonasPUT("CRM", "nm32202", 7);//rompio a ultimo momento, no deberia, no se le cambio nada


//String personaJson ="{ \"apellido\": \"Braaa\", \"codigo_pais\": \"80\", \"codigo_sucursal\": \"1\", \"domicilios\": [ { \"barrio\": \"San Martin\", \"calle\": \"D.JL Suarez\", \"codigo_localidad\": \"2\", \"codigo_pais\": \"10\", \"codigo_postal\": \"1111\", \"codigo_postal_adicional\": \"A1234AAA\", \"codigo_provincia\": \"20\", \"departamento\": \"1\", \"id\": 0, \"numero\": \"11\", \"origen_contacto\": \"MERLIN\", \"partido\": \"burzaco\", \"piso\": \"11\", \"tipo_contacto\": \"LABORAL\" } ], \"emails\": [ { \"declarado\": \"true\", \"direccion\": \"sarasas123@hotmail.com.ar\", \"origen_contacto\": \"MERLIN\", \"tipo_contacto\": \"LABORAL\" } ], \"es_titular\": true, \"estado_civil\": \"2\", \"fecha_nacimiento\": \"10-10-1995\", \"genero\": \"M\", \"nombre\": \"alejandro\", \"numero_documento\": \"3332\", \"numero_tributario\": \"1\", \"oficial_propietario\": \"nicolas\", \"oficial_referente\": \"11\", \"segmento_potencial\": \"8\", \"telefonos\": [ { \"compania\": \"CLARO\", \"declarado\": \"true\", \"no_llame\": \"false\", \"numero\": \"11111133\", \"origen_contacto\": \"MERLIN\", \"tipo_contacto\": \"LABORAL\", \"tipo_telefono\": \"FIJO\" } ], \"tipo_documento\": \"1\", \"tipo_tributario\": \"1\"}";
		//apiPersonasPOST_1.apiPersonasPOST_1("CRM", "nm32202", personaJson);
		
	//AP_GetBANTOTAL.pruebasApiPersonas(url,"CRM", "rb36671", "80", "111", "1");
		//http://apiperds-01:9091/swagger-ui.html#/

	}

}
