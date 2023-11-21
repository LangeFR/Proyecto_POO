package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.FlowLayout;


public class PanelJugadores extends JPanel{

    public PanelJugadores() {
        setLayout(new FlowLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Navegación");
        border.setTitleColor(Color.ORANGE);
        setBorder(border);

    }
}
