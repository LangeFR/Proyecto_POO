package Testing;

import Torneo_PKG.*;

public class Competencia_Test {
    
    public static void main(String[] args) {
        /*
        System.out.println("test4");
        Competencia compe = new Competencia();

        Fortnite fortnite = new Fortnite("Fortnite", "Epic Games", 100, "Last one standing");
        Ajedrez ajedrez = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");
        ApexLegends apexLegends = new ApexLegends("ApexLegends", "Respawn Entertainment", 50, "Numero de kills");
        Tetris tetris = new Tetris("Tetris", "Alekséi Pázhitnov", 1, "Acumulacion de puntos");
            
        //Definir jugadores
        Jugador jugadorJ = new Jugador("Juan", "Juan@gmail.com", "Jaunito");
        Jugador jugadorP = new Jugador("Pepe", "pepe@gmail.com", "Pepegrillo");
        Jugador jugadorA = new Jugador("Alice", "Alice@hotmail.com", "Aliceee");
        Jugador jugadorB = new Jugador("Bob", "Bob@gmail.com", "Bob");


        //Partidas Juan
        Partida partidaJ1 = new Partida("2023_11_26", 3600, 36, fortnite);
        Partida partidaJ2 = new Partida("2023_1_6", 2000, 40, fortnite);
        Partida partidaJ3 = new Partida("2023_12_2", 3600, 10, ajedrez);
        Partida partidaJ4 = new Partida("2023_6_16", 700, 80, tetris);
        Partida partidaJ5 = new Partida("2023_3_4", 1600, 22, fortnite);
        Partida partidaJ6 = new Partida("2023_24_2", 1000, 18, apexLegends);
        Partida partidaJ7 = new Partida("2023_1_7", 4600, 0, ajedrez);

        //Partidas Pepe
        Partida partidaP1 = new Partida("2023_11_25", 3600, 36, fortnite);
        Partida partidaP2 = new Partida("2023_10_6", 2000, 40, fortnite);
        Partida partidaP3 = new Partida("2023_2_2", 3600, 10, ajedrez);
        Partida partidaP4 = new Partida("2023_6_16", 700, 80, tetris);
        Partida partidaP5 = new Partida("2023_5_14", 1600, 22, fortnite);
        Partida partidaP6 = new Partida("2023_2_4", 1000, 18, apexLegends);
        Partida partidaP7 = new Partida("2023_1_7", 4600, 0, ajedrez);
        Partida partidaP8 = new Partida("2023_8_15", 2910, 64, tetris);
        Partida partidaP9 = new Partida("2023_5_12", 1783, 15, apexLegends);
        Partida partidaP10 = new Partida("2023_10_1", 4215, 30, ajedrez);

        //Partidas Alice
        Partida partidaA1 = new Partida("2023_9_10", 2483, 42, apexLegends);
        Partida partidaA2 = new Partida("2023_7_3", 3210, 27, tetris);
        Partida partidaA3 = new Partida("2023_4_22", 1935, 51, fortnite);
        Partida partidaA4 = new Partida("2023_2_8", 3892, 18, ajedrez);
        Partida partidaA5 = new Partida("2023_11_30", 2765, 33, apexLegends);
        Partida partidaA6 = new Partida("2023_6_5", 1428, 25, tetris);
        Partida partidaA7 = new Partida("2023_3_18", 3074, 46, fortnite);
        Partida partidaA8 = new Partida("2023_1_1", 1987, 20, ajedrez);

        //Partidas Bob
        Partida partidaB1 = new Partida("2023_7_14", 2679, 38, fortnite);
        Partida partidaB2 = new Partida("2023_4_9", 1942, 22, tetris);
        Partida partidaB3 = new Partida("2023_10_5", 3367, 49, apexLegends);
        Partida partidaB4 = new Partida("2023_2_20", 1598, 15, ajedrez);
        Partida partidaB5 = new Partida("2023_11_12", 4021, 32, fortnite);

        //Añade Partidas Juan
        jugadorJ.agregarPartida(partidaJ1);
        jugadorJ.agregarPartida(partidaJ2);
        jugadorJ.agregarPartida(partidaJ3);
        jugadorJ.agregarPartida(partidaJ4);
        jugadorJ.agregarPartida(partidaJ5);
        jugadorJ.agregarPartida(partidaJ6);
        jugadorJ.agregarPartida(partidaJ7);

        //Añade Partidas Pepe
        jugadorP.agregarPartida(partidaP1);
        jugadorP.agregarPartida(partidaP2);
        jugadorP.agregarPartida(partidaP3);
        jugadorP.agregarPartida(partidaP4);
        jugadorP.agregarPartida(partidaP5);
        jugadorP.agregarPartida(partidaP6);
        jugadorP.agregarPartida(partidaP7);
        jugadorP.agregarPartida(partidaP8);
        jugadorP.agregarPartida(partidaP9);
        jugadorP.agregarPartida(partidaP10);

        //Añade Partidas Alice
        jugadorA.agregarPartida(partidaA1);
        jugadorA.agregarPartida(partidaA2);
        jugadorA.agregarPartida(partidaA3);
        jugadorA.agregarPartida(partidaA4);
        jugadorA.agregarPartida(partidaA5);
        jugadorA.agregarPartida(partidaA6);
        jugadorA.agregarPartida(partidaA7);
        jugadorA.agregarPartida(partidaA8);

        //Añade Partidas Bob
        jugadorB.agregarPartida(partidaB1);
        jugadorB.agregarPartida(partidaB2);
        jugadorB.agregarPartida(partidaB3);
        jugadorB.agregarPartida(partidaB4);
        jugadorB.agregarPartida(partidaB5);

        //Añade jugadores a los juegos
        fortnite.añadirJugadorFortnite(jugadorJ);
        fortnite.añadirJugadorFortnite(jugadorP);
        fortnite.añadirJugadorFortnite(jugadorA);
        fortnite.añadirJugadorFortnite(jugadorB);
        
        // Añadir jugadores a Ajedrez
        ajedrez.añadirJugadorAjedrez(jugadorJ);
        ajedrez.añadirJugadorAjedrez(jugadorP);
        ajedrez.añadirJugadorAjedrez(jugadorA);
        ajedrez.añadirJugadorAjedrez(jugadorB);
        
        // Añadir jugadores a Tetris
        tetris.añadirJugadorTetris(jugadorJ);
        tetris.añadirJugadorTetris(jugadorP);
        tetris.añadirJugadorTetris(jugadorA);
        tetris.añadirJugadorTetris(jugadorB);
        
        // Añadir jugadores a Apex Legends
        apexLegends.añadirJugadorApexLegends(jugadorJ);
        apexLegends.añadirJugadorApexLegends(jugadorP);
        apexLegends.añadirJugadorApexLegends(jugadorA);
        apexLegends.añadirJugadorApexLegends(jugadorB);


        compe.agregarJuego(tetris);
        compe.agregarJuego(fortnite);
        compe.agregarJuego(ajedrez);
        compe.agregarJuego(apexLegends);

        compe.agregarJugador(jugadorJ);
        compe.agregarJugador(jugadorP);
        compe.agregarJugador(jugadorA);
        compe.agregarJugador(jugadorB);

        CompetenciaPersistencia compePersistente = new CompetenciaPersistencia(compe);

        compePersistente.escribir(compe);
        */
    }
}
