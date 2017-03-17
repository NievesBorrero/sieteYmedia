package sieteYmedia;

import java.util.ArrayList;
/**
 * Esta clase contiene los jugadores que existen en las Siete y media.
 * @author Nieves
 *
 */
public class Jugadores {
	private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	/**
	 * Añade un jugador a las siete y media.
	 * 
	 * @param alias
	 */
	void add(String alias) {
		jugadores.add(new Jugador(alias));
	}
	/**
	 * Elimina un jugador.
	 * 
	 * @param index
	 */
	void remove(int index) {
		jugadores.remove(index);
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	/**
	 * Devuelve el jugador de la posición introducida.
	 * 
	 * @param opcion
	 */
	public Jugador getJugador(int index) {
		return jugadores.get(index);
	}
	/**
	 * Comprueba si la lista está vacía.
	 * @return true o false.
	 */
	public boolean jugadoresIsEmpty() {
		if (jugadores.isEmpty())
			return true;
		return false;
	}
}
