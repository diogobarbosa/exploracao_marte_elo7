package org.diogobarbosa.exploracaomartecore.enums;

public enum DirecaoGiroSondaEnum {

	GIRAR_SONDA_ESQUERDA("L"),
	GIRAR_SONDA_DIREITA("R");
	
	private String direcaoGiro;
	
	DirecaoGiroSondaEnum(String direcaoGiro) {
		this.direcaoGiro = direcaoGiro;
	}

	//GETTER
	public String getDirecaoGiro() {
		return direcaoGiro;
	}
	
}
