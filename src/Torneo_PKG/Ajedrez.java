package Torneo_PKG;

public class Ajedrez extends Juego{
    private int puntaje;

    public Ajedrez(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.puntaje = 0;
    }

    public int getPuntaje(){return puntaje;}

    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
}
