package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificar extends JPanel implements ActionListener {
    // Botón para modificar la información del jugador
    private JButton bModificarJugador;
    
    // Constante para identificar la acción de modificar
    private static final String bMODIFICAR = "MODIFICAR";
    
    // Referencia a la interfaz principal
    private InterfazTorneo principal;

    // Constructor del panel de modificación
    public PanelModificar(InterfazTorneo inter) { 
        // Inicialización de la referencia a la interfaz principal
        principal = inter;
        
        // Configuración del diseño del panel
        setLayout(new FlowLayout());
        Color moradoOscuro = new Color(102, 0, 102);
        setBackground(moradoOscuro);

        // Creación y configuración del botón
        bModificarJugador = new JButton("Modificar información de jugador");
        bModificarJugador.setBackground(Color.YELLOW);

        // Agregar el botón al panel
        add(bModificarJugador);

        // Agregar ActionListener para el botón Modificar Jugador
        bModificarJugador.addActionListener(this);
        bModificarJugador.setActionCommand(bMODIFICAR);
    }

    // Manejo de eventos al hacer clic en el botón
    public void actionPerformed(ActionEvent evento) {
        String command = evento.getActionCommand();
        switch (command) {
            case bMODIFICAR:
                // Llamar al método correspondiente en la interfaz principal
                principal.eModificar();
                break;
        }
    }
}
