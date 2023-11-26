package Interfaz;

import javax.swing.*;
import java.awt.*;


public class PanelModificar extends JPanel{
    private JButton bModificarJugador;
    private JButton bModificarPartida;

    public PanelModificar() {
        setLayout(new FlowLayout());
        Color moradoOscuro = new Color(102, 0, 102);
        setBackground(moradoOscuro);

    bModificarJugador = new JButton("Modificar información de jugador");
    bModificarJugador.setBackground(Color.YELLOW);
    bModificarPartida = new JButton("Modificar información de partida");
    bModificarPartida.setBackground(Color.YELLOW);

    add(bModificarJugador);
    add(bModificarPartida);
    }

    
    
}