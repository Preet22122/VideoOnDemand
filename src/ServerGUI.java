
import java.awt.Toolkit;

public class ServerGUI extends javax.swing.JFrame {

    public ServerGUI() {
        initComponents();

        setSize(661,300);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/2 - (650/2);
        int y = height/2 - (350/2);
        setLocation(x, y);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bt = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        bt.setBackground(new java.awt.Color(255, 255, 0));
        bt.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        bt.setForeground(new java.awt.Color(102, 51, 0));
        bt.setText("Start Server");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        jPanel1.add(bt);
        bt.setBounds(200, 40, 230, 70);

        bt2.setBackground(new java.awt.Color(255, 255, 0));
        bt2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bt2.setForeground(new java.awt.Color(102, 51, 0));
        bt2.setText("Enter Admin  Login");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel1.add(bt2);
        bt2.setBounds(200, 140, 230, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btActionPerformed
    {//GEN-HEADEREND:event_btActionPerformed

        try {
            MyServer serverobj = new MyServer(9999);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        AdminLogin obj = new AdminLogin();
    }//GEN-LAST:event_bt2ActionPerformed

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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton bt2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
