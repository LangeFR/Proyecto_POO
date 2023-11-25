package Interfaz;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelJuegos extends JPanel{
    private JButton bFortnite;
    private JButton bAjedrez;
    private JButton bTetris;
    private JButton bApex;

    public PanelJuegos() {
        //Aquí caracterizamos al panel de forma básica: color, borde y disposición "Flow"
        setLayout(new GridLayout(2,4));
        TitledBorder border = BorderFactory.createTitledBorder("Selecciona un juego para conocer sus estadísticas");
        border.setTitleColor(Color.BLACK);
        setBorder(border);
        setBackground(Color.WHITE);

        //Inicializamos los botones y el label
        bFortnite = new JButton("");
        bFortnite.setBackground(Color.WHITE);
        bAjedrez = new JButton("");
        bAjedrez.setBackground(Color.WHITE);
        bTetris = new JButton("");
        bTetris.setBackground(Color.WHITE);
        bApex = new JButton("");
        bApex.setBackground(Color.WHITE);
        
        //Añadimos las imágenes a los botones y ajustamos el tamaño
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

        //Añadimos los botones estipulados a la interfaz
        add(bFortnite);
        add(bAjedrez);
        add(bTetris);
        add(bApex);

        
    }

    
}
