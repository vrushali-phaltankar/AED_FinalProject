/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author kunal
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseArrayList;
    
    public EnterpriseDirectory(){
        
        enterpriseArrayList = new ArrayList<Enterprise>();
        
    }

    public ArrayList<Enterprise> getEnterpriseArrayList() {
        return enterpriseArrayList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.FoodManagement){
            enterprise = new FoodManagementEnterprise(name);
            enterpriseArrayList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.WasteDisposal){
            enterprise = new WasteDisposalEnterprise(name);
            enterpriseArrayList.add(enterprise);
        }
        
        return enterprise;
    }
    
    
    
}
