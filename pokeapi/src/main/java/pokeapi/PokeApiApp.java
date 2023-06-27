package pokeapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class PokeApiApp {
	
	static URL url;
	
	public static int connectApi(String pokemon) {
		int httpResponseCode = 0;
		
		try {
			url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemon);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			httpResponseCode = conn.getResponseCode();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponseCode;
		
	}
	

	public static Map<String, String> PokeApi(String pokemon) {
		// TODO Auto-generated constructor stub
		Map<String, String> pokemonMap = new HashMap<String, String>();
		
		int reponse = connectApi(pokemon);

		if (reponse != 200)
		{
			throw new RuntimeException("HTTPSResponseCode: "+ reponse);
		}
		else
		{
			StringBuilder informacion = new StringBuilder();
			Scanner sc;
			try {
				sc = new Scanner(url.openStream());
				while (sc.hasNext())
				{
					informacion.append(sc.nextLine());
				}
//				System.out.println(informacion);
				JSONObject jsonObject = new JSONObject(informacion.toString());
				
				String especie = jsonObject.getJSONObject("species").getString("name");
				String orden = String.valueOf(jsonObject.getInt("order"));
				String nombre = jsonObject.getString("name");
				
				
				pokemonMap.put("Especie", especie); 
				
				pokemonMap.put("Orden", orden); 
	
				pokemonMap.put("Nombre", nombre);
				
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return pokemonMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PokeApi("ditto").toString());
		
	}

}
