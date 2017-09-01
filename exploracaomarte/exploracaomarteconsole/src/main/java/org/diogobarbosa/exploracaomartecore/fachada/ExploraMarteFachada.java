package org.diogobarbosa.exploracaomartecore.fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.diogobarbosa.exploracaomartecore.criador.CriadorPlanaltoDTO;
import org.diogobarbosa.exploracaomartecore.criador.CriadorSondaDTO;
import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorPlanaltoRetangular;
import org.diogobarbosa.exploracaomartecore.dto.PlanaltoDTO;
import org.diogobarbosa.exploracaomartecore.dto.SondaDTO;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.excecoes.InstrucaoInvalidaException;

public class ExploraMarteFachada {

	public String explorarMarte(String instrucoesExploracao) throws ColisaoException, InstrucaoInvalidaException {

		List<String> listaInstrucoes = Arrays.asList(instrucoesExploracao.split(System.getProperty("line.separator")));
		return explorarMarte(listaInstrucoes);
	}
	
	public String explorarMarte(List<String> listaInstrucoes) throws ColisaoException, InstrucaoInvalidaException {
		
		PlanaltoDTO planaltoDTO = new CriadorPlanaltoDTO().montarPlanaltoDTO(listaInstrucoes.get(0));
		
		List<SondaDTO> listaSondaDTO = new ArrayList<SondaDTO>(); 
		listaSondaDTO = criaListaSondaDTO(listaInstrucoes, planaltoDTO);
		
		Planalto planalto = CriadorPlanaltoRetangular.criarPlanalto(planaltoDTO.getCoordenadaX(), planaltoDTO.getCoordenadaY());

		RealizaComportamentoFachada realizaComportamentoFachada = new RealizaComportamentoFachada();
		
		String retorno = "";
		for (SondaDTO sondaDTO : listaSondaDTO) {
			 retorno = retorno+realizaComportamentoFachada.RealizarComportamento(sondaDTO, planalto)+"\n";
		}
		
		return retorno;
	}

	private List<SondaDTO> criaListaSondaDTO(List<String> listaInstrucoes, PlanaltoDTO planaltoDTO)
			throws ColisaoException, InstrucaoInvalidaException {
		
		List<SondaDTO> listaSondaDTO = new ArrayList<SondaDTO>(); 
		
		for (int index = 1; index < listaInstrucoes.size(); index = index+2) {
			String posicaoInicialSonda = listaInstrucoes.get(index);
			String instrucaoSonda = listaInstrucoes.get(index+1);
			
			SondaDTO sonda = new CriadorSondaDTO().montarSondaDTO(posicaoInicialSonda, instrucaoSonda, planaltoDTO);
			listaSondaDTO.add(sonda);
		}
		
		return listaSondaDTO;
	}
	
	
}
