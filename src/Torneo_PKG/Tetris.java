package Torneo_PKG;

public class Tetris extends Juego {
    int filledRows;

    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int filledRows) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.filledRows = filledRows;
    }
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    public int getFilledRows() {return filledRows;}

    public void setFilledRows(int filledRows) {this.filledRows = filledRows;}
}
