package org.diogobarbosa.exploracaomartecore.comportamento.mover.impl;

import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoMoverSonda;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;

public abstract class ComportamentoMoverSondaAbstrata implements ComportamentoMoverSonda{

	private ComportamentoMoverSonda proximoComportamento;
	
	
	public Coordenada chamarProximoComportamento(Coordenada coordenadaAtual, DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum) {

		if(this.proximoComportamento != null) {
			return this.proximoComportamento.moverSonda(coordenadaAtual, orientacaoAtualSondaEnum);
		}else {
			return null;
		}
	}

	public void setProximoComportamento(ComportamentoMoverSonda comportamentoMoverSonda) {
	
		this.proximoComportamento = comportamentoMoverSonda;
	}
}
