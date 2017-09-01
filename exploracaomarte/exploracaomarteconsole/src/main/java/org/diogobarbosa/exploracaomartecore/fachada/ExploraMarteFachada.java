package org.diogobarbosa.exploracaomartecore.fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorPlanaltoRetangular;
import org.diogobarbosa.exploracaomartecore.dto.PlanaltoDTO;
import org.diogobarbosa.exploracaomartecore.dto.SondaDTO;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;

public class ExploraMarteFachada {

	public String explorarMarte(String instrucoesComandos) throws ColisaoException {
		
		List<String> listaInstrucoes = Arrays.asList(instrucoesComandos.split(System.getProperty("line.separator")));
		PlanaltoDTO planaltoDTO = montarPlanaltoDTO(listaInstrucoes.get(0));
		
		List<SondaDTO> listaSondaDTO = new ArrayList<SondaDTO>(); 
		for (int index = 1; index < listaInstrucoes.size(); index = index+2) {
			String posicaoInicialSonda = listaInstrucoes.get(index);
			String instrucaoSonda = listaInstrucoes.get(index+1);
			
			SondaDTO sonda = montarSondaDTO(posicaoInicialSonda, instrucaoSonda, planaltoDTO);
			listaSondaDTO.add(sonda);
		}
		
		Planalto planalto = CriadorPlanaltoRetangular.criarPlanalto(planaltoDTO.getCoordenadaX(), planaltoDTO.getCoordenadaY());

		RealizaComportamentoFachada realizaComportamentoFachada = new RealizaComportamentoFachada();
		
		String retorno = "";
		for (SondaDTO sondaDTO : listaSondaDTO) {
			 retorno = retorno+realizaComportamentoFachada.RealizarComportamento(sondaDTO, planalto)+"\n";
		}
		
		
		return retorno;
	}
	
	private PlanaltoDTO montarPlanaltoDTO(String instrucoesAreaTotalPlanalto) {
		
		String[] posicoesAreaPlanalto = instrucoesAreaTotalPlanalto.trim().split(" ");
		PlanaltoDTO planaltoDTO = new PlanaltoDTO();
		planaltoDTO.setCoordenadaX(Long.valueOf(posicoesAreaPlanalto[0]));
		planaltoDTO.setCoordenadaY(Long.valueOf(posicoesAreaPlanalto[1]));
		
		return planaltoDTO;
	}
	
	private SondaDTO montarSondaDTO(String posicaoInicialSonda, String instrucaoSonda, PlanaltoDTO planaltoDTO) throws ColisaoException {
		
		String[] posicoesIniciais = posicaoInicialSonda.trim().split(" ");

		SondaDTO sondaDTO = new SondaDTO();
		sondaDTO.setPlanaltoDTO(planaltoDTO);
		sondaDTO.setCoordenadaX(Long.valueOf(posicoesIniciais[0]));
		sondaDTO.setCoordenadaY(Long.valueOf(posicoesIniciais[1]));
		sondaDTO.setDirecaoOrientacao(posicoesIniciais[2]);
		
		List<String> listaInstrucoes = Arrays.asList(instrucaoSonda.split(""));
		sondaDTO.setInstrucoesComportamento(listaInstrucoes);
		
		return sondaDTO;
	}
}
