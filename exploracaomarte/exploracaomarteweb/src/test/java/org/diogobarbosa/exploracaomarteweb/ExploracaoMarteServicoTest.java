package org.diogobarbosa.exploracaomarteweb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.diogobarbosa.exploracaomarteweb.servidor.ServidorGrizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExploracaoMarteServicoTest {

	private HttpServer server;

	@Before
	public void inicializaServidor() {
		this.server = ServidorGrizzly.inicializaServidor();
	}

	@After
	public void finalizaServidor() {
		server.shutdown();
	}

	@Test
	public void testaConexaoExplorarMarte() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Response response = target.path("/explorarmarte").request()
				.post(Entity.text("5 5\r\n" + 
								  "1 2 N\r\n" + 
								  "LMLMLMLMM\r\n" + 
								  "3 3 E\r\n" + 
								  "MMRMMRMRRM"));
		
		String respostaServico = response.readEntity(String.class);
		
		assertEquals(200, response.getStatus());
		assertTrue(respostaServico.contains("1 3 N"));
		assertTrue(respostaServico.contains("5 1 E"));

	}
	
	@Test
	public void testaEnvioInstrucaoInvalidaPlanaltoExplorarMarte() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Response response = target.path("/explorarmarte").request()
				.post(Entity.text("A5 5\r\n" + 
								  "1 2 N\r\n" + 
								  "LMLMLMLMM\r\n" + 
								  "3 3 E\r\n" + 
								  "MMRMMRMRRM"));
		
		System.out.println(response.readEntity(String.class));
		assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());

	}
	
	@Test
	public void testaEnvioInstrucaoInvalidaSondaExplorarMarte() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Response response = target.path("/explorarmarte").request()
				.post(Entity.text("5 5\r\n" + 
								  "A 2 N\r\n" + 
								  "LMLMLMLMM\r\n" + 
								  "3 3 E\r\n" + 
								  "MMRMMRMRRM"));
		
		System.out.println(response.readEntity(String.class));
		assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());

	}
	
	@Test
	public void testaEnvioInstrucaoImcompletaSondaExplorarMarte() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Response response = target.path("/explorarmarte").request()
				.post(Entity.text("5 5\r\n" + 
								  "A 2 N\r\n" + 
								  "LMLMLMLMM\r\n" + 
								  "3 3 E\r\n"));
		
		System.out.println(response.readEntity(String.class));
		assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());

	}
}
