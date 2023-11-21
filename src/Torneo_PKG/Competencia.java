package Torneo_PKG;

import java.util.ArrayList;

public class Competencia {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Juego> juegos;

    /*
     * Constructor competencia
     * No parametros
     */
    public Competencia(){

    }

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

    //--------------------------------------------------
    public Jugador mejorJugador(){
        //Por implementar
        return null;
    }
}
