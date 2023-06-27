package pokeapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TestsPokeApi {

	@Test
	public void TestsApi() {
		
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertEquals(200, PokeApiApp.connectApi("pikachu"));
		
		//(assertEquals para validar que el valor sea "nombreDelPokemon") entiendo que hay que comparar la especie y el nombre
		assertEquals(PokeApiApp.PokeApi("pikachu").get("nombre"), PokeApiApp.PokeApi("pikachu").get("nombre"));
		
		//assertTrue para validar que el tiempo de respuesta sea mayor a 0
		assertTrue(PokeApiApp.connectApi("pikachu") > 0);
	}
	
}
