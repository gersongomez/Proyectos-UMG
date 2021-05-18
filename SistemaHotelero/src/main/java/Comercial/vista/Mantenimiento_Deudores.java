/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.DeudoresDAO;
import Comercial.dominio.Deudores;
import Comercial.datos.Conexion;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
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
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;
import seguridad.vista.MDI_Components;

/**
 *
 * @author PERSONAL
 */
public class Mantenimiento_Deudores extends javax.swing.JInternalFrame {
     void habilitarAcciones() {

      int   codigoAplicacion = 3002;
        var usuario = Login.usuarioComercial;

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[4];

        for (int i = 0; i < 4; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            btnAgregar.setEnabled(true);
        }
        if (permisosApp[1].equals("0")) {
            btnBuscar.setEnabled(true);
        }
        if (permisosApp[2].equals("0")) {
            btnModificar.setEnabled(true);
        }
        if (permisosApp[3].equals("0")) {
            btnEliminar.setEnabled(false);
        }
    }

public void llenadoDeTablas() {
        /**
 *
 * creaccion de la tabla de de titulos  
 */
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Acreedores");
        modelo.addColumn("Acreedores");
        modelo.addColumn("Nit");
          modelo.addColumn("Monto");
          modelo.addColumn("Estatus");
          modelo.addColumn("Telefono");
           modelo.addColumn("Producto");
       
  
     DeudoresDAO  ventasDAO = new   DeudoresDAO ();
  


       List<Deudores> ventas = ventasDAO.select();
        JtProductos1.setModel(modelo);
        String[] dato = new String[7];
    for (int i = 0; i < ventas.size(); i++) {
            dato[0] = (ventas.get(i).getId_Acreedores());
            dato[1] = ventas.get(i).getAcreedores();
              dato[2] = ventas.get(i).getNit();
            dato[3] = (ventas.get(i).getMonto());
          dato[4] = (ventas.get(i).getEstatus_Cliente());
            dato[5] = (ventas.get(i).getTelefono());
            dato[6] = ventas.get(i).getProducto();
          
          
            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
     }
  public void buscarVendedor() {
     
   
     DeudoresDAO Clientes= new  DeudoresDAO ();
            
         Deudores Buscar = new  Deudores();


Buscar.setId_Acreedores(i.getText());
Buscar=Clientes.query(Buscar);         
cliente.setText(Buscar.getAcreedores());

ID.setText(Buscar.getId_Acreedores());
nit.setText(Buscar.getNit());
monto.setText(Buscar.getMonto());
estatus.setText(Buscar.getEstatus_Cliente());
telefono.setText(Buscar.getTelefono());
producto.setText(Buscar.getProducto());
  
    }
    /**
     * Creates new form Mantenimiento_Acreedor
     */
    public void limpiar() {
        ID.setText("");
        cliente.setText("");
        nit.setText("");
        monto.setText("");
        estatus.setText("");
        telefono.setText("");
           producto.setText("");
    }
    public Mantenimiento_Deudores() {
        initComponents();
        habilitarAcciones();
         llenadoDeTablas() ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        i = new javax.swing.JTextField();
        cliente = new javax.swing.JTextField();
        monto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        producto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtProductos1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        estatus = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento Deudor\n\n");

        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText(" Producto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento Deudores");

        nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Estatus de Deudores");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID Deudores");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Capital");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Deudores");

        JtProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtProductos1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nit");

        estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estatusActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(22, 22, 22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(338, 338, 338))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(65, 65, 65)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar)
                    .addComponent(btnBuscar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\Clientes.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\Clientes.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nitActionPerformed

    private void estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estatusActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DeudoresDAO acreedor = new DeudoresDAO ();

        Deudores vendedorAEliminar = new Deudores();
        vendedorAEliminar.setId_Acreedores(ID.getText());
        vendedorAEliminar.setAcreedores(cliente.getText());
        vendedorAEliminar.setNit(nit.getText());
        vendedorAEliminar.setMonto(monto.getText());
        vendedorAEliminar.setEstatus_Cliente(estatus.getText());
        vendedorAEliminar.setTelefono(telefono.getText());
        vendedorAEliminar.setProducto(producto.getText());
        acreedor.delete(vendedorAEliminar);
        llenadoDeTablas();
        JOptionPane.showMessageDialog(null, "Acreedor Eliminado.");
        limpiar();
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora AInsertar = new Bitacora();

       
        AInsertar.setAccion("Eliminar");
         GenerarPermisos permisos = new GenerarPermisos();
    MDI_Components mdi_Components = new MDI_Components();
 AInsertar.setCodigoAplicacion("3002");
           AInsertar.setModulo("3000");
 AInsertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        buscarVendedor();
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora AInsertar = new Bitacora();

       
        AInsertar.setAccion("Buscar");
         GenerarPermisos permisos = new GenerarPermisos();
    MDI_Components mdi_Components = new MDI_Components();
 AInsertar.setCodigoAplicacion("3002");
           AInsertar.setModulo("3000");
 AInsertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       DeudoresDAO dao = new   DeudoresDAO  ();

        Deudores  modificar = new   Deudores ();
        modificar.setId_Acreedores (ID.getText());
        modificar.setAcreedores(cliente.getText());
        modificar.setNit(nit.getText());
        modificar.setMonto(monto.getText());
        modificar.setEstatus_Cliente(estatus.getText());
        modificar.setTelefono(telefono.getText());
        modificar.setProducto(producto.getText());

        dao.update(modificar);
        llenadoDeTablas();
        limpiar();
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora AInsertar = new Bitacora();

      
        AInsertar.setAccion("Modificar");
   GenerarPermisos permisos = new GenerarPermisos();
    MDI_Components mdi_Components = new MDI_Components();
 AInsertar.setCodigoAplicacion("3002");
           AInsertar.setModulo("3000");
 AInsertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        DeudoresDAO    AcreedoresDAO = new   DeudoresDAO  ();

        Deudores  AInsertar = new   Deudores ();
        AInsertar.setId_Acreedores(ID.getText());
        AInsertar.setAcreedores(cliente.getText());
        AInsertar.setNit(nit.getText());
        AInsertar.setMonto(monto.getText());
        AInsertar.setEstatus_Cliente(estatus.getText());
        AInsertar.setTelefono(telefono.getText());
        AInsertar.setProducto(producto.getText());
        AcreedoresDAO.insert(AInsertar);
        llenadoDeTablas();
        limpiar();
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();

      
        Insertar.setAccion("insertar");
          GenerarPermisos permisos = new GenerarPermisos();
    MDI_Components mdi_Components = new MDI_Components();
 Insertar.setCodigoAplicacion("3002");
           Insertar.setModulo("3000");
 Insertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed
private Connection connection = null;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                + "/src/main/java/Comercial/reportes/MantenimientoDeudor.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("deudor ");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField ID;
    private static javax.swing.JTable JtProductos1;
    private static javax.swing.JButton btnAgregar;
    private static javax.swing.JButton btnBuscar;
    private static javax.swing.JButton btnEliminar;
    private static javax.swing.JButton btnModificar;
    private static javax.swing.ButtonGroup buttonGroup1;
    private static javax.swing.JTextField cliente;
    private static javax.swing.JTextField estatus;
    private static javax.swing.JTextField i;
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel8;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField monto;
    private static javax.swing.JTextField nit;
    private static javax.swing.JTextField producto;
    private static javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
