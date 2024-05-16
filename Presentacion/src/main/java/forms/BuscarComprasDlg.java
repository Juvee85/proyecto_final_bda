/*
 * BuscarVentasDlg.java
 */
package forms;

import dtos.CompraDTO;
import excepciones.NegocioException;
import interfaces.IControlComprasBO;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ControlComprasBO;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class BuscarComprasDlg extends javax.swing.JDialog {

    IControlComprasBO control = new ControlComprasBO();
    private List<CompraDTO> compras;

    /**
     * Creates new form BuscarVentasDlg
     */
    public BuscarComprasDlg(java.awt.Frame parent, boolean modal, List<CompraDTO> compras) {
        super(parent, modal);
        initComponents();
        this.compras = compras;
        llenarTablaProductos();
    }

    private void llenarTablaProductos() {
        
            List<CompraDTO> listaProductos = compras;
            DefaultTableModel modeloTabla = (DefaultTableModel) comprasTbl.getModel();

            if (modeloTabla.getRowCount() > 0) {
                for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                    modeloTabla.removeRow(i);
                }
            }

            if (listaProductos != null) {
                listaProductos.forEach(row -> {
                    Object[] fila = new Object[4];
                    fila[0] = row.getFolio();
                    fila[1] = row.getNombreProveedor();
                    fila[2] = row.getMontoTotal();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    fila[3] = row.getFecha().format(formatter);

                    modeloTabla.addRow(fila);
                });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        comprasTbl = new javax.swing.JTable();
        detallesBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        comprasTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Nombre Proveedor", "Monto Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        comprasTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(comprasTbl);
        if (comprasTbl.getColumnModel().getColumnCount() > 0) {
            comprasTbl.getColumnModel().getColumn(0).setResizable(false);
            comprasTbl.getColumnModel().getColumn(1).setResizable(false);
            comprasTbl.getColumnModel().getColumn(2).setResizable(false);
            comprasTbl.getColumnModel().getColumn(3).setResizable(false);
        }

        detallesBtn.setText("Ver detalles");
        detallesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallesBtnActionPerformed(evt);
            }
        });

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salirBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detallesBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detallesBtn)
                    .addComponent(salirBtn))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void detallesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallesBtnActionPerformed
        try {
            String folio = (String) comprasTbl.getModel().getValueAt(comprasTbl.getSelectedRow(), 0);
            CompraDTO compra = control.obtenerCompraPorFolio(folio);
            new InformacionCompraDlg(null, false, compra).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Seleccione una venta antes de continuar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_detallesBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable comprasTbl;
    private javax.swing.JButton detallesBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
