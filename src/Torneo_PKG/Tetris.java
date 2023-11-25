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

    public int definirPuntos(){
        if(filledRows < 10)
            return 5;
        else if(10 <= filledRows && filledRows < 20)
            return 10;
        else if(20 <= filledRows && filledRows < 30)
            return 15;
        else if(30 <= filledRows && filledRows < 40)
            return 30;
        else if(40 <= filledRows && filledRows < 50)
            return 45;
        else if(50 <= filledRows && filledRows < 60)
            return 65;
        else if(60 <= filledRows && filledRows < 70)
            return 85;
        else
            return 100;
    }
}
