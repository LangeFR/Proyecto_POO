package Testing;

import Torneo_PKG.*;
import javax.swing.*;

public class Jugador_Test {
    public static void main(String[] args) {
        Fortnite fortnite = new Fortnite("Fortnite", "Epic Games", 100, "Last one standing");
        Ajedrez ajedrez = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");
        ApexLegends apexLegends = new ApexLegends("ApexLegends", "Respawn Entertainment", 50, "Numero de kills");
        Tetris tetris = new Tetris("Tetris", "Alekséi Pázhitnov", 1, "Acumulacion de puntos");
            
        Jugador jugador = new Jugador("Pepe", "pepe123@gmail.com", "pepito");

        Partida partida1 = new Partida("2023_11_26", 3600, 36, fortnite);
        Partida partida2 = new Partida("2023_1_6", 2000, 40, fortnite);
        Partida partida3 = new Partida("2023_12_2", 3600, 10, ajedrez);
        Partida partida4 = new Partida("2023_6_16", 700, 80, tetris);
        Partida partida5 = new Partida("2023_3_4", 1600, 22, fortnite);
        Partida partida6 = new Partida("2023_24_2", 1000, 18, apexLegends);
        Partida partida7 = new Partida("2023_1_7", 4600, 0, ajedrez);

        jugador.agregarPartida(partida1);
        jugador.agregarPartida(partida2);
        jugador.agregarPartida(partida3);
        jugador.agregarPartida(partida4);
        jugador.agregarPartida(partida5);
        jugador.agregarPartida(partida6);
        jugador.agregarPartida(partida7);

        int puntos = jugador.puntajeAcumulado();                //Expected: 206
        int partidasTotales = jugador.cantidadPartidas();       //Expected: 7
        int horas = jugador.horasJugadas();                     //Expected: 4
        int horasFortnite = jugador.horasJugadas(fortnite);     //Expected: 2
        int partidasAjedrez = jugador.cantidadPartidas(ajedrez); //Expected:2

        String resultados = "Puntaje Acumulado: " + puntos + "\nPartidas Jugadas: " + partidasTotales + "\nHoras jugadas: " + horas +
         "\nHoras jugando Fortnite: " + horasFortnite + "\nPartidas Ajedrez: " + partidasAjedrez;

        JOptionPane.showMessageDialog(null, resultados);
        
    }
}
