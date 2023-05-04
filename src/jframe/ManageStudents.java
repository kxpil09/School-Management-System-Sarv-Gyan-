/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author N Bansal
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    String studname,branch,course;
    int studID;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    //to set the student details into the table
    public void setStudentDetailsToTable()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Students_details");
            
            while(rs.next())
            {
                String StudentId = rs.getString("stud_id");
                String StudentName = rs.getString("stud_name");
                String CourseName = rs.getString("course");
                String BranchName = rs.getString("branch");
                Object[] obj = {StudentId,StudentName,CourseName,BranchName}; 
                model = (DefaultTableModel) tbl_StudentsDetails.getModel();
                model.addRow(obj);
            }
        }
        catch(Exception e)
        {
              e.printStackTrace();
        }
    }
    
    //to add students to Students_detials table
    public boolean addStudent()
    {
        boolean isAdded = false;
        studID= Integer.parseInt(txt_studID.getText());
        studname=txt_studName.getText();
        course=txt_CourseName.getText();
        branch=txt_BranchName.getText(); 
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="insert into Students_details value(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studID);
            pst.setString(2, studname);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
               isAdded = true;
            }   
            else
            {
                isAdded = false;
            }
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
        return isAdded;
    }
    
    //to update student Details
    public boolean updateStudentDetail()
    {
        boolean isUpdated = false;
        studID= Integer.parseInt(txt_studID.getText());
        studname=txt_studName.getText();
        course=txt_CourseName.getText();
        branch=txt_BranchName.getText();
        try
        {
            Connection con = DBConnection.getConnection();
            String sql = "update Students_details set stud_name=?, course =?, branch=? where stud_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studname);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studID);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
               isUpdated = true;
            }   
            else
            {
                isUpdated= false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    //method to delete Students detail
    public boolean deleteStudentDetails()
    {
        boolean isDeleted = false;
        studID= Integer.parseInt(txt_studID.getText());
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="delete from Students_details where stud_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studID);
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
               isDeleted = true;
            }   
            else
            {
                isDeleted= false;
            } 
        }
        catch(Exception e)
        {
             e.printStackTrace();       
        }
        return isDeleted;
    }
        
    //method to clear the table, so that complete data is fetched from the database
   public void clearTable()
   {
      DefaultTableModel model = (DefaultTableModel) tbl_StudentsDetails.getModel();
      model.setRowCount(0);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_studName = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_CourseName = new app.bolivia.swing.JCTextField();
        txt_BranchName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        jLabel20 = new javax.swing.JLabel();
        txt_studID = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_StudentsDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jLabel15.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Enter Student Name:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 190, 30));

        jLabel11.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 30, 50));

        txt_studName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studName.setPlaceholder("Enter StudentName...");
        txt_studName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studNameFocusLost(evt);
            }
        });
        txt_studName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Student Course:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 190, 30));

        jLabel17.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Enter Student Branch:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 190, 30));

        txt_CourseName.setBackground(new java.awt.Color(102, 102, 255));
        txt_CourseName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_CourseName.setPlaceholder("Enter CourseName...");
        txt_CourseName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CourseNameFocusLost(evt);
            }
        });
        txt_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        txt_BranchName.setBackground(new java.awt.Color(102, 102, 255));
        txt_BranchName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BranchName.setPlaceholder("Enter StudentBranch...");
        txt_BranchName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BranchNameFocusLost(evt);
            }
        });
        txt_BranchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BranchNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BranchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 482, -1, 30));

        jLabel12.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 30, 50));

        jLabel13.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 30, 50));

        jLabel14.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 30, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 120, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("Delete");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 120, 80));

        jLabel20.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Enter Student ID:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 190, 30));

        txt_studID.setBackground(new java.awt.Color(102, 102, 255));
        txt_studID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studID.setPlaceholder("Enter Studnet ID...");
        txt_studID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studIDFocusLost(evt);
            }
        });
        txt_studID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle5.setText("ADD");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 120, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 90, 40));

        tbl_StudentsDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ));
        tbl_StudentsDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_StudentsDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_StudentsDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_StudentsDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_StudentsDetails.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tbl_StudentsDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_StudentsDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_StudentsDetails.setFuenteHead(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        tbl_StudentsDetails.setRowHeight(30);
        tbl_StudentsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentsDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_StudentsDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 700, 180));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 330, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 290, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 730, 700));

        setSize(new java.awt.Dimension(1095, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
HomePage home = new HomePage();   
home.setVisible(true);
dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studNameFocusLost

    private void txt_studNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studNameActionPerformed

    private void txt_CourseNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CourseNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CourseNameFocusLost

    private void txt_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CourseNameActionPerformed

    private void txt_BranchNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BranchNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BranchNameFocusLost

    private void txt_BranchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BranchNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BranchNameActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
if (updateStudentDetail() == true)
{
JOptionPane.showMessageDialog(this, "student details are updated");
clearTable();
setStudentDetailsToTable(); 
}
else
{
 JOptionPane.showMessageDialog(this, "student details are not updated");   
}        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
if (deleteStudentDetails() == true)
{
JOptionPane.showMessageDialog(this, "student details are deleted");
clearTable();
setStudentDetailsToTable(); 
}
else
{
 JOptionPane.showMessageDialog(this, "student details are not deleted");   
}
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
if (addStudent() == true)
{
JOptionPane.showMessageDialog(this, "student is Added");
clearTable();
setStudentDetailsToTable(); 
}
else
{
 JOptionPane.showMessageDialog(this, "student is not Added");   
}

    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_StudentsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentsDetailsMouseClicked
int rowNo = tbl_StudentsDetails.getSelectedRow();
TableModel model = tbl_StudentsDetails.getModel();

txt_studID.setText(model.getValueAt(rowNo, 0).toString());
txt_studName.setText(model.getValueAt(rowNo, 1).toString());
txt_CourseName.setText(model.getValueAt(rowNo, 2).toString());
txt_BranchName.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_StudentsDetailsMouseClicked

    private void txt_studIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studIDFocusLost

    private void txt_studIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studIDActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tbl_StudentsDetails;
    private app.bolivia.swing.JCTextField txt_BranchName;
    private app.bolivia.swing.JCTextField txt_CourseName;
    private app.bolivia.swing.JCTextField txt_studID;
    private app.bolivia.swing.JCTextField txt_studName;
    // End of variables declaration//GEN-END:variables
}
