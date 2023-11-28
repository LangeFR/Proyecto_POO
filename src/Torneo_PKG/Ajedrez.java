package Torneo_PKG;
import java.util.ArrayList;

public class Ajedrez extends Juego{
    private ArrayList<Jugador> jugadoresAjedrez;

    /*
     * Constructor recibe atributos de juego
     */
    public Ajedrez(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        jugadoresAjedrez = new ArrayList<Jugador> ();
    }

    /*
     * Getter y Setter
     */
    public ArrayList<Jugador> getJugadoresAjedrez(){return jugadoresAjedrez;}
    public void setJugadoresAjedrez(ArrayList<Jugador> jugadoresAjedrez){this.jugadoresAjedrez = jugadoresAjedrez;}

    /*
     * Recibe un jugador y lo añade a la lista
     * No retorna nada
     */
    public void añadirJugadorAjedrez(Jugador jugador) {
        jugadoresAjedrez.add(jugador);
    }

    /*
     * Recibe un jugador y verifica si esta en la lista
     * Retorna el valor verdad
     */
    public boolean isInAjedrez(Jugador jugador){
        String correo = jugador.getCorreo();

        for(Jugador jugadorActual : jugadoresAjedrez){
            if(jugadorActual.getCorreo().equals(correo))
                return true;
        }

        return false;
    }

    /*
     * Sistema de puntajes
     * Si es victoria, asigna 10 puntos, si empate 5 puntos, si derrota 0 puntos
     */
    public int definirPuntaje(int res){
        if(res == 1)
            return 10;
        else if(res == 2)
            return 5;
        return 0;
    }
}
