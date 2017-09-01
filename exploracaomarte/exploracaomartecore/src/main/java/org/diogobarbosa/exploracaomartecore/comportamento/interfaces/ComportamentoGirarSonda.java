package org.diogobarbosa.exploracaomartecore.comportamento.interfaces;

import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;

public interface ComportamentoGirarSonda {

	public DirecaoOrientacaoSondaEnum girarSonda(DirecaoGiroSondaEnum direcaoGiroSondaEnum, DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum);
	public void setProximoComportamento(ComportamentoGirarSonda comportamentoGirarSonda);

}
