/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmMantenimientoCliente.java
 *
 * Created on 11/11/2011, 02:54:31 PM
 */
package ComponenteMantenimiento;

/*import ComponenteClase.Cliente;
import ComponenteConsulta.JDListaClientes;
import ComponenteDatos.*;
import ComponenteReportes.ReporteClienteParametro;*/
import ComponenteAdministracion.BD;
import ComponenteAdministracion.BDCliente;
import ComponenteAdministracion.BDTipoDocumentoCliente;
import ComponenteClases.Cliente;
import ComponenteConsulta.JDListaClientes;
import ComponenteReportes.ReporteClienteParametro;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author BADY RICHARD
 */
public class FrmMantenimientoCliente extends javax.swing.JFrame {

    String accion = "";

    /** Creates new form FrmMantenimientoCliente */
    public FrmMantenimientoCliente() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        obtenerUltimoId();
        this.setLocationRelativeTo(null);
        actualizarBusqueda();
        activarBotones(true);
        LBLMensajesoloNum.setVisible(false);
        btnModificarCli.setEnabled(false);
    }

    public void obtenerUltimoId() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(CB_idCliente) as Codigo from t_cbcliente");
            while (rs.next()) {
               int lastID = rs.getInt(1);
                txtCodigoCli.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

    public void limpiarCajatexto() {
        txtCodigoCli.setText("");
        txtNombreCli.setText("");
        txtApellidosCli.setText("");
        cboTipoDocumento.setSelectedItem("Seleccionar...");
        txtNroIdentifCli.setText("");
        txtOtrosCli.setText("");
    }

    public void activarCajatexto(boolean b) {
        txtCodigoCli.setEditable(!b);
        txtNombreCli.setEditable(b);
        txtApellidosCli.setEditable(b);
        txtNroIdentifCli.setEditable(b);
        txtOtrosCli.setEditable(b);
    }
    
    public void activarBotones(boolean b){
        btnNuevoCli.setEnabled(b);
        btnGuardarCli.setEnabled(!b);
        btnModificarCli.setEnabled(b);
        btnCancelarCli.setEnabled(!b);
        btnMostrarCli.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnNuevoCli = new javax.swing.JButton();
        btnGuardarCli = new javax.swing.JButton();
        btnModificarCli = new javax.swing.JButton();
        btnCancelarCli = new javax.swing.JButton();
        btnMostrarCli = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombreCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellidosCli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox();
        txtNroIdentifCli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOtrosCli = new javax.swing.JTextArea();
        LBLMensajesoloNum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalirCli = new javax.swing.JButton();
        btnImprimirCli = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtBuscarCli2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboParametroCli1 = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCliente1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        jLabel4.setText("REGISTRAR CLIENTE");

        btnNuevoCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/New document.png"))); // NOI18N
        btnNuevoCli.setText("NUEVO");
        btnNuevoCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliActionPerformed(evt);
            }
        });

        btnGuardarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Save.png"))); // NOI18N
        btnGuardarCli.setText("GUARDAR");
        btnGuardarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCliActionPerformed(evt);
            }
        });

        btnModificarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Modify.png"))); // NOI18N
        btnModificarCli.setText("MODIFICAR");
        btnModificarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCliActionPerformed(evt);
            }
        });

        btnCancelarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Erase.png"))); // NOI18N
        btnCancelarCli.setText("CANCELAR");
        btnCancelarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCliActionPerformed(evt);
            }
        });

        btnMostrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/List.png"))); // NOI18N
        btnMostrarCli.setText("MOSTRAR");
        btnMostrarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCliActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar los datos del Cliente"));

        jLabel2.setText("Código :");

        txtCodigoCli.setEditable(false);
        txtCodigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCliActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre :");

        txtNombreCli.setEditable(false);

        jLabel8.setText("Apellidos:");

        txtApellidosCli.setEditable(false);

        jLabel1.setText("Tipo documento:");

        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI" }));
        cboTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoDocumentoActionPerformed(evt);
            }
        });

        txtNroIdentifCli.setEditable(false);
        txtNroIdentifCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroIdentifCliKeyTyped(evt);
            }
        });

        jLabel11.setText("Otros Datos:");

        txtOtrosCli.setEditable(false);
        txtOtrosCli.setColumns(8);
        txtOtrosCli.setRows(5);
        txtOtrosCli.setTabSize(5);
        jScrollPane1.setViewportView(txtOtrosCli);

        LBLMensajesoloNum.setForeground(new java.awt.Color(255, 0, 0));
        LBLMensajesoloNum.setText("¡Ingrese sólo números!");

        jLabel3.setText("Número Doc:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNroIdentifCli, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txtNombreCli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigoCli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidosCli)
                    .addComponent(LBLMensajesoloNum, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtApellidosCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNroIdentifCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(LBLMensajesoloNum, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        btnSalirCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        btnSalirCli.setText("SALIR");
        btnSalirCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCliActionPerformed(evt);
            }
        });

        btnImprimirCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Hard disk.png"))); // NOI18N
        btnImprimirCli.setText("IMPRIMIR");
        btnImprimirCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimirCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimirCli, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirCli, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnImprimirCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoCli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalirCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(247, 254, 255));

        txtBuscarCli2.setForeground(new java.awt.Color(255, 0, 0));
        txtBuscarCli2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarCli2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarCli2MouseClicked(evt);
            }
        });
        txtBuscarCli2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCli2KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        jLabel5.setText("BUSCAR CLIENTE");

        cboParametroCli1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre" }));
        cboParametroCli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroCli1ActionPerformed(evt);
            }
        });

        jtCliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NIT", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtCliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCliente1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtCliente1MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jtCliente1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, 0, 308, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtBuscarCli2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroCli1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCli2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroCli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCliente1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCliente1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCliente1MouseEntered

    private void jtCliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCliente1MouseClicked
        // TODO add your handling code here:
        try {
            Cliente cli = BDCliente.buscarClienteCodigo(Integer.parseInt(String.valueOf(jtCliente1.getModel().getValueAt(jtCliente1.getSelectedRow(),0))));
            txtCodigoCli.setText(String.valueOf(cli.getnCliCodigo()));
            txtNombreCli.setText(cli.getcCliNombres());
            txtApellidosCli.setText(cli.getcCliApellidos());
            txtNroIdentifCli.setText(cli.getcNumeroIdentificacion());
            cboTipoDocumento.setSelectedItem((String)cli.getTipodocumentocli().getTipDescripcion());
            txtOtrosCli.setText(cli.getcOtrosDatos());
            btnModificarCli.setEnabled(true);
            btnCancelarCli.setEnabled(true);
            btnGuardarCli.setEnabled(false);
        } catch (SQLException ex) {
            //System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            System.out.println();
        }
    }//GEN-LAST:event_jtCliente1MouseClicked

    private void cboParametroCli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroCli1ActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroCli1ActionPerformed

    private void txtBuscarCli2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCli2KeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarCli2KeyReleased

    private void txtBuscarCli2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarCli2MouseClicked

    }//GEN-LAST:event_txtBuscarCli2MouseClicked

    private void btnImprimirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCliActionPerformed
        // TODO add your handling code here:
        //aqui se establecera un reporte por parametro
        if(txtCodigoCli.getText().compareTo("")!=0){
            try {
                Cliente verificaexiste=BDCliente.buscarClienteCodigo(Integer.parseInt(txtCodigoCli.getText()));
                if (verificaexiste !=null ) {
                    rClienPar = new ReporteClienteParametro();
                    rClienPar.runClienteParametro(Integer.parseInt(txtCodigoCli.getText()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmMantenimientoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnImprimirCliActionPerformed

    private void btnSalirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCliActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirCliActionPerformed

    private void txtNroIdentifCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroIdentifCliKeyTyped
        // TODO add your handling code here:
        if (Character.isLetter(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            LBLMensajesoloNum.setVisible(true);
        } else {
            LBLMensajesoloNum.setVisible(false);
        }
    }//GEN-LAST:event_txtNroIdentifCliKeyTyped

    private void btnMostrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCliActionPerformed
        // TODO add your handling code here:
        JDListaClientes jdlCliente = new JDListaClientes(this,true);
        jdlCliente.setVisible(true);
    }//GEN-LAST:event_btnMostrarCliActionPerformed

    private void btnCancelarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCliActionPerformed
        // TODO add your handling code here:
        limpiarCajatexto();
        activarCajatexto(false);
        activarBotones(true);
        obtenerUltimoId();
        txtCodigoCli.setEditable(false);
        btnModificarCli.setEnabled(false);
    }//GEN-LAST:event_btnCancelarCliActionPerformed

    private void btnModificarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCliActionPerformed
        // TODO add your handling code here:
        activarCajatexto(true);
        btnNuevoCli.setEnabled(false);
        btnGuardarCli.setEnabled(true);
        btnModificarCli.setEnabled(false);
        btnCancelarCli.setEnabled(true);
        btnMostrarCli.setEnabled(false);
        accion = "Actualizar";
    }//GEN-LAST:event_btnModificarCliActionPerformed

    private void btnGuardarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCliActionPerformed
        // TODO add your handling code here:
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNombreCli.getText().compareTo("") != 0) {
                if (txtOtrosCli.getText().length()<200) {
                    try {
                        Cliente cli = new Cliente();
                        cli.setcCliNombres(txtNombreCli.getText());
                        cli.setcCliApellidos(txtApellidosCli.getText());
                        cli.setcNumeroIdentificacion(txtNroIdentifCli.getText());
                        cli.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocClienteName((String) cboTipoDocumento.getSelectedItem()));
                        cli.setcCantidadVisitas(0);
                        cli.setcOtrosDatos(txtOtrosCli.getText());
                        BDCliente.insertarCliente(cli);
                        JOptionPane.showMessageDialog(null, "Cliente registrado");
                    } catch (SQLException e) {
                        System.out.println();
                    }
                    limpiarCajatexto();
                    obtenerUltimoId();
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad de letras debe ser menos de 200 en el campo Otros Datos!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el Nombre del Cliente!!");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Cliente cli;
            try {
                cli = BDCliente.buscarClienteCodigo(Integer.parseInt(txtCodigoCli.getText()));
                cli.setcCliNombres(txtNombreCli.getText());
                cli.setcCliApellidos(txtApellidosCli.getText());
                cli.setcNumeroIdentificacion(txtNroIdentifCli.getText());
                cli.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocClienteName((String) cboTipoDocumento.getSelectedItem()));
                cli.setcCantidadVisitas(0);
                cli.setcOtrosDatos(txtOtrosCli.getText());
                BDCliente.actualizarCliente(cli);
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
            } catch (SQLException e) {
                System.out.println();
            }
        }
    }//GEN-LAST:event_btnGuardarCliActionPerformed

    private void btnNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliActionPerformed
        // TODO add your handling code here:
        limpiarCajatexto();
        activarCajatexto(true);
        activarBotones(false);
        obtenerUltimoId();
        accion = "Guardar";
    }//GEN-LAST:event_btnNuevoCliActionPerformed

    private void cboTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoDocumentoActionPerformed

    private void txtCodigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCliActionPerformed

     private void actualizarBusqueda() {
        ArrayList<Cliente> result = null;
 if (String.valueOf(cboParametroCli1.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDCliente.listarClientePorNombre(txtNombreCli.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Cliente> list) {
        Object[][] datos = new Object[list.size()][3];
        int i = 0;
        for (Cliente cli : list) {
            datos[i][0] = cli.getnCliCodigo();
            datos[i][1] = cli.getcCliNombres(); 
            datos[i][2] = cli.getcCliApellidos();  
            i++;
        }
        jtCliente1.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO", "NOMBRE","APELLIDOS"
                }) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

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
            java.util.logging.Logger.getLogger(FrmMantenimientoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMantenimientoCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLMensajesoloNum;
    private javax.swing.JButton btnCancelarCli;
    private javax.swing.JButton btnGuardarCli;
    private javax.swing.JButton btnImprimirCli;
    private javax.swing.JButton btnModificarCli;
    private javax.swing.JButton btnMostrarCli;
    private javax.swing.JButton btnNuevoCli;
    private javax.swing.JButton btnSalirCli;
    private javax.swing.JComboBox cboParametroCli1;
    private javax.swing.JComboBox cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtCliente1;
    private javax.swing.JTextField txtApellidosCli;
    private javax.swing.JTextField txtBuscarCli2;
    private javax.swing.JTextField txtCodigoCli;
    private javax.swing.JTextField txtNombreCli;
    private javax.swing.JTextField txtNroIdentifCli;
    private javax.swing.JTextArea txtOtrosCli;
    // End of variables declaration//GEN-END:variables
   private ReporteClienteParametro rClienPar;
}