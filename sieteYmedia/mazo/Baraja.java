package sieteYmedia.mazo;
/**
 * Clase para crear una baraja
 * @author Nieves Borrero
 */
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	private ArrayList<Carta> baraja = new ArrayList<Carta>(40);

	public Baraja() {
		for (Palo palo : Palo.values()) {
			/*
			 * Usamos values() para que nos devuelva un array de las enum y así
			 * poderlas recorrer para añadirle los valores a cada carta.
			 */for (Figura figura : Figura.values()) {
				baraja.add(new Carta(palo, figura));
			}
		}
	}

	/**
	 * Cambia el orden de los elementos de la coleccion de forma aleatoria.
	 */
	public void barajar() {
		Collections.shuffle(baraja);
	}

	/**
	 * Devuelve la carta en la posición 0 de la baraja.
	 * 
	 * @return
	 * @throws BarajaVaciaException 
	 */
	public Carta get() throws BarajaVaciaException {
		if(baraja.isEmpty())
			throw new BarajaVaciaException("La baraja está vacía");
		return baraja.get(0);
	}

	/**
	 * Elimina una carta de la baraja.
	 * 
	 * @param carta
	 * @throws BarajaVaciaException 
	 */
	public void remove(Carta carta) throws BarajaVaciaException {
		if(baraja.isEmpty())
			throw new BarajaVaciaException("La baraja está vacía");
		baraja.remove(carta);
	}
}