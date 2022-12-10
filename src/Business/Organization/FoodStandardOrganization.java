/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.FoodStandardAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author kunal
 */
public class FoodStandardOrganization extends Organization{

    public FoodStandardOrganization() {
        super(Organization.OrganizationType.FOODSTANDARD.getValue());
        roles.add(new FoodStandardAdminRole());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
     
        return roles;
    }
    
    
    
}
