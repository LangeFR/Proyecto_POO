package Interfaz;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Torneo_PKG.*;

public class InterfazTorneo extends JFrame {
    private PanelRegistro panelRegistro;
    private PanelJuegos panelJuegos;
    private PanelJugadores panelJugadores;
    private PanelModificar panelModificar;
    private int actual;
    private Competencia competencia;

    private Fortnite fortnite;
    private Ajedrez ajedrez;
    private ApexLegends apexLegends;
    private Tetris tetris;

    public InterfazTorneo() {
        setTitle("Torneo de videojuegos");
        setSize(1050, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Inicilizar juegos y competencia
        competencia = new Competencia();
        fortnite = new Fortnite("Fortnite", "Epic Games", 100, "Last one Standing");
        ajedrez = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");
        apexLegends = new ApexLegends("ApexLegends", "Respawn Entertainment", 50, "Numero de kills");
        tetris = new Tetris("Tetris", "Alekséi Pázhitnov", 1, "Acumulacion de puntos");

        competencia.agregarJuego(fortnite);
        competencia.agregarJuego(ajedrez);
        competencia.agregarJuego(apexLegends);
        competencia.agregarJuego(tetris);

        //Estos son los 4 paneles principales
        panelRegistro = new PanelRegistro();
        panelJuegos = new PanelJuegos();
        panelJugadores = new PanelJugadores();
        panelModificar = new PanelModificar();
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(panelRegistro);
        Color vinotinto = new Color(153, 0, 0);
        topPanel.setBackground(vinotinto);
        add(topPanel, BorderLayout.NORTH);

        // Panel central
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(panelJugadores);
        centerPanel.add(panelJuegos);
        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(panelModificar);
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(vinotinto);
    }

    public static void main(String[] args) {
        InterfazTorneo ic = new InterfazTorneo();
        ic.setVisible(true);
    }

    //Lógica para el botón de consultar.
    public void consultar() {
        if (competencia == null || competencia.getJugador(actual) == null) {
            JOptionPane.showMessageDialog(this, "Error: Jugador no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Jugador j = competencia.getJugador(actual);
        String mensaje = "Estadísticas del Jugador:\n\n" +
                "Cantidad de Partidas: " + j.cantidadPartidas() + "\n" +
                "Mejor Puntaje: " + j.mejorJuego() + "\n" +
                "Puntaje Acumulado: " + j.puntajeAcumulado();
    
        JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Jugador", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ecampeon(){
        String mensaje2 = "El campeón del torneo es" + competencia.mejorJugador();
        JOptionPane.showMessageDialog(this, mensaje2, "Campeón", JOptionPane.INFORMATION_MESSAGE);
    }


    public void eFortnite(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getName();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        //Crea un nuevo jugador con dichos atributos
        Jugador jugador = new Jugador(nombre, correo, nickname);

        //Trae la lista de jugadores de competencia
        ArrayList<Jugador> jugadoresCompetencia = competencia.getJugadores();
        boolean flagCompetencia = true;

        /*
         * Verifica que el jugador no se encuentre inscrito en competencia
         * Si no esta inscrito, lo añade 
         */
        for(int jugadorActual = 0; jugadorActual < jugadoresCompetencia.size() && flagCompetencia; jugadorActual++){
            String correoActual = jugadoresCompetencia.get(jugadorActual).getCorreo();

            if(correoActual.equals(correo))
                flagCompetencia = false;
        }

        if(flagCompetencia)
            competencia.agregarJugador(jugador);

        
        //Trae la lista de jugadores de Fortnite
        ArrayList<Jugador> jugadoresFortnite = fortnite.getJugadoresFortnite();
        boolean flagJuego = true;

        /*
         * Verifica que el jugador no se encuentre inscrito en Fortnite
         * Si no esta inscrito, lo añade 
         */
        for(int jugadorActual = 0; jugadorActual < jugadoresFortnite.size() && flagJuego; jugadorActual++){
            String correoActual = jugadoresFortnite.get(jugadorActual).getCorreo();

            if(correoActual.equals(correo))
                flagJuego = false;
        }

        if(flagJuego)
            fortnite.agregarJugadorFortnite(jugador);


        //Limpia los campos para recibir un nuevo inscrito
        panelRegistro.limpiarCampos();
    }
}


