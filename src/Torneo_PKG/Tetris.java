package Torneo_PKG;

public class Tetris extends Juego {
    private int filledRows;
    private int puntaje;

    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int filledRows) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.filledRows = filledRows;
        this.puntaje = 0;
    }
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    public int getFilledRows() {return filledRows;}
    public int getPuntaje(){return puntaje;}

    public void setFilledRows(int filledRows) {this.filledRows = filledRows;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
}
