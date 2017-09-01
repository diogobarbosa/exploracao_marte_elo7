package org.diogobarbosa.exploracaomarteconsole;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.fachada.ExploraMarteFachada;
import org.junit.Test;

public class ConsolePrincipalTest {

	@Test
	public void testarExploracaoMarteViaConsole() throws ColisaoException {

			List<String> listaInstrucoesSonda = new ArrayList<String>();
			listaInstrucoesSonda.add("5 5");
			listaInstrucoesSonda.add("1 2 N");
			listaInstrucoesSonda.add("LMLMLMLMM");
			listaInstrucoesSonda.add("3 3 E");
			listaInstrucoesSonda.add("MMRMMRMRRM");
			
			ExploraMarteFachada exploraMarteFachada = new ExploraMarteFachada();
			String retornoExploracao = exploraMarteFachada.explorarMarte(listaInstrucoesSonda);
			
			assertTrue(retornoExploracao.contains("1 3 N"));
			assertTrue(retornoExploracao.contains("5 1 E"));	
			
	}
}
