package sieteYmedia.mazo;

/**
 * Enumeración de cartas.
 * 
 * @author Nieves Borrero.
 *
 */
public enum Figura {
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(0.5), CABALLO(
			0.5), REY(0.5);
	Double puntos;

	Figura(double puntos) {
		setPuntos(puntos);
	}

	double getPuntos() {
		return puntos;
	}

	private void setPuntos(Double puntos) {
		this.puntos = puntos;
	}
}
