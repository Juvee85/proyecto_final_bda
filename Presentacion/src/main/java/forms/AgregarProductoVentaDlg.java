/*
 * AgregarProductoVentaDlg.java
 */
package forms;

import dtos.ProductoDTO;
import excepciones.NegocioException;
import interfaces.IControlProductoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ControlProductosBO;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class AgregarProductoVentaDlg extends javax.swing.JDialog {

    private IControlProductoBO control = new ControlProductosBO();
    private ProductoDTO producto;
    private Integer cantidad;

    /**
     * Creates new form AgregarProductoDlg
     */
    public AgregarProductoVentaDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarTablaProductos();
    }

    private void llenarTablaProductos() {
        try {
            List<ProductoDTO> listaProductos = control.obtenerProductosConStock();
            DefaultTableModel modeloTabla = (DefaultTableModel) productoTabla.getModel();

            if (modeloTabla.getRowCount() > 0) {
                for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                    modeloTabla.removeRow(i);
                }
            }

            if (listaProductos != null) {
                listaProductos.forEach(row -> {
                    Object[] fila = new Object[3];
                    fila[0] = row.getCodigo();
                    fila[1] = row.getNombre();
                    fila[2] = row.getPrecio();

                    modeloTabla.addRow(fila);
                });
            }
        } catch (NegocioException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        cantidadSpinner = new javax.swing.JSpinner();
        agregarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productoTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jLabel1.setText("Cantidad:");

        cantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        cantidadSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadSpinnerKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadSpinnerKeyTyped(evt);
            }
        });

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

        productoTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productoTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productoTabla);
        if (productoTabla.getColumnModel().getColumnCount() > 0) {
            productoTabla.getColumnModel().getColumn(0).setResizable(false);
            productoTabla.getColumnModel().getColumn(1).setResizable(false);
            productoTabla.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarBtn)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarBtn)
                    .addComponent(cancelarBtn))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        try {
            String codigo = (String) productoTabla.getModel().getValueAt(productoTabla.getSelectedRow(), 0);
            producto = control.obtenerProductoPorCodigo(codigo);
            cantidad = (Integer) cantidadSpinner.getValue();

            this.setVisible(false);
        } catch (NegocioException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Seleccione un producto antes de continuar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void cantidadSpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadSpinnerKeyTyped

    }//GEN-LAST:event_cantidadSpinnerKeyTyped

    private void cantidadSpinnerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadSpinnerKeyPressed
       
    }//GEN-LAST:event_cantidadSpinnerKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productoTabla;
    // End of variables declaration//GEN-END:variables
}
