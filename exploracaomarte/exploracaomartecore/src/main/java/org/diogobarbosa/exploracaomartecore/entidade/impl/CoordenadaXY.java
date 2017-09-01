package org.diogobarbosa.exploracaomartecore.entidade.impl;

import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;

public class CoordenadaXY implements Coordenada{
	
	private Long coordenadaX;
	private Long coordenadaY;
	
	public CoordenadaXY(Long coordenadaX, Long coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public Long getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Long coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public Long getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Long coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

}