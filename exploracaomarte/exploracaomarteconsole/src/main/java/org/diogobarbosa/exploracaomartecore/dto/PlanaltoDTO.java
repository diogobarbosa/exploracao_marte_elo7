package org.diogobarbosa.exploracaomartecore.dto;

import java.io.Serializable;

public class PlanaltoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7925089957276382443L;
	
	private Long coordenadaX;
	private Long coordenadaY;
	
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
