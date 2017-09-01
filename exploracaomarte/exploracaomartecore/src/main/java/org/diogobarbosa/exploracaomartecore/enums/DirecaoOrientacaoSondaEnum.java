package org.diogobarbosa.exploracaomartecore.enums;

public enum DirecaoOrientacaoSondaEnum {

	DIRECAO_NORTE("N"),
	DIRECAO_SUL("S"),
	DIRECAO_LESTE("E"),
	DIRECAO_OESTE("W");
	
	private String direcaoOrientacaoGiro;
	
	DirecaoOrientacaoSondaEnum(String direcaoOrientacaoGiro) {
		this.direcaoOrientacaoGiro = direcaoOrientacaoGiro;
	}

	//GETTER
	public String getDirecaoOrientacaoGiro() {
		return direcaoOrientacaoGiro;
	}
	
	
	public static DirecaoOrientacaoSondaEnum getDirecaoOrientacaoGiroEnumPorString(String direcaoOrientacaoGiro) {
		
		DirecaoOrientacaoSondaEnum direcaoOrientacaoSondaEnumEncontrado = null;
		for(DirecaoOrientacaoSondaEnum direcaoOrientacaoSondaEnum : DirecaoOrientacaoSondaEnum.values()){
			if(direcaoOrientacaoSondaEnum.getDirecaoOrientacaoGiro().equalsIgnoreCase(direcaoOrientacaoGiro)) {
				direcaoOrientacaoSondaEnumEncontrado = direcaoOrientacaoSondaEnum;
				break;
			}
		}
		
		return direcaoOrientacaoSondaEnumEncontrado;
	}
}
