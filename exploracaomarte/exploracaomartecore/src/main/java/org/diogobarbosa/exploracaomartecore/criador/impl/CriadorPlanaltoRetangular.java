package org.diogobarbosa.exploracaomartecore.criador.impl;

import org.diogobarbosa.exploracaomartecore.entidade.impl.CoordenadaXY;
import org.diogobarbosa.exploracaomartecore.entidade.impl.PlanaltoRetangular;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;

public class CriadorPlanaltoRetangular{

	public static Planalto criarPlanalto(Long coordenadaX, Long coordenadaY) {
		
		Coordenada coordenada = new CoordenadaXY(coordenadaX, coordenadaY);
		Planalto planaltoRetangular = new PlanaltoRetangular(coordenada);
		
		return planaltoRetangular;
	}

}
