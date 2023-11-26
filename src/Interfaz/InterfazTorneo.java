package Interfaz;
import java.awt.*;
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

    public InterfazTorneo() {
        setTitle("Torneo de videojuegos");
        setSize(1050, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


   /* public void eFortnite(){
        String nombre = panelRegistro.getName();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        Jugador jugador = new Jugador(nombre, correo, nickname);

        if(){
            //Añadir jugador a competencia
        }

        //añadir jugador a Fortnite

        panelRegistro.LimpiarCampos();
    }*/


    public void eTetris() {
        if (panelRegistro != null && competencia != null) {
            String nombre = panelRegistro.getNombre();
            String nickName = panelRegistro.getNickname();
            String correo = panelRegistro.getCorreo();
    
            Jugador te = new Jugador(nombre, nickName, correo);
            te.setNombre(nombre);
            te.setNickName(nickName);
            te.setCorreo(correo);

            competencia.agregarJugador(te);
            panelRegistro.limpiarCampos();
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error: panelRegistro o competencia es null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


