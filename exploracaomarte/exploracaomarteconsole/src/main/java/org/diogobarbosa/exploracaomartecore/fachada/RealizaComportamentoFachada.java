package org.diogobarbosa.exploracaomartecore.fachada;

import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorCoordenadaXY;
import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorSondaPadrao;
import org.diogobarbosa.exploracaomartecore.dto.SondaDTO;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Sonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;

public class RealizaComportamentoFachada {

	private static final String INSTRUCAO_MOVER = "M";
	
	
	public String RealizarComportamento(SondaDTO sondaDTO, Planalto planalto) throws ColisaoException {
		
		Coordenada coordenadaInicial = CriadorCoordenadaXY.criarCoordenada(sondaDTO.getCoordenadaX(), sondaDTO.getCoordenadaY());
		CriadorSondaPadrao criadorSondaPadrao = new CriadorSondaPadrao();
		
		Sonda sonda = criadorSondaPadrao.adicionarCoordenada(coordenadaInicial)
				.adicionarPlanalto(planalto)
				.adicionarDirecaoOrientacaoSonda(DirecaoOrientacaoSondaEnum.getDirecaoOrientacaoGiroEnumPorString(sondaDTO.getDirecaoOrientacao()))
				.criarSonda();
		
		for (String instrucao : sondaDTO.getInstrucoesComportamento()) {
			
			if(instrucao.equalsIgnoreCase(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA.getDirecaoGiro())){
				sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
				
			}else
			if(instrucao.equalsIgnoreCase(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA.getDirecaoGiro())) {
				sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);

			}else
			if(instrucao.equalsIgnoreCase(INSTRUCAO_MOVER)) {
				sonda.moverSonda();
			}
		}
		
		return sonda.getCoordenada().getCoordenadaX()+" "+sonda.getCoordenada().getCoordenadaY()+" "+sonda.getDirecaoOrientacao().getDirecaoOrientacaoGiro();
	}
}
