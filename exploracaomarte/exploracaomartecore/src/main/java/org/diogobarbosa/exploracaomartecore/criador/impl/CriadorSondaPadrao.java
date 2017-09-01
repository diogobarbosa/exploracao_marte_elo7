package org.diogobarbosa.exploracaomartecore.criador.impl;

import org.diogobarbosa.exploracaomartecore.comportamento.girar.impl.ComportamentoGirarSondaDireita;
import org.diogobarbosa.exploracaomartecore.comportamento.girar.impl.ComportamentoGirarSondaEsquerda;
import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoGirarSonda;
import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoMoverSonda;
import org.diogobarbosa.exploracaomartecore.comportamento.mover.impl.ComportamentoMoverSondaLeste;
import org.diogobarbosa.exploracaomartecore.comportamento.mover.impl.ComportamentoMoverSondaNorte;
import org.diogobarbosa.exploracaomartecore.comportamento.mover.impl.ComportamentoMoverSondaOeste;
import org.diogobarbosa.exploracaomartecore.comportamento.mover.impl.ComportamentoMoverSondaSul;
import org.diogobarbosa.exploracaomartecore.entidade.impl.SondaPadrao;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Sonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;

public class CriadorSondaPadrao{

	private Coordenada coordenada;
	private Planalto planalto;
	private DirecaoOrientacaoSondaEnum direcaoOrientacaoSondaEnum;
	
	public CriadorSondaPadrao adicionarCoordenada(Coordenada coordenada) {

		this.coordenada = coordenada;
		return this;
	}
	
	public CriadorSondaPadrao adicionarPlanalto(Planalto planalto) {

		this.planalto = planalto;
		return this;
	}
	
	
	public CriadorSondaPadrao adicionarDirecaoOrientacaoSonda(DirecaoOrientacaoSondaEnum direcaoOrientacaoSondaEnum) {

		this.direcaoOrientacaoSondaEnum = direcaoOrientacaoSondaEnum;
		return this;
	}
	
	
	public Sonda criarSonda() throws ColisaoException {
		
		Sonda sonda = new SondaPadrao();
		sonda.setCoordenada(coordenada);
		sonda.setPlanalto(planalto);
		sonda.setDirecaoOrientacao(direcaoOrientacaoSondaEnum);
		
		//Chain of responsability
		ComportamentoGirarSonda comportamentoGirarSondaEsquerda = new ComportamentoGirarSondaEsquerda();
		comportamentoGirarSondaEsquerda.setProximoComportamento(new ComportamentoGirarSondaDireita());
		sonda.setComportamentoGirarSonda(comportamentoGirarSondaEsquerda);
		
		ComportamentoMoverSonda comportamentoMoverSondaNorte = new ComportamentoMoverSondaNorte();
		ComportamentoMoverSonda comportamentoMoverSondaOeste = new ComportamentoMoverSondaOeste();
		ComportamentoMoverSonda comportamentoMoverSondaSul = new ComportamentoMoverSondaSul();
		ComportamentoMoverSonda comportamentoMoverSondaLeste = new ComportamentoMoverSondaLeste();

		comportamentoMoverSondaNorte.setProximoComportamento(comportamentoMoverSondaOeste);
		comportamentoMoverSondaOeste.setProximoComportamento(comportamentoMoverSondaSul);
		comportamentoMoverSondaSul.setProximoComportamento(comportamentoMoverSondaLeste);
		sonda.setComportamentoMoverSonda(comportamentoMoverSondaNorte);
		
		return sonda;
	}
	

}
