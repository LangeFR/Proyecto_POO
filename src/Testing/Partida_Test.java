package Testing;

import Torneo_PKG.*;

public class Partida_Test {

    public static void main(String[] args) {
        Fortnite fortnite = new Fortnite("Fortnite", "Epic Games", 100, "Last one standing");
        Ajedrez ajedrez = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");
        ApexLegends apexLegends = new ApexLegends("ApexLegends", "Respawn Entertainment", 50, "Numero de kills");
        Tetris tetris = new Tetris("Tetris", "Alekséi Pázhitnov", 1, "Acumulacion de puntos");
            
        Partida partida1 = new Partida("2023_11_26", 1800, 4, fortnite);
        Partida partida2 = new Partida("2023_1_6", 450, 4, fortnite);
        Partida partida3 = new Partida("2023_12_2", 3600, 4, ajedrez);
        Partida partida4 = new Partida("2023_6_16", 700, 4, tetris);
        Partida partida5 = new Partida("2023_3_4", 1600, 4, fortnite);
        Partida partida6 = new Partida("2023_24_2", 1000, 4, apexLegends);

        
    }

}
