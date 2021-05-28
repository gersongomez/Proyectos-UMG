/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.datos.Conexion;
import Finanzas.datos.EncabezadoAsientoDAO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.util.List;
import javax.swing.UIManager;
import Finanzas.datos.MonedaDAO;
import Finanzas.dominio.EncabezadoAsiento;
import Finanzas.dominio.Moneda;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Login;
/**
 *
 * @author Carlos Castillo
 */
public class Transaccion_EncabezadoAsiento extends javax.swing.JFrame {
       int codigoAplicacion = 1102;

    public void llenadoDeCombos() throws SQLException  {
       MonedaDAO moneda = new MonedaDAO();
      List<Moneda> tipo = moneda.listar();
      CbMoneda.addItem("Seleccione una opción");
      for (int i = 0; i < tipo.size(); i++) {
           CbMoneda.addItem(tipo.get(i).getCodigo_Moneda());
       }
 }
    
   public void llenadoDeTablas() throws SQLException  {
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("Codigo");
       modelo.addColumn("Fecha");
       modelo.addColumn("Moneda");
       modelo.addColumn("Descripcion");


       EncabezadoAsientoDAO EncADAO = new EncabezadoAsientoDAO();
       List<EncabezadoAsiento> cuenta = EncADAO.select();
       Tabla.setModel(modelo);
       String[] dato = new String[8];
       for (int i = 0; i < cuenta.size(); i++) {
           dato[0] = cuenta.get(i).getCodigoEA();
           dato[1] = cuenta.get(i).getFecha();
           dato[2] = cuenta.get(i).getMoneda();
           dato[3] = cuenta.get(i).getDescripcion();

    
           modelo.addRow(dato);
       }
   }
   public void limpiar() {
       txtCod.setText("");
       JdA.setDate(null);
       txtADes.setText("");
   }
    /**
     * Creates new form FrmNuevoEncabezadoAsiento
     */
    public Transaccion_EncabezadoAsiento() throws SQLException {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JdA = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        CbMoneda = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADes = new javax.swing.JTextArea();
        BtnIng = new javax.swing.JButton();
        BtnMod = new javax.swing.JButton();
        BtnElim = new javax.swing.JButton();
        BtnBus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setTitle("Nuevo Encabezado de Asiento Contable");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Nuevo Encabezado Contable");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código Encabezado:");

        jLabel3.setText("Fecha Asiento Contable:");

        JdA.setBackground(new java.awt.Color(255, 255, 255));
        JdA.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setText("Moneda Asiento Contable:");

        jLabel5.setText("Descripción Asiento Contable:");

        txtADes.setColumns(20);
        txtADes.setRows(5);
        jScrollPane1.setViewportView(txtADes);

        BtnIng.setText("Agregar");
        BtnIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngActionPerformed(evt);
            }
        });

        BtnMod.setText("Modificar");
        BtnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModActionPerformed(evt);
            }
        });

        BtnElim.setText("Eliminar");
        BtnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnElimActionPerformed(evt);
            }
        });

        BtnBus.setText("Buscar");
        BtnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusActionPerformed(evt);
            }
        });

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JdA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCod)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnIng, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnElim, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnBus, BtnElim, BtnIng, BtnMod, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JdA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnIng)
                    .addComponent(BtnMod)
                    .addComponent(BtnElim)
                    .addComponent(BtnBus)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Ingresar");
        AInsertar.setCodigoAplicacion("1102");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        EncabezadoAsiento EAI = new EncabezadoAsiento();
        EncabezadoAsientoDAO EADAO = new EncabezadoAsientoDAO();
        if (txtCod.getText().length() != 0 && txtADes.getText().length() != 0) {
            {
                String Fecha = new SimpleDateFormat("dd/MM/yyyy").format(JdA.getDate());
                EAI.setCodigoEA((txtCod.getText()));
                EAI.setFecha(Fecha);
                EAI.setMoneda((String) CbMoneda.getSelectedItem()); 
                EAI.setDescripcion(txtADes.getText());
                {
                    JOptionPane.showMessageDialog(null, "Registrado Exitosamente");
                }
                limpiar();
                EADAO.insert(EAI);
                try {
                    llenadoDeTablas();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            try {
                llenadoDeTablas();
            } catch (SQLException ex) {
                Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            llenadoDeTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnIngActionPerformed

    private void BtnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnElimActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Eliminar");
        AInsertar.setCodigoAplicacion("1102");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
          }        
        EncabezadoAsiento EAE = new EncabezadoAsiento();
        EncabezadoAsientoDAO EADAO = new EncabezadoAsientoDAO();

        EAE.setCodigoEA((txtCod.getText()));
        int salida = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Advertencia de eliminacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        System.out.println(salida);
        if (salida == 0) {
            EADAO.delete(EAE);
            JOptionPane.showMessageDialog(null, "Registro Eliminado.");
        }
        else {
            JOptionPane.showMessageDialog(null, "El registro no se ha eliminado");
        }
        try {
            llenadoDeTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpiar();
    }//GEN-LAST:event_BtnElimActionPerformed

    private void BtnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Modificar");
        AInsertar.setCodigoAplicacion("1102");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
          }
        EncabezadoAsiento EAM = new EncabezadoAsiento();
        EncabezadoAsientoDAO EADAO = new EncabezadoAsientoDAO();
        String Fecha = new SimpleDateFormat("dd/MM/yyyy").format(JdA.getDate());
        
        EAM.setCodigoEA(txtCod.getText());
        EAM.setFecha(Fecha);
        EAM.setMoneda((String) CbMoneda.getSelectedItem());
        EAM.setDescripcion(txtADes.getText());
        EAM.setCodigoEA((txtCod.getText()));
        
        EADAO.update(EAM);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        try {
            llenadoDeTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnModActionPerformed

    private void BtnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Buscar");
        AInsertar.setCodigoAplicacion("1102");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
          }
        EncabezadoAsiento EAB = new EncabezadoAsiento();
        EncabezadoAsientoDAO EADAO = new EncabezadoAsientoDAO();
        EAB.setCodigoEA((txtCod.getText()));
        
        EAB = EADAO.query(EAB);
        
        txtCod.setText(String.valueOf(EAB.getCodigoEA()));
        String Fecha = String.valueOf(EAB.getFecha());
        SimpleDateFormat modelo = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date Fecha1 = modelo.parse(Fecha);
            JdA.setDate(Fecha1);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }
        CbMoneda.setSelectedItem(EAB.getMoneda());
        txtADes.setText(String.valueOf(EAB.getDescripcion()));
        

        {
            JOptionPane.showMessageDialog(null, "Registro encontrado");
        }
        try {        
            llenadoDeTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnBusActionPerformed
private Connection connection = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Imprimir");
        AInsertar.setCodigoAplicacion("1102");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
          }
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/Finanzas/reportes/ReporteTransEncabezadoAsiento.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Transaccional Encabezado Asiento");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FLATLAF
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Transaccion_EncabezadoAsiento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Transaccion_EncabezadoAsiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBus;
    private javax.swing.JButton BtnElim;
    private javax.swing.JButton BtnIng;
    private javax.swing.JButton BtnMod;
    private javax.swing.JComboBox<String> CbMoneda;
    private com.toedter.calendar.JDateChooser JdA;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtADes;
    private javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables
}
