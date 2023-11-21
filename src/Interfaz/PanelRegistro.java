package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelRegistro extends JPanel{
    private JLabel lNombre;
    private JLabel lNota;
    private JTextField tNombre;
    private JTextField tNota;

  /*   private static final String EPRESENCIAL = "PRESENCIAL";
    private static final String EVIRTUAL= "VIRTUAL";
    private static final String EINTERCAMBIO = "INTERCAMBIO";
    private static final String EDOBLETITULACION = "DOBLETITULACION";*/


    public PanelRegistro() {
        //GridLayout
        setLayout(new GridLayout(2, 4));
        TitledBorder border = BorderFactory.createTitledBorder("Registro");
        border.setTitleColor(Color.BLUE);
        setBorder(border);

        lNombre = new JLabel("Nombre:");
        lNota = new JLabel("Partidas:");
        lNombre.setForeground(Color.BLACK);
        lNota.setForeground(Color.BLACK);

        tNombre = new JTextField("Carlos");
        tNota = new JTextField("5");
        tNombre.setForeground(Color.BLACK);
        tNota.setForeground(Color.BLACK);

        
        add(lNombre);
        add(tNombre);
        add(lNota);
        add(tNota);
    }
    
}
