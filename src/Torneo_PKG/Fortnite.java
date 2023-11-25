package Torneo_PKG;

public class Fortnite extends Juego{
    private int puesto;
    private int puntaje;

    /*
     * Constructor recibe atributos de Juego y puesto del jugador
     * Si no recibe kills, asigna 0
     */
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego, int puesto) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
        this.puesto = puesto;
        this.puntaje = 0;
    }
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        this(nombre, casaMatriz, cantjugadores, tipoJuego, 0);
    }

    /*
     * Getters
     */
    public int getKills() {return puesto;}
    public int getPuntaje(){return puntaje;}

    /*
     * Setters
     */
    public void setKills(int puesto) {this.puesto = puesto;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}

    /*
     * Sistema de puntajes
     * Puestos del 1-100, asigna un punto por puesto avanzado
     */
    public int definirPuntaje(){
        return 101 - puesto;
    }
}
