/*
 * BuscarVentasDlg.java
 */
package forms;

import dtos.VentaDTO;
import excepciones.NegocioException;
import interfaces.IControlVentasBO;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ControlVentasBO;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class BuscarVentasDlg extends javax.swing.JDialog {

    IControlVentasBO control = new ControlVentasBO();
    private List<VentaDTO> ventas;

    /**
     * Creates new form BuscarVentasDlg
     */
    public BuscarVentasDlg(java.awt.Frame parent, boolean modal, List<VentaDTO> ventas) {
        super(parent, modal);
        initComponents();
        this.ventas = ventas;
        llenarTablaProductos();
    }

    private void llenarTablaProductos() {
        
            List<VentaDTO> listaProductos = ventas;
            DefaultTableModel modeloTabla = (DefaultTableModel) ventasTabla.getModel();

            if (modeloTabla.getRowCount() > 0) {
                for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                    modeloTabla.removeRow(i);
                }
            }

            if (listaProductos != null) {
                listaProductos.forEach(row -> {
                    Object[] fila = new Object[5];
                    fila[0] = row.getFolio();
                    fila[1] = row.getNombreCliente() + " " + row.getApellidoCliente();
                    fila[2] = row.getMetodoPago();
                    fila[3] = row.getMontoTotal();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    fila[4] = row.getFecha().format(formatter);

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
        ventasTabla = new javax.swing.JTable();
        detallesBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        ventasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Nombre cliente", "Metodo Pago", "Monto Total", "Fecha"
            }
        ));
        ventasTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ventasTabla);

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
            String folio = (String) ventasTabla.getModel().getValueAt(ventasTabla.getSelectedRow(), 0);
            VentaDTO venta = control.obtenerVentaPorFolio(folio);
            new InformacionVentaDlg(null, false, venta).setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(AgregarProductoVentaDlg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Seleccione una venta antes de continuar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_detallesBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detallesBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salirBtn;
    private javax.swing.JTable ventasTabla;
    // End of variables declaration//GEN-END:variables
}
