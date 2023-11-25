package Interfaz;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazTorneo extends JFrame {
    private PanelRegistro panelRegistro;
    private PanelJuegos panelJuegos;
    private PanelJugadores panelJugadores;
    private PanelModificar panelModificar;

    public InterfazTorneo() {
        setTitle("Torneo de videojuegos");
        setSize(1050, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
}


