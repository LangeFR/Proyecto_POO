package Torneo_PKG;
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
    private String nombre;
    private String correo;
    private String nickName;

    private ArrayList<Partida> partidas;

    public Jugador(String nombre, String correo, String nickName) {
        this.nombre = nombre;
        this.correo = correo;
        this.nickName = nickName;
        partidas = new ArrayList<>();
    }

    /*
     * Getters
     */
    public String getNombre() {return nombre;}
    public String getCorreo() {return correo;}
    public String getNickName() {return nickName;}
    public ArrayList<Partida> getPartidas() {return partidas;}
    public Partida getPartida(int i){return partidas.get(i);}

    /*
     * Setters
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } public void setCorreo(String correo) {
        this.correo = correo;
    } public void setNickName(String nikcName) {
        this.nickName = nikcName;
    } public void setPartidas(ArrayList<Partida> partidas){
        this.partidas = partidas;
    } public void setPartida(int i, Partida partida){
        partidas.set(i, partida);
    }

    /*
     * Recibe una partida y la agrega a la lista
     * No retorna nada
     */
    public void agregarPartida(Partida partida){partidas.add(partida);}

    /*
     * Retorna la suma del puntaje de todas las partidas del jugador     
    */    
    public int puntajeAcumulado(){
        int puntaje = 0;
        for (int i = 0; i < partidas.size(); i++) {
            puntaje += partidas.get(i).getPuntaje();
        }
        return puntaje;
    }

    /*
     * Recibe un juego y suma el total de puntos
     * Retorna la suma de puntos
     */
    public int puntajeAcumulado(Juego juego){
        int puntajeTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            puntajeTotal += partidas.get(partidaActual).getPuntaje();
        }

        return puntajeTotal;
    }

    /*
     * Recibe un juego y retorna el mayor puntaje
     */
    public int mejorPuntaje(Juego juego){
        int puntajeMax = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                if(partidas.get(partidaActual).getPuntaje() > puntajeMax)
                    puntajeMax = partidas.get(partidaActual).getPuntaje();
            
        }

        return puntajeMax;
    }

    /*
     * Recibe un juego e identifica el mayor puntaje
     * Retorna la partida con dicho puntaje
     */
    public Partida mejorPartida(Juego juego){
        int puntajeMax = 0;
        int posMax = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                if(partidas.get(partidaActual).getPuntaje() > puntajeMax)
                    puntajeMax = partidas.get(partidaActual).getPuntaje();
                    posMax = partidaActual;
            
        }

        return partidas.get(posMax);
    }

    /*
     * No recibe nada.
     * Retorna el juego con mayor puntaje 
     */
    public Juego mejorJuego(){
        int puntajeFortnite = 0;
        int puntajeAjedrez = 0;
        int puntajeApexLegends = 0;
        int puntajeTetris = 0;

        Fortnite juegoFortnite = null;
        Ajedrez juegoAjedrez = null;
        ApexLegends juegoApex = null;
        Tetris juegoTetris = null;

        /*
         * Itera por todas las partidas del jugador
         * Identifica el juego especifico usando polimorfismo y le añade el puntaje al contador respectivo
         * 
         * Ademas almacena el tipo de juego para retornar
         */
        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            Partida partida = partidas.get(partidaActual);
            
            //Contador Fortnite
            if(partida.getJuego() instanceof Fortnite){
                puntajeFortnite += partida.getPuntaje();

                //Guarda el juego de las partidas de Fortnite
                if(juegoFortnite == null)
                    juegoFortnite = (Fortnite) partida.getJuego();
            }

            //Contador Ajedrez
            else if(partida.getJuego() instanceof Ajedrez){
                puntajeAjedrez += partida.getPuntaje();

                //Guarda el juego de las partidas de Ajedrez
                if(juegoAjedrez == null)
                    juegoAjedrez = (Ajedrez) partida.getJuego();
            }

            //Contador ApexLegends
            else if(partida.getJuego() instanceof ApexLegends){
                puntajeApexLegends += partida.getPuntaje();

                //Guarda el juego de las partidas de Apex Legends
                if(juegoApex == null)
                    juegoApex = (ApexLegends) partida.getJuego();
            }

            //Contador Tetris
            else if(partida.getJuego() instanceof Tetris){
                puntajeTetris += partida.getPuntaje();

                //Guarda el juego de las partidas de Tetris
                if(juegoTetris == null)
                    juegoTetris = (Tetris) partida.getJuego();
            }
        }

        /*
         * Compara los puntajes de cada juego y almacena el mejor juego
         * Luego lo retorna
         */
        Juego mejorJuego = null;

        if (puntajeFortnite >= puntajeAjedrez && puntajeFortnite >= puntajeApexLegends && 
            puntajeFortnite >= puntajeTetris) {
            mejorJuego = juegoFortnite;
        } else if (puntajeAjedrez >= puntajeApexLegends && puntajeAjedrez >= puntajeTetris) {
            mejorJuego = juegoAjedrez;
        } else if (puntajeApexLegends >= puntajeTetris) {
            mejorJuego = juegoApex;
        } else {
            mejorJuego = juegoTetris;
        }

        return mejorJuego;
    }

    /*
     * No recibe nada. 
     * Retorna la cantidad de partidas totales (en los 4 juegos) del jugador
     */
    public int cantidadPartidas(){
        return partidas.size();
    }

    /*
     * Recibe un juego
     * Retorna la cantidad de partidas jugadas de ese juego
     */
    public int cantidadPartidas(Juego juego){
        int partidasTotales = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                partidasTotales++;
            
        }

        return partidasTotales;
    }

    /*
     * No recibe nada
     * Retorna la cantidad de horas jugadas totales (en los 4 juegos) del jugador
     */
    public int horasJugadas(){
        int horasTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            horasTotal += partidas.get(partidaActual).getTiempo();
        }

        return horasTotal  / 3600;
    }

    /*
     * Recibe un juego
     * Retorna la cantidad de horas jugadas de ese juego
     */
    public int horasJugadas(Juego juego){
        int horasTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            Partida partida = partidas.get(partidaActual);
            
            if(juego.getClass().isInstance(partida.getJuego()))
                horasTotal += partidas.get(partidaActual).getTiempo();
        }

        return horasTotal / 3600;
    }

}
