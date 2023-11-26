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
        panelRegistro = new PanelRegistro(this);
        panelJuegos = new PanelJuegos();
        panelJugadores = new PanelJugadores();
        panelModificar = new PanelModificar();
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(panelRegistro);
        Color moradoOscuro = new Color(102, 0, 102);
        topPanel.setBackground(moradoOscuro);
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
        bottomPanel.setBackground(moradoOscuro);
    }

    public static void main(String[] args) {
        InterfazTorneo ic = new InterfazTorneo();
        ic.setVisible(true);
    }
    
// Lógica para el botón consultar
    public void consultar() {
    //Se obtiene el jugador actual de la lista de competencia
        Jugador j = competencia.getJugador(actual);
    // Verifica si el jugador está en la lista
        if (competencia.getJugadores().contains(j)) {
        // Si está en la lista, mostramos las estadísticas
            String mensaje = "Estadísticas del Jugador:\n\n" +
                    "Cantidad de Partidas: " + j.cantidadPartidas() + "\n" +
                    "Mejor Puntaje: " + j.mejorJuego() + "\n" +
                    "Puntaje Acumulado: " + j.puntajeAcumulado();

            JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Jugador", JOptionPane.INFORMATION_MESSAGE);
        } else {
        // Si no está en la lista, mostramos un mensaje de error
            JOptionPane.showMessageDialog(this, "Error: Jugador no encontrado en la lista de competencia", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public void ecampeon(){
        String mensaje2 = "El campeón del torneo es" + competencia.mejorJugador();
        JOptionPane.showMessageDialog(this, mensaje2, "Campeón", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void eFortnite(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{

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

            if(flagCompetencia){
                competencia.agregarJugador(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);


            /*
            * Verifica que el jugador no se encuentre inscrito en Fortnite
            * Si no esta inscrito, lo añade 
            */
            if(!fortnite.isInFortnite(jugador)){
                fortnite.añadirJugadorFortnite(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Fortnite", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en Fortnite", "Información", JOptionPane.INFORMATION_MESSAGE);

            //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
        }
    }
        public void eAjedrez(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{

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

            if(flagCompetencia){
                competencia.agregarJugador(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);


            /*
            * Verifica que el jugador no se encuentre inscrito en Ajedrez
            * Si no esta inscrito, lo añade 
            */
            if(!ajedrez.isInAjedrez(jugador)){
                ajedrez.añadirJugadorAjedrez(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Ajedrez", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en Ajedrez", "Información", JOptionPane.INFORMATION_MESSAGE);

            //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
        }
    }
    public void eTetris(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty())
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
        else{

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
            if(flagCompetencia){
                competencia.agregarJugador(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);


            /*
            * Verifica que el jugador no se encuentre inscrito en Tetris
            * Si no esta inscrito, lo añade 
            */
            if(!tetris.isInTetris(jugador)){
                tetris.añadirJugadorTetris(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Tetris", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en Tetris", "Información", JOptionPane.INFORMATION_MESSAGE);

            //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
        }
    }

        public void eApex(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty())
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
        else{

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
            if(flagCompetencia){
                competencia.agregarJugador(jugador);
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);


            /*
            * Verifica que el jugador no se encuentre inscrito en Apex Legends
            * Si no esta inscrito, lo añade 
            */
            if(!apexLegends.isInApexLegends(jugador)){
                apexLegends.añadirJugadorApexLegends(jugador);;
                JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Apex Legends", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Jugador ya registrado en Apex Legends", "Información", JOptionPane.INFORMATION_MESSAGE);

            //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
        }
    }


}


