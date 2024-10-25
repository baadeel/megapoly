/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

/**
 *
 * @author Badal
 */
import java.awt.Component;
import java.awt.Insets;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import megapoly.Calle;
import megapoly.Carcel;
import megapoly.Casillas;
import megapoly.Impuesto;

import megapoly.Jugador;
import megapoly.Suerte;
import megapoly.Tablero;

public class PantallaTablero extends javax.swing.JFrame {

  private Jugador jugador1;
  private Jugador jugador2;
  private int turno;
  private Tablero tablero;
  private Casillas casilla;
  private Suerte[] cartas;

  public PantallaTablero() {
    initComponents();

  }

  public PantallaTablero(Jugador jugador1, Jugador jugador2) {
    initComponents();
    this.setSize(1515, 900);
    this.setResizable(false);

    //Poner márgenes al TextAreaMovimientos
    TextAreaMovimientos.setBorder(BorderFactory.createCompoundBorder(TextAreaMovimientos.getBorder(), BorderFactory.createEmptyBorder(5, 10, 0, 0)));

    //Ocultar Menu
    Menu.setVisible(false);

    //Creación de jugadores 
    this.jugador1 = jugador1;
    this.jugador2 = jugador2;
    LabelNombreJugador1.setText(jugador1.getNombre());
    LabelNombreJugador2.setText(jugador2.getNombre());

    LabelDineroJugador1.setText(jugador1.getDinero() + "");
    LabelDineroJugador2.setText(jugador2.getDinero() + "");

    //Creación del Tablero
    tablero = new Tablero();
    tablero.crearTablero();

    //Creación cartas
    cartas = new Suerte[10];

    cartas[0] = new Suerte("Ganaste un recorrido gratuito por los canales de Ámsterdam. "
            + "Avanza hasta los Países Bajos y recibe 10 Mm como bonificación. Si pasas por la casilla de Salida recibe "
            + "también la recompensa de la vuelta.");
    cartas[1] = new Suerte("¡Enhorabuena! Ganas un tour gratuito por el Mercadillo Vintage de Londres. Avanza hasta Reino Unido"
            + " y recibe 15 Mm como premio. Si pasas por la casilla de Salida recibe "
            + " también la recompensa de la vuelta.");
    cartas[2] = new Suerte("Gana un concurso de fotografía. Recibe 50 Mm como premio.");
    cartas[3] = new Suerte("Recibe un bono de 30 Mm por haber ayudado a una anciana a cruzar la calle.");
    cartas[4] = new Suerte("Has encontrado 5 Mm por la calle, !vaya suerte!");
    cartas[5] = new Suerte("Pierdes tu pasaporte y debes retroceder cinco espacios para recuperarlo.");
    cartas[6] = new Suerte("Te pierdes en las calles de Barcelona y te han robado la cartera, pierdes 20 Mm.");
    cartas[7] = new Suerte("Pagas una multa por exceso de equipaje en el avión. Retrocede dos espacios y paga 15 Mm.");
    cartas[8] = new Suerte("Te enfermas durante tu viaje y debes pagar una consulta médica de emergencia. "
            + "Retrocede tres espacios y paga 25 Mm.");
    cartas[9] = new Suerte("Te enfrentas a una ola de calor en Madrid. Pagas 40 Mm para que te lleven a la playa más cercana.");

    turno = jugador1.getTurno();

    //Volvemos a poner las propiedades
    int[] propiedades1 = jugador1.getPropiedades();
    int[] propiedades2 = jugador2.getPropiedades();

    for (int i = 0; i < propiedades1.length; i++) {
      if (propiedades1[i] == 1) {
        casilla = tablero.getTablero(i);
        if (casilla instanceof Calle) {
          Calle calle = (Calle) casilla;
          calle.setJugadorPropietario(jugador1);
           TextAreaPropiedades1.append(calle.getNombre()+ ", ");
        }
      }
    }
    for (int i = 0; i < propiedades2.length; i++) {
      if (propiedades2[i] == 1) {
        casilla = tablero.getTablero(i);
        if (casilla instanceof Calle) {
          Calle calle = (Calle) casilla;
          calle.setJugadorPropietario(jugador2);
          TextAreaPropiedades2.append(calle.getNombre() + ", ");
        }
      }
    }

    
    if (turno == 1) {
      turnoJugador(jugador1);
    } else {
      turnoJugador(jugador2);
    }

    setLocationFicha(jugador1, jugador2);
    actualizarDinero(jugador1, jugador2);
  }

  public PantallaTablero(String nombreJugador1, String nombreJugador2) {

    initComponents();
    this.setSize(1515, 900);
    this.setResizable(false);

    //Poner márgenes al TextAreaMovimientos
    TextAreaMovimientos.setBorder(BorderFactory.createCompoundBorder(TextAreaMovimientos.getBorder(), BorderFactory.createEmptyBorder(5, 10, 0, 0)));

    //Ocultar Menu
    Menu.setVisible(false);

    //Creación de jugadores 
    jugador1 = new Jugador();
    jugador2 = new Jugador();

  
    LabelNombreJugador1.setText(nombreJugador1);
    LabelNombreJugador2.setText(nombreJugador2);
    jugador1.setNombre(nombreJugador1);
    jugador2.setNombre(nombreJugador2);

    LabelDineroJugador1.setText(jugador1.getDinero() + "");
    LabelDineroJugador2.setText(jugador2.getDinero() + "");

    //Creación del Tablero
    tablero = new Tablero();
    tablero.crearTablero();

    //Creación cartas
    cartas = new Suerte[10];

    cartas[0] = new Suerte("Ganaste un recorrido gratuito por los canales de Ámsterdam. "
            + "Avanza hasta los Países Bajos y recibe 10 Mm como bonificación. Si pasas por la casilla de Salida recibe "
            + "también la recompensa de la vuelta.");
    cartas[1] = new Suerte("¡Enhorabuena! Ganas un tour gratuito por el Mercadillo Vintage de Londres. Avanza hasta Reino Unido"
            + " y recibe 15 Mm como premio. Si pasas por la casilla de Salida recibe "
            + " también la recompensa de la vuelta.");
    cartas[2] = new Suerte("Gana un concurso de fotografía. Recibe 50 Mm como premio.");
    cartas[3] = new Suerte("Recibe un bono de 30 Mm por haber ayudado a una anciana a cruzar la calle.");
    cartas[4] = new Suerte("Has encontrado 5 Mm por la calle, !vaya suerte!");
    cartas[5] = new Suerte("Pierdes tu pasaporte y debes retroceder cinco espacios para recuperarlo.");
    cartas[6] = new Suerte("Te pierdes en las calles de Barcelona y te han robado la cartera, pierdes 20 Mm.");
    cartas[7] = new Suerte("Pagas una multa por exceso de equipaje en el avión. Retrocede dos espacios y paga 15 Mm.");
    cartas[8] = new Suerte("Te enfermas durante tu viaje y debes pagar una consulta médica de emergencia. "
            + "Retrocede tres espacios y paga 25 Mm.");
    cartas[9] = new Suerte("Te enfrentas a una ola de calor en Madrid. Pagas 40 Mm para que te lleven a la playa más cercana.");

    //Ponemos turno
    turno = 1;
    turnoJugador(jugador1);

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    PanelPrincipalFondo = new javax.swing.JPanel();
    LabelNombreJugador1 = new javax.swing.JLabel();
    LabelNombreJugador2 = new javax.swing.JLabel();
    LabelDineroJugador1 = new javax.swing.JLabel();
    LabelDineroJugador2 = new javax.swing.JLabel();
    LabelFicha1 = new javax.swing.JLabel();
    LabelFicha2 = new javax.swing.JLabel();
    ButtonMostrarMenu = new javax.swing.JButton();
    ScrollPanelMovimientos = new javax.swing.JScrollPane();
    TextAreaMovimientos = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();
    ButtonLanzarDado = new javax.swing.JButton();
    LabelDado0 = new javax.swing.JLabel();
    LabelDado1 = new javax.swing.JLabel();
    LabelDado2 = new javax.swing.JLabel();
    LabelDado3 = new javax.swing.JLabel();
    LabelDado4 = new javax.swing.JLabel();
    LabelDado5 = new javax.swing.JLabel();
    LabelDado6 = new javax.swing.JLabel();
    LabelTurnoJugador = new javax.swing.JLabel();
    ButtonMoverFicha = new javax.swing.JButton();
    PanelJuego = new javax.swing.JPanel();
    ScrollPanelPropiedades2 = new javax.swing.JScrollPane();
    TextAreaPropiedades2 = new javax.swing.JTextArea();
    ScrollPanelPropiedades1 = new javax.swing.JScrollPane();
    TextAreaPropiedades1 = new javax.swing.JTextArea();
    ButtonGuardarPartida = new javax.swing.JButton();
    ButtonSalir = new javax.swing.JButton();
    LabelFondo = new javax.swing.JLabel();
    LabelDadoNumero1 = new javax.swing.JLabel();
    LabelDadoNumero2 = new javax.swing.JLabel();
    Menu = new javax.swing.JMenuBar();
    Archivo = new javax.swing.JMenu();
    GuardarPartida = new javax.swing.JMenuItem();
    Salir = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    PanelPrincipalFondo.setLayout(null);

    LabelNombreJugador1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    LabelNombreJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelNombreJugador1.setText("Jugador1");
    LabelNombreJugador1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        LabelNombreJugador1PropertyChange(evt);
      }
    });
    PanelPrincipalFondo.add(LabelNombreJugador1);
    LabelNombreJugador1.setBounds(1290, 40, 180, 30);

    LabelNombreJugador2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    LabelNombreJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelNombreJugador2.setText("Jugador2");
    PanelPrincipalFondo.add(LabelNombreJugador2);
    LabelNombreJugador2.setBounds(1290, 310, 180, 30);

    LabelDineroJugador1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    LabelDineroJugador1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    LabelDineroJugador1.setText("Jugador1");
    LabelDineroJugador1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        LabelDineroJugador1PropertyChange(evt);
      }
    });
    PanelPrincipalFondo.add(LabelDineroJugador1);
    LabelDineroJugador1.setBounds(1290, 80, 140, 30);

    LabelDineroJugador2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    LabelDineroJugador2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    LabelDineroJugador2.setText("Jugador1");
    LabelDineroJugador2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        LabelDineroJugador2PropertyChange(evt);
      }
    });
    PanelPrincipalFondo.add(LabelDineroJugador2);
    LabelDineroJugador2.setBounds(1290, 350, 140, 30);

    LabelFicha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ficha1.png"))); // NOI18N
    LabelFicha1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        LabelFicha1MouseDragged(evt);
      }
    });
    LabelFicha1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        LabelFicha1MouseClicked(evt);
      }
    });
    PanelPrincipalFondo.add(LabelFicha1);
    LabelFicha1.setBounds(1010, 690, 71, 71);

    LabelFicha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ficha2.png"))); // NOI18N
    LabelFicha2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        LabelFicha2MouseClicked(evt);
      }
    });
    PanelPrincipalFondo.add(LabelFicha2);
    LabelFicha2.setBounds(1080, 690, 70, 71);

    ButtonMostrarMenu.setBackground(new java.awt.Color(0, 0, 0));
    ButtonMostrarMenu.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
    ButtonMostrarMenu.setForeground(new java.awt.Color(255, 255, 255));
    ButtonMostrarMenu.setText("Mostrar/Ocultar Menú");
    ButtonMostrarMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ButtonMostrarMenuActionPerformed(evt);
      }
    });
    PanelPrincipalFondo.add(ButtonMostrarMenu);
    ButtonMostrarMenu.setBounds(190, 140, 190, 30);

    ScrollPanelMovimientos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    ScrollPanelMovimientos.setToolTipText("");

    TextAreaMovimientos.setEditable(false);
    TextAreaMovimientos.setBackground(new java.awt.Color(255, 255, 153));
    TextAreaMovimientos.setColumns(20);
    TextAreaMovimientos.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
    TextAreaMovimientos.setForeground(new java.awt.Color(0, 0, 0));
    TextAreaMovimientos.setLineWrap(true);
    TextAreaMovimientos.setRows(5);
    TextAreaMovimientos.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    TextAreaMovimientos.setFocusable(false);
    TextAreaMovimientos.setMargin(new java.awt.Insets(20, 60, 20, 60));
    ScrollPanelMovimientos.setViewportView(TextAreaMovimientos);

    PanelPrincipalFondo.add(ScrollPanelMovimientos);
    ScrollPanelMovimientos.setBounds(500, 180, 480, 460);

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Movimientos");
    PanelPrincipalFondo.add(jLabel1);
    jLabel1.setBounds(500, 130, 480, 57);

    ButtonLanzarDado.setBackground(new java.awt.Color(0, 0, 0));
    ButtonLanzarDado.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    ButtonLanzarDado.setForeground(new java.awt.Color(255, 255, 255));
    ButtonLanzarDado.setText("Lanzar Dado");
    ButtonLanzarDado.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    ButtonLanzarDado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ButtonLanzarDadoActionPerformed(evt);
      }
    });
    PanelPrincipalFondo.add(ButtonLanzarDado);
    ButtonLanzarDado.setBounds(230, 490, 180, 34);

    LabelDado0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado0.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado0);
    LabelDado0.setBounds(280, 380, 80, 81);

    LabelDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado1.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado1);
    LabelDado1.setBounds(280, 380, 80, 81);

    LabelDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado2.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado2);
    LabelDado2.setBounds(280, 380, 81, 81);

    LabelDado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado3.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado3);
    LabelDado3.setBounds(280, 380, 81, 81);

    LabelDado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado4.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado4);
    LabelDado4.setBounds(280, 380, 81, 81);

    LabelDado5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado5.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado5);
    LabelDado5.setBounds(280, 380, 81, 81);

    LabelDado6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Dado6.png"))); // NOI18N
    PanelPrincipalFondo.add(LabelDado6);
    LabelDado6.setBounds(280, 380, 81, 81);

    LabelTurnoJugador.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    LabelTurnoJugador.setForeground(new java.awt.Color(255, 255, 255));
    LabelTurnoJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTurnoJugador.setText("TURNO DE ");
    PanelPrincipalFondo.add(LabelTurnoJugador);
    LabelTurnoJugador.setBounds(170, 280, 300, 100);

    ButtonMoverFicha.setBackground(new java.awt.Color(0, 0, 0));
    ButtonMoverFicha.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    ButtonMoverFicha.setForeground(new java.awt.Color(255, 255, 255));
    ButtonMoverFicha.setText("Mover ficha");
    ButtonMoverFicha.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    ButtonMoverFicha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ButtonMoverFichaActionPerformed(evt);
      }
    });
    PanelPrincipalFondo.add(ButtonMoverFicha);
    ButtonMoverFicha.setBounds(230, 550, 180, 34);

    PanelJuego.setBackground(new java.awt.Color(102, 102, 102));
    PanelJuego.setForeground(new java.awt.Color(153, 153, 153));

    javax.swing.GroupLayout PanelJuegoLayout = new javax.swing.GroupLayout(PanelJuego);
    PanelJuego.setLayout(PanelJuegoLayout);
    PanelJuegoLayout.setHorizontalGroup(
      PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    PanelJuegoLayout.setVerticalGroup(
      PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    PanelPrincipalFondo.add(PanelJuego);
    PanelJuego.setBounds(190, 280, 0, 0);

    ScrollPanelPropiedades2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    ScrollPanelPropiedades2.setAutoscrolls(true);

    TextAreaPropiedades2.setBackground(new java.awt.Color(51, 204, 255));
    TextAreaPropiedades2.setColumns(20);
    TextAreaPropiedades2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
    TextAreaPropiedades2.setForeground(new java.awt.Color(0, 0, 0));
    TextAreaPropiedades2.setLineWrap(true);
    TextAreaPropiedades2.setRows(5);
    TextAreaPropiedades2.setText("Propiedades: ");
    TextAreaPropiedades2.setFocusable(false);
    ScrollPanelPropiedades2.setViewportView(TextAreaPropiedades2);

    PanelPrincipalFondo.add(ScrollPanelPropiedades2);
    ScrollPanelPropiedades2.setBounds(1180, 390, 300, 130);

    ScrollPanelPropiedades1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    TextAreaPropiedades1.setBackground(new java.awt.Color(255, 153, 153));
    TextAreaPropiedades1.setColumns(20);
    TextAreaPropiedades1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
    TextAreaPropiedades1.setForeground(new java.awt.Color(0, 0, 0));
    TextAreaPropiedades1.setLineWrap(true);
    TextAreaPropiedades1.setRows(5);
    TextAreaPropiedades1.setText("Propiedades: ");
    TextAreaPropiedades1.setToolTipText("");
    TextAreaPropiedades1.setFocusable(false);
    ScrollPanelPropiedades1.setViewportView(TextAreaPropiedades1);

    PanelPrincipalFondo.add(ScrollPanelPropiedades1);
    ScrollPanelPropiedades1.setBounds(1180, 120, 300, 130);

    ButtonGuardarPartida.setBackground(new java.awt.Color(0, 0, 0));
    ButtonGuardarPartida.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    ButtonGuardarPartida.setForeground(new java.awt.Color(255, 255, 255));
    ButtonGuardarPartida.setText("Guardar partida");
    ButtonGuardarPartida.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    ButtonGuardarPartida.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ButtonGuardarPartidaActionPerformed(evt);
      }
    });
    PanelPrincipalFondo.add(ButtonGuardarPartida);
    ButtonGuardarPartida.setBounds(1170, 550, 220, 50);

    ButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
    ButtonSalir.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    ButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
    ButtonSalir.setText("Salir");
    ButtonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ButtonSalirActionPerformed(evt);
      }
    });
    PanelPrincipalFondo.add(ButtonSalir);
    ButtonSalir.setBounds(1170, 610, 160, 50);

    LabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
    LabelFondo.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
    PanelPrincipalFondo.add(LabelFondo);
    LabelFondo.setBounds(0, 0, 1508, 778);

    LabelDadoNumero1.setText("jLabel2");
    PanelPrincipalFondo.add(LabelDadoNumero1);
    LabelDadoNumero1.setBounds(200, 260, 37, 16);

    LabelDadoNumero2.setText("jLabel2");
    PanelPrincipalFondo.add(LabelDadoNumero2);
    LabelDadoNumero2.setBounds(200, 260, 37, 16);

    Archivo.setText("Archivo");

    GuardarPartida.setText("Guardar partida");
    GuardarPartida.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        GuardarPartidaActionPerformed(evt);
      }
    });
    Archivo.add(GuardarPartida);

    Salir.setText("Salir");
    Salir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        SalirActionPerformed(evt);
      }
    });
    Archivo.add(Salir);

    Menu.add(Archivo);

    setJMenuBar(Menu);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(PanelPrincipalFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(PanelPrincipalFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  //Actualizar el dinero en la interfaz
  private void actualizarDinero(Jugador jugador1, Jugador jugador2) {
    LabelDineroJugador1.setText(jugador1.getDinero() + "");
    LabelDineroJugador2.setText(jugador2.getDinero() + "");

  }
  
  //Escoger número aleatorio del 1 al 6
  private int numeroAleatorio16() {
    int numero = 0;
    return numero = (int) Math.floor(Math.random() * 6 + 1);
  }

  
  //Setear dado en la interfaz y en las propiedades del jugador. Escribir en la pantalla de movimientos el valor que ha sacado.
  private int lanzarDado(Jugador jugador) {
    int numero = 0;
    if (jugador.getNumeroDado() == 0) {

      LabelDado0.setVisible(false);
      LabelDado1.setVisible(false);
      LabelDado2.setVisible(false);
      LabelDado3.setVisible(false);
      LabelDado4.setVisible(false);
      LabelDado5.setVisible(false);
      LabelDado6.setVisible(false);

      numero = numeroAleatorio16();
      jugador.setNumeroDado(numero);
      switch (numero) {
        case 1:
          LabelDado1.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 1. \n");
          break;
        case 2:
          LabelDado2.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 2. \n");
          break;
        case 3:
          LabelDado3.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 3. \n");
          break;
        case 4:
          LabelDado4.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 4. \n");
          break;
        case 5:
          LabelDado5.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 5. \n");
          break;
        case 6:
          LabelDado6.setVisible(true);
          TextAreaMovimientos.append(jugador.getNombre() + " ha sacado un 6. \n");
          break;
      }
    } else {
      String mensaje = "Ya has tirado el dado, ahora tienes que mover ficha.";
      String titulo = "Error";
      JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    return numero;
  }

  //Poner en la interfaz el nomnbre del jugador cuyo turno es y comprobrar si tiene dinero para continuar el juego.
  private void turnoJugador(Jugador jugador) {

    if (jugador.getDinero() > 0) {
      LabelTurnoJugador.setText("Turno de " + jugador.getNombre() + ":");
    } else {
      String mensaje;
      if (jugador1.getDinero() <= 0) {
        mensaje = jugador2.getNombre() + " ES GANADOR/A";
        JOptionPane.showMessageDialog(this, mensaje);
        PantallaInicio pantallaInicio = new PantallaInicio();
        pantallaInicio.setVisible(true);
        dispose();
        
      } else if (jugador2.getDinero() <= 0) {
        mensaje = jugador1.getNombre() + " ES GANADOR/A";

        JOptionPane.showMessageDialog(this, mensaje);
        PantallaInicio pantallaInicio = new PantallaInicio();
        pantallaInicio.setVisible(true);
        dispose();
      }
    }
  }

  //Comprobar en que casilla hemos caído.
  public void comprobarCasilla(Jugador jugador, int numCasilla) {
    casilla = tablero.getTablero(jugador.getPosicion());

    //Si es una calle -> Comprar calle o pagar alquiler
    if (casilla instanceof Calle) {
      Calle calle = (Calle) casilla;
      comprarCalle(jugador, calle);
      pagoJugadorJugador(jugador, calle);
    }
    //Si son impuestos
    if (casilla instanceof Impuesto) {
      Impuesto impuesto = (Impuesto) casilla;
      jugador.setDinero((jugador.getDinero()) - 20);
      escribirEnTableroMovimiento("Has pagado los impuestos: -20 Mm. \n");
      actualizarDinero(jugador1, jugador2);
    }
    //Si caes en la cárcel
    if (casilla instanceof Carcel) {
      jugador.setPosicion(6);
      jugador.setCarcel(true);
      setLocationFicha(jugador1, jugador2);
    }
    //Si caes en Suerte
    if (casilla instanceof Suerte) {
      Suerte carta = (Suerte) casilla;
      elegirCarta(jugador);

    }

  }

  //Preguntar si quiere comprar calle.
  public void comprarCalle(Jugador jugador, Calle calle) {
    int dinero = jugador.getDinero();

    if (calle.getJugadorPropietario() == null) {
      String[] opciones = {"Si", "No"};
      String mensaje = "¿Quieres comprar " + calle.getNombre() + " ? \n Cuesta " + calle.getValor() + " Mm.";

      int respuesta = JOptionPane.showOptionDialog(this, mensaje, "Pregunta", JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
      if (respuesta == 0) {
        dinero -= calle.getValor();
        if (dinero > 0) {
          jugador.setDinero(dinero);
          escribirEnTableroMovimiento(jugador.getNombre() + " ha comprado " + calle.getNombre() + ": -" + calle.getValor() + " Mm \n");
          calle.setJugadorPropietario(jugador);
          actualizarDinero(jugador1, jugador2);
          escribirEnTableroPropiedades(calle.getNombre() + ", ", jugador);
          jugador.setPropiedades(calle.getPosicion());

        } else {
          String mensajeError = "¡Si compras este país te quedas en bancarrota! Ahorra un poco más de dinero e inténtalo más tarde.";
          String titulo = "Error";
          JOptionPane.showMessageDialog(this, mensajeError, titulo, JOptionPane.ERROR_MESSAGE);

        }
      } else if (respuesta == 1 | respuesta == -1) {
        escribirEnTableroMovimiento("No se ha comprado " + calle.getNombre() + ". \n");
      }
    } else if (calle.getJugadorPropietario() == jugador) {
      escribirEnTableroMovimiento(calle.getNombre() + " ya te pertenece. ¡Vacaciones gratis! :) \n");
    }
  }

  //Pagar alquiler.
  public void pagoJugadorJugador(Jugador jugador, Calle calle) {
    int dinero = jugador.getDinero();
    if (calle.getJugadorPropietario() != jugador && calle.getJugadorPropietario() != null) {
      Jugador propietario = calle.getJugadorPropietario();
      int dineroPropietario = propietario.getDinero();
      dineroPropietario += calle.getAlquiler();
      dinero -= calle.getAlquiler();
      jugador.setDinero(dinero);
      propietario.setDinero(dineroPropietario);
      actualizarDinero(jugador1, jugador2);
      escribirEnTableroMovimiento("Este país pertenece a " + propietario.getNombre() + ", debes de pagarle "
              + ": -" + calle.getAlquiler() + " Mm. \n");
      actualizarDinero(jugador1, jugador2);
    }
  }

  //Elegir una carta Suerte aleatoriamente.
  public void elegirCarta(Jugador jugador) {
    int numero = 0;
    numero = (int) Math.floor(Math.random() * 9);
    Suerte carta = cartas[numero];
    //Mensaje
    String mensaje = carta.getMensaje();
    JOptionPane.showMessageDialog(this, mensaje);
    efectosCartas(jugador, numero);

  }

  //Establecer los efectos de las cartas Suerte.
  public void efectosCartas(Jugador jugador, int numero) {

    switch (numero) {
      case 0:
        int posicion = jugador.getPosicion();
        jugador.setDinero((jugador.getDinero()) + 10);
        if (posicion == 21) {
          jugador.setNumeroVueltas((jugador.getNumeroVueltas()) + 1);
          jugador.setDinero((jugador.getDinero()) + 20);
          escribirEnTableroMovimiento(jugador.getNombre() + " has dado una vuelta pasando por "
                  + "la casilla de Inicio, te damos 20 Mm + 10 Mm por la bonificación \n");
        } else {
          escribirEnTableroMovimiento(jugador.getNombre() + ": +10 Mm. \n ");
        }
        jugador.setPosicion(13);
        setLocationFicha(jugador1, jugador2);
        TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
        comprobarCasilla(jugador, 13);

        break;

      case 1:
        posicion = jugador.getPosicion();
        jugador.setDinero((jugador.getDinero()) + 15);
        if (posicion == 21) {
          jugador.setNumeroVueltas((jugador.getNumeroVueltas()) + 1);
          jugador.setDinero((jugador.getDinero()) + 20);
          escribirEnTableroMovimiento(jugador.getNombre() + " has dado una vuelta pasando por la casilla de Inicio, "
                  + "te damos 20 Mm + 15 Mm por la bonificación. \n");
        } else {
          escribirEnTableroMovimiento(jugador.getNombre() + ": +15 Mm. \n");
        }
        jugador.setPosicion(16);
        setLocationFicha(jugador1, jugador2);
        TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
        comprobarCasilla(jugador, 16);

        break;

      case 2:
        jugador.setDinero((jugador.getDinero()) + 50);
        escribirEnTableroMovimiento(jugador.getNombre() + ": +50 Mm. \n");
        break;

      case 3:
        jugador.setDinero((jugador.getDinero()) + 30);
        escribirEnTableroMovimiento(jugador.getNombre() + ": +30 Mm. \n");
        break;

      case 4:
        jugador.setDinero((jugador.getDinero()) + 5);
        escribirEnTableroMovimiento(jugador.getNombre() + ": +15 Mm. \n");
        break;

      case 5:
        jugador.setPosicion(jugador.getPosicion() - 5);
        escribirEnTableroMovimiento(jugador.getNombre() + " ha retrocedido 5 casillas. \n");
        setLocationFicha(jugador1, jugador2);
        TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
        comprobarCasilla(jugador, jugador.getPosicion());
        break;

      case 6:
        jugador.setDinero((jugador.getDinero()) - 20);
        escribirEnTableroMovimiento(jugador.getNombre() + ": -20 Mm. \n");
        break;

      case 7:
        jugador.setPosicion(jugador.getPosicion() - 2);
        jugador.setDinero((jugador.getDinero()) - 15);
        escribirEnTableroMovimiento(jugador.getNombre() + " ha retrocedido 2 casillas y -15 Mm. \n");
        setLocationFicha(jugador1, jugador2);
        TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
        comprobarCasilla(jugador, jugador.getPosicion());
        break;

      case 8:
        jugador.setPosicion(jugador.getPosicion() - 3);
        jugador.setDinero((jugador.getDinero()) - 25);
        escribirEnTableroMovimiento(jugador.getNombre() + " ha retrocedido 3 casillas y -25 Mm. \n");
        setLocationFicha(jugador1, jugador2);
        TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
        comprobarCasilla(jugador, jugador.getPosicion());
        break;

      case 9:
        jugador.setDinero((jugador.getDinero()) - 40);
        escribirEnTableroMovimiento(jugador.getNombre() + " : -40 Mm. \n");
        break;
    }
    setLocationFicha(jugador1, jugador2);
    actualizarDinero(jugador1, jugador2);
  }

  //Mover la posición del jugador y comprobar la casilla.
  public void moverFicha(Jugador jugador, int numero) {
    jugador.setPosicion(numero + jugador.getPosicion());
    setLocationFicha(jugador1, jugador2);
    contadorVueltas(jugador);
    TextAreaMovimientos.append(tablero.getTablero(jugador.getPosicion()) + "");
    comprobarCasilla(jugador, jugador.getPosicion());

  }

  //Mover la posición del jugador en la interfaz gráfica.
  public void setLocationFicha(Jugador jugador1, Jugador jugador2) {

    int posicion1 = jugador1.getPosicion();
    int posicion2 = jugador2.getPosicion();

    switch (posicion1) {
      case 0:

        LabelFicha1.setLocation(1000, 690);
        break;
      case 1:
        LabelFicha1.setLocation(840, 700);
        break;
      case 2:
        LabelFicha1.setLocation(680, 700);
        break;
      case 3:
        LabelFicha1.setLocation(510, 700);
        break;
      case 4:
        LabelFicha1.setLocation(340, 700);
        break;
      case 5:
        LabelFicha1.setLocation(180, 700);
        break;
      case 6:
        LabelFicha1.setLocation(40, 660);
        break;
      case 7:
        LabelFicha1.setLocation(0, 580);
        break;
      case 8:
        LabelFicha1.setLocation(0, 460);
        break;
      case 9:
        LabelFicha1.setLocation(0, 350);
        break;
      case 10:
        LabelFicha1.setLocation(0, 240);
        break;
      case 11:
        LabelFicha1.setLocation(0, 130);
        break;
      case 12:
        LabelFicha1.setLocation(40, 0);
        break;
      case 13:
        LabelFicha1.setLocation(180, 0);
        break;
      case 14:
        LabelFicha1.setLocation(340, 0);
        break;
      case 15:
        LabelFicha1.setLocation(510, 0);
        break;
      case 16:
        LabelFicha1.setLocation(680, 0);
        break;
      case 17:
        LabelFicha1.setLocation(840, 0);
        break;
      case 18:
        LabelFicha1.setLocation(1000, 30);
        break;
      case 19:
        LabelFicha1.setLocation(1080, 140);
        break;
      case 20:
        LabelFicha1.setLocation(1080, 250);
        break;
      case 21:
        LabelFicha1.setLocation(1080, 360);
        break;
      case 22:
        LabelFicha1.setLocation(1080, 470);
        break;
      case 23:
        LabelFicha1.setLocation(1080, 580);
        break;
    }

    switch (posicion2) {
      case 0:
        LabelFicha2.setLocation(1080, 690);

        break;
      case 1:
        LabelFicha2.setLocation(910, 700);
        break;
      case 2:
        LabelFicha2.setLocation(750, 700);
        break;
      case 3:
        LabelFicha2.setLocation(580, 700);
        break;
      case 4:
        LabelFicha2.setLocation(410, 700);
        break;
      case 5:
        LabelFicha2.setLocation(250, 700);
        break;
      case 6:
        LabelFicha2.setLocation(90, 700);
        break;
      case 7:
        LabelFicha2.setLocation(60, 580);
        break;
      case 8:
        LabelFicha2.setLocation(60, 460);
        break;
      case 9:
        LabelFicha2.setLocation(60, 350);
        break;
      case 10:
        LabelFicha2.setLocation(60, 240);
        break;
      case 11:
        LabelFicha2.setLocation(60, 130);
        break;
      case 12:
        LabelFicha2.setLocation(90, 40);
        break;
      case 13:
        LabelFicha2.setLocation(250, 0);
        break;
      case 14:
        LabelFicha2.setLocation(410, 0);
        break;
      case 15:
        LabelFicha2.setLocation(580, 0);
        break;
      case 16:
        LabelFicha2.setLocation(750, 0);
        break;
      case 17:
        LabelFicha2.setLocation(910, 0);
        break;
      case 18:
        LabelFicha2.setLocation(1030, 0);
        break;
      case 19:
        LabelFicha2.setLocation(1030, 110);
        break;
      case 20:
        LabelFicha2.setLocation(1030, 220);
        break;
      case 21:
        LabelFicha2.setLocation(1020, 340);
        break;
      case 22:
        LabelFicha2.setLocation(1030, 450);
        break;
      case 23:
        LabelFicha2.setLocation(1030, 550);
        break;
    }
  }

  //Mandar mensaje a la tabla de Propiedades.
  public void escribirEnTableroPropiedades(String mensaje, Jugador jugador) {
    if (turno == 1) {
      TextAreaPropiedades1.append(mensaje);
    }
    if (turno == 2) {
      TextAreaPropiedades2.append(mensaje);
    }
  }

  //Mandar mensaje a la tabla de Movimientos.
  public void escribirEnTableroMovimiento(String mensaje) {
    TextAreaMovimientos.append(mensaje );
  }
  
 //Resetear la propiedad NumeroDado del jugador.
  public void resetDado(Jugador jugador) {
    jugador.setNumeroDado(0);
  }

  //Contar las vueltas y corregir la posición del jugador cuando da una vuelta al tablero.
  public void contadorVueltas(Jugador jugador) {
    if (jugador.getPosicion() > 23) {
      jugador.setPosicion((jugador.getPosicion()) - 24);
      setLocationFicha(jugador1, jugador2);
      jugador.setNumeroVueltas((jugador.getNumeroVueltas()) + 1);
      jugador.setDinero((jugador.getDinero()) + 20);
      escribirEnTableroMovimiento(jugador.getNombre() + " has dado una vuelta pasando por "
              + "la casilla de Inicio, te damos 20 Mm. \n");
      actualizarDinero(jugador1, jugador2);
    }
  }


  private void LabelNombreJugador1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LabelNombreJugador1PropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_LabelNombreJugador1PropertyChange

  private void LabelDineroJugador1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LabelDineroJugador1PropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_LabelDineroJugador1PropertyChange

  private void LabelDineroJugador2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LabelDineroJugador2PropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_LabelDineroJugador2PropertyChange

  private void ButtonMostrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMostrarMenuActionPerformed
    // TODO add your handling code here
    //Mostar/Ocutar menú de arriba
    if (Menu.isVisible() == false) {
      Menu.setVisible(true);
    } else {
      Menu.setVisible(false);
    }
    jugador1.setNumeroDado(4);
  }//GEN-LAST:event_ButtonMostrarMenuActionPerformed

  private void ButtonLanzarDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLanzarDadoActionPerformed
    // TODO add your handling code here
    //Lanzar dado, resetear el dado del otro jugador, comprobar si esta en la cárcel.
    
    boolean click = true;
    if (turno == 1) {
      if (jugador1.isCarcel() == false) {
        lanzarDado(jugador1);
        resetDado(jugador2);
      } else if (jugador1.isCarcel() == true) {
        click = false;
        lanzarDado(jugador1);
        resetDado(jugador2);
        if (jugador1.getNumeroDado() != 5) {
          escribirEnTableroMovimiento("No has sacado un 5, sigues en la cárcel =´( \n");
          resetDado(jugador1);
          turno = 2;
          turnoJugador(jugador2);
        } else if (jugador1.getNumeroDado() == 5) {
          escribirEnTableroMovimiento(jugador1.getNombre() + " saliste de la cárcel!! Felicidades =D \n");
          jugador1.setCarcel(false);
        }
      }
    }

    if ((turno == 2) && click == true) {
      if (jugador2.isCarcel() == false) {
        lanzarDado(jugador2);
        resetDado(jugador1);
      } else if (jugador2.isCarcel() == true) {
        lanzarDado(jugador2);
        resetDado(jugador1);
        if (jugador2.getNumeroDado() != 5) {
          escribirEnTableroMovimiento("No has sacado un 5, sigues en la cárcel =´( \n");
          turno = 1;
          turnoJugador(jugador1);
          resetDado(jugador2);
        } else if (jugador2.getNumeroDado() == 5) {
          escribirEnTableroMovimiento(jugador2.getNombre() + " saliste de la cárcel!! Felicidades =D \n");
          jugador2.setCarcel(false);
        }
      }

    }

  }//GEN-LAST:event_ButtonLanzarDadoActionPerformed

  private void ButtonMoverFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMoverFichaActionPerformed
    // TODO add your handling code here:
    //Mover la ficha y corregir errores.
    
    if (turno == 1) {
      if (jugador1.getNumeroDado() != 0) {
        setLocationFicha(jugador1, jugador2);
        moverFicha(jugador1, jugador1.getNumeroDado());
        turnoJugador(jugador2);
        LabelDado0.setVisible(true);
        turno = 2;
      }
      if (jugador1.getNumeroDado() == 0) {
        String mensaje = "Debes de tirar el dado antes de mover ficha!";
        String titulo = "Error";
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
      }
    } else if (turno == 2) {
      setLocationFicha(jugador1, jugador2);
      if (jugador2.getNumeroDado() != 0) {
        moverFicha(jugador2, jugador2.getNumeroDado());
        turnoJugador(jugador1);
        LabelDado0.setVisible(true);
        turno = 1;
      }
      if (jugador2.getNumeroDado() == 0) {
        String mensaje = "Debes de tirar el dado antes de mover ficha!";
        String titulo = "Error";
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_ButtonMoverFichaActionPerformed

  private void LabelFicha1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelFicha1MouseDragged
    // TODO add your handling code here:
  }//GEN-LAST:event_LabelFicha1MouseDragged

  private void LabelFicha1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelFicha1MouseClicked
    // TODO add your handling code here:
    //Mover ficha haciendo click en la ficha.
    if (turno == 1) {
      if (jugador1.getNumeroDado() != 0) {
        setLocationFicha(jugador1, jugador2);
        moverFicha(jugador1, jugador1.getNumeroDado());
        turnoJugador(jugador2);
        LabelDado0.setVisible(true);

      }
      if (jugador1.getNumeroDado() == 0) {
        String mensaje = "Debes de tirar el dado antes de mover ficha!";
        String titulo = "Error";
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
      }
    }
    if (turno == 2) {
      String mensaje = "No es tu turno!";
      String titulo = "Error";
      JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    turno = 2;
  }//GEN-LAST:event_LabelFicha1MouseClicked

  private void LabelFicha2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelFicha2MouseClicked
    // TODO add your handling code here:
     //Mover ficha haciendo click en la ficha.
    if (turno == 2) {
      if (jugador2.getNumeroDado() != 0) {
        setLocationFicha(jugador1, jugador2);
        moverFicha(jugador2, jugador2.getNumeroDado());
        turnoJugador(jugador1);
        LabelDado0.setVisible(true);

      }
      if (jugador2.getNumeroDado() == 0) {
        String mensaje = "Debes de tirar el dado antes de mover ficha!";
        String titulo = "Error";
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
      }
    }
    if (turno == 1) {
      String mensaje = "No es tu turno!";
      String titulo = "Error";
      JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    turno = 1;
  }//GEN-LAST:event_LabelFicha2MouseClicked

  private void ButtonGuardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarPartidaActionPerformed
    // TODO add your handling code here:
    //Guardar partida

    jugador1.setTurno(turno);
    jugador1.escribirArchivosGuardarPartida(jugador1, "datosJugador1.dat");
    jugador2.escribirArchivosGuardarPartida(jugador2, "datosJugador2.dat");
    JOptionPane.showMessageDialog(this, "Partida guardada correctamente =D");

  }//GEN-LAST:event_ButtonGuardarPartidaActionPerformed

  private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    // TODO add your handling code here:
    //Salir de la partida
    String[] opciones = {"Si", "No"};
      String mensaje = "¿Segur@ que quieres salir?";

       int opcion = JOptionPane.showOptionDialog(this, mensaje, "Pregunta", JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
       if(opcion == JOptionPane.YES_OPTION){
         dispose();
       }
    
  }//GEN-LAST:event_ButtonSalirActionPerformed

  private void GuardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarPartidaActionPerformed
    // TODO add your handling code here:
    //Guardar partida
     jugador1.setTurno(turno);
    jugador1.escribirArchivosGuardarPartida(jugador1, "datosJugador1.dat");
    jugador2.escribirArchivosGuardarPartida(jugador2, "datosJugador2.dat");
    JOptionPane.showMessageDialog(this, "Partida guardada correctamente =D");
  }//GEN-LAST:event_GuardarPartidaActionPerformed

  private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
    // TODO add your handling code here:
     //Salir de la partida
    String[] opciones = {"Si", "No"};
      String mensaje = "¿Segur@ que quieres salir?";

       int opcion = JOptionPane.showOptionDialog(this, mensaje, "Pregunta", JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
       if(opcion == JOptionPane.YES_OPTION){
         dispose();
       }
    
    
  }//GEN-LAST:event_SalirActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PantallaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PantallaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PantallaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PantallaTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PantallaTablero().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu Archivo;
  private javax.swing.JButton ButtonGuardarPartida;
  private javax.swing.JButton ButtonLanzarDado;
  private javax.swing.JButton ButtonMostrarMenu;
  private javax.swing.JButton ButtonMoverFicha;
  private javax.swing.JButton ButtonSalir;
  private javax.swing.JMenuItem GuardarPartida;
  private javax.swing.JLabel LabelDado0;
  private javax.swing.JLabel LabelDado1;
  private javax.swing.JLabel LabelDado2;
  private javax.swing.JLabel LabelDado3;
  private javax.swing.JLabel LabelDado4;
  private javax.swing.JLabel LabelDado5;
  private javax.swing.JLabel LabelDado6;
  private javax.swing.JLabel LabelDadoNumero1;
  private javax.swing.JLabel LabelDadoNumero2;
  private javax.swing.JLabel LabelDineroJugador1;
  private javax.swing.JLabel LabelDineroJugador2;
  private javax.swing.JLabel LabelFicha1;
  private javax.swing.JLabel LabelFicha2;
  private javax.swing.JLabel LabelFondo;
  private javax.swing.JLabel LabelNombreJugador1;
  private javax.swing.JLabel LabelNombreJugador2;
  private javax.swing.JLabel LabelTurnoJugador;
  private javax.swing.JMenuBar Menu;
  private javax.swing.JPanel PanelJuego;
  private javax.swing.JPanel PanelPrincipalFondo;
  private javax.swing.JMenuItem Salir;
  private javax.swing.JScrollPane ScrollPanelMovimientos;
  private javax.swing.JScrollPane ScrollPanelPropiedades1;
  private javax.swing.JScrollPane ScrollPanelPropiedades2;
  private javax.swing.JTextArea TextAreaMovimientos;
  private javax.swing.JTextArea TextAreaPropiedades1;
  private javax.swing.JTextArea TextAreaPropiedades2;
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables
}
