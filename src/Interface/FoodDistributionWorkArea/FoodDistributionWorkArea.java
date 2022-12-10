/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodDistributionWorkArea;

import Business.Community.Community;
import Business.Employee.FoodDistributionSupervisorEmployee;
import Business.Organization.FoodDistributionOrganization;
import Business.FoodProvider.Food;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodDistributionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author kunal
 */
public class FoodDistributionWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form FoodDistributionWorkArea
     */
     private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Community community;
    private FoodDistributionSupervisorEmployee distributionEmp;
    private FoodDistributionOrganization organization;
    
    public FoodDistributionWorkArea(JPanel userProcessContainer, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        community = account.getEmployee().getCommunityAssociated();
        organization = community.getFoodDistributionOrganization();
        distributionEmp = (FoodDistributionSupervisorEmployee) account.getEmployee();
        lblNumber.setVisible(false);
        txtNumber.setVisible(false);
        btnSubmit.setVisible(false);
        tblFoodDistribution.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblFoodDistributionHistory.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        populateTable();
        populateHistoryTable();        
    }
    
     public void sendEmail(String emailID,Food food)
   {
      
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "kunal.deora@gmail.com";//
     final String password = "adrika46";
     String text = "Hi Sir/Mam, " +'\n' + "You have received rewards points for the food you have donated. Details are listed below: "+ '\n' 
             + "Food Name:  " + food.getFoodName() + '\n'
             + "Food ID :"  + food.getFoodBarCode() + '\n'
             + "Food Reward Points "      + food.getRewardPoints() + '\n'
             + "If you have any queries you can contact us on +133333333333" +
             '\n' + "Thank you for helping for the betterment of society. Every little bite counts :) " + '\n';
     try{
     Session session = Session.getDefaultInstance(props, 
                          new javax.mail.Authenticator(){
                             protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                return new javax.mail.PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
     javax.mail.Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress("kunal.deora@gmail.com"));
     msg.setRecipients(javax.mail.Message.RecipientType.TO, 
                      InternetAddress.parse(emailID,false));
     msg.setSubject("Congratulations! You have received reward points !!!");
     msg.setText(text);
     msg.setSentDate(new Date());
     javax.mail.Transport.send(msg);
     System.out.println("Message sent.");
  }catch (javax.mail.MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
  
   
       
      
  }
    
     public void populateHistoryTable(){
        
         DefaultTableModel model = (DefaultTableModel) tblFoodDistributionHistory.getModel();
         model.setRowCount(0);
         for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
             if(request.getStatus().equalsIgnoreCase("Distributed")){
                        Object[] row = new Object[7];
                        row[0] = ((FoodDistributionWorkRequest) request);
                        row[1] = ((FoodDistributionWorkRequest) request).getFood().getFoodBarCode();
                        row[2] = ((FoodDistributionWorkRequest) request).getFood().getQuantity();
                        row[3] = ((FoodDistributionWorkRequest) request).getFood().getFoodExpiryDate();
                        row[4] = ((FoodDistributionWorkRequest) request).getStatus();
                        row[5] = ((FoodDistributionWorkRequest) request).getFood().getNumberOfBenificary();
                        model.addRow(row);
             }
         
         }
    }
    
    
    public void populateTable(){
        
         DefaultTableModel model = (DefaultTableModel) tblFoodDistribution.getModel();
         model.setRowCount(0);
         for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){
             if(!request.getStatus().equalsIgnoreCase("Distributed")){
                        Object[] row = new Object[7];
                        row[0] = ((FoodDistributionWorkRequest) request);
                        row[1] = ((FoodDistributionWorkRequest) request).getFood().getFoodBarCode();
                        row[2] = ((FoodDistributionWorkRequest) request).getFood().getQuantity();
                        row[3] = ((FoodDistributionWorkRequest) request).getFood().getFoodExpiryDate();
                        row[4] = ((FoodDistributionWorkRequest) request).getStatus();
                        row[5] = ((FoodDistributionWorkRequest) request).getMessage();
                        row[6] = ((FoodDistributionWorkRequest) request).getStandardSupervisor(); 
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoodDistribution = new javax.swing.JTable();
        btnDistribute = new javax.swing.JButton();
        lblNumber = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFoodDistributionHistory = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCalculate1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Food Distribution Work Area");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblFoodDistribution.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblFoodDistribution.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food BarCode", "Food Weight(lbs)", "Food Expiry Date", "Status", "Message", "Standization Dept. Sender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFoodDistribution.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblFoodDistribution);

        btnDistribute.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDistribute.setText("Distribute Food");
        btnDistribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeActionPerformed(evt);
            }
        });

        lblNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumber.setText("Number of Benificiary who consumed this food");

        txtNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(lblNumber)
                .addGap(43, 43, 43)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(btnDistribute))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumber)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDistribute))
                .addGap(37, 37, 37)
                .addComponent(btnSubmit)
                .addGap(100, 100, 100))
        );

        jTabbedPane1.addTab("Supervisor Work Area", jPanel1);

        tblFoodDistributionHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Food Name", "Food BarCode", "Food Weight(lbs)", "Food Expiry Date", "Status", "No of beneficiary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFoodDistributionHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblFoodDistributionHistory);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Distribution History", jPanel2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("From Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("To Date");

        btnCalculate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCalculate1.setText("View Results >>");
        btnCalculate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addComponent(btnCalculate1)
                .addContainerGap(844, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculate1))
                .addGap(236, 236, 236))
        );

        jTabbedPane1.addTab("Priority wise food distribution", jPanel4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Number of beneficiary getting benefited from the food ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("From Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("To Date");

        btnCalculate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCalculate.setText("View Results >>");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(btnCalculate)))
                .addContainerGap(818, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalculate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Number of beneficiary ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeActionPerformed
        // TODO add your handling code here:
        lblNumber.setVisible(true);
        txtNumber.setVisible(true);
        btnSubmit.setVisible(true);
        btnDistribute.setEnabled(false);
        txtNumber.setEnabled(false);
        
        int selectedRow = tblFoodDistribution.getSelectedRow();
        
         if (selectedRow < 0){
                lblNumber.setVisible(false);
                txtNumber.setVisible(false);
                btnSubmit.setVisible(false);
                btnDistribute.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
         }
         
         FoodDistributionWorkRequest request= (FoodDistributionWorkRequest)  tblFoodDistribution.getValueAt(selectedRow, 0);
         request.setStatus("Define number of beneficiary");
         request.setMessage("Distribute food");
         int i =  request.getFood().getQuantity();
         int y = i*2;
         request.getFood().setRewardPoints(String.valueOf(y));
         txtNumber.setText(String.valueOf(y));
         populateTable();
         populateHistoryTable();
        
        
    }//GEN-LAST:event_btnDistributeActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        String i = txtNumber.getText();
         
         int selectedRow = tblFoodDistribution.getSelectedRow();
        
         if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select the row from the table.");
            return;
         }
        FoodDistributionWorkRequest request= (FoodDistributionWorkRequest)  tblFoodDistribution.getValueAt(selectedRow, 0);
        request.getFood().setNumberOfBenificary(Integer.parseInt(i));
        request.setStatus("Distributed");
        request.setDistributionSupervisor(userAccount);
        String emailID = request.getSender().getEmployee().getEmailID();
        Food food = request.getFood();
        sendEmail(emailID,food);
      
        populateTable();
        populateHistoryTable();
        lblNumber.setVisible(false);
        txtNumber.setVisible(false);
        btnSubmit.setVisible(false);
        btnDistribute.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Food has been distributed to  " + i + "  beneficiary");
        
        
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        Date toDate1=jDateChooser1.getDate();
        Date toDate2=jDateChooser2.getDate();
        if ((toDate1==null) || (toDate2==null)){
            JOptionPane.showMessageDialog(null, "Invalid date..Kindly enter valid date.");
            return;         
        }
        long fromDate = (jDateChooser1.getDate().getTime())/(1000*60*60*24);
        long toDate =  (jDateChooser2.getDate().getTime())/(1000*60*60*24);
        int noOfBeneficiaryCanned=1;
        int noOfBeneficiaryPurchased=1;
        int noOfBeneficiaryHome=1;
        //int i = 0;

        for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){

            long requestDate =  (request.getRequestDate().getTime())/(1000*60*60*24);

            if ((requestDate>=fromDate) && (requestDate <= toDate) ){
                
               if(((FoodDistributionWorkRequest) request).getFood().getFoodType().equalsIgnoreCase("Canned Food")){
                    
                    noOfBeneficiaryCanned+= (int) ((FoodDistributionWorkRequest) request).getFood().getNumberOfBenificary();
               }
               else if (((FoodDistributionWorkRequest) request).getFood().getFoodType().equalsIgnoreCase("Purchased food")){
                   
                    noOfBeneficiaryPurchased+= (int) ((FoodDistributionWorkRequest) request).getFood().getNumberOfBenificary();
               }               
               else if (((FoodDistributionWorkRequest) request).getFood().getFoodType().equalsIgnoreCase("Home made food")){
                    
                    noOfBeneficiaryHome+= (int) ((FoodDistributionWorkRequest) request).getFood().getNumberOfBenificary();
               }
            else{

                JOptionPane.showMessageDialog(null, "There are no records for this search criteria.");
            }

        }
     }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(noOfBeneficiaryCanned, "Number of food collected", "Canned Food");
        dataset.setValue(noOfBeneficiaryPurchased, "Number of food collected", "Purchased Food");
        dataset.setValue(noOfBeneficiaryHome, "Number of food collected", "Home madde Food");
        JFreeChart chart = ChartFactory.createBarChart("Number of beneficiary", "Types of food donated to bebeficiary", "Number of food collected", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Bar Chart for Number of beneficiary",chart);
        frame.setVisible(true);
        frame.setSize(1000, 600);
        
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnCalculate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculate1ActionPerformed
        // TODO add your handling code here:
        Date toDate1=jDateChooser3.getDate();
        Date toDate2=jDateChooser4.getDate();
        if ((toDate1==null) || (toDate2==null)){
            JOptionPane.showMessageDialog(null, "Invalid date..Kindly enter valid date.");
            return;         
        }
        long fromDate = (jDateChooser3.getDate().getTime())/(1000*60*60*24);
        long toDate =  (jDateChooser4.getDate().getTime())/(1000*60*60*24);
        int priorityFive=1;
        int priorityFour=1;
        int priorityThree=1;
        int priorityTwo=1;
        int priorityOne=1;
        //int i = 0;

        for(WorkRequest request : organization.getWorkQueue().getWorkRequestArrayList()){

            long requestDate =  (request.getRequestDate().getTime())/(1000*60*60*24);

            if ((requestDate>=fromDate) && (requestDate <= toDate) ){
                
               if(((FoodDistributionWorkRequest) request).getFood().getFoodPriority().equalsIgnoreCase("5")){
                    
                    priorityFive++;
               }
               else if(((FoodDistributionWorkRequest) request).getFood().getFoodPriority().equalsIgnoreCase("4")){
                   
                    priorityFour++;
               }               
               else if(((FoodDistributionWorkRequest) request).getFood().getFoodPriority().equalsIgnoreCase("3")){
                    
                   priorityThree++;
               }
               else if(((FoodDistributionWorkRequest) request).getFood().getFoodPriority().equalsIgnoreCase("2")){
                    
                    priorityTwo++;
               }
               else if(((FoodDistributionWorkRequest) request).getFood().getFoodPriority().equalsIgnoreCase("1")){
                    
                    priorityOne++;
               }
            else{

                JOptionPane.showMessageDialog(null, "There are no records for this search criteria.");
            }

        }
            else{
                
                JOptionPane.showMessageDialog(null, "There are no records for this search criteria.");
            }
     }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(priorityFive, "Number of food collected", "Priority 5");
        dataset.setValue(priorityFour, "Number of food collected", "Priority 4");
        dataset.setValue(priorityThree, "Number of food collected","Priority 3");
        dataset.setValue(priorityTwo, "Number of food collected",  "Priority 2");
        dataset.setValue(priorityOne, "Number of food collected",  "Priority 1");
        JFreeChart chart = ChartFactory.createBarChart("Number of beneficiary", "Types of food donated to bebeficiary", "Number of food collected", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Bar Chart for Number of beneficiary",chart);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_btnCalculate1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCalculate1;
    private javax.swing.JButton btnDistribute;
    private javax.swing.JButton btnSubmit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JTable tblFoodDistribution;
    private javax.swing.JTable tblFoodDistributionHistory;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
