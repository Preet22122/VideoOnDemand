
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class download extends javax.swing.JFrame {

    String vtitle;
    String name;

    public download(String vtitle) {
        initComponents();
        this.vtitle = vtitle;
        name = vtitle.substring(vtitle.lastIndexOf("/") + 1);
        new Thread(new job()).start();
       
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(width, height);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb1 = new javax.swing.JLabel();
        pb1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setForeground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        jlb1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jlb1.setForeground(new java.awt.Color(255, 255, 0));
        jlb1.setText("Wait File is Downloading........");
        jPanel1.add(jlb1);
        jlb1.setBounds(90, 60, 460, 110);

        pb1.setBackground(new java.awt.Color(255, 255, 0));
        pb1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(pb1);
        pb1.setBounds(60, 240, 600, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    class job implements Runnable {

        @Override
        public void run() {
            try {
                HttpResponse<InputStream> httpresponse = Unirest.get("http://"+globalvariable.host+"/GetResource/" + vtitle).asBinary();

                //File Download Code
                InputStream is = httpresponse.getBody();
                FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + name);

                long contentlength = Integer.parseInt(httpresponse.getHeaders().getFirst("Content-Length"));
                byte b[] = new byte[10000];
                int r;
                long count = 0;

                while (true) {
                    r = is.read(b, 0, 10000);
                    fos.write(b, 0, r);
                    count = count + r;
                    int per = (int) (count * 100 / contentlength);
                    pb1.setValue(per);
                    pb1.setString(per + "%");
                    if (count == contentlength) {
                        break;
                    }
                }

                fos.close();
                jlb1.setText("File Downloaded!!!");
                JOptionPane.showMessageDialog(download.this,"succesfull");
                 
                

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlb1;
    private javax.swing.JProgressBar pb1;
    // End of variables declaration//GEN-END:variables
}
