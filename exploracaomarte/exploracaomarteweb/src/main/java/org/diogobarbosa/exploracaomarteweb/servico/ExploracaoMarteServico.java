package org.diogobarbosa.exploracaomarteweb.servico;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.fachada.ExploraMarteFachada;

@Path("explorarmarte")
public class ExploracaoMarteServico {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String explorarMarte(String instrucoesExploracaoMarte) {

		try {
			System.out.println("Parametros de entrada: \n" + instrucoesExploracaoMarte);

			ExploraMarteFachada exploraMarteFachada = new ExploraMarteFachada();
			String retorno = exploraMarteFachada.explorarMarte(instrucoesExploracaoMarte);

			System.out.println("Parametros de saida: \n" + retorno);

			return retorno;
			
		} catch (ColisaoException e) {
			return e.getMessage();
		}
	}
}
