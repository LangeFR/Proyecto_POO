package Torneo_PKG;

import java.util.ArrayList;

public class ApexLegends extends Juego{
    private ArrayList<Jugador> jugadoresApexLegends;

    /*
     * Constructor recibe atributos de Juego
     */
    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        jugadoresApexLegends = new ArrayList<Jugador>();
    }

    /*
     * Getter y Setter
     */
    public ArrayList<Jugador> getJugadoresApexLegends(){return jugadoresApexLegends;}
    public void setJugadoresApexLegends(ArrayList<Jugador> jugadoresApexLegends){this.jugadoresApexLegends = jugadoresApexLegends;}

    /*
     * Recibe un jugador y lo añade a la lista
     * No retorna nada
     */
    public void añadirJugadorApexLegends(Jugador jugador) {
        jugadoresApexLegends.add(jugador);
    }

    /*
     * Sistema de Puntajes
     * Kill = 10 puntos - Death = -6 puntos
     * No es posible tener puntaje negativo*
     */
    public int definirPuntos(int kills, int deaths){
        int puntosKill = kills * 5;
        int puntosDeath = deaths * 3;

        int total = puntosKill - puntosDeath;

        if(total >= 0)
            return total;
        return 0;
    }
}
