
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class AdminLogin extends javax.swing.JFrame {

    public AdminLogin() {
        initComponents();
        setVisible(true);
        setSize(650,300);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/2 - (650/2);
        int y = height/2 - (300/2);
        setLocation(x, y);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contentfolder/adminlogin.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 40, 200, 200);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Email");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 60, 60, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 120, 100, 22);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(390, 50, 223, 40);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(390, 110, 223, 43);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 51, 0));
        jButton1.setText("Submit");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 190, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread t = new Thread(new LoginJob());
        t.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    class LoginJob implements Runnable {

        @Override
        public void run() {
            String email = jTextField1.getText();
            String password = jPasswordField1.getText();
            try {
                HttpResponse httpResponse = Unirest.get("http://"+globalvariable.host+"/AdminLogin").queryString("email", email).queryString("password", password).asString();

                String s;
                s = (String) (httpResponse.getBody());
                if (s.equals("success")) {
                    JOptionPane.showMessageDialog(AdminLogin.this, "Login Successful!!");
                    Adminitem obj = new Adminitem();
                    obj.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(AdminLogin.this, "Login Failed!!!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
