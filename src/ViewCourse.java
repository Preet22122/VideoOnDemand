
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import static com.mashape.unirest.http.Unirest.delete;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ViewCourse extends javax.swing.JFrame {

    ArrayList<Course> courseList;
    ViewCourseModel tableModel;
    int n;

    public ViewCourse() {
        initComponents();
         setSize(1179,642);
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int x = width/3 - (1179/2);
        int y = height/3 - (642/2);
        setLocation(x, y);


        tableModel = new ViewCourseModel();
        courseList = new ArrayList<>();
        jt1.setModel(tableModel);
        new Thread(new FetchCoursesJob()).start();
    }

    class FetchCoursesJob implements Runnable {

        @Override
        public void run() {
            try {
                HttpResponse httpResponse = Unirest.get("http://"+globalvariable.host+"/fetchdata").asString();
                String result = httpResponse.getBody().toString();
                StringTokenizer st = new StringTokenizer(result, "~");
                courseList.clear();
                while (st.hasMoreTokens()) {
                    String courseRow = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(courseRow, ";");
                    String courseName = st2.nextToken();
                    String desc = st2.nextToken();
                    String preReq = st2.nextToken();
                    int amount = Integer.parseInt(st2.nextToken());
                    courseList.add(new Course(courseName, desc, preReq, amount));
                }
                tableModel.fireTableDataChanged();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jbdelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(null);

        jt1.setBackground(new java.awt.Color(255, 255, 0));
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
        jt1.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jScrollPane1.setViewportView(jt1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 90, 830, 402);

        jbdelete.setBackground(new java.awt.Color(255, 255, 0));
        jbdelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jbdelete.setForeground(new java.awt.Color(102, 51, 0));
        jbdelete.setText("Delete");
        jbdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jbdelete);
        jbdelete.setBounds(510, 540, 210, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1170, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdeleteActionPerformed
         n = jt1.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "select row");
        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure want to delete?", "confirmation", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                Thread t = new Thread(new delete());
                t.start();

            }

        }

    }//GEN-LAST:event_jbdeleteActionPerformed

    class delete implements Runnable {

        @Override
        public void run() {

            try {
                HttpResponse<String> ans =   Unirest.get("http://"+globalvariable.host+"/deletecourse")
                 .queryString("coursename",courseList.get(n).name)
                        .asString();
                
                new Thread(new FetchCoursesJob()).start();
                
                

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCourse().setVisible(true);
            }
        });
    }

    class ViewCourseModel extends AbstractTableModel {

        String columns[] = {"Name", "Category", "Pre-requisiteds", "Amount"};

        @Override
        public String getColumnName(int i) {

            return columns[i];
        }

        @Override
        public int getRowCount() {
            return courseList.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            Course course = courseList.get(row);
            if (column == 0) {
                return course.name;
            } else if (column == 1) {
                return course.category;
            } else if (column == 2) {
                return course.requisite;
            } else if (column == 3) {
                return course.amount;
            }
            return "";
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbdelete;
    private javax.swing.JTable jt1;
    // End of variables declaration//GEN-END:variables
}
