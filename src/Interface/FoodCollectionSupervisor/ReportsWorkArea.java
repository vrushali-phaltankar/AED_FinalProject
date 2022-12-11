/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FoodCollectionSupervisor;

import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author gauripatil
 */
public class ReportsWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ReportsWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;

    public ReportsWorkArea(JPanel userProcessContainer,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        
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
        btnBestResident = new javax.swing.JButton();
        btnFoodCollectedResident = new javax.swing.JButton();
        btnFoodCollectedRestaurqant = new javax.swing.JButton();
        btnMostPopularArea = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(25, 118, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Food Collection Admin Reports");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        btnBestResident.setBackground(new java.awt.Color(25, 118, 242));
        btnBestResident.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBestResident.setForeground(new java.awt.Color(255, 255, 255));
        btnBestResident.setText("Types Of Food gathered during the time frame");
        btnBestResident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnBestResident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestResidentActionPerformed(evt);
            }
        });
        add(btnBestResident, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 470, 60));

        btnFoodCollectedResident.setBackground(new java.awt.Color(25, 118, 242));
        btnFoodCollectedResident.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnFoodCollectedResident.setForeground(new java.awt.Color(255, 255, 255));
        btnFoodCollectedResident.setText("Types of food collected from  the Residents");
        btnFoodCollectedResident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnFoodCollectedResident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodCollectedResidentActionPerformed(evt);
            }
        });
        add(btnFoodCollectedResident, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 480, 53));

        btnFoodCollectedRestaurqant.setBackground(new java.awt.Color(25, 118, 242));
        btnFoodCollectedRestaurqant.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnFoodCollectedRestaurqant.setForeground(new java.awt.Color(255, 255, 255));
        btnFoodCollectedRestaurqant.setText("Types of food collected from the Restaurants");
        btnFoodCollectedRestaurqant.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnFoodCollectedRestaurqant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodCollectedRestaurqantActionPerformed(evt);
            }
        });
        add(btnFoodCollectedRestaurqant, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 470, 55));

        btnMostPopularArea.setBackground(new java.awt.Color(25, 118, 242));
        btnMostPopularArea.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnMostPopularArea.setForeground(new java.awt.Color(255, 255, 255));
        btnMostPopularArea.setText("Most popular locality of Donation");
        btnMostPopularArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnMostPopularArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostPopularAreaActionPerformed(evt);
            }
        });
        add(btnMostPopularArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 470, 56));

        btnback.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnback.setText("<< Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 695, 112, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 430, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBestResidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestResidentActionPerformed
        // TODO add your handling code here:
        TotalFoodDonation manageCityPanel = new TotalFoodDonation(userProcessContainer, account);
        userProcessContainer.add("manageCityPanel", manageCityPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnBestResidentActionPerformed

    private void btnFoodCollectedResidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodCollectedResidentActionPerformed
        // TODO add your handling code here:
        TypeOfFoodResidents manageCityPanel = new TypeOfFoodResidents(userProcessContainer, account);
        userProcessContainer.add("manageCityPanel", manageCityPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnFoodCollectedResidentActionPerformed

    private void btnFoodCollectedRestaurqantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodCollectedRestaurqantActionPerformed
        // TODO add your handling code here:
        TypesOfFoodRestaurant manageCityPanel = new TypesOfFoodRestaurant(userProcessContainer, account);
        userProcessContainer.add("manageCityPanel", manageCityPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnFoodCollectedRestaurqantActionPerformed

    private void btnMostPopularAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostPopularAreaActionPerformed
        // TODO add your handling code here:
        MostPopularLocation manageCityPanel = new MostPopularLocation(userProcessContainer, account);
        userProcessContainer.add("manageCityPanel", manageCityPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMostPopularAreaActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestResident;
    private javax.swing.JButton btnFoodCollectedResident;
    private javax.swing.JButton btnFoodCollectedRestaurqant;
    private javax.swing.JButton btnMostPopularArea;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
