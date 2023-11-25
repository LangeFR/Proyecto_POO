package Torneo_PKG;

public class Tetris extends Juego {
    int puntaje;

    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int puntaje) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.puntaje = puntaje;
    }
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    
}
