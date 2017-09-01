package org.diogobarbosa.exploracaomartecore.entidade.interfaces;

import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoGirarSonda;
import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoMoverSonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;

public interface Sonda {

	public void moverSonda() throws ColisaoException;
	public void girarSonda(DirecaoGiroSondaEnum direcaoGiroSondaEnum);
	
	public Coordenada getCoordenada();
	public void setCoordenada(Coordenada coordenada);

	public DirecaoOrientacaoSondaEnum getDirecaoOrientacao();
	public void setDirecaoOrientacao(DirecaoOrientacaoSondaEnum direcaoOrientacao);
	

	public ComportamentoMoverSonda getComportamentoMoverSonda();
	public ComportamentoGirarSonda getComportamentoGirarSonda();

	public void setComportamentoMoverSonda(ComportamentoMoverSonda comportamentoMoverSonda) ;
	public void setComportamentoGirarSonda(ComportamentoGirarSonda comportamentoGirarSonda) ;
	public void setPlanalto(Planalto planalto) throws ColisaoException;
	
}
