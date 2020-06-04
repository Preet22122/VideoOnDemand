
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class profile extends javax.swing.JFrame {

    String phone, email, photo, name;

    public profile(String email) {
        initComponents();
        this.email = email;
        System.out.println("email: ---------" + email);
       
         setSize(840,630);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/3 - (650/2);
        int y = height/3 - (350/2);
        setLocation(x, y);
        new Thread(new Job()).start();
        new Thread(new job2()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tphoto = new javax.swing.JLabel();
        tname = new javax.swing.JLabel();
        tphone = new javax.swing.JLabel();
        temail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("                   Profile");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 20, 390, 50);

        tphoto.setText("jLabel2");
        tphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(tphoto);
        tphoto.setBounds(70, 110, 150, 140);

        tname.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tname.setForeground(new java.awt.Color(255, 255, 0));
        tname.setText("jLabel2");
        jPanel1.add(tname);
        tname.setBounds(370, 110, 310, 40);

        tphone.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tphone.setForeground(new java.awt.Color(255, 255, 0));
        tphone.setText("jLabel2");
        jPanel1.add(tphone);
        tphone.setBounds(360, 166, 260, 40);

        temail.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        temail.setForeground(new java.awt.Color(255, 255, 0));
        temail.setText("jLabel2");
        jPanel1.add(temail);
        temail.setBounds(360, 220, 270, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 860, 290);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(102, 51, 0));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("               My Subscription");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(210, 20, 410, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 290, 860, 80);

        jPanel3.setBackground(new java.awt.Color(102, 51, 0));
        jPanel3.setLayout(null);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 370, 860, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    class Job implements Runnable {

        @Override
        public void run() {

            try {

                HttpResponse<String> res = Unirest.get("http://"+globalvariable.host+"/fetchprofile")
                        .queryString("email", email)
                        .asString();
                String result = res.getBody().toString();
                System.out.println("result: " + result);
                StringTokenizer st = new StringTokenizer(result, ";");
                while (st.hasMoreTokens()) {
                    photo = st.nextToken();
                    name = st.nextToken();
                    phone = st.nextToken();

                    URL urlnm = new URL("http://"+globalvariable.host+"/GetResource/" + photo);

                    BufferedImage orig_bing1 = ImageIO.read(urlnm);
                    BufferedImage newimgage = resize(orig_bing1, tphoto.getWidth(), tphoto.getHeight());

                    tphoto.setIcon(new ImageIcon(newimgage));

                    temail.setText(email);
                    tname.setText(name);
                    tphone.setText(phone);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    class job2 implements Runnable {

        public void run() {
            try {
                HttpResponse<String> ans = Unirest.get("http://"+globalvariable.host+"/fetchsubscribedcourses")
                        .queryString("email", email).asString();
                String result = ans.getBody().toString();
                System.out.println("result: --" + result);

                StringTokenizer str = new StringTokenizer(result, "~");
                int count = str.countTokens();
                singlecategorypanel2 coursePanel[] = new singlecategorypanel2[count];
                int x = 10, y = 10;

                for (int i = 0; i < count; i++) {

                    String next = str.nextToken();
                    StringTokenizer str1 = new StringTokenizer(next, ";");
                    // while(str1.hasMoreTokens()){

                    String name1 = str1.nextToken();
                    String photo1 = str1.nextToken();
                    singlevideopanel sp1[] = new singlevideopanel[i];

                    //coursePanel[i]= new singlecategorypanel2(photo);
                    System.out.println("hello2.1");
                    URL urlnm = new URL("http://"+globalvariable.host+"/GetResource/" + photo1);

                    coursePanel[i] = new singlecategorypanel2();
                    BufferedImage orig_bing1 = ImageIO.read(urlnm);
                    BufferedImage newimgage = resize(orig_bing1, coursePanel[i].lb2.getWidth(), coursePanel[i].lb2.getHeight());

                    coursePanel[i].lb2.setIcon(new ImageIcon(newimgage));
                    jPanel3.add(coursePanel[i]);
                    coursePanel[i].lb3.setText(name1);
                    coursePanel[i].setBounds(x, y, 200, 196);

                    if (x < 900) {
                        x = x + 210;

                    } else {
                        x = 10;
                        y = y + 210;
                    }
                    jPanel3.repaint();

                    //  }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel temail;
    public javax.swing.JLabel tname;
    public javax.swing.JLabel tphone;
    public javax.swing.JLabel tphoto;
    // End of variables declaration//GEN-END:variables

}
