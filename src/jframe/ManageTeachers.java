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
public class ManageTeachers extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    String TeacherName,subject,branch;
    int teacherId;
    DefaultTableModel model;
    public ManageTeachers() {
        initComponents();
        setTeacherDetailsToTable();
    }
    //to set the Teacher details into the table
    public void setTeacherDetailsToTable()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Teachers_details");
            
            while(rs.next())
            {
                String TeacherId = rs.getString("teacher_id");
                String TeacherNames = rs.getString("teach_name");
                String SubjectName = rs.getString("subject_name");
                String BranchName = rs.getString("branch");
                Object[] obj = {TeacherId,TeacherNames,SubjectName,BranchName}; 
                model = (DefaultTableModel) tbl_TeacherDetails.getModel();
                model.addRow(obj);
            }
        }
        catch(Exception e)
        {
              e.printStackTrace();
        }
    }
    
    //to add Teachers to Teachers_detials table
    public boolean addTeacher()
    {
        boolean isAdded = false;
        teacherId= Integer.parseInt(txt_teacherID.getText());
        TeacherName=txt_TeacherName.getText();
        subject=combo_SubjectName.getSelectedItem().toString();
        branch=combo_BranchName.getSelectedItem().toString();
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="insert into Teachers_details value(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, teacherId);
            pst.setString(2, TeacherName);
            pst.setString(3, subject);
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
    
    //to update Teachers Details
    public boolean updateTeacherDetail()
    {
        boolean isUpdated = false;
        teacherId= Integer.parseInt(txt_teacherID.getText());
        TeacherName=txt_TeacherName.getText();
        subject=combo_SubjectName.getSelectedItem().toString();
        branch=combo_BranchName.getSelectedItem().toString();
        try
        {
            Connection con = DBConnection.getConnection();
            String sql = "update Teachers_details set teach_name=?, subject_name =?, branch=? where teacher_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, TeacherName);
            pst.setString(2, subject);
            pst.setString(3, branch);
            pst.setInt(4, teacherId);
            
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
    
    //method to delete Teachers detail
    public boolean deleteTeacherDetails()
    {
        boolean isDeleted = false;
        teacherId= Integer.parseInt(txt_teacherID.getText());
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="delete from Teachers_details where teacher_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, teacherId);
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
      DefaultTableModel model = (DefaultTableModel) tbl_TeacherDetails.getModel();
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
        txt_TeacherName = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_teacherID = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        combo_BranchName = new javax.swing.JComboBox<>();
        combo_SubjectName = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_TeacherDetails = new rojeru_san.complementos.RSTableMetro();
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
        jLabel15.setText("Enter Teacher Name:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 190, 30));

        jLabel11.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 30, 50));

        txt_TeacherName.setBackground(new java.awt.Color(102, 102, 255));
        txt_TeacherName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_TeacherName.setPlaceholder("Enter TeacherName...");
        txt_TeacherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_TeacherNameFocusLost(evt);
            }
        });
        txt_TeacherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TeacherNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_TeacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Subject Teaching:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 190, 30));

        jLabel17.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Branch Name:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 190, 30));

        jLabel19.setFont(new java.awt.Font("STSong", 0, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Enter Teacher E-ID:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 190, 30));

        txt_teacherID.setBackground(new java.awt.Color(102, 102, 255));
        txt_teacherID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_teacherID.setPlaceholder("Enter Teacher ID...");
        txt_teacherID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_teacherIDFocusLost(evt);
            }
        });
        txt_teacherID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teacherIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_teacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 30, 50));

        jLabel13.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 30, 50));

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

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle5.setText("Add");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 120, 80));

        combo_BranchName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        combo_BranchName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "AITCSE", "IT", "MECHANICAL", " " }));
        combo_BranchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_BranchNameActionPerformed(evt);
            }
        });
        jPanel1.add(combo_BranchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 200, -1));

        combo_SubjectName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        combo_SubjectName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C Programming", "Programming with java", "Python Programming", "Algorithms Analysis", " " }));
        combo_SubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_SubjectNameActionPerformed(evt);
            }
        });
        jPanel1.add(combo_SubjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
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
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 90, 40));

        tbl_TeacherDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher E-ID", "Teacher Name", "Subject Teaching", "Branch"
            }
        ));
        tbl_TeacherDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_TeacherDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_TeacherDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_TeacherDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_TeacherDetails.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tbl_TeacherDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_TeacherDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_TeacherDetails.setFuenteHead(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        tbl_TeacherDetails.setRowHeight(30);
        tbl_TeacherDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TeacherDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_TeacherDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 700, 180));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Teachers");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 330, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 310, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 730, 700));

        setSize(new java.awt.Dimension(1095, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
HomePage home = new HomePage();   
home.setVisible(true);
dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_TeacherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TeacherNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TeacherNameFocusLost

    private void txt_TeacherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TeacherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TeacherNameActionPerformed

    private void txt_teacherIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_teacherIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teacherIDFocusLost

    private void txt_teacherIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teacherIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teacherIDActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
if (updateTeacherDetail() == true)
{
JOptionPane.showMessageDialog(this, "Teacher details are updated");
clearTable();
setTeacherDetailsToTable();
}
else
{
 JOptionPane.showMessageDialog(this, "Teacher details are not updated");   
}        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
if (deleteTeacherDetails() == true)
{
JOptionPane.showMessageDialog(this, "Teacher details are deleted");
clearTable();
setTeacherDetailsToTable(); 
}
else
{
 JOptionPane.showMessageDialog(this, "Teacher details are not deleted");   
}
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
if (addTeacher() == true)
{
JOptionPane.showMessageDialog(this, "Teacher is Added");
clearTable();
setTeacherDetailsToTable(); 
}
else
{
 JOptionPane.showMessageDialog(this, "Teacher is not Added");   
}

    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_TeacherDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TeacherDetailsMouseClicked
int rowNo = tbl_TeacherDetails.getSelectedRow();
TableModel model = tbl_TeacherDetails.getModel();

txt_teacherID.setText(model.getValueAt(rowNo, 0).toString());
txt_TeacherName.setText(model.getValueAt(rowNo, 1).toString());
combo_SubjectName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
combo_BranchName.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_TeacherDetailsMouseClicked

    private void combo_BranchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_BranchNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_BranchNameActionPerformed

    private void combo_SubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_SubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_SubjectNameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageTeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTeachers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_BranchName;
    private javax.swing.JComboBox<String> combo_SubjectName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private rojeru_san.complementos.RSTableMetro tbl_TeacherDetails;
    private app.bolivia.swing.JCTextField txt_TeacherName;
    private app.bolivia.swing.JCTextField txt_teacherID;
    // End of variables declaration//GEN-END:variables
}
