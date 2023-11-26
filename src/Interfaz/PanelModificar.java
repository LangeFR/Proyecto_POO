package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PanelModificar extends JPanel implements ActionListener {
    private JButton bModificarJugador;
    private JButton bModificarPartida;
    private static final String bMODIFICAR = "MODIFICAR";
    private InterfazTorneo principal;

    public PanelModificar(InterfazTorneo inter) { 
        principal = inter;
        setLayout(new FlowLayout());
        Color moradoOscuro = new Color(102, 0, 102);
        setBackground(moradoOscuro);
    

        bModificarJugador = new JButton("Modificar información de jugador");
        bModificarJugador.setBackground(Color.YELLOW);
        bModificarPartida = new JButton("Modificar información de partida");
        bModificarPartida.setBackground(Color.YELLOW);

        add(bModificarJugador);
        add(bModificarPartida);

        // Agregar ActionListener para el botón Modificar Jugador
        bModificarJugador.addActionListener(this);
        bModificarJugador.setActionCommand(bMODIFICAR);
    }

    public void actionPerformed(ActionEvent evento) {
        String command = evento.getActionCommand();
        switch (command) {
            case bMODIFICAR:
                principal.eModificar();;
                break;
        }
    }

}
    
