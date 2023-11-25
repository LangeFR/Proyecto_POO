package Torneo_PKG;

public class Fortnite extends Juego{
    private int kills;
    private int puntaje;

    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int kills) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.kills = kills;
        this.puntaje = 0;
    }
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    public int getKills() {return kills;}
    public int getPuntaje(){return puntaje;}

    public void setKills(int kills) {this.kills = kills;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
}
