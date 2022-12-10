/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.FoodDistributionAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class FoodDistributionOrganization extends Organization {

    public FoodDistributionOrganization() {
        super(Organization.OrganizationType.FOODDISTRIBUTION.getValue());
        roles.add(new FoodDistributionAdminRole());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {        
        return roles;
    }
    
}
