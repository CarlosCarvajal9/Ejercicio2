
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class NewJFrame extends javax.swing.JFrame {
    NewJFrame1 operaciones = new NewJFrame1();
    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column){
            return false;
        }
    
    };//no activara la edicion de valores si no apretamos el boton de editar
    
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setOpacity(0.7f);
        jToolBar1.setOpaque(true);
        
        operaciones.setVisible(true);//aparece las ventana operaciones
        this.setLocation(getX(), getY()-(operaciones.getHeight()/2));//centro las ventanas
        operaciones.setLocation(this.getX(),this.getY()+this.getHeight());
        
        operaciones.puntero = this;//asigono puntero de operaciones a este segmento de memoria- esta es la ventana del toolbar
        operaciones.jTable1.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sueldo");
    }
    
   
    public void salir(){
        System.exit(0);
    }
    
    public void reUbicar(int x, int y){
        this.setLocation(x, y-getHeight());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jToolBar1.setBackground(new java.awt.Color(255, 102, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconfinder_user_half_add_103774.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconfinder_user_half_edit_103775.png"))); // NOI18N
        jButton2.setText("  Editar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconfinder_user_half_remove_103777.png"))); // NOI18N
        jButton3.setText("  Eliminar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconfinder_user_half_settings_103779.png"))); // NOI18N
        jButton4.setText("  Salir");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        salir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewJPanel panel = new NewJPanel();
        
        int res = JOptionPane.showConfirmDialog(this, panel, "Escriba Valores a insertar", JOptionPane.OK_OPTION);
        
        if(res == JOptionPane.OK_OPTION){
            String[] data = new String[]{panel.jTextField1.getText(),panel.jTextField2.getText(),panel.jTextField3.getText()};//pasando el nombre,edad,sueldo
            
            modelo.addRow(data);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //revisando si existe un renglon seleccionado de la jTable
        int renglon = operaciones.jTable1.getSelectedRow();
        if(renglon == -1){
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar el renglon que deas modificar");
            return;//si entra al if el return interrumpe la ejecucion del codigo por lo tanto aqui terminaria
        }
        NewJPanel panel = new NewJPanel();
        
        panel.jTextField1.setText(modelo.getValueAt(renglon, 0).toString());//selecciona el campo del nombre
        panel.jTextField2.setText(modelo.getValueAt(renglon, 1).toString());//selecciona el campo del edad
        panel.jTextField3.setText(modelo.getValueAt(renglon, 2).toString());//selecciona el campo del sueldo
        
        int respuesta = JOptionPane.showConfirmDialog(this, panel,"Actualizando Valores",JOptionPane.OK_OPTION);
        if(respuesta == JOptionPane.OK_OPTION){
            modelo.setValueAt(panel.jTextField1.getText(), renglon, 0);
            modelo.setValueAt(panel.jTextField2.getText(), renglon, 1);
            modelo.setValueAt(panel.jTextField3.getText(), renglon, 2);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        int renglon = operaciones.jTable1.getSelectedRow();
        
        if(renglon == -1){
            JOptionPane.showMessageDialog(this, "ERROR:\nDebes seleccionar un renglon para borrarlo");
            return;
        }
        
        String cadena = "Estas Seguro que deaseas eliminar esta persona?:"+modelo.getValueAt(renglon, 0).toString();
        
        int respuesta = JOptionPane.showConfirmDialog(this, cadena);
        if(respuesta == JOptionPane.OK_OPTION){
            modelo.removeRow(renglon);
        }
    }//GEN-LAST:event_jButton3MouseReleased

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
