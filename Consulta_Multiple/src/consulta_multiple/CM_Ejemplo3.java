/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta_multiple;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
/**
 *
 * @author Jordy J
 */
public class CM_Ejemplo3 extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel dtm03=new DefaultTableModel();
    /**
     * Creates new form CM_Ejemplo3
     */
    public CM_Ejemplo3() {
        initComponents();
            String titulos []={"Nombre","Apellidos","Dirección","Fecha"};
            dtm03.setColumnIdentifiers(titulos);
            tblcliec.setModel(dtm03);    
            conectar03();
    }

    public void conectar03(){
        String url="jdbc:sqlserver://localhost;databaseName=ventasNoche;user="
        + "sa;password=123456;";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(rootPane, "Bienvenido", "Conectar",
            JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "No se pudo conectar a la"
            + "base de datos", "Conectar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrar(){
        String valor1=txtf1.getText();
        String valor2=txtf2.getText();
        try{
            String sql="SELECT c.nombre_clie,(c.ape_pat_clie+' '+c.ape_mat_clie),"
            + "c.dir_clie,v.fec_ven FROM Cliente AS c INNER JOIN Venta AS v ON (c.cod_clie=v.cod_clie) WHERE v.fec_ven>'"+valor1+"' AND v.fec_ven<'"+valor2+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            limpiar();
            while(rs.next()){
            String []datos03=new String[4];
            datos03[0]=rs.getString(1);
            datos03[1]=rs.getString(2);
            datos03[2]=rs.getString(3);
            datos03[3]=rs.getString(4);
            dtm03.addRow(datos03);
            }
//            con.close();
//            stmt.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
    }
    
    private void limpiar(){
        int filas;
        filas=dtm03.getRowCount()-1;
        for(int i=filas;i>=0;i--){
            dtm03.removeRow(i);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcliec = new javax.swing.JTable();
        btnCONSULTA = new javax.swing.JButton();
        txtf1 = new javax.swing.JTextField();
        txtf2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FECHA1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        jLabel2.setText("FECHA2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 14, -1, -1));

        tblcliec.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblcliec);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 381, 189));

        btnCONSULTA.setText("CONSULTA");
        btnCONSULTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSULTAActionPerformed(evt);
            }
        });
        getContentPane().add(btnCONSULTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 244, -1, -1));
        getContentPane().add(txtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 12, 90, -1));
        getContentPane().add(txtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 12, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCONSULTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSULTAActionPerformed
        // TODO add your handling code here:
        mostrar();
    }//GEN-LAST:event_btnCONSULTAActionPerformed

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
            java.util.logging.Logger.getLogger(CM_Ejemplo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CM_Ejemplo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CM_Ejemplo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CM_Ejemplo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CM_Ejemplo3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCONSULTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcliec;
    private javax.swing.JTextField txtf1;
    private javax.swing.JTextField txtf2;
    // End of variables declaration//GEN-END:variables
}
