package Torneo_PKG;

import java.util.ArrayList;

public class Tetris extends Juego{
    private ArrayList<Jugador> jugadoresTetris;

    /*
     * Constructor recibe atributos de Juego y filas completadas
     * Si no recibe filas, asigna 0
     */
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        jugadoresTetris = new ArrayList<Jugador> ();
    }

    /*
     * Getter y Setter
     */
    public ArrayList<Jugador> getJugadoresTetris(){return jugadoresTetris;}
    public void setJugadoresTetris(ArrayList<Jugador> jugadoresTetris){this.jugadoresTetris = jugadoresTetris;}

    /*
     * Recibe un jugador y lo añade a la lista
     * No retorna nada
     */
    public void añadirJugadorTetris(Jugador jugador) {
        jugadoresTetris.add(jugador);
    }

    /*
     * Recibe un jugador y verifica si esta en la lista
     * Retorna el valor verdad
     */
    public boolean isInTetris(Jugador jugador){
        String correo = jugador.getCorreo();

        for(Jugador jugadorActual : jugadoresTetris){
            if(jugadorActual.getCorreo().equals(correo))
                return true;
        }

        return false;
    }

    /*
     * Sistema de puntajes
     * Va aumentando progresivamente dependiendo del numero de filas despejadas
     */
    public int definirPuntos(int filledRows){
        if(filledRows < 10)
            return 5;
        else if(10 <= filledRows && filledRows < 20)
            return 10;
        else if(20 <= filledRows && filledRows < 30)
            return 15;
        else if(30 <= filledRows && filledRows < 40)
            return 30;
        else if(40 <= filledRows && filledRows < 50)
            return 45;
        else if(50 <= filledRows && filledRows < 60)
            return 65;
        else if(60 <= filledRows && filledRows < 70)
            return 85;
        else
            return 100;
    }
}
