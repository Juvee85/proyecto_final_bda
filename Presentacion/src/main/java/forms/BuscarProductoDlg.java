/*
 * AgregarProductoDlg.java
 */
package forms;

import dtos.ProductoDTO;
import excepciones.NegocioException;
import interfaces.IControlProductoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import negocio.ControlProductosBO;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class BuscarProductoDlg extends javax.swing.JDialog {

    private IControlProductoBO control = new ControlProductosBO();

    /**
     * Creates new form AgregarProductoDlg
     */
    public BuscarProductoDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarTablaProductos();
    }

    private void llenarTablaProductos() {
        try {
            List<ProductoDTO> listaProductos = control.obtenerProductos();
            DefaultTableModel modeloTabla = (DefaultTableModel) productoTabla.getModel();

            if (modeloTabla.getRowCount() > 0) {
                for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                    modeloTabla.removeRow(i);
                }
            }

            if (listaProductos != null) {
                listaProductos.forEach(row -> {
                    Object[] fila = new Object[4];
                    fila[0] = row.getCodigo();
                    fila[1] = row.getNombre();
                    fila[2] = row.getPrecio();
                    fila[3] = row.getStock();

                    modeloTabla.addRow(fila);
                });
            }
        } catch (NegocioException ex) {
            Logger.getLogger(BuscarProductoDlg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productoTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        cancelarBtn.setText("Salir");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        productoTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productoTabla.setColumnSelectionAllowed(true);
        productoTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productoTabla);
        productoTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (productoTabla.getColumnModel().getColumnCount() > 0) {
            productoTabla.getColumnModel().getColumn(0).setResizable(false);
            productoTabla.getColumnModel().getColumn(1).setResizable(false);
            productoTabla.getColumnModel().getColumn(2).setResizable(false);
            productoTabla.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelarBtn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productoTabla;
    // End of variables declaration//GEN-END:variables
}
