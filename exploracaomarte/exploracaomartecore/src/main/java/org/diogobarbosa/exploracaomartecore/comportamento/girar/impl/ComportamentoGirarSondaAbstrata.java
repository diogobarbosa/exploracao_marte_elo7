package org.diogobarbosa.exploracaomartecore.comportamento.girar.impl;

import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoGirarSonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;

public abstract class ComportamentoGirarSondaAbstrata implements ComportamentoGirarSonda{

	private ComportamentoGirarSonda proximoComportamento;
	
	public DirecaoOrientacaoSondaEnum chamarProximoComportamento(DirecaoGiroSondaEnum direcaoGiroSondaEnum, DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum) {

		if(this.proximoComportamento != null) {
			return this.proximoComportamento.girarSonda(direcaoGiroSondaEnum, orientacaoAtualSondaEnum);
		}else {
			return null;
		}
	}

	public void setProximoComportamento(ComportamentoGirarSonda comportamentoGirarSonda) {

		this.proximoComportamento = comportamentoGirarSonda;
	}
}
