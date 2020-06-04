
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class managevideos extends javax.swing.JFrame {

    File f1, f2, f3;
    ArrayList<video> videoList;
    ViewVideoModel tablemodel;
    int n;
    
    public managevideos() {
        initComponents();
        videoList = new ArrayList<>();
        tablemodel = new ViewVideoModel();
        jt1.setModel(tablemodel);

        cb1.removeAllItems();
        globalvariable obj = new globalvariable();
        for (int i = 0; i < globalvariable.category.length; i++) {
            String cat = globalvariable.category[i];
            cb1.addItem(cat);
            setVisible(true);
            setSize(1286,630);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/3 - (650/2);
        int y = height/3 - (300/2);
        setLocation(x, y);



        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        btfetch = new javax.swing.JButton();
        lb4 = new javax.swing.JLabel();
        tflacnum = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        tftitle = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        tfduration = new javax.swing.JTextField();
        lb7 = new javax.swing.JLabel();
        tfvideo = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfvtitle = new javax.swing.JTextField();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        btdelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        lb1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 0));
        lb1.setText("Manage videos");
        jPanel1.add(lb1);
        lb1.setBounds(490, 20, 280, 43);

        lb3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 0));
        lb3.setText("Select Course");
        jPanel1.add(lb3);
        lb3.setBounds(730, 160, 190, 40);

        cb1.setBackground(new java.awt.Color(255, 255, 0));
        cb1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        cb1.setForeground(new java.awt.Color(102, 51, 0));
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb1.setBorder(null);
        cb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb1ItemStateChanged(evt);
            }
        });
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        jPanel1.add(cb1);
        cb1.setBounds(940, 100, 260, 40);

        cb2.setBackground(new java.awt.Color(255, 255, 0));
        cb2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        cb2.setForeground(new java.awt.Color(102, 51, 0));
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb2.setBorder(null);
        jPanel1.add(cb2);
        cb2.setBounds(940, 160, 250, 40);

        btfetch.setBackground(new java.awt.Color(255, 255, 0));
        btfetch.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btfetch.setForeground(new java.awt.Color(102, 51, 0));
        btfetch.setText("Fetch");
        btfetch.setBorder(null);
        btfetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfetchActionPerformed(evt);
            }
        });
        jPanel1.add(btfetch);
        btfetch.setBounds(940, 220, 130, 30);

        lb4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 0));
        lb4.setText("Enter Lacture Number");
        jPanel1.add(lb4);
        lb4.setBounds(40, 120, 240, 30);

        tflacnum.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tflacnum.setBorder(null);
        jPanel1.add(tflacnum);
        tflacnum.setBounds(310, 120, 212, 32);

        lb2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 0));
        lb2.setText("Select Category");
        jPanel1.add(lb2);
        lb2.setBounds(730, 100, 180, 40);

        lb5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 0));
        lb5.setText("Enter Title");
        jPanel1.add(lb5);
        lb5.setBounds(40, 200, 240, 30);

        tftitle.setBorder(null);
        jPanel1.add(tftitle);
        tftitle.setBounds(310, 200, 212, 30);

        lb6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 0));
        lb6.setText("Enter Duration");
        jPanel1.add(lb6);
        lb6.setBounds(40, 270, 240, 33);

        tfduration.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tfduration.setBorder(null);
        jPanel1.add(tfduration);
        tfduration.setBounds(310, 270, 212, 33);

        lb7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lb7.setForeground(new java.awt.Color(255, 255, 0));
        lb7.setText("Select Video");
        jPanel1.add(lb7);
        lb7.setBounds(40, 340, 240, 30);

        tfvideo.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tfvideo.setBorder(null);
        jPanel1.add(tfvideo);
        tfvideo.setBounds(310, 340, 212, 34);

        bt1.setBackground(new java.awt.Color(255, 255, 0));
        bt1.setForeground(new java.awt.Color(102, 51, 0));
        bt1.setText("Browse");
        bt1.setBorder(null);
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        jPanel1.add(bt1);
        bt1.setBounds(540, 340, 120, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Select Title");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 390, 250, 30);

        tfvtitle.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tfvtitle.setBorder(null);
        tfvtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfvtitleActionPerformed(evt);
            }
        });
        jPanel1.add(tfvtitle);
        tfvtitle.setBounds(310, 400, 220, 32);

        bt2.setBackground(new java.awt.Color(255, 255, 0));
        bt2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bt2.setForeground(new java.awt.Color(102, 51, 0));
        bt2.setText("Browse");
        bt2.setBorder(null);
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel1.add(bt2);
        bt2.setBounds(540, 400, 120, 30);

        bt3.setBackground(new java.awt.Color(255, 255, 0));
        bt3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bt3.setForeground(new java.awt.Color(102, 51, 0));
        bt3.setText("Add");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        jPanel1.add(bt3);
        bt3.setBounds(310, 460, 180, 40);

        jt1.setBackground(new java.awt.Color(255, 255, 0));
        jt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.green, java.awt.Color.green, java.awt.Color.green, java.awt.Color.green));
        jt1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jt1.setForeground(new java.awt.Color(102, 51, 0));
        jt1.setModel(new javax.swing.table.DefaultTableModel(
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
        jt1.setGridColor(new java.awt.Color(102, 51, 0));
        jt1.setSelectionBackground(new java.awt.Color(102, 51, 0));
        jScrollPane1.setViewportView(jt1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(730, 260, 490, 230);

        btdelete.setBackground(new java.awt.Color(255, 255, 0));
        btdelete.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btdelete.setForeground(new java.awt.Color(102, 51, 0));
        btdelete.setText("Delete");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btdelete);
        btdelete.setBounds(890, 510, 160, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1290, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb1ItemStateChanged
        // TODO add your handling code here:

        if (cb1.getSelectedItem() != null) {
            new Thread(new job()).start();

        }

    }//GEN-LAST:event_cb1ItemStateChanged

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            f1 = jfc.getSelectedFile();
            tfvideo.setText(f1.getPath());
        }


    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            f2 = jfc.getSelectedFile();
            tfvtitle.setText(f2.getPath());
        }

    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        
        new Thread(new add()).start();

    }//GEN-LAST:event_bt3ActionPerformed

    private void tfvtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfvtitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfvtitleActionPerformed

    private void btfetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfetchActionPerformed

        new Thread(new FetchvideoJob()).start();

    }//GEN-LAST:event_btfetchActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
               n = jt1.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "select row");
        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure want to delete?", "confirmation", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                Thread t = new Thread(new delete1());
                t.start();

            }

        }

    }                                        

    class delete1 implements Runnable {

        @Override
        public void run() {

            try {
                int videoId =videoList.get(n).videoId;
                
                System.out.println(videoId);
                HttpResponse<String> ans = Unirest.get("http://"+globalvariable.host+"/deletevideo")
                 .queryString("videoid",videoId+"")
                        .asString();
                if(ans.getBody().equals("success")){
                    JOptionPane.showMessageDialog(managevideos.this, "Video Deleted successfully!!");
                    new Thread(new FetchvideoJob()).start();
                }
                else{
                    JOptionPane.showMessageDialog(managevideos.this, "deletion failed!!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btdeleteActionPerformed
    class FetchvideoJob implements Runnable {

        @Override
        public void run() {
            try {
                HttpResponse httpResponse = Unirest.get("http://"+globalvariable.host+"/fetchvideo").asString();
                String result = httpResponse.getBody().toString();
                StringTokenizer st = new StringTokenizer(result, "~");
                videoList.clear();
                while (st.hasMoreTokens()) {
                    String courseRow = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(courseRow, ";");
                    int video_id = Integer.parseInt(st2.nextToken());
                    String lecNo = st2.nextToken();
                    String title = st2.nextToken();
                    String duration = (st2.nextToken());
                    videoList.add(new video(video_id, lecNo, title, duration));
                }
                tablemodel.fireTableDataChanged();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    class ViewVideoModel extends AbstractTableModel {

        String columns[] = {"video_id", "lacnum", "title", "duration"};

        @Override
        public String getColumnName(int i) {

            return columns[i];
        }

        @Override
        public int getRowCount() {
            return videoList.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            video video = videoList.get(row);
            if (column == 0) {
                return video.videoId;
            } else if (column == 1) {
                return video.lecNo;
            } else if (column == 2) {
                return video.title;
            } else if (column == 3) {
                return video.duration;
            }
            return "";
        }
    }

    class add implements Runnable {

        @Override
        public void run() {
            String course = cb2.getSelectedItem().toString();
            String lacnum = tflacnum.getText();
            String title = tftitle.getText();
            String duration = tfduration.getText();
            String video = tfvideo.getText();
            String vtitle = tfvtitle.getText();

            try {
                HttpResponse<String> res = Unirest.post("http://"+globalvariable.host+"/addvideo")
                        .queryString("course", course)
                        .queryString("lacnum", lacnum)
                        .queryString("title", title)
                        .queryString("duration", duration)
                        .field("video", new File(video))
                        .field("vtitle", new File(vtitle))
                        .asString();
                String ans = res.getBody();
                JOptionPane.showMessageDialog(rootPane, ans);

                String msg = res.getBody();
                if (msg.equals("rowadded")) {
//                    System.out.println("course added");
                    JOptionPane.showMessageDialog(managevideos.this, "Video Added!!");
                    new Thread(new FetchvideoJob()).start();

                } else {
//                    System.out.println("failed");
                    JOptionPane.showMessageDialog(managevideos.this, "Failed!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class job implements Runnable {

        @Override
        public void run() {
            try {

                String cat = cb1.getSelectedItem().toString();

                HttpResponse<String> res = Unirest.get("http://"+globalvariable.host+"/sendcourses")
                        .queryString("category", cat)
                        .asString();

                String ans = res.getBody();
                StringTokenizer st = new StringTokenizer(ans, ";");
                cb2.removeAllItems();
                while (st.hasMoreTokens()) {
                    cb2.addItem(st.nextToken());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managevideos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btfetch;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JTextField tfduration;
    private javax.swing.JTextField tflacnum;
    private javax.swing.JTextField tftitle;
    private javax.swing.JTextField tfvideo;
    private javax.swing.JTextField tfvtitle;
    // End of variables declaration//GEN-END:variables
}
