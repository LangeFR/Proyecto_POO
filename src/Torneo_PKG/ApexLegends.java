package Torneo_PKG;

public class ApexLegends extends Juego{
    int kills;
    int deaths;

    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int kills, int deaths) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.kills = kills;
        this.deaths = deaths;
    }
    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0, 0);
    }
}
