package org.diogobarbosa.exploracaomartecore.criador;

import org.diogobarbosa.exploracaomartecore.dto.PlanaltoDTO;
import org.diogobarbosa.exploracaomartecore.excecoes.InstrucaoInvalidaException;

public class CriadorPlanaltoDTO {

	public PlanaltoDTO montarPlanaltoDTO(String instrucoesAreaTotalPlanalto) throws InstrucaoInvalidaException {

		try {
			String[] posicoesAreaPlanalto = instrucoesAreaTotalPlanalto.trim().split(" ");
			PlanaltoDTO planaltoDTO = new PlanaltoDTO();
			planaltoDTO.setCoordenadaX(Long.valueOf(posicoesAreaPlanalto[0]));
			planaltoDTO.setCoordenadaY(Long.valueOf(posicoesAreaPlanalto[1]));
			
			return planaltoDTO;

		} catch (Exception e) {
			throw new InstrucaoInvalidaException("Instrução invalida ao criar o planalto");
		}

	}
}
