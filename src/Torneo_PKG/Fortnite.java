package Torneo_PKG;

public class Fortnite extends Juego{
    int kills;

    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int kills) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.kills = kills;
    }
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    public int getKills() {return kills;}

    public void setKills(int kills) {this.kills = kills;}
}
