package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;



public class InterfazTorneo extends JFrame{
    //Creamos 4 paneles
    private PanelRegistro panelRegistro; 
    private PanelJuegos panelJuegos;
    private PanelJugadores panelJugadores;
    private PanelModificar panelModificar;
    
    public InterfazTorneo(){
        setTitle("Torneo de videojuegos");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando se cierra esta ventana, se cierra la app

        panelRegistro = new PanelRegistro(); 
        panelJuegos = new PanelJuegos();
        panelJugadores = new PanelJugadores();
        panelModificar = new PanelModificar();
        setLayout(new BorderLayout()); //Método que permite establecer un Layout sobre el JFrame al que se aplica.
        panelRegistro.setBackground(Color.YELLOW);
        panelJuegos.setBackground(Color.pink);
        panelJugadores.setBackground(Color.cyan);
        panelModificar.setBackground(Color.MAGENTA);
        add(panelRegistro, BorderLayout.NORTH);
        add(panelJuegos, BorderLayout.EAST);
        add(panelJugadores, BorderLayout.WEST);
        add(panelModificar, BorderLayout.SOUTH);




    }
    public static void main(String[] args){
        InterfazTorneo ic = new InterfazTorneo();
        ic.setVisible(true);
    }

    


}


/**********
 * 
 */