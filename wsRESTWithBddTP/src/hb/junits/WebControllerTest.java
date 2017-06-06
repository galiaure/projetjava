package hb.junits;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebControllerTest {
	
	private Client client;
	
	@Before
	public void init(){
		client = Client.create();
	}

	@Test
	public void testListPlanetsXML() {
		WebResource webResourceXml = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/planets");
		
		ClientResponse response=webResourceXml.accept("application/xml")
          .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).contains("<planet>"
				+ "<description>Planète petite, "
				+ "très proche du soleil et composée de roche</description>"
				+ "<id>3</id><name>Mercure</name>"
				+ "<type>tellurique</type></planet>"));
	}
	
	@Test
	public void testListPlanetsJSON() {
		WebResource webResourceJson = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/json/planets");
		ClientResponse response = webResourceJson.accept("application/json")
             .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).contains("{\"planet\":[{\"description\":\"Planète petite,"
				+ " très proche du soleil et composée de roche\",\"id\":\"1\","
				+ "\"name\":\"Terre\",\"type\":\"tellurique\"}"));
	}
	
	@Test
	public void testGetPlanetsByTypeXML() {
		WebResource webResourceXml = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/planetsByType?type=tellurique");
		
		ClientResponse response=webResourceXml.accept("application/xml")
       .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).contains("<stringList><data>Terre</data>"
				+ "<data>Vénus</data><data>Mercure</data>"
				+ "<data>Mars</data></stringList>"));
	}
	
	@Test
	public void testGetPlanetsByTypeJSON() {
		WebResource webResourceJson = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/json/planetsByType?type=tellurique");
		ClientResponse response = webResourceJson.accept("application/json")
          .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).equals("{\"data\":[\"Terre\",\"Vénus\",\"Mercure\",\"Mars\"]}"));
	}
	
	@Test
	public void listSatellitesByPlanetXML() {
		WebResource webResourceXml = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/sattelites?planetName=Terre");
		
		ClientResponse response=webResourceXml.accept("application/xml")
    .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).contains("<stringList><data>La lune</data></stringList>"));
	}
	
	@Test
	public void listSatellitesByPlanetJSON() {
		WebResource webResourceJson = client
				   .resource("http://localhost:8080/wsRESTWithBDD/hb/webservice/json/sattelites?planetName=Terre");
		ClientResponse response = webResourceJson.accept("application/json")
       .get(ClientResponse.class);
		assertTrue(response.getEntity(String.class).equals("{\"data\":\"La lune\"}"));
	}

}
