
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class AddCourse extends javax.swing.JFrame {
    File f1, f2, f3;

    public AddCourse() {
        initComponents();
        setVisible(true);
          setSize(772,594);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/3 - (772/2);
        int y = height/3 - (584/2);
        setLocation(x, y);


        jcombo.removeAllItems();
        jcombo.addItem("--select course--"); 
        jcombo.addItem("basic"); 
        jcombo.addItem("Web Development");
        jcombo.addItem("App Development");
        jcombo.addItem("Software Development");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jview = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        tfdisc = new javax.swing.JTextField();
        jcombo = new javax.swing.JComboBox<>();
        tfwide = new javax.swing.JTextField();
        jbwide = new javax.swing.JButton();
        tfsquare = new javax.swing.JTextField();
        jbsquare = new javax.swing.JButton();
        tfrequisite = new javax.swing.JTextField();
        tfamount = new javax.swing.JTextField();
        tfsamplevideo = new javax.swing.JTextField();
        jbsample = new javax.swing.JButton();
        jbadd = new javax.swing.JButton();

        jview.setText("view course");
        jview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jviewActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setForeground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("     Add Course");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 20, 253, 38);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Enter Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 80, 227, 29);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Enter Discription");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 140, 227, 27);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Select Category");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 200, 227, 27);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Select Wide Photo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 260, 227, 27);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Select Square Photo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 310, 227, 27);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Enter Pre-requisite");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 360, 227, 27);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Enter Amount");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 410, 227, 27);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Select Sample Video");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 460, 227, 27);

        tfname.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfname.setBorder(null);
        tfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameActionPerformed(evt);
            }
        });
        jPanel1.add(tfname);
        tfname.setBounds(330, 80, 246, 30);

        tfdisc.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfdisc.setBorder(null);
        tfdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdiscActionPerformed(evt);
            }
        });
        jPanel1.add(tfdisc);
        tfdisc.setBounds(330, 140, 246, 30);

        jcombo.setBackground(new java.awt.Color(255, 255, 0));
        jcombo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jcombo.setForeground(new java.awt.Color(102, 51, 0));
        jcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcombo.setBorder(null);
        jcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboActionPerformed(evt);
            }
        });
        jPanel1.add(jcombo);
        jcombo.setBounds(330, 200, 246, 26);

        tfwide.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfwide.setBorder(null);
        jPanel1.add(tfwide);
        tfwide.setBounds(330, 260, 246, 30);

        jbwide.setBackground(new java.awt.Color(255, 255, 0));
        jbwide.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jbwide.setForeground(new java.awt.Color(102, 51, 0));
        jbwide.setText("Browse");
        jbwide.setBorder(null);
        jbwide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbwideActionPerformed(evt);
            }
        });
        jPanel1.add(jbwide);
        jbwide.setBounds(600, 260, 121, 30);

        tfsquare.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfsquare.setBorder(null);
        jPanel1.add(tfsquare);
        tfsquare.setBounds(330, 310, 246, 30);

        jbsquare.setBackground(new java.awt.Color(255, 255, 0));
        jbsquare.setForeground(new java.awt.Color(102, 51, 0));
        jbsquare.setText("Browse");
        jbsquare.setBorder(null);
        jbsquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsquareActionPerformed(evt);
            }
        });
        jPanel1.add(jbsquare);
        jbsquare.setBounds(600, 310, 121, 30);

        tfrequisite.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfrequisite.setBorder(null);
        jPanel1.add(tfrequisite);
        tfrequisite.setBounds(330, 360, 246, 30);

        tfamount.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfamount.setBorder(null);
        jPanel1.add(tfamount);
        tfamount.setBounds(330, 410, 246, 30);

        tfsamplevideo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tfsamplevideo.setBorder(null);
        jPanel1.add(tfsamplevideo);
        tfsamplevideo.setBounds(330, 460, 246, 30);

        jbsample.setBackground(new java.awt.Color(255, 255, 0));
        jbsample.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jbsample.setForeground(new java.awt.Color(102, 51, 0));
        jbsample.setText("Browse");
        jbsample.setBorder(null);
        jbsample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsampleActionPerformed(evt);
            }
        });
        jPanel1.add(jbsample);
        jbsample.setBounds(610, 460, 121, 30);

        jbadd.setBackground(new java.awt.Color(255, 255, 0));
        jbadd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jbadd.setForeground(new java.awt.Color(102, 51, 0));
        jbadd.setText("Add");
        jbadd.setBorder(null);
        jbadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbaddActionPerformed(evt);
            }
        });
        jPanel1.add(jbadd);
        jbadd.setBounds(330, 510, 100, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameActionPerformed

    private void tfdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdiscActionPerformed

    private void jbwideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbwideActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = jfc.getSelectedFile();
            tfwide.setText(f1.getPath());
        }

    }//GEN-LAST:event_jbwideActionPerformed

    private void jbsquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsquareActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            f2 = jfc.getSelectedFile();
            tfsquare.setText(f2.getPath());
        }
    }//GEN-LAST:event_jbsquareActionPerformed

    private void jbsampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsampleActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            f3 = jfc.getSelectedFile();
            tfsamplevideo.setText(f3.getPath());
        }
    }//GEN-LAST:event_jbsampleActionPerformed

    private void jbaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbaddActionPerformed

        Thread t = new Thread(new LoginJob());
        t.start();

    }

    class LoginJob implements Runnable {

        @Override
        public void run() {
            String name = tfname.getText();
            String discription = tfdisc.getText();
            String category = jcombo.getSelectedItem().toString();
            String pre_requisite = tfrequisite.getText();
            String square = tfsquare.getText();
            String wide = tfwide.getText();
            String sampleVideo = tfsamplevideo.getText();
            int amount = Integer.parseInt(tfamount.getText());

            try {
                HttpResponse<String> res = Unirest.post("http://"+globalvariable.host+"/AddCourse")
                        .queryString("name", name)
                        .queryString("discription", discription)
                        .queryString("category", category)
                        .queryString("prerequisite", pre_requisite)
                        .queryString("amount", amount)
                        .field("square", new File(square))
                        .field("wide", new File(wide))
                        .field("sampleVideo", new File(sampleVideo))
                        .asString();
                        String ans = res.getBody();
                        JOptionPane.showMessageDialog(rootPane, ans);
                
                String msg = res.getBody();
                if(msg.equals("rowadded")){
                    JOptionPane.showMessageDialog(AddCourse.this, "Course Added!!");
                }
                else{
                    JOptionPane.showMessageDialog(AddCourse.this, "Failed!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jbaddActionPerformed

    private void jviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jviewActionPerformed
            ViewCourse obj=new ViewCourse();
    }//GEN-LAST:event_jviewActionPerformed

    private void jcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboActionPerformed
           
    }//GEN-LAST:event_jcomboActionPerformed

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
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbadd;
    private javax.swing.JButton jbsample;
    private javax.swing.JButton jbsquare;
    private javax.swing.JButton jbwide;
    private javax.swing.JComboBox<String> jcombo;
    private javax.swing.JButton jview;
    private javax.swing.JTextField tfamount;
    private javax.swing.JTextField tfdisc;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfrequisite;
    private javax.swing.JTextField tfsamplevideo;
    private javax.swing.JTextField tfsquare;
    private javax.swing.JTextField tfwide;
    // End of variables declaration//GEN-END:variables
}
