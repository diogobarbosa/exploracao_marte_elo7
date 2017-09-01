package org.diogobarbosa.exploracaomartecore.criador;

import java.util.Arrays;
import java.util.List;

import org.diogobarbosa.exploracaomartecore.dto.PlanaltoDTO;
import org.diogobarbosa.exploracaomartecore.dto.SondaDTO;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.diogobarbosa.exploracaomartecore.excecoes.InstrucaoInvalidaException;

public class CriadorSondaDTO {

	public SondaDTO montarSondaDTO(String posicaoInicialSonda, String instrucaoSonda, PlanaltoDTO planaltoDTO)
			throws ColisaoException, InstrucaoInvalidaException {

		try {
			String[] posicoesIniciais = posicaoInicialSonda.trim().split(" ");

			SondaDTO sondaDTO = new SondaDTO();
			sondaDTO.setPlanaltoDTO(planaltoDTO);
			sondaDTO.setCoordenadaX(Long.valueOf(posicoesIniciais[0]));
			sondaDTO.setCoordenadaY(Long.valueOf(posicoesIniciais[1]));
			sondaDTO.setDirecaoOrientacao(posicoesIniciais[2]);

			List<String> listaInstrucoes = Arrays.asList(instrucaoSonda.split(""));
			sondaDTO.setInstrucoesComportamento(listaInstrucoes);

			return sondaDTO;
			
		} catch (Exception e) {

			throw new InstrucaoInvalidaException("Instrução invalida ao criar a sonda");
		}
	}
}
