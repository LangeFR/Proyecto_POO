package Torneo_PKG;

public class Ajedrez extends Juego{
    private int puntaje;

    /*
     * Constructor recibe atributos de juego y asigna puntaje en 0
     */
    public Ajedrez(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.puntaje = 0;
    }

    /*
     * Getters
     */
    public int getPuntaje(){return puntaje;}

    /*
     * Setters
     */
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}

    /*
     * Sistema de puntajes
     * Si es victoria, asigna 10 puntos, si empate 5 puntos, si derrota 0 puntos
     */
    public int definirPuntaje(int res){
        if(res == 1)
            return 10;
        else if(res == 0)
            return 5;
        return 0;
    }
}
