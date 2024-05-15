/*
 * InformacionVentaDlg.java
 */
package forms;

import dtos.DetalleVentaDTO;
import dtos.UsuarioVentaDTO;
import dtos.VentaDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class InformacionVentaDlg extends javax.swing.JDialog {

    private VentaDTO venta;

    /**
     * Creates new form DetallesVentaDlg
     */
    public InformacionVentaDlg(java.awt.Frame parent, boolean modal, VentaDTO venta) {
        super(parent, modal);
        initComponents();
        this.venta = venta;
        iniciiarLabels();
        llenarTablaDetalles();
    }

    private void iniciiarLabels() {
        folioTxt.setText(venta.getFolio());
        nombreClienteTxt.setText(venta.getNombreCliente() + " " + venta.getApellidoCliente());
        UsuarioVentaDTO usuario = venta.getUsuario();
        nombreUsuarioTxt.setText(usuario.getNombre() + " " + usuario.getApellidoPaterno()
                + " " + usuario.getApellidoMaterno());
        metodoPagoTxt.setText(venta.getMetodoPago().toString());
        totalTxt.setText(String.valueOf(venta.getMontoTotal()));
    }

    private void llenarTablaDetalles() {

        List<DetalleVentaDTO> listaProductos = venta.getDetalles();
        DefaultTableModel modeloTabla = (DefaultTableModel) detalleTabla.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaProductos != null) {
            listaProductos.forEach(row -> {
                Object[] fila = new Object[4];
                fila[0] = row.getNombreProducto();
                fila[1] = row.getPrecio();
                fila[2] = row.getCantidad();
                fila[3] = row.getTotal();

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        folioTxt = new javax.swing.JLabel();
        nombreClienteTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        metodoPagoTxt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombreUsuarioTxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleTabla = new javax.swing.JTable();
        cerrarBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel1.setText("Información de Venta");

        jLabel2.setText("Folio:");

        jLabel3.setText("Nombre del cliente:");

        folioTxt.setText("jLabel4");

        nombreClienteTxt.setText("jLabel5");

        jLabel6.setText("Método de pago:");

        metodoPagoTxt.setText("jLabel7");

        jLabel8.setText("Atendido por:");

        nombreUsuarioTxt.setText("jLabel9");

        jLabel10.setText("Productos comprados");

        detalleTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        detalleTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(detalleTabla);

        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Monto Total: $");

        totalTxt.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreUsuarioTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metodoPagoTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(folioTxt)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreClienteTxt))
                    .addComponent(jLabel1))
                .addContainerGap(130, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrarBtn)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(folioTxt)
                    .addComponent(nombreClienteTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(metodoPagoTxt)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nombreUsuarioTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrarBtn)
                    .addComponent(jLabel11)
                    .addComponent(totalTxt))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JTable detalleTabla;
    private javax.swing.JLabel folioTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel metodoPagoTxt;
    private javax.swing.JLabel nombreClienteTxt;
    private javax.swing.JLabel nombreUsuarioTxt;
    private javax.swing.JLabel totalTxt;
    // End of variables declaration//GEN-END:variables
}