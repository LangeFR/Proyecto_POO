import Torneo_PKG.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Jugador jug1 = new Jugador("Mateo", "mdj", "mvanegas");

        Fortnite juego = new Fortnite("Fortnite", "Nintendo", 100, "Last one standing");
        Ajedrez juego2 = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");

        Partida par1 = new Partida("2023_11_24", 18000, 45, juego);
        Partida par2 = new Partida("2023_11_25", 36000, 5, juego);
        Partida par3 = new Partida("2023_11_25", 3600, 1, juego2);

        jug1.agregarPartida(par1);
        jug1.agregarPartida(par2);
        jug1.agregarPartida(par3);

        //System.out.println(jug1.horasJugadas(juego));
        //System.out.println(jug1.horasJugadas(juego2));

        Juego mejorJuego = jug1.mejorJuego();
    }
}
