package Torneo_PKG;
import java.util.ArrayList;

public class Fortnite extends Juego{
    private ArrayList<Jugador> jugadoresFortnite;

    /*
     * Constructor recibe atributos de Juego
     */
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        jugadoresFortnite = new ArrayList<Jugador> ();
    }

    /*
     * Getter y Setter
     */
    public ArrayList<Jugador> getJugadoresFortnite(){return jugadoresFortnite;}
    public void setJugadoresFortnite(ArrayList<Jugador> jugadoresFortnite){this.jugadoresFortnite = jugadoresFortnite;}

    /*
     * Recibe un jugador y lo añade a la lista
     * No retorna nada
     */
    public void añadirJugadorFortnite(Jugador jugador) {
        jugadoresFortnite.add(jugador);
    }

    /*
     * Recibe un jugador y verifica si esta en la lista
     * Retorna el valor verdad
     */
    public boolean isInFortnite(Jugador jugador){
        String correo = jugador.getCorreo();

        for(Jugador jugadorActual : jugadoresFortnite){
            if(jugadorActual.getCorreo().equals(correo))
                return true;
        }

        return false;
    }
    /*
     * Sistema de puntajes
     * Puestos del 1-100, asigna un punto por puesto avanzado
     */
    public int definirPuntaje(int puesto){
        return 101 - puesto;
    }
}
