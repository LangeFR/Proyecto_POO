package Interfaz;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JPanel implements ActionListener{
    // Etiquetas y campos de texto para el registro de usuario
    private JLabel lNombre;
    private JLabel lNickname;
    private JLabel lCorreo;
    private JLabel espacio;
    private JTextField tNombre;
    private JTextField tNickname;
    private JTextField tCorreo;
    
    // Botones para seleccionar el juego al que se desea registrar
    private JButton bFORTNITE, bAJEDREZ, bTETRIS, bAPEX;
    
    // Referencia a la interfaz principal
    private InterfazTorneo principal;

    // Constantes para identificar los juegos
    private static final String FORTNITE = "FORTNITE";
    private static final String AJEDREZ = "AJEDREZ";
    private static final String TETRIS = "TETRIS";
    private static final String APEX = "APEX";

    // Constructor del panel de registro
    public PanelRegistro(InterfazTorneo inter) {
        // Configuración del diseño del panel
        principal = inter;
        setLayout(new GridLayout(2, 4));  
        TitledBorder border = BorderFactory.createTitledBorder("Registra tu usuario");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        // Inicialización de componentes gráficos
        lNombre = new JLabel("Nombre:");
        lNickname = new JLabel("Nickname:");
        lCorreo = new JLabel("Correo:");
        espacio = new JLabel("");
        lNombre.setForeground(Color.BLACK);

        tNombre = new JTextField("");
        tNickname = new JTextField("");
        tCorreo = new JTextField("");
        tNombre.setForeground(Color.BLACK);

        bFORTNITE = new JButton("Fortnite");
        bFORTNITE.setBackground(Color.YELLOW);
        bAJEDREZ = new JButton("Ajedrez");
        bAJEDREZ.setBackground(Color.YELLOW);
        bTETRIS = new JButton("Tetris");
        bTETRIS.setBackground(Color.YELLOW);
        bAPEX = new JButton("Apex Legends");
        bAPEX.setBackground(Color.YELLOW);

        // Añadir componentes al panel
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

        // Asignar comandos a los botones para identificar la acción
        bFORTNITE.setActionCommand(FORTNITE);
        bAJEDREZ.setActionCommand(AJEDREZ);
        bTETRIS.setActionCommand(TETRIS);
        bAPEX.setActionCommand(APEX);

        // Agregar el manejador de eventos (this) a los botones
        bFORTNITE.addActionListener(this);
        bAJEDREZ.addActionListener(this);
        bTETRIS.addActionListener(this);
        bAPEX.addActionListener(this);
    }

    // Métodos para obtener y establecer valores de los campos
    public String getNombre(){
      return tNombre.getText();
    }
    public String getCorreo(){
      return tCorreo.getText();
    }
    public String getNickname(){
      return tNickname.getText();
    }
    public void setNombre(String nombre){
      tNombre.setText(nombre);
    }
    public void setNickName(String nickName){
      tNickname.setText(nickName);
    }
    public void setCorreo(String correo){
      tCorreo.setText(correo);
    }

    // Método para limpiar los campos de texto
    public void limpiarCampos(){
      tNombre.setText("");
      tCorreo.setText("");
      tNickname.setText("");
    }

    // Manejo de eventos al hacer clic en los botones
    public void actionPerformed(ActionEvent evento) {
      String command = evento.getActionCommand();
      switch (command) {
          case FORTNITE:
              principal.eFortnite();
              break;
          case TETRIS:
              principal.eTetris();
              break;
          case AJEDREZ:
              principal.eAjedrez();
              break;
          case APEX:
              principal.eApex();
              break;
      }
  }
}
