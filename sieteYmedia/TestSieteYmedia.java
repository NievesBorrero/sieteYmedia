package sieteYmedia;
/**
 * Probando las 7 y media
 * @author Nieves Borrero
 */
import java.util.ArrayList;
import java.util.ListIterator;

import sieteYmedia.mazo.BarajaVaciaException;
import utiles.Menu;
import utiles.Teclado;

public class TestSieteYmedia {
	static Jugadores jugadores = Jugadores.getInstance();
	
	public static void main(String[] args) {
		Menu menu = new Menu("SIETE Y MEDIA", new String[] { "aÃ±adir jugador",
				"Jugar partida", "Ranking", "Eliminar jugador", "Salir" });
		int opcion;
		do {
			switch (opcion = menu.gestionar()) {
			case 1:
				annadirJugador();
				break;
			case 2:
				jugar();
				break;
			case 3:
				ranking();
				break;
			case 4:
				eliminarJugador();
			case 5:
				System.out.println("Hasta otra");
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcion != menu.getSalir());
	}
	
	/**
	 * elimina un jugador de la lista
	 */
	private static void eliminarJugador() {
		try {
			jugadores.remove(Teclado
					.leerEntero("Introduce el numero de jugador que deseas borrar"));
		} catch (IndiceNoValidoException e) {
			e.getMessage();
		}

	}

	/**
	 * introduce un jugador en la lista
	 */
	private static void annadirJugador() {
		jugadores.add(new Jugador(Teclado.leerCadena("Alias:")));
	}
	
	/**
	 * muestra el ranking de jugadores
	 */
	private static void ranking() {
		if(!jugadores.isEmpty()){
			jugadores.ordenarPorPartidasGanadas();
			ListIterator<Jugador> it= jugadores.toIterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		else
			System.out.println("No existen jugadores");				
	}
	/**
	 * se juega una partida
	 */
	private static void jugar() {
		if (!jugadores.isEmpty()) {
			try {
				String alias;
				int n_jugadores=0;
				String[] opciones = new String[jugadores.size()];
				boolean deseaContinuar;
				do {
					deseaContinuar=false;
					for (int i = 0; i < opciones.length; i++) {
						alias = jugadores.get(i).getAlias();
						opciones[i] = alias;
					}
					Menu menu = new Menu("JUGADORES", opciones);
					int opcion = menu.gestionar();
					jugadores.get(opcion - 1).esParticipante = true;
					n_jugadores++;
					if(n_jugadores<opciones.length)
						deseaContinuar=Teclado.deseaContinuar("Deseas aÃ±adir otro participante?");
				} while (deseaContinuar);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Selecciona una opcion valida");
			}
			ArrayList<Jugador> nuevaPartida= new ArrayList<Jugador>();
			Partida partida=new Partida(nuevaPartida);
			
			ListIterator<Jugador> it= jugadores.toIterator();
			Jugador jugador;
			while(it.hasNext()){
				jugador=it.next();
				if(jugador.esParticipante)
					partida.add(jugador);		
			}
			try {
				partida.jugarPartida();
			} catch (BarajaVaciaException e) {
				System.out.println(e.getMessage());
			} catch (MinimoDosJugadoresException e) {
				System.out.println(e.getMessage());
			}
			for (int i = 0; i < partida.tamañoParticipantes(); i++) {
				partida.getParticipante(i).esParticipante=false; 
					// Una vez terminada la partida,nadie es participante
			}
		}
	}
}
		


