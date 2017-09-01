package org.diogobarbosa.exploracaomartecore.entidade.impl;

import java.util.ArrayList;
import java.util.List;

import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Sonda;

public class PlanaltoRetangular implements Planalto{

	private Coordenada coordenada;
	private List<Sonda> listaSondas;
	
	public PlanaltoRetangular(Coordenada coordenada) {
		
		this.coordenada = coordenada;
		this.listaSondas = new ArrayList<Sonda>();
	}
	
	public List<Sonda> getListaSondas() {
		
		return this.listaSondas;
	}


	public Coordenada getCoordenada() {
		return this.coordenada;
	}

}
