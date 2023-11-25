package Torneo_PKG;

public class ApexLegends extends Juego{
    private int kills;
    private int deaths;
    private int puntaje;

    /*
     * Constructor recibe atributos de Juego y kills y deaths del jugador
     * Si no recibe kills o deaths, asigna 0
     */
    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int kills, int deaths) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.kills = kills;
        this.deaths = deaths;
    }
    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0, 0);
    }

    /*
     * Getters
     */
    public int getKills() {return kills;}
    public int getDeaths() {return deaths;}
    public int getPuntaje(){return puntaje;}

    /*
     * Setters
     */
    public void setKills(int kills) {this.kills = kills;}
    public void setDeaths(int deaths) {this.deaths = deaths;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}

    /*
     * Sistema de Puntajes
     * Kill = 10 puntos - Death = -6 puntos
     * No es posible tener puntaje negativo*
     */
    public int definirPuntos(){
        int puntosKill = kills * 10;
        int puntosDeath = deaths * 6;

        int total = puntosKill - puntosDeath;

        if(total >= 0)
            return total;
        return 0;
    }
}
