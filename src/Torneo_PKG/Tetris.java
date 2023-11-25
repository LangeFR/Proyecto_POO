package Torneo_PKG;

public class Tetris extends Juego {
    private int filledRows;
    private int puntaje;

    /*
     * Constructor recibe atributos de Juego y filas completadas
     * Si no recibe filas, asigna 0
     */
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int filledRows) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.filledRows = filledRows;
        this.puntaje = 0;
    }
    public Tetris(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    /*
     * Getters
     */
    public int getFilledRows() {return filledRows;}
    public int getPuntaje(){return puntaje;}

    /*
     * Setters
     */
    public void setFilledRows(int filledRows) {this.filledRows = filledRows;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
}
