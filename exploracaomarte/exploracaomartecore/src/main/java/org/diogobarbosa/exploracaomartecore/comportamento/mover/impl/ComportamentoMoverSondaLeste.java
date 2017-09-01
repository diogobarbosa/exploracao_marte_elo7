package org.diogobarbosa.exploracaomartecore.comportamento.mover.impl;

import org.diogobarbosa.exploracaomartecore.entidade.impl.CoordenadaXY;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;

public class ComportamentoMoverSondaLeste extends ComportamentoMoverSondaAbstrata {

	public Coordenada moverSonda(Coordenada coordenadaAtual, DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum) {

		if (orientacaoAtualSondaEnum.equals(DirecaoOrientacaoSondaEnum.DIRECAO_LESTE)) {

			Coordenada coordenada = new CoordenadaXY(coordenadaAtual.getCoordenadaX()+1, coordenadaAtual.getCoordenadaY());
			return coordenada;
		}else {
			
			return this.chamarProximoComportamento(coordenadaAtual, orientacaoAtualSondaEnum);
		}
		
	}

}
