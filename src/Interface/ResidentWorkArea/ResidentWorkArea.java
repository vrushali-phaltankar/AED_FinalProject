/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ResidentWorkArea;

import Business.Community.Community;
import Business.Employee.ResidentEmployee;
import Business.Organization.Organization;
import Business.FoodProvider.Food;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodCollectionWorkRequest;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gauripatil
 */
public class ResidentWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ResidentWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Community community;
    private ResidentEmployee residentEmployee;
    
    public ResidentWorkArea(JPanel userProcessContainer, UserAccount userAccount) {
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        community=  userAccount.getEmployee().getCommunityAssociated();
        residentEmployee = (ResidentEmployee) userAccount.getEmployee();
        initComponents();
        populateTable();  
        populateDonatedHistory();
        populateFridgeItems();
        tblDonatedHistory.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblFoodItemsToBeDonated.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblFridgeItemsw.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
         
    }
    
    
    private void populateFridgeItems(){
        
        
          DefaultTableModel model = (DefaultTableModel) tblFridgeItemsw.getModel();
          model.setRowCount(0);
          String status;
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           //ResidentEmployee ee = (ResidentEmployee)  userAccount.getEmployee();      
           for(Food food : residentEmployee.getFoodDirectory().getFoodDirectory()){
                        status = calculateStatusOfFood(food);
                        if(!status.equalsIgnoreCase("Can Be Donated")){
                            Object[] row = new Object[6];
                            row[0] = food;
                            row[1]=  food.getFoodBarCode();
                            row[2]=  status;            
                            row[3]= formatter.format(food.getFoodExpiryDate());
                            row[4]= formatter.format(food.getFoodDateOfPurchase());
                            row[5] = food.getQuantity();
                            model.addRow(row); 
                        }
        }
        
        
    }
    
    
    private void populateDonatedHistory(){
        DefaultTableModel model = (DefaultTableModel) tblDonatedHistory.getModel();
        model.setRowCount(0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(Food food : residentEmployee.getFoodDonatedHistory().getFoodDirectory()  ){
               
                Object[] row = new Object[5];
                    row[0] = food;
                    row[1]=  food.getFoodBarCode();
                    row[2]=  food.getQuantity();
                    row[3]= formatter.format(food.getFoodExpiryDate());
                    row[4] = food.getRewardPoints();
                    model.addRow(row);
                
        }
        
    }
    

    private void populateTable(){
        
           DefaultTableModel model = (DefaultTableModel) tblFoodItemsToBeDonated.getModel();
           model.setRowCount(0);
           String status;
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           //ResidentEmployee ee = (ResidentEmployee)  userAccount.getEmployee();      
           for(Food food : residentEmployee.getFoodDirectory().getFoodDirectory()){
               status = calculateStatusOfFood(food);
               if(!status.equalsIgnoreCase("Can be kept") && !status.equalsIgnoreCase("Spoiled")){
                        Object[] row = new Object[6];
                        row[0] = food;
                        row[1]=  food.getFoodBarCode();
                        row[2]=  status;         
                        row[3]= formatter.format(food.getFoodExpiryDate());
                        row[4] = food.getQuantity();
                        row[5] = calculatePriority(food);
                        model.addRow(row); 
               }
         
            
        }
        
    }
    
    public String calculatePriority(Food food){
        String priority = "";
        long thresholdDate = (food.getFoodThresholdDate().getTime())/(1000*60*60*24) ;
        //long expiryDate = (food.getFoodExpiryDate().getTime())/(1000*60*60*24);
        
        if(thresholdDate == new Date().getTime()/(1000*60*60*24) ){
            
            priority = "1";
            food.setFoodPriority(priority);
            
        }
        else {
            
            long difference = (long) (food.getFoodExpiryDate().getTime() - new Date().getTime())/(1000*60*60*24);
            if(difference >=5){
                priority = "1";
                food.setFoodPriority(priority);
            }
            else if(difference == 4){
                
                priority = "2";
                food.setFoodPriority(priority);
            }
            else if(difference == 3){
                
                priority = "3";
                food.setFoodPriority(priority);
            }
            else if(difference == 2){
                
                priority = "4";
                food.setFoodPriority(priority);
            }
            else if(difference ==1){
                
                priority = "5";
                food.setFoodPriority(priority);
            }
            else if(difference ==0){
                
                priority = "5";
                food.setFoodPriority(priority);
            }
            
            else{
                priority = "3";
                food.setFoodPriority(priority);
            }
        }
           
        
        return priority;
        
    }
    
    public String calculateStatusOfFood(Food food){
        String statusOfFood;
        Date today = new Date();
        
        long differenceFromThreshold = (long) (today.getTime() - food.getFoodThresholdDate().getTime())/(1000*60*60*24);
        long differenceFromExpiry = (long) (today.getTime() - food.getFoodExpiryDate().getTime())/(1000*60*60*24);
  
        if (differenceFromThreshold >=0 && differenceFromExpiry <= 0){
            statusOfFood = "Can Be Donated";            
        }
        else if(differenceFromThreshold >=0 && differenceFromExpiry >0 ){
            statusOfFood = "Spoiled"; 
        }  
        else{
            statusOfFood = "Can be kept";           
        }
             return statusOfFood; 
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoodItemsToBeDonated = new javax.swing.JTable();
        btnDonation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonatedHistory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFridgeItemsw = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Resident Work Area");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblFoodItemsToBeDonated.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFoodItemsToBeDonated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food Barcode", "Food Status", "Food Expiry Date", "Food Weight(lbs)", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFoodItemsToBeDonated.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblFoodItemsToBeDonated);

        btnDonation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDonation.setText("Donate Food >>");
        btnDonation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDonation)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnDonation)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Donation Requests", jPanel1);

        tblDonatedHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDonatedHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food ID", "Food Weight(lbs)", "Food Expiry Date", "Reward Points"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDonatedHistory);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Donated History", jPanel2);

        tblFridgeItemsw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFridgeItemsw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food ID", "Food Status", "Food Expiry Date", "Food Purchase Date", "Food Weight(lbs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblFridgeItemsw);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Fridge Items", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonationActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblFoodItemsToBeDonated.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table");
            return;
        }
        
        Food  food = (Food)tblFoodItemsToBeDonated.getValueAt(selectedRow, 0);
        food.setRewardPoints("0");
        FoodCollectionWorkRequest foodCollection = new FoodCollectionWorkRequest();
        foodCollection.setRequestDate(new Date());
        foodCollection.setSender(userAccount);
        foodCollection.setFood(food);
        foodCollection.setResidentEmployee(residentEmployee);
        foodCollection.setStatus("New Request");
        
        Organization org =  community.getFoodCollectionOrganization();
        org.getWorkQueue().getWorkRequestArrayList().add(foodCollection);
        //userAccount.getWorkQueue().getWorkRequestList().add(foodCollection);
        residentEmployee.getFoodDirectory().getFoodDirectory().remove(food);
        residentEmployee.getFoodDonatedHistory().getFoodDirectory().add(food);
        populateTable();
        populateDonatedHistory();
        JOptionPane.showMessageDialog(null, "Work request send succesfully to Food Collection Authority. Please wait for the driver to come and collect your food items. Thank you for helping for the betterment of the society");
        
        
      
        
    }//GEN-LAST:event_btnDonationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDonatedHistory;
    private javax.swing.JTable tblFoodItemsToBeDonated;
    private javax.swing.JTable tblFridgeItemsw;
    // End of variables declaration//GEN-END:variables
}
