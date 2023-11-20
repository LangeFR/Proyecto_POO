package Torneo_PKG;

import java.util.ArrayList;

public class Jugador {
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
    public void agregarPartida(Partida partida){partidas.add(partida);}
    public String getNombre() {return nombre;}
    public String getCorreo() {return correo;}
    public String getNickName() {return String.valueOf(nickName);}
    public Partida getPartida(int i){return partidas.get(i);}

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } public void setCorreo(String correo) {
        this.correo = correo;
    } public void setNickName(String nikcName) {
        this.nickName = nickName;
    } public void setPartida(int i, Partida partida){
        partidas.set(i, partida);
    }
    
    public int PuntajeAcumulado(){
        int puntaje = 0;
        for (int i = 0; i < partidas.size(); i++) {
            puntaje += partidas.get(i).getPuntaje();
        }
        return puntaje;
    }
}
