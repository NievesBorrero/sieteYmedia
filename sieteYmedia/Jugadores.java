package sieteYmedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Jugadores {
	
	private static ArrayList<Jugador> jugadores;
	
	private Jugadores(){
		jugadores= new ArrayList<Jugador>();
	}
	
	public static Jugadores getInstance(){
		if(jugadores==null)
			return new Jugadores();
		return null;
	}
	
	/**
	 * A�ade un jugador
	 * @param jugador
	 */
	public void add(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	/**
	 * Elimina un jugador
	 * @param index
	 */
	public void remove(int index) {
		jugadores.remove(index);
		
	}
	/**
	 * Comprueba si la lista est� vac�a
	 * @return boolean
	 */
	public boolean isEmpty() {
		return jugadores.isEmpty();
	}
	
	/**
	 * Devuelve un jugador
	 * @param indice
	 * @return jugador
	 */
	public Jugador get(int i) {
		return jugadores.get(i);
	}
	
	/**
	 * Devuelve una lista de jugadores iterable
	 * @return iterator
	 */
	public ListIterator toIterator() {
		ListIterator it= jugadores.listIterator();
		return it;
	}
	/**
	 * Ordena la lista de jugadores por partidas ganadas
	 */
	static void ordenarPorPartidasGanadas() {
		Collections.sort(jugadores);
	}
	
	/**
	 * Devuelve el tama�o de la lista de jugadores.
	 * @return entero
	 */
	public int size() {
		return jugadores.size();
	}

}
