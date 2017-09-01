package org.diogobarbosa.exploracaomartecore;

import static org.junit.Assert.assertEquals;

import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorCoordenadaXY;
import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorPlanaltoRetangular;
import org.diogobarbosa.exploracaomartecore.criador.impl.CriadorSondaPadrao;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Coordenada;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Planalto;
import org.diogobarbosa.exploracaomartecore.entidade.interfaces.Sonda;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoGiroSondaEnum;
import org.diogobarbosa.exploracaomartecore.enums.DirecaoOrientacaoSondaEnum;
import org.diogobarbosa.exploracaomartecore.excecoes.ColisaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SondaPadraoTest {

	private Sonda sonda = null;
	private Planalto planalto = null;

	@Before
	public void criarSondaEPlanalto() {

		try {
			planalto = CriadorPlanaltoRetangular.criarPlanalto(5l, 5l);
			Coordenada coordenada = CriadorCoordenadaXY.criarCoordenada(0l, 0l);

			CriadorSondaPadrao criadorSondaPadrao = new CriadorSondaPadrao();
			sonda = criadorSondaPadrao.adicionarCoordenada(coordenada)
					.adicionarPlanalto(planalto)
					.adicionarDirecaoOrientacaoSonda(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE)
					.criarSonda();
			
		} catch (ColisaoException e) {
			
			Assert.fail();
		}
	}

	@Test
	public void girarSonda90GrausEsquerda() {

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_OESTE, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_SUL, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_LESTE, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE, sonda.getDirecaoOrientacao());

	}

	@Test
	public void girarSonda90GrausDireita() {

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_LESTE, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_SUL, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_OESTE, sonda.getDirecaoOrientacao());

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
		assertEquals(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE, sonda.getDirecaoOrientacao());

	}

	@Test
	public void moverSondaParaFrente() {

		try {
			sonda.moverSonda();
			assertEquals(0l, sonda.getCoordenada().getCoordenadaX().longValue());
			assertEquals(1l, sonda.getCoordenada().getCoordenadaY().longValue());

			sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
			sonda.moverSonda();
			assertEquals(1l, sonda.getCoordenada().getCoordenadaX().longValue());
			assertEquals(1l, sonda.getCoordenada().getCoordenadaY().longValue());

			sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
			sonda.moverSonda();
			assertEquals(1l, sonda.getCoordenada().getCoordenadaX().longValue());
			assertEquals(0l, sonda.getCoordenada().getCoordenadaY().longValue());

			sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_DIREITA);
			sonda.moverSonda();
			assertEquals(0l, sonda.getCoordenada().getCoordenadaX().longValue());
			assertEquals(0l, sonda.getCoordenada().getCoordenadaY().longValue());

		} catch (ColisaoException e) {
			Assert.fail();
		}
	}

	@Test(expected = ColisaoException.class)
	public void tratarColisaoLateralPlanaltoRetangular() throws ColisaoException {

		sonda.girarSonda(DirecaoGiroSondaEnum.GIRAR_SONDA_ESQUERDA);
		sonda.moverSonda();

	}

	@Test(expected = ColisaoException.class)
	public void tratarColisaoEntreSondas() throws ColisaoException {

		sonda.moverSonda();

		CriadorSondaPadrao criadorSondaPadrao = new CriadorSondaPadrao();
		Coordenada coordenada = CriadorCoordenadaXY.criarCoordenada(0l, 0l);
		Sonda sonda2 = criadorSondaPadrao.adicionarCoordenada(coordenada).adicionarPlanalto(planalto)
				.adicionarDirecaoOrientacaoSonda(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE).criarSonda();

		sonda2.moverSonda();
	}

	@Test(expected = ColisaoException.class)
	public void tratarSondaInicialEmPosicaoJaOcupada() throws ColisaoException {

		CriadorSondaPadrao criadorSondaPadrao = new CriadorSondaPadrao();
		Coordenada coordenada = CriadorCoordenadaXY.criarCoordenada(0l, 0l);
		Sonda sonda2 = criadorSondaPadrao.adicionarCoordenada(coordenada)
				.adicionarPlanalto(planalto)
				.adicionarDirecaoOrientacaoSonda(DirecaoOrientacaoSondaEnum.DIRECAO_NORTE)
				.criarSonda();

	}
}
