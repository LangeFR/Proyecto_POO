package Torneo_PKG;

public class Partida {
    String fecha;
    int tiempo;
    int puntaje;
    Juego juego;

    /*
     * Constructor
     * Recibe fecha, tiempo, puntaje, y el juego correspondiente de la partida
     */
    public Partida(String fecha, int tiempo, int puntaje, Juego juego){
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.puntaje = puntaje;
        this.juego = juego;
    }

    /*
     * Getters
     */
    public String getFecha(){return fecha;}
    public int getTiempo(){return tiempo;}
    public int getPuntaje(){return puntaje;}
    public Juego getJuego (){return juego;}

    /*
     * Setters
     */
    public void setFecha(String fecha){this.fecha = fecha;}
    public void setTiempo(int tiempo){this.tiempo = tiempo;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
    public void setJuego(Juego juego){this.juego = juego;}

    
    
}
