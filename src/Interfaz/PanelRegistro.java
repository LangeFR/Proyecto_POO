package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JPanel implements ActionListener{
    private JLabel lNombre;
    private JLabel lNickname;
    private JLabel lCorreo;
    private JLabel espacio;
    private JTextField tNombre;
    private JTextField tNickname;
    private JTextField tCorreo;
    private JButton bFORTNITE, bAJEDREZ, bTETRIS, bAPEX;

    private static final String FORTNITE = "FORTNITE";
    private static final String AJEDREZ = "AJEDREZ";
    private static final String TETRIS = "TETRIS";
    private static final String APEX = "APEX";


    public PanelRegistro() {
        //GridLayout
        setLayout(new GridLayout(2, 4));  
        TitledBorder border = BorderFactory.createTitledBorder("Registra tu usuario");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        lNombre = new JLabel("Nombre:");
        lNickname = new JLabel("Nickname:");
        lCorreo = new JLabel("Correo:");
        espacio = new JLabel("");
        lNombre.setForeground(Color.BLACK);

        tNombre = new JTextField("");
        tNickname = new JTextField("");
        tCorreo = new JTextField("");
        tNombre.setForeground(Color.YELLOW);

        bFORTNITE = new JButton("Fortnite");
        bFORTNITE.setBackground(Color.YELLOW);
        bAJEDREZ = new JButton("Ajedrez");
        bAJEDREZ.setBackground(Color.YELLOW);
        bTETRIS = new JButton("Tetris");
        bTETRIS.setBackground(Color.YELLOW);
        bAPEX = new JButton("Apex Legends");
        bAPEX.setBackground(Color.YELLOW);

        
        add(lNombre);
        add(tNombre);
        add(lNickname);
        add(tNickname);
        add(lCorreo);
        add(tCorreo);
        add(espacio);
        add(bFORTNITE);
        add(bAJEDREZ);
        add(bTETRIS);
        add(bAPEX);

        bFORTNITE.setActionCommand(FORTNITE);
        bAJEDREZ.setActionCommand(AJEDREZ);
        bTETRIS.setActionCommand(TETRIS);
        bAPEX.setActionCommand(APEX);

        bFORTNITE.addActionListener(this);
        bAJEDREZ.addActionListener(this);
        bTETRIS.addActionListener(this);
        bAPEX.addActionListener(this);
    }


    public String getNombre(){
      return tNombre.getText();
    }
    public String getCorreo(){
      return tCorreo.getText();
    }
    public String getNickname(){
      return tNickname.getText();
    }

    public void limpiarCampos(){
      tNombre.setText("");
      tCorreo.setText("");
      tNickname.setText("");
  }

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


      
    
}