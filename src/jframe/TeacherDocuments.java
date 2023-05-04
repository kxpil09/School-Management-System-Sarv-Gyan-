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
public class TeacherDocuments extends javax.swing.JFrame {

    /**
     * Creates new form StudentDocuments
     */
    String teachname, doc, penddoc, docstatus;
    int teacherId;
    DefaultTableModel model;
    
    public TeacherDocuments() 
    {
        initComponents();
        setteachDocumentDetailsToTable();
    }
    public void setteachDocumentDetailsToTable()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from doc_teachdetails");
            
            while(rs.next())
            {
                String TeacherId = rs.getString("teacher_id");
                String TeacherNames = rs.getString("teach_name");
                String DocumentName = rs.getString("document_name");
                String PendingDocument = rs.getString("penddocument_name");
                String DocStatus = rs.getString("docstatus");
                Object[] obj = {TeacherId,TeacherNames,DocumentName,PendingDocument,DocStatus}; 
                model = (DefaultTableModel) tbl_DocTeacherDetail.getModel();
                model.addRow(obj);
            }
        }
        catch(Exception e)
        {
              e.printStackTrace();
        }
    }
    
    public boolean addteacherdocdetails()
    {
        boolean isAdded = false;
        teacherId = Integer.parseInt(txt_teacherid.getText());
        teachname=txt_teachname.getText();
        doc=txt_doc.getText();
        penddoc=txt_penddoc.getText();
        docstatus=combo_docstatus.getSelectedItem().toString();
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="insert into doc_teachdetails value(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, teacherId);
            pst.setString(2, teachname);
            pst.setString(3, doc);
            pst.setString(4, penddoc);
            pst.setString(5, docstatus);
            
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
    
    public boolean updateteacherDocDetail()
    {
        boolean isUpdated = false;
        teacherId= Integer.parseInt(txt_teacherid.getText());
        teachname=txt_teachname.getText();
        doc=txt_doc.getText();
        penddoc=txt_penddoc.getText();
        docstatus=combo_docstatus.getSelectedItem().toString();
        try
        {
            Connection con = DBConnection.getConnection();
            String sql = "update doc_teachdetails set teach_name=?, document_name =?, penddocument_name=?, docstatus=? where teacher_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, teachname);
            pst.setString(2, doc);
            pst.setString(3, penddoc);
            pst.setString(4, docstatus);
            pst.setInt(5,teacherId);
            
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
    public boolean deleteteacherDocDetails()
    {
        boolean isDeleted = false;
        teacherId= Integer.parseInt(txt_teacherid.getText());
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="delete from doc_teachdetails where teacher_id =?";
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
    public void clearTable()
   {
      DefaultTableModel model = (DefaultTableModel) tbl_DocTeacherDetail.getModel();
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

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txt_teachname = new app.bolivia.swing.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_penddoc = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_teacherid = new app.bolivia.swing.JCTextField();
        combo_docstatus = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txt_doc = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DocTeacherDetail = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Students");

        jLabel6.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel4.setText("Teacher Document Details");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, 5));

        jLabel24.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel24.setText("Enter Teacher ID:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 190, 30));

        txt_teachname.setBackground(new java.awt.Color(102, 102, 255));
        txt_teachname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_teachname.setPlaceholder("Enter Studnet Name...");
        txt_teachname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_teachnameFocusLost(evt);
            }
        });
        txt_teachname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teachnameActionPerformed(evt);
            }
        });
        jPanel6.add(txt_teachname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel26.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel26.setText("Enter Teacher Name:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 190, 30));

        txt_penddoc.setBackground(new java.awt.Color(102, 102, 255));
        txt_penddoc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_penddoc.setPlaceholder("Documents name...");
        txt_penddoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_penddocFocusLost(evt);
            }
        });
        txt_penddoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_penddocActionPerformed(evt);
            }
        });
        jPanel6.add(txt_penddoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel21.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel21.setText("Document Status:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 190, 30));

        jLabel23.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel23.setText("Documents:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 190, 30));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_teacherid.setBackground(new java.awt.Color(102, 102, 255));
        txt_teacherid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_teacherid.setPlaceholder("Enter Studnet ID...");
        txt_teacherid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_teacheridFocusLost(evt);
            }
        });
        txt_teacherid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teacheridActionPerformed(evt);
            }
        });
        jPanel6.add(txt_teacherid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        combo_docstatus.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        combo_docstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending ", "Submitted", " ", " " }));
        combo_docstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_docstatusActionPerformed(evt);
            }
        });
        jPanel6.add(combo_docstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 200, -1));

        jLabel25.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel25.setText("Pending Documents:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 190, 30));

        txt_doc.setBackground(new java.awt.Color(102, 102, 255));
        txt_doc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_doc.setPlaceholder("Documents name...");
        txt_doc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_docFocusLost(evt);
            }
        });
        txt_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_docActionPerformed(evt);
            }
        });
        jPanel6.add(txt_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle5.setText("Add");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 120, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("delete");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 120, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 120, 80));

        jLabel14.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 30, 70));

        jLabel11.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 30, 50));

        jLabel12.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 30, 50));

        jLabel15.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 30, 50));

        jLabel16.setFont(new java.awt.Font("STSong", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 30, 50));

        panel_main.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 770));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 770));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Serif", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Edit_Property_50px.png"))); // NOI18N
        jLabel5.setText("Manage Teacher Documents");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 490, 60));

        tbl_DocTeacherDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher E-ID", "Teacher Name", "Document ", "Pending Document ", "Document Status"
            }
        ));
        tbl_DocTeacherDetail.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_DocTeacherDetail.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_DocTeacherDetail.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_DocTeacherDetail.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_DocTeacherDetail.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        tbl_DocTeacherDetail.setFuenteFilas(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_DocTeacherDetail.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_DocTeacherDetail.setFuenteHead(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        tbl_DocTeacherDetail.setRowHeight(30);
        tbl_DocTeacherDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DocTeacherDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DocTeacherDetail);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 710, 180));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 80, 40));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 750, 770));

        setSize(new java.awt.Dimension(1128, 769));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_teachnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_teachnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teachnameFocusLost

    private void txt_teachnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teachnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teachnameActionPerformed

    private void txt_penddocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_penddocFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_penddocFocusLost

    private void txt_penddocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_penddocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_penddocActionPerformed

    private void txt_teacheridFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_teacheridFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teacheridFocusLost

    private void txt_teacheridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teacheridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teacheridActionPerformed

    private void combo_docstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_docstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_docstatusActionPerformed

    private void txt_docFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_docFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_docFocusLost

    private void txt_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_docActionPerformed

    private void tbl_DocTeacherDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DocTeacherDetailMouseClicked
 int rowNo = tbl_DocTeacherDetail.getSelectedRow();
 TableModel model = tbl_DocTeacherDetail.getModel();

txt_teacherid.setText(model.getValueAt(rowNo, 0).toString());
txt_teachname.setText(model.getValueAt(rowNo, 1).toString());
txt_doc.setText(model.getValueAt(rowNo, 2).toString());
txt_penddoc.setText(model.getValueAt(rowNo, 3).toString());
combo_docstatus.setSelectedItem(model.getValueAt(rowNo, 4).toString());
    }//GEN-LAST:event_tbl_DocTeacherDetailMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        if (addteacherdocdetails() == true)
        {
            JOptionPane.showMessageDialog(this, "Teacher Details are Added");
            clearTable();
            setteachDocumentDetailsToTable();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Teacher Details  are not Added");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
    if (deleteteacherDocDetails() == true)
    {
        JOptionPane.showMessageDialog(this, "Teacher Details  are deleted");
        clearTable();
        setteachDocumentDetailsToTable();
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Teacher Details  are not deleted");   
    }        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if (updateteacherDocDetail() == true)
        {
            JOptionPane.showMessageDialog(this, "Teacher Details  are updated");
            clearTable();
            setteachDocumentDetailsToTable();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Teacher Details  are not updated");
        }        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
System.exit(0);           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(TeacherDocuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDocuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDocuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDocuments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherDocuments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_docstatus;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_main;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tbl_DocTeacherDetail;
    private app.bolivia.swing.JCTextField txt_doc;
    private app.bolivia.swing.JCTextField txt_penddoc;
    private app.bolivia.swing.JCTextField txt_teacherid;
    private app.bolivia.swing.JCTextField txt_teachname;
    // End of variables declaration//GEN-END:variables
}
