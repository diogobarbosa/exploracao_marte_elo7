package org.diogobarbosa.exploracaomartecore.comportamento.interfaces;

import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;

public interface ComportamentoMoverSonda {

	public Coordenada moverSonda(Coordenada coordenadaAtual, DirecaoOrientacaoSondaEnum orientacaoAtualSondaEnum);
	public void setProximoComportamento(ComportamentoMoverSonda comportamentoMoverSonda);
}
