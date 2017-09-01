package org.diogobarbosa.exploracaomartecore.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.fachada.ExploraMarteFachada;

public class ConsolePrincipal {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Por favor, digite as instruções, ou tecle enter para enviar.");
			String instrucao = scanner.nextLine();

			List<String> listaInstrucoesSonda = new ArrayList<String>();
			while (!"".equals(instrucao.trim())) {

				listaInstrucoesSonda.add(instrucao);
				instrucao = scanner.nextLine();
			}

			ExploraMarteFachada exploraMarteFachada = new ExploraMarteFachada();
			String retornoExploracao = exploraMarteFachada.explorarMarte(listaInstrucoesSonda);
			
			System.out.println("Retorno da exploração: \n" + retornoExploracao);
			
		} catch (ColisaoException e) {
			e.printStackTrace();
			
		} finally {
			scanner.close();
		}
	}
}
