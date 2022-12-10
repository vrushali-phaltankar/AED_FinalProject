/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SystemAdminWorkArea;

import Business.City.City;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kunal
 */
public class ManageEnterprise extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterprise
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private String enterpriseName;
    private String cityName;
    public ManageEnterprise(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        synchronized (system) {}
		tblEnterpriseTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				DefaultTableModel model = (DefaultTableModel) tblEnterpriseTable.getModel();
				int row = tblEnterpriseTable.getSelectedRow();
                                int column = tblEnterpriseTable.getSelectedColumn();
				if (row < 0)
				{
					JOptionPane.showMessageDialog(null, "Please select city");
					return;
				}
				enterpriseName = model.getValueAt(row, 0).toString();
                                cityName = model.getValueAt(row, 1).toString();
			}
		});
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        lblErrEnterprise.setVisible(false);
        populateCombobox();
        populateTable();
        tblEnterpriseTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
    }
    
    public void populateCombobox(){
        
        cboCity.removeAllItems();
        cboEnterpriseType.removeAllItems();
        for (City city : system.getCitiesList()){
            cboCity.addItem(city);
        }
        
        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()){
            cboEnterpriseType.addItem(type);
            
        }
        
    }
    public void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblEnterpriseTable.getModel();

        model.setRowCount(0);
        for (City city : system.getCitiesList()) {
            for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseArrayList()) {
                Object[] row = new Object[3];
                row[0] = enterprise.getName();
                row[1] = city.getName();
                row[2] = enterprise.getEnterpriseType().getValue();

                model.addRow(row);
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
        tblEnterpriseTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboCity = new javax.swing.JComboBox();
        cboEnterpriseType = new javax.swing.JComboBox();
        txtEnterpriseName = new javax.swing.JTextField();
        lblErrEnterprise = new javax.swing.JLabel();
        btnAddEnterprise = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Enterprise");

        tblEnterpriseTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblEnterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "EnterpriseName", "AssociatedArea", "Type of EnterPrise"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnterpriseTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEnterpriseTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Select City");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Select Enterprise Type");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Enterprise Name");

        cboCity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboEnterpriseType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboEnterpriseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtEnterpriseName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblErrEnterprise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblErrEnterprise.setForeground(java.awt.Color.red);
        lblErrEnterprise.setText("errEnterpriseName");

        btnAddEnterprise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddEnterprise.setText("Add Enterprise");
        btnAddEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEnterpriseActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddEnterprise)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboEnterpriseType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblErrEnterprise)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboEnterpriseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblErrEnterprise)
                .addGap(10, 10, 10)
                .addComponent(btnAddEnterprise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEnterpriseActionPerformed
        // TODO add your handling code here:
        City city = (City) cboCity.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) cboEnterpriseType.getSelectedItem();

        if (city == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }

        String name = txtEnterpriseName.getText();

        if (name.isEmpty()){
            lblErrEnterprise.setText("Enterprise name cannot be blank");
            lblErrEnterprise.setVisible(true);
        }

        Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]+");
        Matcher m = p.matcher(name);  
        if(!m.matches())
        {
            JOptionPane.showMessageDialog(null, "Invalid Enterprise Name");
            return;
        }
        Enterprise enterprise = city.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        
        populateTable();
        txtEnterpriseName.setText("");
        
                   
        JOptionPane.showMessageDialog(null, "Enterprise added successfully");
        
    }//GEN-LAST:event_btnAddEnterpriseActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkArea systemAdminwjp = (SystemAdminWorkArea) component;
        systemAdminwjp.populateJtree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tblEnterpriseTable.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "Please select Enterprise");
			return;
		}
		
		Enterprise tempEnterprise = null;
                City tempCity = null;
                if (null != system.getCitiesList() && !system.getCitiesList().isEmpty())
		{
                    for(City city : system.getCitiesList())
                    {
                        if(cityName.equalsIgnoreCase(city.getName()))
                        {
                            tempCity = city;
                            break;
                        }
                    }
                }
                

		if ( null!= tempCity && null != tempCity.getEnterpriseDirectory() && !tempCity.getEnterpriseDirectory().getEnterpriseArrayList().isEmpty())
		{
			for (Enterprise enterprise : tempCity.getEnterpriseDirectory().getEnterpriseArrayList())
			{
				if (enterpriseName.equalsIgnoreCase(enterprise.getName()))
				{
					tempEnterprise = enterprise;
					break;
				}
			}
                        tempCity.getEnterpriseDirectory().getEnterpriseArrayList().remove(tempEnterprise);
		}
                populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tblEnterpriseTable.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "Please select Enterprise");
			return;
		}
		
		Enterprise tempEnterprise = null;
                City tempCity = null;
                if (null != system.getCitiesList() && !system.getCitiesList().isEmpty())
		{
                    for(City city : system.getCitiesList())
                    {
                        if(cityName.equalsIgnoreCase(city.getName()))
                        {
                            tempCity = city;
                            break;
                        }
                    }
                }
                

		if ( null!= tempCity && null != tempCity.getEnterpriseDirectory() && !tempCity.getEnterpriseDirectory().getEnterpriseArrayList().isEmpty())
		{
			for (Enterprise enterprise : tempCity.getEnterpriseDirectory().getEnterpriseArrayList())
			{
				if (enterpriseName.equalsIgnoreCase(enterprise.getName()))
				{
					tempEnterprise = enterprise;
					break;
				}
			}
                        
		}

		new UpdateEnterprise(this,system,tempEnterprise, tempCity).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEnterprise;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cboCity;
    private javax.swing.JComboBox cboEnterpriseType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrEnterprise;
    private javax.swing.JTable tblEnterpriseTable;
    private javax.swing.JTextField txtEnterpriseName;
    // End of variables declaration//GEN-END:variables
}
