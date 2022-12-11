/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodEnterpriseAdminWorkArea;

import Business.Community.Community;
import Business.Employee.CommunityAdminEmployee;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.Roles.CommunityAdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gauripatil
 */
public class ManageCommunityAdmin extends javax.swing.JPanel {

    /**
     * Creates new form ManageCommunityAdmin
     */
     private JPanel userProcessContainer;
    private Enterprise enterprise;
    public ManageCommunityAdmin(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        lblErrPassword.setVisible(false);
        lblErrUsername.setVisible(false);
        lblErrCommunityName.setVisible(false);
        populateTable();
        populateCombobox();
        tblCommunityAdmin.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
    }
    
    public void populateCombobox(){
        cboCommunity.removeAllItems();
        if (enterprise instanceof FoodManagementEnterprise){
            FoodManagementEnterprise foodManagementEnterprise = (FoodManagementEnterprise) enterprise;
            for (Community community : foodManagementEnterprise.getCommunityArrayList()){
                
//                if(!(community.getCommunityOrganization().getEmployeeDirectory().getEmployeeList().size() > 0 )){
//                    cboCommunity.addItem(community);
//                }
                cboCommunity.addItem(community);
                     
               }
        }

    }
    
    public void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblCommunityAdmin.getModel();
        model.setRowCount(0);
        if (enterprise instanceof FoodManagementEnterprise){
            FoodManagementEnterprise foodManagementEnterprise = (FoodManagementEnterprise) enterprise;
            
            for(Community community : foodManagementEnterprise.getCommunityArrayList() ){
                
                for (UserAccount useraccount : community.getCommunityOrganization().getUserAccountDirectory().getUserAccountArrayList()){
                    Object[] row = new Object[2];
                    row[0] = community.getCommunityName();
                    row[1] = useraccount.getUsername();
                    
                    model.addRow(row);
                }
            }
                
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCommunityAdmin = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboCommunity = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblErrUsername = new javax.swing.JLabel();
        lblErrPassword = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JTextField();
        lblErrCommunityName = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Community Admin");

        tblCommunityAdmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblCommunityAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Community Name", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCommunityAdmin);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Select Community: ");

        cboCommunity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("UserName");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblErrUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrUsername.setForeground(new java.awt.Color(255, 0, 51));
        lblErrUsername.setText("errMessage");

        lblErrPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrPassword.setForeground(new java.awt.Color(255, 0, 51));
        lblErrPassword.setText("errMessage");

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Community Admin Name");

        txtAdminName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblErrCommunityName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrCommunityName.setForeground(new java.awt.Color(255, 0, 51));
        lblErrCommunityName.setText("errMessage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAdminName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCommunity, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrUsername)
                                    .addComponent(lblErrPassword)
                                    .addComponent(lblErrCommunityName)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrUsername))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrPassword)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrCommunityName))
                .addGap(35, 35, 35)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String userName = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String name = txtAdminName.getText();
        
        if(userName.isEmpty() ){
            lblErrUsername.setText("User Name cannot be blank");
            lblErrUsername.setVisible(true);
            return;
        }
        
        
        Pattern p = Pattern.compile("^[a-z\\s]+");
        Matcher m = p.matcher(userName);  
        if(!m.matches())
        {
            txtUserName.setText("");
            txtPassword.setText("");
            txtAdminName.setText("");
            JOptionPane.showMessageDialog(null, "Invalid username");
            
            return;
        }
        
        if(password.isEmpty() ){
            lblErrPassword.setText("Password cannot be blank");
            lblErrPassword.setVisible(true);
            return;
        }
        
        p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        m = p.matcher(password);  
        if(!m.matches())
        {
            txtUserName.setText("");
            txtPassword.setText("");
            txtAdminName.setText("");
            JOptionPane.showMessageDialog(null, "Password should contain atleast One Uppercase, one Lowercase, a number and a special character");
            
            return;
        }
        
        if(name.isEmpty() ){
            
            txtAdminName.setText("Name cannot be blank");
            txtAdminName.setVisible(true);
            return;
        }
        
        p = Pattern.compile("^[a-zA-Z \\s]+");
        m = p.matcher(name);  
        if(!m.matches())
        {
             txtUserName.setText("");
            txtPassword.setText("");
            txtAdminName.setText("");
            JOptionPane.showMessageDialog(null, "Invalid Name");
            
            return;
        }
        
        Community c = (Community) cboCommunity.getSelectedItem();
        
        if(null != c.getCommunityOrganization().getUserAccountDirectory().getUserAccountArrayList() && !c.getCommunityOrganization().getUserAccountDirectory().getUserAccountArrayList().isEmpty())
        {
            for(UserAccount ua : c.getCommunityOrganization().getUserAccountDirectory().getUserAccountArrayList())
            {
                if(userName.equalsIgnoreCase(ua.getUsername()))
                {
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtAdminName.setText("");
                    JOptionPane.showMessageDialog(null, "User already exist in the System");
            
                    return;
                }
            }
        }
        Employee ee = c.getCommunityOrganization().getEmployeeDirectory().createEmployee(name,c,new CommunityAdminEmployee());
        UserAccount uu = c.getCommunityOrganization().getUserAccountDirectory().createUserAccount(userName, password, ee, new CommunityAdminRole());
        txtAdminName.setText("");
        txtPassword.setText("");
        txtUserName.setText("");
        lblErrCommunityName.setText("");
        lblErrPassword.setText("");
        lblErrUsername.setText("");
        JOptionPane.showMessageDialog(null, "Community Admin successfully created");

        
        populateTable();
        
        
        
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cboCommunity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrCommunityName;
    private javax.swing.JLabel lblErrPassword;
    private javax.swing.JLabel lblErrUsername;
    private javax.swing.JTable tblCommunityAdmin;
    private javax.swing.JTextField txtAdminName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
