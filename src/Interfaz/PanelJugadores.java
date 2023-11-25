package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelJugadores extends JPanel {
    private JLabel lJugador;
    private JTextField tJugador;
    private JButton bConsultar;
    private JButton bCampeon;

public PanelJugadores() {
    setLayout(new FlowLayout());
    TitledBorder border = BorderFactory.createTitledBorder("Consultar jugadores");
    border.setTitleColor(Color.BLACK);
    setBorder(border);
    setBackground(Color.WHITE);


    lJugador = new JLabel("Nombre del jugador:");
    lJugador.setForeground(Color.BLACK);

    // Creación de JTextField
    tJugador = new JTextField(30); // Ajusto el tamaño para mejor estética
    tJugador.setForeground(Color.BLACK);
    bConsultar = new JButton("Consultar jugador");
    bConsultar.setBackground(Color.YELLOW);
    bCampeon = new JButton("Consultar campeón del torneo");
    bCampeon.setBackground(Color.YELLOW);

    // Crear JLabel para la imagen y cargar la imagen desde el archivo consola.jpg
    JLabel imagenLabel = new JLabel();
    ImageIcon icono = new ImageIcon(getClass().getResource("/Interfaz/consola.jpg"));

    // Ajustar el tamaño de la imagen
    //Obtiene la imagen asociada al objeto
    //Image.SCALE_SMOOTH indica un algoritmo de suavizado para mejorar calidad de imagen
    Image image = icono.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    icono = new ImageIcon(image);

    imagenLabel.setIcon(icono);

    add(lJugador);
    add(tJugador);
    add(bConsultar);
    add(bCampeon);
    add(imagenLabel);
}
}