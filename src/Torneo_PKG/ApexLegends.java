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
}
