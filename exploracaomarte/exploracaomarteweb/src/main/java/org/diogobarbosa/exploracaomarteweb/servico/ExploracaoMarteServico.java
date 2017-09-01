package org.diogobarbosa.exploracaomarteweb.servico;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("explorarmarte")
public class ExploracaoMarteServico {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String explorarMarte(String instrucoesExploracaoMarte) {

		return null;
	}
}
