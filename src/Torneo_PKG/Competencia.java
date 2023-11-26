package Torneo_PKG;

import java.io.Serializable;
import java.util.ArrayList;

public class Competencia implements Serializable{
    private ArrayList<Jugador> jugadores;
    private ArrayList<Juego> juegos;

    /*
     * Constructor competencia
     * No parametros
     */
    public Competencia(){
        jugadores = new ArrayList<Jugador>();
        juegos = new ArrayList<Juego>();
    }

    /*
     * Getters
     */
    public ArrayList<Jugador> getJugadores(){return jugadores;}
    public ArrayList<Juego> getJuegos(){return juegos;}

    /*
     * Recibe un jugador y lo agrega a la lista de jugadores
     * No retorna nada
     */
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    /*
     * Recibe un juego y lo agrega a la lista de juegos
     * No retorna nada
     */
    public void agregarJuego(Juego juego){
        juegos.add(juego);
    }

    /*
     * Recibe la posicion de un jugador y lo retorna
     */
    public Jugador getJugador (int i){
        return jugadores.get(i);
    }

    /*
     * Recibe la posicion de un juego y lo retorna
     */
    public Juego getJuego(int i){
        return juegos.get(i);
    }

    /*
     * Compara los puntajes de todos los jugadores y encuentra el mejor
     * Retorna el jugador con el puntaje mas alto
     */
    public Jugador mejorJugador(){
        int puntajeMax = jugadores.get(0).puntajeAcumulado();
        int posMejor = 0;

        for (int jugadorActual = 0; jugadorActual <= jugadores.size(); jugadorActual++){
            if(jugadores.get(jugadorActual).puntajeAcumulado() > puntajeMax){
                puntajeMax = jugadores.get(jugadorActual).puntajeAcumulado();
                posMejor = jugadorActual;
            }
        }

        return jugadores.get(posMejor);
    }

    /*
     * Recibe un juego y retorna el mejor jugador en dicho juego
     */
    public Jugador mejorJugador(Juego juego){
        Jugador mejorJugador = null;
        int maxPuntaje = 0;

        for(Jugador jugadorActual : jugadores){
            if(jugadorActual.puntajeAcumulado(juego) > maxPuntaje){
                maxPuntaje = jugadorActual.horasJugadas();
                mejorJugador = jugadorActual;
            } 
        }

        return mejorJugador;
    }

    /*
     * No recibe nada
     * Retorna el jugador con mayor numero de horas jugadas
     */
    public Jugador adicto (){
        Jugador jugadorAdicto = null;
        int maxHoras = 0;

        for(Jugador jugadorActual : jugadores){
            if(jugadorActual.horasJugadas() > maxHoras){
                maxHoras = jugadorActual.horasJugadas();
                jugadorAdicto = jugadorActual;
            } 
        }

        return jugadorAdicto;
    }

    /*
     * No recibe nada
     * Retorna el jugador con mayor numero de partidas
     */
    public Jugador persistente (){
        Jugador jugadorPersistente = null;
        int maxPartidas = 0;

        for(Jugador jugadorActual : jugadores){
            if(jugadorActual.cantidadPartidas() > maxPartidas){
                maxPartidas = jugadorActual.cantidadPartidas();
                jugadorPersistente = jugadorActual;
            } 
        }

        return jugadorPersistente;
    }
}
