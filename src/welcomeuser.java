
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class welcomeuser extends javax.swing.JFrame {

    String email;

    public welcomeuser(String email) {
        initComponents();
        this.email = email;

         setSize(1620,820);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/4 - (650/2);
        int y = height/4 - (350/2);
        setLocation(x, y);
        jLabel1.setText("Welcome " + email);
        new Thread(new job()).start();
    }

    class job implements Runnable {

        @Override
        public void run() {
            final PanelSlider42<JPanel> slider = new PanelSlider42<JPanel>(jPanel2);
            JPanel basePanel = slider.getBasePanel();
            String images[] = {"/slider/0.jpg", "/slider/1.png", "/slider/2.png", "/slider/3.png", "/slider/4.jpg", "/slider/5.png", "/slider/6.jpg", "/slider/7.png", "/slider/8.png"};

            for (int i = 0; i < images.length; i++) {
                try {
                    JLabel lb = new JLabel();
                    BufferedImage image = ImageIO.read(getClass().getResource(images[i]));
                    BufferedImage img = resize(image, 1620, 270);
                    lb.setIcon(new ImageIcon(img));
                    slider.addComponent(lb);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            slider.test();
            jPanel2.add(basePanel);
            jScrollPane1.setPreferredSize(new Dimension(1714, 500));
            p3.setPreferredSize(new Dimension(1740, 270 * globalvariable.category.length));
            singlecategorypanel sp[] = new singlecategorypanel[globalvariable.category.length];
            int y = 10;
            for (int i = 1; i < globalvariable.category.length; i++) {
                sp[i] = new singlecategorypanel();
                sp[i].setBounds(10, y, 1714, 250);
                sp[i].lb1.setText(globalvariable.category[i]);
                p3.add(sp[i]);
                y = y + 270;
                repaint();
                try {
                    HttpResponse<String> httpResponse = Unirest.get("http://" + globalvariable.host + "/fetchcourseundercategory")
                            .queryString("Cname", globalvariable.category[i])
                            .asString();
                    String ans = httpResponse.getBody().toString();
                    StringTokenizer st = new StringTokenizer(ans, "~");
                    int count = st.countTokens();
                    singlecategorypanel2 sp2[] = new singlecategorypanel2[count];
                    int x = 10;
                    for (int j = 0; j < count; j++) {
                        String next = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(next, ";");
                        String photo = st2.nextToken();
                        String course = st2.nextToken();
                        String amount = st2.nextToken();
                        sp2[j] = new singlecategorypanel2();
                        sp2[j].addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                fullcourseview obj = new fullcourseview(course, email);
                                obj.setVisible(true);
                            }
                        });
                        URL url = new URL("http://" + globalvariable.host + "/GetResource/" + photo);
                      
                        //JOptionPane.showMessageDialog(p3, url.toString());
                        BufferedImage orig_bimg = ImageIO.read(url);
                        BufferedImage newimg = resize(orig_bimg, sp2[j].lb2.getWidth(), sp2[j].lb2.getHeight());

                        sp2[j].lb2.setIcon(new ImageIcon(newimg));

//                        sp2[j].lb2.setText(photo);
                        sp2[j].lb3.setText(course);
                        sp2[j].lb4.setText(amount);
                        sp[i].add(sp2[j]);
                        sp2[j].setBounds(x, 40, 200, 196);
                        x = x + 210;
                        sp[i].repaint();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                   // JOptionPane.showMessageDialog(p3, e.getMessage());
                }

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jchange = new javax.swing.JButton();
        jlogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        p3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jchange.setBackground(new java.awt.Color(255, 255, 0));
        jchange.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jchange.setForeground(new java.awt.Color(102, 51, 0));
        jchange.setText("Change password");
        jchange.setBorder(null);
        jchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchangeActionPerformed(evt);
            }
        });
        jPanel1.add(jchange);
        jchange.setBounds(890, 30, 160, 50);

        jlogout.setBackground(new java.awt.Color(255, 255, 0));
        jlogout.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jlogout.setForeground(new java.awt.Color(102, 51, 0));
        jlogout.setText("Logout");
        jlogout.setBorder(null);
        jlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlogoutActionPerformed(evt);
            }
        });
        jPanel1.add(jlogout);
        jlogout.setBounds(1370, 30, 180, 50);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Welcome");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 10, 950, 80);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 51, 0));
        jButton1.setText("Profile");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1110, 30, 210, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1600, 100);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1598, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 100, 1600, 202);

        p3.setBackground(new java.awt.Color(102, 51, 0));
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1598, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 306, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 174, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 300, 1600, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlogoutActionPerformed

        userlogin obj = new userlogin();
        obj.setVisible(true);
        dispose();

    }//GEN-LAST:event_jlogoutActionPerformed

    private void jchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchangeActionPerformed
        changepassword obj = new changepassword();
        obj.setVisible(true);
    }//GEN-LAST:event_jchangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        profile obj = new profile(email);
        obj.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(welcomeuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcomeuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcomeuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcomeuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jchange;
    private javax.swing.JButton jlogout;
    private javax.swing.JPanel p3;
    // End of variables declaration//GEN-END:variables

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}
