/*
 * InicioForm.java
 */
package forms;

import dtos.DetalleVentaDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import dtos.UsuarioVentaDTO;
import dtos.VentaDTO;
import excepciones.NegocioException;
import interfaces.IControlComprasBO;
import interfaces.IControlUsuarioBO;
import interfaces.IControlVentasBO;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ControlComprasBO;
import negocio.ControlUsuarioBO;
import negocio.ControlVentasBO;
import pojos.MetodoPago;
import pojos.Puesto;
import utilidades.JButtonCellEditor;
import utilidades.JButtonRenderer;

/**
 *
 * @author Juventino López García
 */
public class InicioForm extends javax.swing.JFrame {

    private IControlVentasBO controlVentas = new ControlVentasBO();
    private IControlUsuarioBO controlUsuarios = new ControlUsuarioBO();
    private IControlComprasBO controlCompras = new ControlComprasBO();
    private float total;

    private UsuarioDTO usuario;
    private List<DetalleVentaDTO> detallesVenta;

    /**
     * Creates new form VentaForn
     *
     * @param usuario
     */
    public InicioForm(UsuarioDTO usuario) {
        initComponents();
        this.usuario = usuario;
        detallesVenta = new ArrayList<>();

        if (usuario.getPuesto().equals(Puesto.CAJERO))
            inicioCajero();
        ActionListener onEditarClickListener = (java.awt.event.ActionEvent e) -> {
            eliminarDetalle();
            this.ventaTabla.clearSelection();
        };

        ventaTabla.getColumnModel().getColumn(5).setCellRenderer(new JButtonRenderer("Eliminar"));
        ventaTabla.getColumnModel().getColumn(5).setCellEditor(new JButtonCellEditor("Eliminar", onEditarClickListener));

        llenarTablaVenta();
    }

    private void inicioCajero() {
        jMenuBar1.remove(usuariosMenu);
        jMenuBar1.remove(comprasMenu);
        productosMenu.remove(resgistrarProductoMenuItem);
    }
    
    private void llenarTablaVenta() {
        DefaultTableModel modeloTabla = (DefaultTableModel) ventaTabla.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        if (detallesVenta != null) {
            detallesVenta.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getCodigoProducto();
                fila[1] = row.getNombreProducto();
                fila[2] = row.getPrecio();
                fila[3] = row.getCantidad();
                row.setTotal(row.getCantidad() * row.getPrecio());
                fila[4] = row.getTotal();

                modeloTabla.addRow(fila);
            });
        }
    }

    private void agregarDetalleTabla() {
        AgregarProductoDlg dlg = new AgregarProductoDlg(this, false);
        dlg.setVisible(true);

        ProductoDTO producto = dlg.getProducto();
        Integer cantidad = dlg.getCantidad();
        if (producto != null) {
            dlg.dispose();
            if (detallesVenta.stream().anyMatch((d) -> d.getCodigoProducto().equals(producto.getCodigo()))) {
                for (DetalleVentaDTO detalleVentaDTO : detallesVenta) {
                    if (detalleVentaDTO.getCodigoProducto().equals(producto.getCodigo())) {
                        detalleVentaDTO.setCantidad(detalleVentaDTO.getCantidad() + cantidad);
                    }
                }

            } else {
                DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO(producto.getCodigo(), producto.getNombre(), producto.getPrecio(), cantidad);
                detallesVenta.add(detalleVentaDTO);
            }

            llenarTablaVenta();
            calcularTotal();
        }
    }

    private void eliminarDetalle() {
        String codigo = (String) ventaTabla.getModel().getValueAt(ventaTabla.getSelectedRow(), 0);
        detallesVenta.removeIf((detalle) -> detalle.getCodigoProducto().equals(codigo));
        int indiceFila = ventaTabla.getSelectedRow();
        ventaTabla.clearSelection();
        ventaTabla.setRowSelectionInterval(indiceFila, indiceFila);

        llenarTablaVenta();
        calcularTotal();
    }

    private UsuarioVentaDTO detallesUsuarioVenta() {
        UsuarioVentaDTO usuarioVentaDTO = new UsuarioVentaDTO();
        usuarioVentaDTO.setRfc(usuario.getRfc());
        usuarioVentaDTO.setNombre(usuario.getNombre());
        usuarioVentaDTO.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioVentaDTO.setApellidoMaterno(usuario.getApellidoMaterno());

        return usuarioVentaDTO;
    }

    private void calcularTotal() {
        total = 0;
        for (DetalleVentaDTO detalleVentaDTO : detallesVenta) {
            total += detalleVentaDTO.getTotal();
        }
        totalLbl.setText(String.valueOf(total));
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
        agregarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventaTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        finalizarBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ventasMenu = new javax.swing.JMenu();
        buscarVentasMenuItem = new javax.swing.JMenuItem();
        ventasDiaMenuItem = new javax.swing.JMenuItem();
        comprasMenu = new javax.swing.JMenu();
        buscarCompraMenuItem = new javax.swing.JMenuItem();
        registrarCompraMenuItem = new javax.swing.JMenuItem();
        productosMenu = new javax.swing.JMenu();
        buscarProductosMenuItem = new javax.swing.JMenuItem();
        resgistrarProductoMenuItem = new javax.swing.JMenuItem();
        usuariosMenu = new javax.swing.JMenu();
        buscarUsuarioMenuItem = new javax.swing.JMenuItem();
        registrarUsuarioMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Registrar Venta");

        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        ventaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio", "Cantidad", "Total", " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ventaTabla.setColumnSelectionAllowed(true);
        ventaTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ventaTabla);
        ventaTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (ventaTabla.getColumnModel().getColumnCount() > 0) {
            ventaTabla.getColumnModel().getColumn(0).setResizable(false);
            ventaTabla.getColumnModel().getColumn(1).setResizable(false);
            ventaTabla.getColumnModel().getColumn(2).setResizable(false);
            ventaTabla.getColumnModel().getColumn(3).setResizable(false);
            ventaTabla.getColumnModel().getColumn(4).setResizable(false);
            ventaTabla.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setText("Total a pagar:  $");

        totalLbl.setText("0");

        finalizarBtn.setText("Finalizar");
        finalizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarBtnActionPerformed(evt);
            }
        });

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(600, 48));

        ventasMenu.setText("Ventas");

        buscarVentasMenuItem.setText("Buscar");
        buscarVentasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarVentasMenuItemActionPerformed(evt);
            }
        });
        ventasMenu.add(buscarVentasMenuItem);

        ventasDiaMenuItem.setText("Ventas del Día");
        ventasDiaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasDiaMenuItemActionPerformed(evt);
            }
        });
        ventasMenu.add(ventasDiaMenuItem);

        jMenuBar1.add(ventasMenu);

        comprasMenu.setText("Compras");

        buscarCompraMenuItem.setText("Buscar");
        buscarCompraMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCompraMenuItemActionPerformed(evt);
            }
        });
        comprasMenu.add(buscarCompraMenuItem);

        registrarCompraMenuItem.setText("Registrar");
        registrarCompraMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCompraMenuItemActionPerformed(evt);
            }
        });
        comprasMenu.add(registrarCompraMenuItem);

        jMenuBar1.add(comprasMenu);

        productosMenu.setText("Productos");

        buscarProductosMenuItem.setText("Buscar");
        buscarProductosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductosMenuItemActionPerformed(evt);
            }
        });
        productosMenu.add(buscarProductosMenuItem);

        resgistrarProductoMenuItem.setText("Registrar");
        resgistrarProductoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resgistrarProductoMenuItemActionPerformed(evt);
            }
        });
        productosMenu.add(resgistrarProductoMenuItem);

        jMenuBar1.add(productosMenu);

        usuariosMenu.setText("Usuarios");

        buscarUsuarioMenuItem.setText("Buscar");
        buscarUsuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuarioMenuItemActionPerformed(evt);
            }
        });
        usuariosMenu.add(buscarUsuarioMenuItem);

        registrarUsuarioMenuItem.setText("Registrar");
        registrarUsuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUsuarioMenuItemActionPerformed(evt);
            }
        });
        usuariosMenu.add(registrarUsuarioMenuItem);

        jMenuBar1.add(usuariosMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finalizarBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(agregarBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cancelarBtn))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLbl)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarBtn)
                    .addComponent(cancelarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizarBtn)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarProductosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductosMenuItemActionPerformed
        new BuscarProductoDlg(this, false).setVisible(true);
    }//GEN-LAST:event_buscarProductosMenuItemActionPerformed

    private void resgistrarProductoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resgistrarProductoMenuItemActionPerformed
        new RegistrarProductoDlg(this, false).setVisible(true);
    }//GEN-LAST:event_resgistrarProductoMenuItemActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        agregarDetalleTabla();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        if (!detallesVenta.isEmpty()) {
            detallesVenta.clear();
            llenarTablaVenta();
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "La venta no tiene ningun elemento aún", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void ventasDiaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasDiaMenuItemActionPerformed
        try {
            new BuscarVentasDlg(this, false, controlVentas.obtenerVentasDia()).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventasDiaMenuItemActionPerformed

    private void finalizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarBtnActionPerformed
        if (!detallesVenta.isEmpty()) {
            ConfirmarVentaDlg dlg = new ConfirmarVentaDlg(this, false, total);
            dlg.setVisible(true);

            String nombreCliente = dlg.getNombreCliente();
            String apellidoCliente = dlg.getApellidoCliente();
            MetodoPago metodo = dlg.getMetodoPago();

            if (nombreCliente != null) {
                dlg.dispose();
                VentaDTO ventaDTO = new VentaDTO(nombreCliente, apellidoCliente, metodo,
                        LocalDateTime.now(), detallesUsuarioVenta(), detallesVenta);
                try {
                    controlVentas.registrarVenta(ventaDTO);
                } catch (NegocioException ex) {
                    Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                detallesVenta.clear();
                llenarTablaVenta();
                calcularTotal();
            }
        } else {
            JOptionPane.showMessageDialog(this, "La venta no tiene ningun elemento aún", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_finalizarBtnActionPerformed

    private void buscarVentasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarVentasMenuItemActionPerformed
        try {
            new BuscarVentasDlg(this, false, controlVentas.obtenerVentas()).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarVentasMenuItemActionPerformed

    private void buscarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuarioMenuItemActionPerformed
        try {
            new BuscarUsuariosDlg(this, false, controlUsuarios.obtenerUsuarios()).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarUsuarioMenuItemActionPerformed

    private void registrarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUsuarioMenuItemActionPerformed
        RegistrarUsuarioDlg dlg = new RegistrarUsuarioDlg(this, false);
        dlg.setVisible(true);
        UsuarioDTO usuarioDTO = dlg.getUsuario();

        if (usuarioDTO != null) {
            dlg.dispose();

            DireccionUsuarioDlg direccionDlg = new DireccionUsuarioDlg(this, false);
            direccionDlg.setVisible(true);
            usuarioDTO.setDireccion(direccionDlg.getDireccion());
            try {
                direccionDlg.dispose();
                controlUsuarios.registrarUsuario(usuarioDTO);
            } catch (NegocioException ex) {
                Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_registrarUsuarioMenuItemActionPerformed

    private void registrarCompraMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCompraMenuItemActionPerformed
        new RegistrarCompraDlg(this, false).setVisible(true);
    }//GEN-LAST:event_registrarCompraMenuItemActionPerformed

    private void buscarCompraMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCompraMenuItemActionPerformed
        try {
            new BuscarComprasDlg(this, false, controlCompras.obtenerCompras()).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(InicioForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_buscarCompraMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JMenuItem buscarCompraMenuItem;
    private javax.swing.JMenuItem buscarProductosMenuItem;
    private javax.swing.JMenuItem buscarUsuarioMenuItem;
    private javax.swing.JMenuItem buscarVentasMenuItem;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JMenu comprasMenu;
    private javax.swing.JButton finalizarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu productosMenu;
    private javax.swing.JMenuItem registrarCompraMenuItem;
    private javax.swing.JMenuItem registrarUsuarioMenuItem;
    private javax.swing.JMenuItem resgistrarProductoMenuItem;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JMenu usuariosMenu;
    private javax.swing.JTable ventaTabla;
    private javax.swing.JMenuItem ventasDiaMenuItem;
    private javax.swing.JMenu ventasMenu;
    // End of variables declaration//GEN-END:variables
}
