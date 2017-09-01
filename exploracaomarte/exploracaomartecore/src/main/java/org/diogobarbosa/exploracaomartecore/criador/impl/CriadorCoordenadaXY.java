package org.diogobarbosa.exploracaomartecore.criador.impl;

import org.diogobarbosa.exploracaomartecore.entidade.impl.CoordenadaXY;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;

public class CriadorCoordenadaXY {

	public static Coordenada criarCoordenada(Long coordenadaX, Long coordenadaY) {
		
		Coordenada coordenada = new CoordenadaXY(coordenadaX, coordenadaY);
		return coordenada;
	}
}
