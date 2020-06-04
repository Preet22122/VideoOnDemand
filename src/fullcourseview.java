
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;

public class fullcourseview extends javax.swing.JFrame {

    String course, email,samplevideo;
    int amount;

    public fullcourseview(String course, String email) {
        initComponents();
        this.course = course;
        this.email = email;

        System.out.println("course " + course + " -----------");
         setSize(1846,793);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/2 - (1846/2);
        int y = height/2 - (793/2);
        setLocation(x, y);

        new Thread(new job()).start();
    }

    class job implements Runnable {

        @Override
        public void run() {

           jPanel2.removeAll();
           jPanel2.repaint();
            try {

                jPanel2.setPreferredSize(new Dimension(1714, 500));
                HttpResponse httpResponse = Unirest.get("http://"+globalvariable.host+"/fetchfullcourseview")
                        .queryString("cname", course)
                        .queryString("email", email)
                        .asString();
                String result = httpResponse.getBody().toString();

                String status = "";

                StringTokenizer st2 = new StringTokenizer(result, ";");
                String name = st2.nextToken();
                String photo = st2.nextToken();
                String photo_wide = st2.nextToken();
                String requisite = st2.nextToken();
                String category = st2.nextToken();
                 amount = Integer.parseInt(st2.nextToken());
                samplevideo=st2.nextToken();
                status = st2.nextToken();
                
                jname.setText(name);
                jrequisite.setText(requisite);
                jcategory.setText(category);
                jprice.setText(amount + "");
                jphoto.setText(photo);
                URL urln = new URL("http://"+globalvariable.host+"/GetResource/" + photo);
                BufferedImage orig_bing = ImageIO.read(urln);
                BufferedImage newimgn = resize(orig_bing, jphoto.getWidth(), jphoto.getHeight());

                jphoto.setIcon(new ImageIcon(newimgn));

                URL url = new URL("http://"+globalvariable.host+"/GetResource/" + photo_wide);
                BufferedImage orig_bimg = ImageIO.read(url);
                BufferedImage newimg = resize(orig_bimg, lb1.getWidth(), lb1.getHeight());

                lb1.setIcon(new ImageIcon(newimg));

                HttpResponse<String> res = Unirest.get("http://"+globalvariable.host+"/fetchallvideos")
                        .queryString("Cname", course)
                        .asString();
                String ans = res.getBody();

                System.out.println(ans);
                StringTokenizer st4 = new StringTokenizer(ans, "~");
                int count = st4.countTokens();
                singlevideopanel sp1[] = new singlevideopanel[count];
                int x = 10, y = 10;
                System.out.println("hello2");
                for (int j = 0; j < count; j++) {

                    String next = st4.nextToken();
                    System.out.println("Row " + next);
                    StringTokenizer stn = new StringTokenizer(next, ";");

                    String lacnum = stn.nextToken();
                    String title = stn.nextToken();
                    String duration = stn.nextToken();
                    String vtitle = stn.nextToken();
                    String video = stn.nextToken();

                    sp1[j] = new singlevideopanel(vtitle);
                    System.out.println("hello2.1");
                    URL urlnm = new URL("http://"+globalvariable.host+"/GetResource/" + vtitle);

                    BufferedImage orig_bing1 = ImageIO.read(urlnm);
                    BufferedImage newimgage = resize(orig_bing1, sp1[j].jphoto.getWidth(), sp1[j].jphoto.getHeight());

                    sp1[j].jphoto.setIcon(new ImageIcon(newimgage));

                    System.out.println("hello3");
//                        sp2[j].lb2.setText(photo);
                    sp1[j].jlecture.setText(lacnum);
                    sp1[j].jtitle.setText(title);
                    sp1[j].jduration.setText(duration);
                    jPanel2.add(sp1[j]);
                    sp1[j].setBounds(x, y, 200, 196);
                    if (status.equals("yes")) {
                        jsub.setEnabled(true);
                        sp1[j].jplay.setEnabled(true);
                        sp1[j].jdownload.setEnabled(true);
                    } else {
                        jsub.setEnabled(true);
                        sp1[j].jplay.setEnabled(false);
                        sp1[j].jdownload.setEnabled(false);

                    }
                    sp1[j].jdownload.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            download obj = new download(vtitle);
                            obj.setVisible(true);
                        }
                    });
                    sp1[j].jplay.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Runtime runtime = Runtime.getRuntime();
                            try {
                                 String[] command = {"cmd.exe", "/k", "Start", vtitle};
                                     Process p =  runtime.exec(command);
                                 } catch (IOException ex) {
                                   ex.printStackTrace();
                                     }
                            //JavaFXMediaPlayerFrame obj = new JavaFXMediaPlayerFrame(vtitle);
                            //obj.setVisible(true);
                            
                        }
                    });
                   
                    if (x < 900) {
                        x = x + 210;

                    } else {
                        x = 10;
                        y = y + 210;
                    }
                    jPanel2.repaint();

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jphoto = new javax.swing.JLabel();
        jname = new javax.swing.JLabel();
        jrequisite = new javax.swing.JLabel();
        jcategory = new javax.swing.JLabel();
        jprice = new javax.swing.JLabel();
        jsub = new javax.swing.JButton();
        jsample = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setText("jLabel1");
        getContentPane().add(lb1);
        lb1.setBounds(10, 6, 1820, 190);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jphoto.setText("jLabel1");
        jphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jphoto);
        jphoto.setBounds(31, 38, 159, 136);

        jname.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jname.setText("Name");
        jPanel1.add(jname);
        jname.setBounds(286, 47, 170, 34);

        jrequisite.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jrequisite.setText("Pre-requisite");
        jPanel1.add(jrequisite);
        jrequisite.setBounds(286, 105, 110, 30);

        jcategory.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jcategory.setText("Category");
        jPanel1.add(jcategory);
        jcategory.setBounds(280, 146, 110, 30);

        jprice.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jprice.setText("Price");
        jPanel1.add(jprice);
        jprice.setBounds(1540, 36, 140, 30);

        jsub.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jsub.setForeground(new java.awt.Color(51, 102, 0));
        jsub.setText("Pay to Subscribe");
        jsub.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0)));
        jsub.setEnabled(false);
        jsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsubActionPerformed(evt);
            }
        });
        jPanel1.add(jsub);
        jsub.setBounds(1470, 90, 210, 29);

        jsample.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jsample.setForeground(new java.awt.Color(0, 102, 0));
        jsample.setText("View sample Video");
        jsample.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0)));
        jsample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsampleActionPerformed(evt);
            }
        });
        jPanel1.add(jsample);
        jsample.setBounds(1470, 150, 210, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 200, 1820, 210);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);
        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 420, 1800, 360);

        pack();
    }// </editor-fold>                        

    private void jsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsubActionPerformed

        PaymentDemo obj = new PaymentDemo();
        obj.setVisible(true);


    }//GEN-LAST:event_jsubActionPerformed

    private void jsampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsampleActionPerformed
        // TODO add your handling code here:
        Runtime runtime = Runtime.getRuntime();
        try {
           String[] command = {"cmd.exe", "/k", "Start", samplevideo};
                Process p =  runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // JavaFXMediaPlayerFrame fXMediaPlayerFrame=new JavaFXMediaPlayerFrame(samplevideo);
       // fXMediaPlayerFrame.setVisible(true);
    }//GEN-LAST:event_jsampleActionPerformed

    class sub implements Runnable {

        @Override
        public void run() {
            try {
                HttpResponse<String> ans = Unirest.get("http://"+globalvariable.host+"/subscribe")
                        .queryString("email", email)
                        .queryString("coursename", course).asString();
                String res = ans.getBody();

                String msg = res;
                if (msg.equals("success")) {
                    JOptionPane.showMessageDialog(fullcourseview.this, "Subscribed");
                    new Thread(new job()).start();
                } else {
                    JOptionPane.showMessageDialog(fullcourseview.this, "Not Subscribed");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
    //inner class

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
            java.util.logging.Logger.getLogger(fullcourseview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fullcourseview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fullcourseview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fullcourseview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jcategory;
    private javax.swing.JLabel jname;
    private javax.swing.JLabel jphoto;
    private javax.swing.JLabel jprice;
    private javax.swing.JLabel jrequisite;
    public javax.swing.JButton jsample;
    public javax.swing.JButton jsub;
    public javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables

    public class PaymentDemo extends javax.swing.JFrame {

    public PaymentDemo() {
        initComponents();
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        add(view, BorderLayout.CENTER);
        view.setBounds(0, 0, 1000, 1000);

        amount = amount*100;
        setSize(1000, 1000);
        setVisible(true);
//        String path = System.getProperty("user.home");
//        path = path.replaceAll("\\\\", "/");
//        browser.loadURL("file:///"+path+"/payment1.jsp?amount=700");

        browser.loadHTML("<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "\n"
                + "        <h1>VMM Payment Gateway Demo</h1>\n"
                + "\n"
                + "        <form action=\"\" method=\"POST\">\n"
                + "            <!-- Note that the amount is in paise = 50 INR -->\n"
                + "            <script\n"
                + "                src=\"https://checkout.razorpay.com/v1/checkout.js\"\n"
                + "                data-key=\"rzp_test_96HeaVmgRvbrfT\"\n"
                + "                data-amount=\"" + amount + "\"\n"
                + "                data-buttontext=\"Pay with Razorpay\"\n"
                + "                data-name=\"VMM Education\"\n"
                + "                data-description=\"Thank You for purchaing Silver Package.\"\n"
                + "                data-image=\"http://vmmeducation.com/images/newlogo.png\"\n"
                + "                data-prefill.name=\"Amrinder Singh\"\n"
                + "                data-prefill.email=\"amrinder@vmmeducation.com\"\n"
                + "                data-theme.color=\"#F3EE54\"\n"
                + "            ></script>\n"
                + "            <input type=\"hidden\" value=\"Hidden Element\" name=\"hidden\">\n"
                + "        </form>\n"
                + "\n"
                + "   <h1>Please close the page to proceed</h1> </body>\n"
                + "</html>\n"
                + "");
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jphoto = new javax.swing.JLabel();
        jname = new javax.swing.JLabel();
        jrequisite = new javax.swing.JLabel();
        jcategory = new javax.swing.JLabel();
        jprice = new javax.swing.JLabel();
        jsub = new javax.swing.JButton();
        jsample = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(102, 51, 0));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jphoto.setText("jLabel1");
        jphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jphoto);
        jphoto.setBounds(31, 38, 159, 136);

        jname.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jname.setText("Name");
        jPanel1.add(jname);
        jname.setBounds(286, 47, 170, 34);

        jrequisite.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jrequisite.setForeground(new java.awt.Color(102, 51, 0));
        jrequisite.setText("Pre-requisite");
        jPanel1.add(jrequisite);
        jrequisite.setBounds(286, 105, 110, 30);

        jcategory.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jcategory.setForeground(new java.awt.Color(102, 51, 0));
        jcategory.setText("Category");
        jPanel1.add(jcategory);
        jcategory.setBounds(280, 146, 110, 30);

        jprice.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jprice.setForeground(new java.awt.Color(102, 51, 0));
        jprice.setText("Price");
        jPanel1.add(jprice);
        jprice.setBounds(1540, 40, 140, 30);

        jsub.setBackground(new java.awt.Color(102, 51, 0));
        jsub.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jsub.setForeground(new java.awt.Color(255, 255, 0));
        jsub.setText("Pay to Subscribe");
        jsub.setBorder(null);
        jsub.setEnabled(false);
        jsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsubActionPerformed(evt);
            }
        });
        jPanel1.add(jsub);
        jsub.setBounds(1470, 90, 210, 23);

        jsample.setBackground(new java.awt.Color(102, 51, 0));
        jsample.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jsample.setForeground(new java.awt.Color(255, 255, 0));
        jsample.setText("View sample Video");
        jsample.setBorder(null);
        jsample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsampleActionPerformed(evt);
            }
        });
        jPanel1.add(jsample);
        jsample.setBounds(1470, 150, 210, 23);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(20, 190, 1800, 210);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        lb1.setText("jLabel1");
        jPanel2.add(lb1);
        lb1.setBounds(490, 120, 1820, 190);

        jScrollPane1.setViewportView(jPanel2);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 410, 1800, 360);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1840, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
            new Thread(new sub()).start();
            
    }

}



}
