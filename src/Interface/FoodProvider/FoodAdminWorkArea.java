/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodProvider;

import Business.Community.Community;
import Business.Employee.ResidentEmployee;
import Business.Employee.Employee;
import Business.Employee.RestaurantEmployee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.FoodProvider.Food;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gauripatil
 */
public class FoodAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form FoodAdminWorkArea
     */
    
private JPanel userProcessContainer;
private FoodManagementEnterprise enterprise;

    public FoodAdminWorkArea(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = (FoodManagementEnterprise) enterprise;
        populateCommunityCombobox();
        String best = (String) cboBestBefore.getSelectedItem();
        calculateExpiryDate(best);
        populateResidentCombobox(); 
        populateRestaturantCombobox();
        populateBestBeforeCombobox();
        populateFoodTypeCombobox();
        txtExpiryDate.setEnabled(false);
        txtThresholdDays.setEnabled(false);
        rdnResident.setSelected(true);
    }
    
    public static int RandInt(int min, int max) {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    public void populateCommunityCombobox(){
        
        cboCommuntiyName.removeAllItems();
        for(Community community : enterprise.getCommunityArrayList()){
            cboCommuntiyName.addItem(community);
        }
    }
    public  void populateResidentCombobox(){
        cboResident.removeAllItems();
        Community selectedCommunity = (Community) cboCommuntiyName.getSelectedItem(); 
        for(Employee ee : selectedCommunity.getResidentOrganization().getEmployeeDirectory().getEmployeeList()){
            ResidentEmployee residentEmployee = (ResidentEmployee) ee;
            cboResident.addItem(residentEmployee);
        }
        
    }
      public  void populateRestaturantCombobox(){
        cboRestaurant.removeAllItems();
        Community selectedCommunity = (Community) cboCommuntiyName.getSelectedItem(); 
        for(Employee ee : selectedCommunity.getRestaurantOrganization().getEmployeeDirectory().getEmployeeList()){
            RestaurantEmployee restaturantEmployee = (RestaurantEmployee) ee;
            cboRestaurant.addItem(restaturantEmployee);
        }
        
    }
      
      public  void populateBestBeforeCombobox(){
              
          cboBestBefore.removeAllItems();
          cboBestBefore.addItem("1 Month");
          cboBestBefore.addItem("2 Month");
          cboBestBefore.addItem("3 Month");
        
        }
      public  void populateFoodTypeCombobox(){
              
          cboFoodType.removeAllItems();
          cboFoodType.addItem("Canned Food");
          cboFoodType.addItem("Purchased Food");
          cboFoodType.addItem("Home made Food");
        
        }
      public void calculateExpiryDate(String bestBefore){
          Date expriryDate= null;
          Date purchaseDate = null;
          
          purchaseDate = jDateChooser1.getDate();
         
          
          if(purchaseDate == null){
              
              txtExpiryDate.setText(new Date().toString());
              return;
              
          }
          
          Calendar cal = Calendar.getInstance();
          cal.setTime(purchaseDate);
                
          if(bestBefore.equals("1 Month")){
//             purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                 cal.add(Calendar.MONTH, 1); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
 
          }
          else if (bestBefore.equals("2 Month")){
//              purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                 cal.add(Calendar.MONTH, 2); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
              
          }
          else if (bestBefore.equalsIgnoreCase("3 Month")){    
//              purchaseDate = jDateChooser1.getDate();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(purchaseDate);
                cal.add(Calendar.MONTH, 3); 
                expriryDate = cal.getTime();
                txtExpiryDate.setText(expriryDate.toString());
              
          }
          else{
                txtExpiryDate.setText(new Date().toString());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboCommuntiyName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboResident = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFoddName = new javax.swing.JTextField();
        cboFoodType = new javax.swing.JComboBox();
        spnQuantity = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        rdnResident = new javax.swing.JRadioButton();
        rdnRestaurant = new javax.swing.JRadioButton();
        cboBestBefore = new javax.swing.JComboBox();
        txtExpiryDate = new javax.swing.JTextField();
        btnCreateFood = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboRestaurant = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtThresholdDays = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FoodProvider Work Area");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Community Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Select Resident");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Food Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Food Type");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Date of Purchase");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Quantity");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Best Before");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Expiry Date");

        cboFoodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFoodTypeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Select type of Donator:");

        buttonGroup1.add(rdnResident);
        rdnResident.setText("Resident");
        rdnResident.setBorderPainted(true);
        rdnResident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnResidentActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdnRestaurant);
        rdnRestaurant.setText("Restaturant");
        rdnRestaurant.setBorderPainted(true);
        rdnRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnRestaurantActionPerformed(evt);
            }
        });

        cboBestBefore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBestBeforeActionPerformed(evt);
            }
        });

        btnCreateFood.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateFood.setText("Create Food >>");
        btnCreateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFoodActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Select Restaurant");

        cboRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRestaurantActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Threshold Days :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdnResident)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                        .addComponent(rdnRestaurant))
                                    .addComponent(cboCommuntiyName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboResident, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboRestaurant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtThresholdDays, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFoddName)
                            .addComponent(cboBestBefore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnCreateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCommuntiyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdnResident)
                    .addComponent(rdnRestaurant))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboResident, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtThresholdDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFoddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboFoodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboBestBefore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(btnCreateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFoodActionPerformed
        // TODO add your handling code here:
    
        String foodName = txtFoddName.getText();
        String foodType=cboFoodType.getSelectedItem().toString();
        Date date = jDateChooser1.getDate();
        int quantity = (int) spnQuantity.getValue();
        if(quantity == 0){
           quantity=1; 
        }
        
        
        Date date1 = null;
        String stringDate = txtExpiryDate.getText();
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
         SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                                            Locale.ENGLISH);
         Date parsedDate = sdf.parse(stringDate);
         date1= formatter.parse(formatter.format(parsedDate));
        
        
        }catch(Exception ex){
           System.out.println(ex);
        }
        
        
        
        Food foodItem = new Food();
        foodItem.setFoodDateOfPurchase(date);
        foodItem.setFoodExpiryDate(date1);
        foodItem.setFoodType(foodType);
        foodItem.setQuantity(quantity);
        foodItem.setFoodName(foodName);
        
        Calendar cc1 = Calendar.getInstance();
        cc1.setTime(date1);
        cc1.add(Calendar.DATE, -Integer.parseInt(txtThresholdDays.getText()));
        foodItem.setFoodThresholdDate(cc1.getTime());
        
        
        if(rdnResident.isSelected()){
            ResidentEmployee residentEmployee = (ResidentEmployee) cboResident.getSelectedItem();
            residentEmployee.getFoodDirectory().addFood(foodItem);
            txtFoddName.setText("");
            
            JOptionPane.showMessageDialog(null, "Food Item created for  "   +   residentEmployee.toString());
            
            
        }
          if(rdnRestaurant.isSelected()){
            RestaurantEmployee restaurantEmployee = (RestaurantEmployee) cboRestaurant.getSelectedItem();
            restaurantEmployee.getFoodDirectory().addFood(foodItem);
            txtFoddName.setText("");
            JOptionPane.showMessageDialog(null, "Food Item created for  "   +   restaurantEmployee.toString());
        }       
    }//GEN-LAST:event_btnCreateFoodActionPerformed

    private void rdnResidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnResidentActionPerformed
        // TODO add your handling code here:
        cboRestaurant.setEnabled(false);
        cboResident.setEnabled(true);
    }//GEN-LAST:event_rdnResidentActionPerformed

    private void rdnRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnRestaurantActionPerformed
        // TODO add your handling code here:
        cboRestaurant.setEnabled(true);
        cboResident.setEnabled(false);
    }//GEN-LAST:event_rdnRestaurantActionPerformed

    private void cboBestBeforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBestBeforeActionPerformed
        // TODO add your handling code here:
        String best = (String) cboBestBefore.getSelectedItem();
        calculateExpiryDate(best);
      
    }//GEN-LAST:event_cboBestBeforeActionPerformed

    private void cboFoodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFoodTypeActionPerformed
        // TODO add your handling code here:
        String type = cboFoodType.getSelectedItem().toString();
        if(type==null)
            return;

        if(type.equalsIgnoreCase("Canned Food"))
              txtThresholdDays.setText("5");
        else if(type.equalsIgnoreCase("Purchased Food"))
              txtThresholdDays.setText("4");
        else
              txtThresholdDays.setText("3");
        
    }//GEN-LAST:event_cboFoodTypeActionPerformed

    private void cboRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRestaurantActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateFood;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboBestBefore;
    private javax.swing.JComboBox cboResident;
    private javax.swing.JComboBox cboCommuntiyName;
    private javax.swing.JComboBox cboFoodType;
    private javax.swing.JComboBox cboRestaurant;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdnResident;
    private javax.swing.JRadioButton rdnRestaurant;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtFoddName;
    private javax.swing.JTextField txtThresholdDays;
    // End of variables declaration//GEN-END:variables
}
