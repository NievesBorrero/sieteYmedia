package sieteYmedia;
/**
 * Clase para crear una partida de las 7 y media
 * @author Nieves Borrero
 */
import java.util.ArrayList;

import sieteYmedia.mazo.Baraja;
import sieteYmedia.mazo.BarajaVaciaException;
import sieteYmedia.mazo.Carta;
import utiles.Teclado;

public class Partida {
	private ArrayList<Jugador> participantes;
	private Baraja baraja;
	private Jugador ganador;
	private static final double SIETEYMEDIA = 7.5;

	Partida(ArrayList<Jugador> participantes) {
		setParticipantes(participantes);
		baraja = new Baraja();
		baraja.barajar();
	}

	/**
	 * En este método se resuelve la partida
	 * @throws BarajaVaciaException 
	 */
	void jugarPartida() throws BarajaVaciaException {
		int rondas = Teclado.leerEntero("Cuantas rondas jugareis?");
		for (int j = 0; j < rondas; j++) {
			double[] puntuaciones = new double[participantes.size()];
			// Creo un array para almacenar las puntuaciones.
			int i = 0;
			for (Jugador jugador : participantes) {
				puntuaciones[i++] = jugarTurno(jugador.getAlias());
				// Guardo la puntuación en el array.
				jugador.sumarPartidasJugadas();
			}
			mostrarPuntuacion(puntuaciones, participantes);
			ganador = obtenerGanador(puntuaciones, participantes);
			ganador.sumarPartidasGanadas();
			mostrarGanador();
			ganador = null;
		}
	}

	/**
	 * Devuelve el jugador que ha ganado.
	 * 
	 * @param puntuaciones
	 * @param participantes
	 * @return campeon
	 */

	private Jugador obtenerGanador(double[] puntuaciones,
			ArrayList<Jugador> participantes) {
		double puntosCampeon = 0;
		Jugador campeon = null;
		for (int i = 0; i < puntuaciones.length; i++) {
			if (puntuaciones[i] > puntosCampeon
					&& puntuaciones[i] <= SIETEYMEDIA){
				puntosCampeon = puntuaciones[i];
			campeon = participantes.get(i);
			}
		}
		return campeon;
	}

	/**
	 * Muestra la puntuación obtenida por cada jugador.
	 * 
	 * @param puntuaciones
	 * @param participantes
	 */
	private void mostrarPuntuacion(double[] puntuaciones,
			ArrayList<Jugador> participantes) {
		System.out.println("PUNTUACION:");
		for (int i = 0; i < puntuaciones.length; i++) {
			System.out.println(participantes.get(i).getAlias() + ": "
					+ puntuaciones[i]);
		}

	}

	/**
	 * En este método se desarrolla el turno de cada jugador.
	 * 
	 * @param jugador
	 * @param turno
	 * @return
	 * @throws BarajaVaciaException 
	 */
	private double jugarTurno(String alias) throws BarajaVaciaException {
		Carta carta;
		double puntos = 0;

		System.out.println("Turno de: " + alias);

		do {
			carta = baraja.get();
			System.out.println(carta.toString());
			puntos += carta.puntos();
			baraja.remove(carta);
			if (esSieteYmedia(puntos) || teHasPasado(puntos))
				return puntos;
			if (!Teclado.deseaContinuar("Desea seguir jugando?"))
				return puntos;
		} while (true);
	}

	/**
	 * Comprueba si el jugador se ha pasado de 7.5
	 * 
	 * @param puntos
	 * @return true o false
	 */
	private boolean teHasPasado(double puntos) {
		if (puntos > SIETEYMEDIA)
			return true;
		return false;
	}

	/**
	 * Comprueba si el jugador ha llegado a las 7.5
	 * 
	 * @param puntos
	 * @return true o false
	 */
	private boolean esSieteYmedia(double puntos) {
		if (puntos == SIETEYMEDIA)
			return true;
		return false;
	}

	/**
	 * Muestra el ganador.
	 */
	private void mostrarGanador() {
		System.out.println("Ganador/a: " + ganador);
	}

	public ArrayList<Jugador> getParticipantes() {
		return participantes;
	}

	private void setParticipantes(ArrayList<Jugador> participantes) {
		this.participantes = participantes;
	}

	/**
	 * Añade un nuevo participante
	 * 
	 * @param jugador
	 */
	public void add(Jugador jugador) {
		participantes.add(jugador);

	}

	/**
	 * Devuelve el tamaño del Arraylist de participantes
	 * 
	 * @return
	 */
	public int tamañoParticipantes() {
		return participantes.size();
	}

	/**
	 * Devuelve un participante del ArrayList
	 * 
	 * @param index
	 * @return participante
	 */
	public Jugador getParticipante(int index) {
		return participantes.get(index);
	}

}
