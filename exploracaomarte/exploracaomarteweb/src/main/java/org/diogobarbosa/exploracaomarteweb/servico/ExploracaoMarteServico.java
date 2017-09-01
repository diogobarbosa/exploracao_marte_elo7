package org.diogobarbosa.exploracaomarteweb.servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.fachada.ExploraMarteFachada;

@Path("explorarmarte")
public class ExploracaoMarteServico {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String explorarMarte(String instrucoesExploracaoMarte) {

		try {
			System.out.println("Parametros de entrada: \n" + instrucoesExploracaoMarte);

			ExploraMarteFachada exploraMarteFachada = new ExploraMarteFachada();
			String retornoExploracao = exploraMarteFachada.explorarMarte(instrucoesExploracaoMarte);

			System.out.println("Retorno da exploração: \n" + retornoExploracao);

			return retornoExploracao;
			
		} catch (ColisaoException e) {
			return e.getMessage();
		}
	}
}
