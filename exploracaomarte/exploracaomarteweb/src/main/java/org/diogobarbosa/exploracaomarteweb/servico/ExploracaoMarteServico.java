package org.diogobarbosa.exploracaomarteweb.servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.excecoes.InstrucaoInvalidaException;
import org.diogobarbosa.exploracaomartecore.fachada.ExploraMarteFachada;

@Path("explorarmarte")
public class ExploracaoMarteServico {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response explorarMarte(String instrucoesExploracaoMarte) {

		try {
			
		
			System.out.println("Parametros de entrada: \n" + instrucoesExploracaoMarte);

			ExploraMarteFachada exploraMarteFachada = new ExploraMarteFachada();
			String retornoExploracao = exploraMarteFachada.explorarMarte(instrucoesExploracaoMarte);

			System.out.println("Retorno da exploração: \n" + retornoExploracao);

			return Response.ok().entity(retornoExploracao).build();
			
		}catch(ColisaoException e) {
			
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			
		}catch(InstrucaoInvalidaException e) {
			
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
			
	}
}
