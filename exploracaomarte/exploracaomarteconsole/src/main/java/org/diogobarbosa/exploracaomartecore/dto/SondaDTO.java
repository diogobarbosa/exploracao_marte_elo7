package org.diogobarbosa.exploracaomartecore.dto;

import java.io.Serializable;
import java.util.List;

public class SondaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8392131809266913401L;
	
	private PlanaltoDTO planaltoDTO;

	private Long coordenadaX;
	private Long coordenadaY;
	private String direcaoOrientacao;
	
	private List<String> instrucoesComportamento;

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

	public String getDirecaoOrientacao() {
		return direcaoOrientacao;
	}

	public void setDirecaoOrientacao(String direcaoOrientacao) {
		this.direcaoOrientacao = direcaoOrientacao;
	}

	public List<String> getInstrucoesComportamento() {
		return instrucoesComportamento;
	}

	public void setInstrucoesComportamento(List<String> instrucoesComportamento) {
		this.instrucoesComportamento = instrucoesComportamento;
	}

	public PlanaltoDTO getPlanaltoDTO() {
		return planaltoDTO;
	}

	public void setPlanaltoDTO(PlanaltoDTO planaltoDTO) {
		this.planaltoDTO = planaltoDTO;
	}
	
}
