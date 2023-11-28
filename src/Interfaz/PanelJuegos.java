package Interfaz;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJuegos extends JPanel implements ActionListener {
    // Botones para cada juego
    private JButton bFortnite;
    private JButton bAjedrez;
    private JButton bTetris;
    private JButton bApex;

    // Constantes para identificar las acciones de cada juego
    private static final String JUGAR_FORTNITE = "JUGAR_FORTNITE";
    private static final String JUGAR_AJEDREZ = "JUGAR_AJEDREZ";
    private static final String JUGAR_APEX = "JUGAR_APEX";
    private static final String JUGAR_TETRIS = "JUGAR_TETRIS";

    // Referencia a la interfaz principal
    private InterfazTorneo principal;

    // Constructor del panel de juegos
    public PanelJuegos(InterfazTorneo inter) {
        principal = inter;

        // Configuración del diseño del panel
        setLayout(new GridLayout(2, 4));
        TitledBorder border = BorderFactory.createTitledBorder("Selecciona un juego");
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        setBackground(Color.WHITE);

        // Inicialización de los botones
        bFortnite = new JButton(" ");
        bFortnite.setBackground(Color.WHITE);
        bAjedrez = new JButton("");
        bAjedrez.setBackground(Color.WHITE);
        bTetris = new JButton("");
        bTetris.setBackground(Color.WHITE);
        bApex = new JButton("");
        bApex.setBackground(Color.WHITE);

        // Configuración de las imágenes y tamaño de los botones
        ImageIcon tetris_icono = new ImageIcon(getClass().getResource("/Interfaz/tetris.png"));
        Image tetrislogo = tetris_icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bTetris.setIcon(new ImageIcon(tetrislogo));

        ImageIcon fortnite_icono = new ImageIcon(getClass().getResource("/Interfaz/fortnite.png"));
        Image fortnitelogo = fortnite_icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bFortnite.setIcon(new ImageIcon(fortnitelogo));

        ImageIcon ajedrez_icono = new ImageIcon(getClass().getResource("/Interfaz/ajedrez.jpg"));
        Image ajedrezlogo = ajedrez_icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bAjedrez.setIcon(new ImageIcon(ajedrezlogo));

        ImageIcon apex_icono = new ImageIcon(getClass().getResource("/Interfaz/apex.png"));
        Image apexlogo = apex_icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bApex.setIcon(new ImageIcon(apexlogo));

        // Agregar botones al panel
        add(bFortnite);
        add(bAjedrez);
        add(bTetris);
        add(bApex);

        // Asignar acciones a los botones
        bFortnite.setActionCommand(JUGAR_FORTNITE);
        bAjedrez.setActionCommand(JUGAR_AJEDREZ);
        bTetris.setActionCommand(JUGAR_TETRIS);
        bApex.setActionCommand(JUGAR_APEX);

        // Agregar ActionListener para los botones
        bFortnite.addActionListener(this);
        bAjedrez.addActionListener(this);
        bTetris.addActionListener(this);
        bApex.addActionListener(this);
    }

    // Manejo de eventos al hacer clic en los botones
    public void actionPerformed(ActionEvent evento) {
        String command = evento.getActionCommand();

        // Realizar la acción correspondiente según el botón presionado
        switch (command) {
            case JUGAR_FORTNITE:
                principal.eJugarFortnite();
                break;
            case JUGAR_AJEDREZ:
                principal.eJugarAjedrez();
                break;
            case JUGAR_TETRIS:
                principal.eJugarTetris();
                break;
            case JUGAR_APEX:
                principal.eJugarApex();
                break;
        }
    }
}