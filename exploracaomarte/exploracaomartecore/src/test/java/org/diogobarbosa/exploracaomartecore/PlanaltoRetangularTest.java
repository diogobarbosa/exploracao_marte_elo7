package org.diogobarbosa.exploracaomartecore;

import static org.junit.Assert.assertEquals;

import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorPlanaltoRetangular;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.junit.Test;

public class PlanaltoRetangularTest {

	@Test
	public void criarPlanaltoRetangular() {
		
		Planalto planaltoRetangular = CriadorPlanaltoRetangular.criarPlanalto(5l, 10l);
		
		assertEquals(5l, planaltoRetangular.getCoordenada().getCoordenadaX().longValue());
		assertEquals(10l, planaltoRetangular.getCoordenada().getCoordenadaY().longValue());
		
	}
}
