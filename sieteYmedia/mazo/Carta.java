package sieteYmedia.mazo;

/**
 * Clase que crea una carta con palo y figura.
 * 
 * @author Nieves Borrero.
 *
 */
public class Carta {

	private Palo palo;
	private Figura figura;

	Carta(Palo palo, Figura figura) {
		this.palo = palo;
		this.figura = figura;
	}

	/**
	 * Devuelve los puntos de la carta.
	 * 
	 * @return
	 */
	public double puntos() {
		return figura.getPuntos();
	}

	@Override
	public String toString() {
		String cadena = "Carta [palo= " + palo + ", figura= " + figura + "]";
		return cadena.toLowerCase();
	}

}
