package org.diogobarbosa.exploracaomartecore.comportamento.girar.impl;

import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;

public class ComportamentoGirarSondaEsquerda extends ComportamentoGirarSondaAbstrata {

	public DirecaoOrientacaoSondaEnum girarSonda(DirecaoGiroSondaEnum direcaoGiroSondaEnum,
			DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum) {

		if (!DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA.equals(direcaoGiroSondaEnum)) {
			return this.chamarProximoComportamento(direcaoGiroSondaEnum, orientacaoAtualSondaEnum);
		}

		if (orientacaoAtualSondaEnum.equals(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE)) {
			return DirecaoOrientacaoSondaEnum.DIRECAO_OESTE;

		} else if (orientacaoAtualSondaEnum.equals(DirecaoOrientacaoSondaEnum.DIRECAO_OESTE)) {
			return DirecaoOrientacaoSondaEnum.DIRECAO_SUL;

		} else if (orientacaoAtualSondaEnum.equals(DirecaoOrientacaoSondaEnum.DIRECAO_SUL)) {
			return DirecaoOrientacaoSondaEnum.DIRECAO_LESTE;

		} else if (orientacaoAtualSondaEnum.equals(DirecaoOrientacaoSondaEnum.DIRECAO_LESTE)) {
			return DirecaoOrientacaoSondaEnum.DIRECAO_NORTE;
		} else
			return null;
	}
}
