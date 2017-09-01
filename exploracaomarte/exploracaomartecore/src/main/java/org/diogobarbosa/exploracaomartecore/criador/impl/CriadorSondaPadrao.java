package org.diogobarbosa.exploracaomartecore.criador.impl;

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
		
		return null;
	}
	

}
