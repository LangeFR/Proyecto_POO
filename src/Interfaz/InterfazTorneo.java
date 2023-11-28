package Interfaz;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import Torneo_PKG.*;

public class InterfazTorneo extends JFrame {
    private PanelRegistro panelRegistro;
    private PanelJuegos panelJuegos;
    private PanelJugadores panelJugadores;
    private PanelModificar panelModificar;
    private Competencia competencia;
    private JComboBox<String> listaJugadoresJCombo; // JComboBox para la lista de jugadores
    private JComboBox<String> listaPartidasJCombo;
    private Fortnite fortnite;
    private Ajedrez ajedrez;
    private ApexLegends apexLegends;
    private Tetris tetris;

    public InterfazTorneo() {
        setTitle("Torneo de videojuegos");
        setSize(1050, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Inicilizar juegos y competencia
        competencia = new Competencia();
        fortnite = new Fortnite("Fortnite", "Epic Games", 100, "Last one Standing");
        ajedrez = new Ajedrez("Ajedrez", "None", 2, "1 vs 1");
        apexLegends = new ApexLegends("ApexLegends", "Respawn Entertainment", 50, "Numero de kills");
        tetris = new Tetris("Tetris", "Alekséi Pázhitnov", 1, "Acumulacion de puntos");
        competencia.agregarJuego(fortnite);
        competencia.agregarJuego(ajedrez);
        competencia.agregarJuego(apexLegends);
        competencia.agregarJuego(tetris);

        //Estos son los 4 paneles principales
        panelRegistro = new PanelRegistro(this);
        panelJuegos = new PanelJuegos(this);
        panelJugadores = new PanelJugadores(this);
        panelModificar = new PanelModificar(this);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(panelRegistro);
        Color moradoOscuro = new Color(102, 0, 102);
        topPanel.setBackground(moradoOscuro);
        add(topPanel, BorderLayout.NORTH);

        // Panel central
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(panelJugadores);
        centerPanel.add(panelJuegos);
        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(panelModificar);
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(moradoOscuro);
    }
        //Hacer visible la interfaz
    public static void main(String[] args) {
        InterfazTorneo ic = new InterfazTorneo();
        ic.setVisible(true);
    }
    
    // Lógica para el botón consultar
    public void consultar() {
        // Obtiene el texto del campo de texto
        String correo = PanelJugadores.getNombre();
        // Verifica si el campo de texto está vacío
        if (correo.isEmpty()) {
            // Muestra un mensaje de error si está vacío
            JOptionPane.showMessageDialog(this, "Error: Debes ingresar un correo para buscar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            // Busca el jugador en la lista de competencia
            Jugador jugadorBusqueda = null;
            for (Jugador jugador : competencia.getJugadores()) {
                if (jugador.getCorreo().equals(correo)) {
                    jugadorBusqueda = jugador;
                    break;
                }
            }
            // Verifica si se encontró el jugador
            if (jugadorBusqueda != null) {
                // Muestra las estadísticas si el jugador está en la lista
                String mensaje = "Estadísticas del Jugador:\n\n" +
                        "Cantidad de Partidas: " + jugadorBusqueda.cantidadPartidas() + "\n" +
                        "Mejor Puntaje: " + jugadorBusqueda.mejorJuego() + "\n" +
                        "Puntaje Acumulado: " + jugadorBusqueda.puntajeAcumulado();

                JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Jugador", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Muestra un mensaje de error si el jugador no está en la lista
                JOptionPane.showMessageDialog(this, "Error: Jugador no encontrado en la lista de competencia", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*
     * Logica para jugadores destacados
     * Encuentra el jugador con mas puntos (mejor jugador), jugador con más tiempo (adicto) y jugador con más partidas (persistente)
     */
    public void eJugadoresDestacados() {
        // Trae la lista de los jugadores de competencia
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
    
        // Verifica que hayajugadores
        if (listaJugadoresCompetencia == null || listaJugadoresCompetencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay jugadores registrados", "No hay jugadores", JOptionPane.ERROR_MESSAGE);
        } else {
            // Trae a los tres jugadores destacados
            Jugador mejorJugador = competencia.mejorJugador();
            Jugador jugadorAdicto = competencia.adicto();
            Jugador jugadorPersistente = competencia.persistente();
    
            if (mejorJugador != null && jugadorAdicto != null && jugadorPersistente != null) {
                String mensajeCampeon = "El campeón del torneo es " + mejorJugador.getNombre();
                String mensajeAdicto = "El jugador más adicto es " + jugadorAdicto.getNombre();
                String mensajePersistente = "El jugador más persistente es " + jugadorPersistente.getNombre();
    
                String mensajeFinal = mensajeCampeon + "\n\n" + mensajeAdicto + "\n\n" + mensajePersistente;
    
                JOptionPane.showMessageDialog(this, mensajeFinal, "Jugadores Destacados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo determinar la información de los jugadores destacados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    
    public boolean registrarCompetencia(String nombre, String correo, String nickname){
        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Trae la lista de jugadores de competencia
        ArrayList<Jugador> jugadoresCompetencia = competencia.getJugadores();
        boolean flagCompetencia = true;

        /*
        * Verifica que el jugador no se encuentre inscrito en competencia
        * Si no esta inscrito, lo añade 
        */
        for(int jugadorActual = 0; jugadorActual < jugadoresCompetencia.size() && flagCompetencia; jugadorActual++){
            String correoActual = jugadoresCompetencia.get(jugadorActual).getCorreo();

            if(correoActual.equals(correo))
                flagCompetencia = false;
        }

        if(flagCompetencia){
            //Crea un nuevo jugador con dichos atributos
            Jugador jugador = new Jugador(nombre, correo, nickname);
            competencia.agregarJugador(jugador);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getPosJugador(String correo){
        ArrayList<Jugador> jugadoresCompetencia = competencia.getJugadores();

        for(int jugadorActual = 0; jugadorActual < jugadoresCompetencia.size(); jugadorActual++){
            String correoActual = jugadoresCompetencia.get(jugadorActual).getCorreo();

            if(correoActual.equals(correo))
                return jugadorActual;
        }

        return -1;
    }
    
    
    /*
     * Registra un jugador en competencia y en Fortnite
     */
    public void eFortnite() {
        // Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();
    
        if(registrarCompetencia(nombre, correo, nickname))
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        /*
        * Verifca que el jugador no se encuentre inscrito en Ajedrez
        * Si no esta inscrito, lo añade 
        */
        int posJugador = getPosJugador(correo);
        if(!fortnite.isInFortnite(new Jugador(nombre, correo, nickname)) && posJugador != -1){
            fortnite.añadirJugadorFortnite(competencia.getJugadores().get(posJugador));
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Fortnite", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en Fortnite", "Información", JOptionPane.INFORMATION_MESSAGE);

    
            // Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
    }
    
    /*
     * Registra un jugador en competencia y en Ajedrez
     */
    public void eAjedrez(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        
        if(registrarCompetencia(nombre, correo, nickname))
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        /*
        * Verifca que el jugador no se encuentre inscrito en Ajedrez
        * Si no esta inscrito, lo añade 
        */
        int posJugador = getPosJugador(correo);
        if(!ajedrez.isInAjedrez(new Jugador(nombre, correo, nickname)) && posJugador != -1){
            ajedrez.añadirJugadorAjedrez(competencia.getJugadores().get(posJugador));
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Ajedrez", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en Ajedrez", "Información", JOptionPane.INFORMATION_MESSAGE);

        //Limpia los campos para recibir un nuevo inscrito
        panelRegistro.limpiarCampos();
        
    }

    /*
     * Registra un jugador en competencia y en Tetris
     */
    public void eTetris(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if(registrarCompetencia(nombre, correo, nickname))
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        /*
        * Verifca que el jugador no se encuentre inscrito en Ajedrez
        * Si no esta inscrito, lo añade 
        */
        int posJugador = getPosJugador(correo);
        if(!tetris.isInTetris(new Jugador(nombre, correo, nickname)) && posJugador != -1){
            tetris.añadirJugadorTetris(competencia.getJugadores().get(posJugador));
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Tetris", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en Tetris", "Información", JOptionPane.INFORMATION_MESSAGE);

        //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
    }

    /*
     * Registra un jugador en competencia y en Apex Legends
     */
    public void eApex(){
        //Recibe el input del usuario para los atributos
        String nombre = panelRegistro.getNombre();
        String correo = panelRegistro.getCorreo();
        String nickname = panelRegistro.getNickname();

        if(registrarCompetencia(nombre, correo, nickname))
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en la Competencia", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        /*
        * Verifca que el jugador no se encuentre inscrito en Ajedrez
        * Si no esta inscrito, lo añade 
        */
        int posJugador = getPosJugador(correo);
        if(!apexLegends.isInApexLegends(new Jugador(nombre, correo, nickname)) && posJugador != -1){
            apexLegends.añadirJugadorApexLegends(competencia.getJugadores().get(posJugador));
            JOptionPane.showMessageDialog(this, "Jugador añadido con éxito a Apex Legends", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Jugador ya registrado en Apex Legends", "Información", JOptionPane.INFORMATION_MESSAGE);

        //Limpia los campos para recibir un nuevo inscrito
            panelRegistro.limpiarCampos();
    }

    /*
     * Modifica la informacion que el usuario requiera de un Jugador
     */
    public void eModificar() {
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Seleccione el jugador...");

        for(Jugador jugadorActual : competencia.getJugadores()){
            listaJugadores.add(jugadorActual.getCorreo());
        }

        listaJugadoresJCombo = new JComboBox<>(listaJugadores.toArray(new String[listaJugadores.size()]));

        // Obtener el jugador seleccionado del JComboBox
        JOptionPane.showMessageDialog(this, listaJugadoresJCombo, "Selecciona un Jugador", JOptionPane.QUESTION_MESSAGE);
        String correoJugadorSeleccionado = (String) listaJugadoresJCombo.getSelectedItem();

        // Buscar el jugador directamente en la lista de jugadores
        Jugador jugadorSeleccionado = null;
        int posJugadorSeleccionado = 0;
        for (int jugadorActual = 0; jugadorActual < competencia.getJugadores().size(); jugadorActual++) {
            if (competencia.getJugador(jugadorActual).getCorreo().equals(correoJugadorSeleccionado)) {
                jugadorSeleccionado = competencia.getJugador(jugadorActual);
                posJugadorSeleccionado = jugadorActual;
                break;
            }
        }

        //Menu para modificar
        String menuEModificar = "Seleccione un item a modificar:\n1. Nombre\n2. Nickname\n3. Correo\n4. Partidas";

        //Define que opcion modificar y lo ejecuta
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuEModificar));
        switch(opcion){
            case 1:
                String nuevoNombre = JOptionPane.showInputDialog(null, "Digite el nuevo nombre:");
                jugadorSeleccionado.setNombre(nuevoNombre);
                break;
            case 2:
                String nuevoNickname = JOptionPane.showInputDialog(null, "Digite el nuevo Nickname:");
                jugadorSeleccionado.setNickName(nuevoNickname);
                break;
            case 3:
                String nuevoCorreo = JOptionPane.showInputDialog(null, "Digite el nuevo correo:");
                jugadorSeleccionado.setCorreo(nuevoCorreo);
                break;
            case 4:
                eModificarPartidas(jugadorSeleccionado, posJugadorSeleccionado);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                break;
        }

        //Actualizar la lista
        listaJugadoresCompetencia.set(posJugadorSeleccionado, jugadorSeleccionado);
        competencia.setJugadores(listaJugadoresCompetencia);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Información del jugador modificada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);        
    }

    /*
     * Metodo especifico para modificar las partidas de un jugador
     */
    public void eModificarPartidas(Jugador jugadorSeleccionado, int posJugadorSeleccionado){
        ArrayList<Partida> listaPartidasJugador = jugadorSeleccionado.getPartidas();
        ArrayList<String> listaPartidas = new ArrayList<String>();
        listaPartidas.add("Seleccione la partida...");

        int count = 1;
        for(Partida partidaActual : jugadorSeleccionado.getPartidas()){
            listaPartidas.add("Partida " + count + ": " + partidaActual.getFecha());
            count++;
        }

        listaPartidasJCombo = new JComboBox<>(listaPartidas.toArray(new String[listaPartidas.size()]));

        JOptionPane.showMessageDialog(this, listaPartidasJCombo, "Selecciona una Partida", JOptionPane.QUESTION_MESSAGE);
        String fechaPartidaSeleccionada = (String) listaPartidasJCombo.getSelectedItem();

        Partida partidaSeleccionada = null;
        int posPartidaSeleccionada = 0;

        count = 1;
        for(int partidaActual = 0; partidaActual < jugadorSeleccionado.getPartidas().size(); partidaActual++) {
            String fechaActual = jugadorSeleccionado.getPartida(partidaActual).getFecha();
            //if(("Partida 2: 2023_11_29").equals(fechaPartidaSeleccionada)){
            if(("Partida " + count + ": " +  fechaActual).equals(fechaPartidaSeleccionada)){
                partidaSeleccionada = jugadorSeleccionado.getPartida(partidaActual);
                posPartidaSeleccionada = partidaActual;
            }
            count++;
        }

        //Menu para modificar
        String menuEModificarPartida = "Seleccione un item a modificar:\n1. Fecha\n2. Tiempo\n3. Puntaje\n4. Juego";

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuEModificarPartida));
        switch(opcion){
            case 1:
                String nuevaFecha = JOptionPane.showInputDialog(null, "Digite la nueva Fecha:");
                partidaSeleccionada.setFecha(nuevaFecha);
                break;
            case 2:
                int nuevoTiempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el nuevo tiempo:"));
                partidaSeleccionada.setTiempo(nuevoTiempo);
                break;
            case 3:
                if(partidaSeleccionada.getJuego() instanceof Fortnite){
                    int nuevoPuesto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el nuevo puesto:"));
                    partidaSeleccionada.setPuntaje(fortnite.definirPuntaje(nuevoPuesto));
                }
                else if(partidaSeleccionada.getJuego() instanceof Ajedrez){
                    String menuAjedrez = "Seleccione el resultado:\n1. Victoria\n2. Empate\n3. Derrota";
                    int res = Integer.parseInt(JOptionPane.showInputDialog(null, menuAjedrez));

                    partidaSeleccionada.setPuntaje(ajedrez.definirPuntaje(res));

                }
                else if(partidaSeleccionada.getJuego() instanceof ApexLegends){
                    int kills = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de kills: "));
                    int deaths = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de deaths: "));
                    
                    partidaSeleccionada.setPuntaje(apexLegends.definirPuntos(kills, deaths));
                }
                else if(partidaSeleccionada.getJuego() instanceof Tetris){
                    int nuevasFilas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el nuevo numero de fillas despejadas:"));
                    
                    partidaSeleccionada.setPuntaje(tetris.definirPuntos(nuevasFilas));
                }
            case 4:
                String menuNuevoJuego = "Digite el nuevo Juego:\n1. Fortnite\n2. Ajedrez\n3. Apex Legends\n4. Tetris";

                int opcionJuego = Integer.parseInt(JOptionPane.showInputDialog(menuNuevoJuego));
                switch(opcionJuego){
                    case 1:
                        partidaSeleccionada.setJuego(fortnite);
                        break;
                    case 2:
                        partidaSeleccionada.setJuego(ajedrez);
                        break;
                    case 3:
                        partidaSeleccionada.setJuego(apexLegends);
                        break;
                    case 4: 
                        partidaSeleccionada.setJuego(tetris);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                        break;
                }
            default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
        }

        listaPartidasJugador.set(posPartidaSeleccionada, partidaSeleccionada);
        jugadorSeleccionado.setPartidas(listaPartidasJugador);

        JOptionPane.showMessageDialog(null, "Cambio exitoso");
    }

    /*
     * Metodo jugar fortnite
     * Selecciona un jugador y le pide los datos de la partida
     * Añade la partida al jugador
     */
    public void eJugarFortnite(){
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Seleccione el jugador...");

        for(Jugador jugadorActual : competencia.getJugadores()){
            listaJugadores.add(jugadorActual.getCorreo());
        }

        listaJugadoresJCombo = new JComboBox<>(listaJugadores.toArray(new String[listaJugadores.size()]));

        // Obtener el jugador seleccionado del JComboBox
        JOptionPane.showMessageDialog(this, listaJugadoresJCombo, "Selecciona un Jugador", JOptionPane.QUESTION_MESSAGE);
        String correoJugadorSeleccionado = (String) listaJugadoresJCombo.getSelectedItem();

        // Buscar el jugador directamente en la lista de jugadores
        Jugador jugadorSeleccionado = null;
        int posJugadorSeleccionado = 0;
        for (int jugadorActual = 0; jugadorActual < competencia.getJugadores().size(); jugadorActual++) {
            if (competencia.getJugador(jugadorActual).getCorreo().equals(correoJugadorSeleccionado)) {
                jugadorSeleccionado = competencia.getJugador(jugadorActual);
                posJugadorSeleccionado = jugadorActual;
                break;
            }
        }

        String fecha = JOptionPane.showInputDialog("Digite la fecha: ");
        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tiempo: "));
        int puesto = Integer.parseInt(JOptionPane.showInputDialog("Digite el puesto: "));
        int puntaje = fortnite.definirPuntaje(puesto);

        Partida partida = new Partida(fecha, tiempo, puntaje, fortnite);

        

        jugadorSeleccionado.agregarPartida(partida);

        //Actualizar la lista
        listaJugadoresCompetencia.set(posJugadorSeleccionado, jugadorSeleccionado);
        competencia.setJugadores(listaJugadoresCompetencia);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Partida agregada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * Metodo jugar Ajedrez
     * Selecciona un jugador y le pide los datos de la partida
     * Añade la partida al jugador
     */
    public void eJugarAjedrez(){
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Seleccione el jugador...");

        for(Jugador jugadorActual : competencia.getJugadores()){
            listaJugadores.add(jugadorActual.getCorreo());
        }

        listaJugadoresJCombo = new JComboBox<>(listaJugadores.toArray(new String[listaJugadores.size()]));

        // Obtener el jugador seleccionado del JComboBox
        JOptionPane.showMessageDialog(this, listaJugadoresJCombo, "Selecciona un Jugador", JOptionPane.QUESTION_MESSAGE);
        String correoJugadorSeleccionado = (String) listaJugadoresJCombo.getSelectedItem();

        // Buscar el jugador directamente en la lista de jugadores
        Jugador jugadorSeleccionado = null;
        int posJugadorSeleccionado = 0;
        for (int jugadorActual = 0; jugadorActual < competencia.getJugadores().size(); jugadorActual++) {
            if (competencia.getJugador(jugadorActual).getCorreo().equals(correoJugadorSeleccionado)) {
                jugadorSeleccionado = competencia.getJugador(jugadorActual);
                posJugadorSeleccionado = jugadorActual;
                break;
            }
        }

        String menuAjedrez = "Seleccione el resultado:\n1. Victoria\n2. Empate\n3. Derrota";

        String fecha = JOptionPane.showInputDialog("Digite la fecha: ");
        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tiempo: "));
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuAjedrez));
        
        Partida partida = new Partida(fecha, tiempo, opcion, ajedrez);

        jugadorSeleccionado.agregarPartida(partida);

        //Actualizar la lista
        listaJugadoresCompetencia.set(posJugadorSeleccionado, jugadorSeleccionado);
        competencia.setJugadores(listaJugadoresCompetencia);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Partida agregada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * Metodo jugar Tetris
     * Selecciona un jugador y le pide los datos de la partida
     * Añade la partida al jugador
     */
    public void eJugarTetris(){
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Seleccione el jugador...");

        for(Jugador jugadorActual : competencia.getJugadores()){
            listaJugadores.add(jugadorActual.getCorreo());
        }

        listaJugadoresJCombo = new JComboBox<>(listaJugadores.toArray(new String[listaJugadores.size()]));

        // Obtener el jugador seleccionado del JComboBox
        JOptionPane.showMessageDialog(this, listaJugadoresJCombo, "Selecciona un Jugador", JOptionPane.QUESTION_MESSAGE);
        String correoJugadorSeleccionado = (String) listaJugadoresJCombo.getSelectedItem();

        // Buscar el jugador directamente en la lista de jugadores
        Jugador jugadorSeleccionado = null;
        int posJugadorSeleccionado = 0;
        for (int jugadorActual = 0; jugadorActual < competencia.getJugadores().size(); jugadorActual++) {
            if (competencia.getJugador(jugadorActual).getCorreo().equals(correoJugadorSeleccionado)) {
                jugadorSeleccionado = competencia.getJugador(jugadorActual);
                posJugadorSeleccionado = jugadorActual;
                break;
            }
        }

        String fecha = JOptionPane.showInputDialog("Digite la fecha: ");
        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tiempo: "));
        int filledRows = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas despejadas: "));
        int puntaje = tetris.definirPuntos(filledRows);

        Partida partida = new Partida(fecha, tiempo, puntaje, tetris);
        
        jugadorSeleccionado.agregarPartida(partida);

        //Actualizar la lista
        listaJugadoresCompetencia.set(posJugadorSeleccionado, jugadorSeleccionado);
        competencia.setJugadores(listaJugadoresCompetencia);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Partida agregada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
    
    }

    /*
     * Metodo jugar Apex Legends
     * Selecciona un jugador y le pide los datos de la partida
     * Añade la partida al jugador
     */
    public void eJugarApex(){
        ArrayList<Jugador> listaJugadoresCompetencia = competencia.getJugadores();
        ArrayList<String> listaJugadores = new ArrayList<String>();
        listaJugadores.add("Seleccione el jugador...");

        for(Jugador jugadorActual : competencia.getJugadores()){
            listaJugadores.add(jugadorActual.getCorreo());
        }

        listaJugadoresJCombo = new JComboBox<>(listaJugadores.toArray(new String[listaJugadores.size()]));

        // Obtener el jugador seleccionado del JComboBox
        JOptionPane.showMessageDialog(this, listaJugadoresJCombo, "Selecciona un Jugador", JOptionPane.QUESTION_MESSAGE);
        String correoJugadorSeleccionado = (String) listaJugadoresJCombo.getSelectedItem();

        // Buscar el jugador directamente en la lista de jugadores
        Jugador jugadorSeleccionado = null;
        int posJugadorSeleccionado = 0;
        for (int jugadorActual = 0; jugadorActual < competencia.getJugadores().size(); jugadorActual++) {
            if (competencia.getJugador(jugadorActual).getCorreo().equals(correoJugadorSeleccionado)) {
                jugadorSeleccionado = competencia.getJugador(jugadorActual);
                posJugadorSeleccionado = jugadorActual;
                break;
            }
        }

        String fecha = JOptionPane.showInputDialog("Digite la fecha: ");
        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tiempo: "));
        int kills = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de kills: "));
        int deaths = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de deaths: "));
        int puntaje = apexLegends.definirPuntos(kills, deaths);

        Partida partida = new Partida(fecha, tiempo, puntaje, apexLegends);

        jugadorSeleccionado.agregarPartida(partida);

        listaJugadoresCompetencia.set(posJugadorSeleccionado, jugadorSeleccionado);
        competencia.setJugadores(listaJugadoresCompetencia);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Partida agregada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cAJEDREZ(){
        ArrayList<Jugador> jugadoresAjedrez = ajedrez.getJugadoresAjedrez();
        // Verificar si hay jugadores de ajedrez
        if(jugadoresAjedrez != null && !jugadoresAjedrez.isEmpty()){
            // Obtener la cantidad de partidas y jugadores de ajedrez
            int cantidadPartidas = 0;
            for (int i = 0; i < jugadoresAjedrez.size(); i++) {
                cantidadPartidas += jugadoresAjedrez.get(i).cantidadPartidas(ajedrez);
            }
            int cantidadJugadores = jugadoresAjedrez.size();
            // Obtener al mejor jugador de ajedrez
            Jugador mejorJugadorAjedrez = competencia.mejorJugador(ajedrez);
             // Mostrar estadísticas
            String mensaje = "Estadísticas del Juego:\n\n" +
                "Cantidad de Partidas: " + cantidadPartidas + "\n" +
                "Cantidad de Jugadores: " + cantidadJugadores + "\n" +
                "Mejor Jugador: " + (mejorJugadorAjedrez != null ? mejorJugadorAjedrez.getNombre() : "No disponible");

                JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Juego de Ajedrez", JOptionPane.INFORMATION_MESSAGE);
        } else {
             // Mostrar mensaje si no hay jugadores de ajedrez
            JOptionPane.showMessageDialog(this, "No hay jugadores de ajedrez registrados", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void cFORTNITE(){
        ArrayList<Jugador> jugadoresFornite = fortnite.getJugadoresFortnite();
        //Verificar si hay jugadores de Fortnite
        if(jugadoresFornite != null && !jugadoresFornite.isEmpty()) {
            //Obtener cantidad de partidas y jugadores de fortnite
            int cantidadPartidas = 0;
            for (int i = 0; i < jugadoresFornite.size(); i++) {
                cantidadPartidas += jugadoresFornite.get(i).cantidadPartidas(fortnite);
            }
            int cantidadJugadores = jugadoresFornite.size();
            //Obtener mejor jugador de Fortnite
            Jugador mejorJugadorFornite = competencia.mejorJugador(fortnite);
            //Mensaje estadísticas
            String mensaje = "Estadísticas del Juego:\n\n" +
                "Cantidad de Partidas: " + cantidadPartidas + "\n" +
                "Cantidad de Jugadores: " + cantidadJugadores + "\n" +
                "Mejor Jugador: " + (mejorJugadorFornite != null ? mejorJugadorFornite.getNombre() : "No disponible");
                JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Juego de Fortnite", JOptionPane.INFORMATION_MESSAGE);
        } else {
             // Mostrar mensaje si no hay jugadores de ajedrez
            JOptionPane.showMessageDialog(this, "No hay jugadores de Fortnite registrados", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public void cTETRIS(){
        ArrayList<Jugador> jugadoresTetris = tetris.getJugadoresTetris();
        //Verificar si hay jugadores de Tetris
        if(jugadoresTetris != null && !jugadoresTetris.isEmpty()) {
            //Obtener cantidad de partidas y jugadores de tetris
            int cantidadPartidas = 0;
            for (int i = 0; i < jugadoresTetris.size(); i++) {
                cantidadPartidas += jugadoresTetris.get(i).cantidadPartidas(tetris);
            }
            int cantidadJugadores = jugadoresTetris.size();
            //Obtener mejor jugador de tetris
            Jugador mejorJugadorTetris = competencia.mejorJugador(tetris);
            //Mensaje estadísticas
            String mensaje = "Estadísticas del Juego:\n\n" +
                "Cantidad de Partidas: " + cantidadPartidas + "\n" +
                "Cantidad de Jugadores: " + cantidadJugadores + "\n" +
                "Mejor Jugador: " + (mejorJugadorTetris != null ? mejorJugadorTetris.getNombre() : "No disponible");
                JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Juego de Tetris", JOptionPane.INFORMATION_MESSAGE);
        } else {
             // Mostrar mensaje si no hay jugadores de ajedrez
            JOptionPane.showMessageDialog(this, "No hay jugadores de Tetris registrados", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public void cAPEX(){
        ArrayList<Jugador> jugadoresApex = apexLegends.getJugadoresApexLegends();
        //Verificar si hay jugadores de Apex
        if(jugadoresApex != null && !jugadoresApex.isEmpty()) {
            //Obtener cantidad de partidas y jugadores de apex legends
            int cantidadPartidas = 0;
            for (int i = 0; i < jugadoresApex.size(); i++) {
                cantidadPartidas += jugadoresApex.get(i).cantidadPartidas(apexLegends);
            }
            int cantidadJugadores = jugadoresApex.size();
            //Obtener mejor jugador de apex legends
            Jugador mejorJugadorApex = competencia.mejorJugador(apexLegends);
            //Mensaje estadísticas
            String mensaje = "Estadísticas del Juego:\n\n" +
                "Cantidad de Partidas: " + cantidadPartidas + "\n" +
                "Cantidad de Jugadores: " + cantidadJugadores + "\n" +
                "Mejor Jugador: " + (mejorJugadorApex != null ? mejorJugadorApex.getNombre() : "No disponible");
                JOptionPane.showMessageDialog(this, mensaje, "Estadísticas del Juego de Apex Legends", JOptionPane.INFORMATION_MESSAGE);
        } else {
             // Mostrar mensaje si no hay jugadores de Apex legends
            JOptionPane.showMessageDialog(this, "No hay jugadores de Apex Legends registrados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eConsultarJugadores(){
        ArrayList<Jugador> arrayJugadores = competencia.getJugadores();
        String[] jugadores = new String[arrayJugadores.size()];

        int count = 1;
        for(Jugador jugadorActual : arrayJugadores){
            String msg = "Jugador " + count + ":   " + jugadorActual.getNombre() + 
            "     -     " + jugadorActual.getNickName() + "     -     " + jugadorActual.getCorreo();
            jugadores[count-1] = msg;
            count++;
        }

        JList listaJugadores = new JList(jugadores);

        // Crear un JFrame para mostrar la lista de jugadores
        JFrame frame = new JFrame("Lista de Jugadores");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Agregar la JList a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane(listaJugadores);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Configuración básica de la ventana
        frame.setSize(400, (30 * arrayJugadores.size() + 15));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}


