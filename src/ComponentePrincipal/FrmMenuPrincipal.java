/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmMenuPrincipal.java
 *
 * Created on 18/11/2011, 04:26:25 AM
 */
package ComponentePrincipal;

/*import ComponenteConsulta.*;
import ComponenteMantenimiento.*;
import ComponenteReportes.*;*/
import ComponenteConsulta.FrmConsultaCliente;
import ComponenteConsulta.FrmConsultaObservacion;
import ComponenteConsulta.FrmConsultaReservacion;
import ComponenteConsulta.JDBuscarCliente;
import ComponenteConsulta.JDListaClientes;
import ComponenteMantenimiento.FrmMantenimientoCliente;
import ComponenteMantenimiento.FrmMantenimientoCochera;
import ComponenteMantenimiento.FrmMantenimientoHabitacion;
import ComponenteMantenimiento.FrmMantenimientoObservacion;
import ComponenteMantenimiento.FrmMantenimientoRegistroHab;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author BADY RICHARD
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /** Creates new form FrmMenuPrincipal */
    public FrmMenuPrincipal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        //this.setLocationRelativeTo(null);
         this.setExtendedState(FrmMenuPrincipal.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Habitaciones - Hotel Casa Blanca");
    }

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String retornarMes(int numero) {
        String descmes = "";
        switch (numero) {
            case 1:
                descmes = "ENERO";
                break;
            case 2:
                descmes = "FEBRERO";
                break;
            case 3:
                descmes = "MARZO";
                break;
            case 4:
                descmes = "ABRIL";
                break;
            case 5:
                descmes = "MAYO";
                break;
            case 6:
                descmes = "JUNIO";
                break;
            case 7:
                descmes = "JULIO";
                break;
            case 8:
                descmes = "AGOSTO";
                break;
            case 9:
                descmes = "SEPTEMBRE";
                break;
            case 10:
                descmes = "OCTOBRE";
                break;
            case 11:
                descmes = "NOVIEMBRE";
                break;
            case 12:
                descmes = "DICIEMBRE";
                break;
        }
        return descmes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Escritorio = new javax.swing.JDesktopPane();
        lblCorreo = new javax.swing.JLabel();
        lblNombreVendedor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCodigoUser = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mOpciones = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        agregaCliente = new javax.swing.JMenuItem();
        consultaCliente = new javax.swing.JMenuItem();
        miListaReq = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        controlHabitacion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        consultaCochera = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        reservaHab = new javax.swing.JMenuItem();
        consultaReser = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        agregaObservacion = new javax.swing.JMenuItem();
        consultaObser = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE RESERVACIONES CASA BLANCA - V 1.0.1");
        setBackground(new java.awt.Color(70, 99, 138));
        setForeground(java.awt.Color.gray);

        Escritorio.setBackground(new java.awt.Color(70, 99, 138));
        Escritorio.setName("Escritorio"); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCorreo.setText("Correo");
        Escritorio.add(lblCorreo);
        lblCorreo.setBounds(110, 130, 320, 22);

        lblNombreVendedor.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVendedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreVendedor.setText("NOMBRE DE USUARIO");
        Escritorio.add(lblNombreVendedor);
        lblNombreVendedor.setBounds(110, 10, 300, 22);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FECHA ACTUAL :");
        Escritorio.add(jLabel5);
        jLabel5.setBounds(10, 190, 120, 20);

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        Escritorio.add(jLabel6);
        jLabel6.setBounds(140, 190, 162, 20);

        jLabel8.setFont(new java.awt.Font("AR JULIAN", 1, 46)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(247, 254, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HOTEL CASA BLANCA");
        Escritorio.add(jLabel8);
        jLabel8.setBounds(340, 240, 496, 59);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombres:");
        Escritorio.add(jLabel3);
        jLabel3.setBounds(10, 10, 90, 22);

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellidos:");
        Escritorio.add(jLabel4);
        jLabel4.setBounds(10, 40, 90, 22);

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DNI:");
        Escritorio.add(jLabel9);
        jLabel9.setBounds(10, 70, 40, 22);

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Celular:");
        Escritorio.add(jLabel10);
        jLabel10.setBounds(10, 100, 66, 22);

        lblCodigoUser.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblCodigoUser.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCodigoUser.setText("CodUser");
        Escritorio.add(lblCodigoUser);
        lblCodigoUser.setBounds(110, 160, 70, 22);

        lblApellidos.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblApellidos.setText("Apellidos");
        Escritorio.add(lblApellidos);
        lblApellidos.setBounds(110, 40, 250, 22);

        lblDni.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        lblDni.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDni.setText("DNI");
        Escritorio.add(lblDni);
        lblDni.setBounds(110, 70, 180, 22);

        lblCelular.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblCelular.setForeground(new java.awt.Color(255, 255, 255));
        lblCelular.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCelular.setText("Celular");
        Escritorio.add(lblCelular);
        lblCelular.setBounds(110, 100, 180, 22);

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Codigo:");
        Escritorio.add(jLabel12);
        jLabel12.setBounds(10, 160, 70, 22);

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Correo:");
        Escritorio.add(jLabel13);
        jLabel13.setBounds(10, 130, 70, 22);

        mOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mOpciones.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        mOpciones.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        mOpciones.setPreferredSize(new java.awt.Dimension(0, 90));
        mOpciones.setRequestFocusEnabled(false);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1291627904_home.png"))); // NOI18N
        jMenu3.setText("INICIO");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setMargin(new java.awt.Insets(0, 21, 0, 0));
        jMenu3.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        miSalir.setText("SALIR");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenu3.add(miSalir);

        mOpciones.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Contact.png"))); // NOI18N
        jMenu1.setText("CLIENTE");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jMenu1.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        agregaCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        agregaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Create.png"))); // NOI18N
        agregaCliente.setText("Agrega cliente");
        agregaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregaClienteActionPerformed(evt);
            }
        });
        jMenu1.add(agregaCliente);

        consultaCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        consultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Search.png"))); // NOI18N
        consultaCliente.setText("Consultar cliente");
        consultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaClienteActionPerformed(evt);
            }
        });
        jMenu1.add(consultaCliente);

        miListaReq.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        miListaReq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/List.png"))); // NOI18N
        miListaReq.setText("Listar Clientes");
        miListaReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListaReqActionPerformed(evt);
            }
        });
        jMenu1.add(miListaReq);

        mOpciones.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/House.png"))); // NOI18N
        jMenu4.setText("HABITACIÓN");
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setMargin(new java.awt.Insets(0, 8, 0, 0));
        jMenu4.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        controlHabitacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        controlHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Notes.png"))); // NOI18N
        controlHabitacion.setText("Control habitacion");
        controlHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlHabitacionActionPerformed(evt);
            }
        });
        jMenu4.add(controlHabitacion);

        mOpciones.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/compra3.png"))); // NOI18N
        jMenu2.setText("COCHERA");
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setMargin(new java.awt.Insets(0, 15, 0, 0));
        jMenu2.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu2.setPreferredSize(new java.awt.Dimension(75, 31));
        jMenu2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        consultaCochera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        consultaCochera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Delivery.png"))); // NOI18N
        consultaCochera.setText("Consulta cochera");
        consultaCochera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCocheraActionPerformed(evt);
            }
        });
        jMenu2.add(consultaCochera);
        consultaCochera.getAccessibleContext().setAccessibleDescription("ctrl+c");

        mOpciones.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Paste.png"))); // NOI18N
        jMenu5.setText("RESERVAR");
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setMargin(new java.awt.Insets(0, 12, 0, 0));
        jMenu5.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu5.setPreferredSize(new java.awt.Dimension(100, 30));
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        reservaHab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        reservaHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Home.png"))); // NOI18N
        reservaHab.setText("Reservar habitacion");
        reservaHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservaHabActionPerformed(evt);
            }
        });
        jMenu5.add(reservaHab);

        consultaReser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        consultaReser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Find.png"))); // NOI18N
        consultaReser.setText("Consultar reservacion");
        consultaReser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaReserActionPerformed(evt);
            }
        });
        jMenu5.add(consultaReser);

        mOpciones.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/mantenimiento2.png"))); // NOI18N
        jMenu6.setText("OBSERVACIÓN");
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        agregaObservacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        agregaObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Modify.png"))); // NOI18N
        agregaObservacion.setText("Agregar observacion");
        agregaObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregaObservacionActionPerformed(evt);
            }
        });
        jMenu6.add(agregaObservacion);

        consultaObser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        consultaObser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Text preview.png"))); // NOI18N
        consultaObser.setText("Consultar observacion");
        consultaObser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaObserActionPerformed(evt);
            }
        });
        jMenu6.add(consultaObser);

        mOpciones.add(jMenu6);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1291628569_system-help.png"))); // NOI18N
        jMenu8.setText("AYUDA");
        jMenu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu8.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jMenu8.setMaximumSize(new java.awt.Dimension(95, 32767));
        jMenu8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mOpciones.add(jMenu8);

        setJMenuBar(mOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_miSalirActionPerformed

    private void agregaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregaClienteActionPerformed
        
             FrmMantenimientoCliente frmC = new FrmMantenimientoCliente();
        frmC.setVisible(true);
        
    }//GEN-LAST:event_agregaClienteActionPerformed

    private void consultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaClienteActionPerformed
        // TODO add your handling code here:
        try {
             FrmConsultaCliente frmC = new FrmConsultaCliente();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_consultaClienteActionPerformed

    private void controlHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlHabitacionActionPerformed
        try {
             FrmMantenimientoHabitacion frmC = new FrmMantenimientoHabitacion();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_controlHabitacionActionPerformed

    private void miListaReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListaReqActionPerformed
        // TODO add your handling code here:
     try {
             JDListaClientes frmC = new JDListaClientes(this,true);
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_miListaReqActionPerformed

    private void reservaHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservaHabActionPerformed
        // TODO add your handling code here:
      try {
             FrmMantenimientoRegistroHab frmC = new FrmMantenimientoRegistroHab();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_reservaHabActionPerformed

    private void consultaReserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaReserActionPerformed
        // TODO add your handling code here:
     try {
             FrmConsultaReservacion frmC = new FrmConsultaReservacion();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_consultaReserActionPerformed

    private void agregaObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregaObservacionActionPerformed
        // TODO add your handling code here:
     try {
             FrmMantenimientoObservacion frmC = new FrmMantenimientoObservacion();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_agregaObservacionActionPerformed

    private void consultaObserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaObserActionPerformed
        // TODO add your handling code here:
     try {
             FrmConsultaObservacion frmC = new FrmConsultaObservacion();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_consultaObserActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void consultaCocheraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCocheraActionPerformed
        // TODO add your handling code here:
        try {
             FrmMantenimientoCochera frmC = new FrmMantenimientoCochera();
        frmC.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_consultaCocheraActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem agregaCliente;
    private javax.swing.JMenuItem agregaObservacion;
    private javax.swing.JMenuItem consultaCliente;
    private javax.swing.JMenuItem consultaCochera;
    private javax.swing.JMenuItem consultaObser;
    private javax.swing.JMenuItem consultaReser;
    private javax.swing.JMenuItem controlHabitacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    public javax.swing.JLabel lblApellidos;
    public javax.swing.JLabel lblCelular;
    public javax.swing.JLabel lblCodigoUser;
    public javax.swing.JLabel lblCorreo;
    public javax.swing.JLabel lblDni;
    public javax.swing.JLabel lblNombreVendedor;
    private javax.swing.JMenuBar mOpciones;
    private javax.swing.JMenuItem miListaReq;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem reservaHab;
    // End of variables declaration//GEN-END:variables
    /*private ReporteListaCliente repListaCli;
    private ReporteListaProducto repListaPro;
    private ReporteVentaGeneralDia rVentaGeneralDia;
    private ReporteVentaGeneralDiaContado rVentaGDContado;
    private ReporteVentaGeneralDiaCredito rVentaGDCredito;
    private ReporteVentasPorMesContado rVentaPMContado;
    private ReporteVentasPorMesCredito rVentaPMCredito;
    private ReporteVentasPorMesGeneral rVentaPMGeneral;
    private ReporteVentasPorAnualContado rVentaPAContado;
    private ReporteVentasPorAnualCredito rVentaPACredito;
    private ReporteVentasPorAnualGeneral rVentaPAGeneral;*/
    public String fecha;
    public String anual;
    public int mes;
}