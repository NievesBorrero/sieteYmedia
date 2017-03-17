package sieteYmedia;

/**
 * Clase para crear un jugador.
 * 
 * @author Nieves Borrero
 *
 */
public class Jugador implements Comparable <Jugador>{
	private String alias;
	private int partidas_jugadas;
	private int partidas_ganadas;
	private int partidas_perdidas;
	boolean esParticipante = false;

	Jugador(String alias) {
		setAlias(alias);
	}

	public int getPartidas_jugadas() {
		return partidas_jugadas;
	}

	private void setPartidas_jugadas(int partidas_jugadas) {
		this.partidas_jugadas = partidas_jugadas;
	}

	public int getPartidas_ganadas() {
		return partidas_ganadas;
	}

	private void setPartidas_ganadas(int partidas_ganadas) {
		this.partidas_ganadas = partidas_ganadas;
	}

	public int getPartidas_perdidas() {
		return partidas_perdidas;
	}

	private void setPartidas_perdidas(int partidas_perdidas) {
		this.partidas_perdidas = partidas_perdidas;
	}

	String getAlias() {
		return alias;
	}

	private void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Suma una partida a las partidas ganadas.
	 */
	public void sumarPartidasGanadas() {
		setPartidas_ganadas(getPartidas_ganadas() + 1);
	}

	/**
	 * Suma una partida a las partidas perdidas.
	 */
	public void sumarPartidasPerdidas() {
		setPartidas_perdidas(getPartidas_perdidas() + 1);
	}

	/**
	 * Suma una partida a las partidas jugadas.
	 */
	public void sumarPartidasJugadas() {
		setPartidas_jugadas(getPartidas_jugadas() + 1);
	}

	/**
	 * Muestra las partidas perdidas y ganadas de un jugador.
	 */
	@Override
	public String toString() {
		return alias + ", partidas jugadas: " + partidas_jugadas
				+ ", partidas ganadas: " + partidas_ganadas+ "\n";
	}

	public int compareTo(Jugador jugador) { 
		 		int comparepg = ((Jugador)jugador).getPartidas_ganadas(); 
		 		return comparepg-this.partidas_ganadas; 
		 	} 

}
