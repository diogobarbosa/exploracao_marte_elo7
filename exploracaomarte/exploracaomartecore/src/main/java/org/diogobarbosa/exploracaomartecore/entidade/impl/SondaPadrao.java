package org.diogobarbosa.exploracaomartecore.entidade.impl;

import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoGirarSonda;
import org.diogobarbosa.exploracaomartecore.comportamento.interfaces.ComportamentoMoverSonda;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Sonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;

public class SondaPadrao implements Sonda{

	private Coordenada coordenada;
	private DirecaoOrientacaoSondaEnum direcaoOrientacao;
	
	private Planalto planalto;
	
	private ComportamentoMoverSonda comportamentoMoverSonda;
	private ComportamentoGirarSonda comportamentoGirarSonda;
	

	public void moverSonda() throws ColisaoException {
		
		Coordenada novaCoordenada = this.comportamentoMoverSonda.moverSonda(this.coordenada, this.direcaoOrientacao);
		for(Sonda sonda : this.planalto.getListaSondas()) {
			
			if(sonda.getCoordenada().getCoordenadaX().equals(novaCoordenada.getCoordenadaX()) && sonda.getCoordenada().getCoordenadaY().equals(novaCoordenada.getCoordenadaY())){
				throw new ColisaoException("A sonda irá colidir com outra.");
			}
		}
		
		if(novaCoordenada.getCoordenadaX() > planalto.getCoordenada().getCoordenadaX() || novaCoordenada.getCoordenadaY() > planalto.getCoordenada().getCoordenadaY()){
			
			throw new ColisaoException("A sonda irá colidir na lateral do planalto.");
		}
		
		if(novaCoordenada.getCoordenadaX() < 0 || novaCoordenada.getCoordenadaY() < 0){
			
			throw new ColisaoException("A sonda irá colidir na lateral do planalto.");
		}
		
		this.coordenada = novaCoordenada;
	}

	public void girarSonda(DirecaoGiroSondaEnum direcaoGiroSondaEnum) {
		
		DirecaoOrientacaoSondaEnum novoOrientacaoSondaEnum =  this.comportamentoGirarSonda.girarSonda(direcaoGiroSondaEnum, this.getDirecaoOrientacao());
		this.direcaoOrientacao = novoOrientacaoSondaEnum;
	}

	public void setPlanalto(Planalto planalto) throws ColisaoException {
		
		for(Sonda sonda : planalto.getListaSondas()) {
			
			if(sonda.getCoordenada().getCoordenadaX().equals(this.getCoordenada().getCoordenadaX()) && sonda.getCoordenada().getCoordenadaY().equals(this.getCoordenada().getCoordenadaY())){
				throw new ColisaoException("A sonda irá colidir com outra.");
			}
		}
		
		this.planalto = planalto;
		planalto.getListaSondas().add(this);
		
	}

	public ComportamentoMoverSonda getComportamentoMoverSonda() {
		return comportamentoMoverSonda;
	}

	public void setComportamentoMoverSonda(ComportamentoMoverSonda comportamentoMoverSonda) {
		this.comportamentoMoverSonda = comportamentoMoverSonda;
	}

	public ComportamentoGirarSonda getComportamentoGirarSonda() {
		return comportamentoGirarSonda;
	}

	public void setComportamentoGirarSonda(ComportamentoGirarSonda comportamentoGirarSonda) {
		this.comportamentoGirarSonda = comportamentoGirarSonda;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public void setDirecaoOrientacao(DirecaoOrientacaoSondaEnum direcaoOrientacao) {
		this.direcaoOrientacao = direcaoOrientacao;
	}

	public DirecaoOrientacaoSondaEnum getDirecaoOrientacao() {
		return direcaoOrientacao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
}
