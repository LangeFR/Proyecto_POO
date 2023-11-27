package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJugadores extends JPanel implements ActionListener {
    private JLabel lJugador;
    private JTextField tJugador;
    private JButton bConsultar;
    private JButton bCampeon;
    private JButton b_cFortnite;
    private JButton b_cAjedrez;
    private JButton b_cTetris;
    private JButton b_cApexLegends;
    private final static String cFORTNITE = "cFORTNITE";
    private final static String cAJEDREZ = "cAJEDREZ";
    private final static String cTETRIS = "cTETRIS";
    private final static String cAPEX_LEGENDS = "cAPEX LEGENDS";
    private final static String CONSULTAR = "CONSULTAR";
    private final static String CAMPEON = "CAMPEON";
    private JLabel lStatsJugador;
    private JLabel lStatsVideojuegos;

    // Asociación del Panel a la Ventana Principal
    private InterfazTorneo principal;

    public PanelJugadores(InterfazTorneo inter) {
        principal = inter;
        
        setLayout(new GridLayout(0, 1, 10, 10)); // GridLayout con espaciado vertical y horizontal
        TitledBorder border = BorderFactory.createTitledBorder("Consultar estadísticas");
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        setBackground(Color.WHITE);

        // Elementos para estadísticas de jugadores
        lStatsJugador = new JLabel("Estadísticas de jugadores:");
        lJugador = new JLabel("Nombre del jugador:");
        tJugador = new JTextField(30);
        bConsultar = new JButton("Consultar stats del jugador");
        bCampeon = new JButton("Campeón del torneo");

        // Configuración de colores
        bConsultar.setBackground(Color.YELLOW);
        bCampeon.setBackground(Color.YELLOW);

        // Añadir botones de estadísticas de jugadores
        add(lStatsJugador);
        add(lJugador);
        add(tJugador);
        add(bConsultar);
        add(bCampeon);

        // Configurar acciones y comandos para los botones
        bConsultar.setActionCommand(CONSULTAR);
        bCampeon.setActionCommand(CAMPEON);
        bConsultar.addActionListener(this);
        bCampeon.addActionListener(this);

        // Elementos para estadísticas de videojuegos
        lStatsVideojuegos = new JLabel("Estadísticas de videojuegos:");
        b_cFortnite = new JButton("Fortnite");
        b_cAjedrez = new JButton("Ajedrez");
        b_cTetris = new JButton("Tetris");
        b_cApexLegends = new JButton("Apex Legends");

        // Configurar colores
        b_cFortnite.setBackground(Color.YELLOW);
        b_cAjedrez.setBackground(Color.YELLOW);
        b_cTetris.setBackground(Color.YELLOW);
        b_cApexLegends.setBackground(Color.YELLOW);

        // Añadir botones de estadísticas de videojuegos
        add(lStatsVideojuegos);
        add(b_cFortnite);
        add(b_cAjedrez);
        add(b_cTetris);
        add(b_cApexLegends);

        // Configurar acciones y comandos para los botones de videojuegos
        b_cFortnite.setActionCommand(cFORTNITE);
        b_cAjedrez.setActionCommand(cAJEDREZ);
        b_cTetris.setActionCommand(cTETRIS);
        b_cApexLegends.setActionCommand(cAPEX_LEGENDS);
        b_cFortnite.addActionListener(this);
        b_cAjedrez.addActionListener(this);
        b_cTetris.addActionListener(this);
        b_cApexLegends.addActionListener(this);
    }

    // Permitir acceso a la información (nombre del jugador)
    public String getNombre() {
        return tJugador.getText();
    }

    // Refrescar la Información
    public void setNombre(String nombre) {
        tJugador.setText(nombre);
    }

    public void limpiar_campos() {
        tJugador.setText("");
    }

    public void actionPerformed(ActionEvent evento) {
        String command = evento.getActionCommand();
        switch (command) {
            case CONSULTAR:
                principal.consultar();
                break;
            case CAMPEON:
                principal.ecampeon();
                break;
            case cFORTNITE:
                break;
            case cAJEDREZ:
                break;
            case cTETRIS:
                break;
            case cAPEX_LEGENDS:
                break;
        }
    }


}
