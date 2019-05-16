package ar.com.supervielle.api.connect;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import ar.com.supervielle.properties.ConfiguradorPropiedades;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.main.bin.Log;

public class AidapClient {
	public static CacheLoader<String, String> loader = new CacheLoader<String, String>() {
        @Override
        public String load(String key) {
            return key.toUpperCase();
        }
    };
    public static LoadingCache<String, String> 
    cache = CacheBuilder.newBuilder()
      .expireAfterWrite(1,TimeUnit.HOURS)
      .build(loader);
//private static	SelfExpiringMap<String, String> map = new SelfExpiringHashMap<String, String>();
public static String obtenerToken() throws InterruptedException, ExecutionException{
	   
		Gson gson = new Gson();
	 
		if(cache.getIfPresent("token")==null){
			TokenHash token =gson.fromJson(generarToken(), TokenHash.class);
			
			cache.put("token", token.getAccess_token());
			System.out.println("Token generado: "+cache.get("token"));
			Log.logloggerIID_debug("Token generado: "+cache.get("token"));
		}else{
			System.out.println("Token reutilizado: "+cache.get("token"));
			Log.logloggerIID_debug("Token reutilizado: "+cache.get("token"));
		}

	
	return cache.get("token");
	
}
	private static String generarToken() {
		StringBuilder sb = new StringBuilder();
		try {
			// Abro una conexion segura
			System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
			
			URL url = new URL(ConfiguradorPropiedades.getPropiedad("URLHash"));//
			//System.out.println("https://apidesa.gscorp.ad/supervielledev/desa/supervielle-oauth-provider/oauth2/token");
		
			String requestParams = "client_id=fd3f0d5d-246d-4d9a-ac42-2177898c8968&client_secret=U7mM0gN2jU6xD8gT1eS0dV2gH6qF5kF3oQ4cC1lY7jG5lW2uP4&grant_type=client_credentials&scope=scope1";
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// Agrego las propiedades necesarias
			con.setRequestProperty("Connection", "close");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length",
					Integer.toString(requestParams.length()));

			// SSLContext context = SSLContext.getInstance("TLS");
			//
			// TrustManager[] trust_mgr = get_trust_mgr();
			//
			// context.init(null, trust_mgr, new SecureRandom());
			// // context.init(keyManagerFactory.getKeyManagers(), null, new
			// // SecureRandom());
			//
			// SSLSocketFactory sockFact = context.getSocketFactory();
			// con.setSSLSocketFactory(sockFact);

			// Envio request
			OutputStream outputStream = con.getOutputStream();
			outputStream.write(requestParams.getBytes("UTF-8"));
			outputStream.close();

			// Chequeo si hay errores
			int responseCode = con.getResponseCode();
			InputStream inputStream;
			if (responseCode == HttpURLConnection.HTTP_OK) {
				inputStream = con.getInputStream();
			} else {
				inputStream = con.getErrorStream();
			}

			// Proceso la respuesta
			BufferedReader reader;
			String line = null;
			reader = new BufferedReader(new InputStreamReader(inputStream));
			
			
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				sb.append(line);
			}

			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}