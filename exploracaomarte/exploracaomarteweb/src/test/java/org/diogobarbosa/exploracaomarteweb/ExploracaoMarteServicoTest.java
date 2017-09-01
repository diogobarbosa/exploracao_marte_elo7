package org.diogobarbosa.exploracaomarteweb;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.diogobarbosa.exploracaomarteweb.servidor.ServidorGrizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
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
		
		Assert.assertEquals(200, response.getStatus());
	}	
}
