/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.City.City;
import Business.Community.Community;
import Business.Employee.ResidentEmployee;
import Business.Employee.CommunityAdminEmployee;
import Business.Employee.Employee;
import Business.Employee.FoodCollectionDriverEmployee;
import Business.Employee.FoodCollectionSupervisorEmployee;
import Business.Employee.FoodDistributionSupervisorEmployee;
import Business.Employee.FoodEnterpriseAdminEmployee;
import Business.Employee.FoodStandardSupervisorEmployee;
import Business.Employee.RestaurantEmployee;
import Business.Employee.SystemAdminEmployee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodManagementEnterprise;
import Business.Roles.ResidentRole;
import Business.Roles.CommunityAdminRole;
import Business.Roles.FoodCollectionDriverRole;
import Business.Roles.FoodCollectionAdminRole;
import Business.Roles.FoodDistributionAdminRole;
import Business.Roles.FoodEnterpriseAdminRole;
import Business.Roles.FoodStandardAdminRole;
import Business.Roles.RestuarantRole;
import Business.Roles.FoodProviderRole;
import Business.Roles.SystemAdminRole;
import Business.FoodProvider.Food;
import Business.FoodProvider.FridgeSimulation;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vrushaliphaltankar
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
     
        // Creating the systemadmin for the first time login
        Employee emp = system.getEmployeeDirectory().createEmployee("Vrushali Phaltankar",null,new SystemAdminEmployee());
        // Creating the user account for the systemadmin
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sa", "sa", emp, new SystemAdminRole());
          
        City n = new City();
        n.setName("Boston");
        system.getCitiesList().add(n);
        
        //Create enterprise
        FoodManagementEnterprise fdm = (FoodManagementEnterprise) system.getCitiesList().get(0).getEnterpriseDirectory().createAndAddEnterprise("ABC Food ENterprise", Enterprise.EnterpriseType.FoodManagement);
        Employee e = fdm.getEmployeeDirectory().createEmployee("ABCFoodAdmin 1",null,new FoodEnterpriseAdminEmployee());
        fdm.getUserAccountDirectory().createUserAccount("f1", "f1", e, new FoodEnterpriseAdminRole());
        
        Employee foodProviderEmployee = fdm.getEmployeeDirectory().createEmployee("Sensor",null,new FoodEnterpriseAdminEmployee());
        fdm.getUserAccountDirectory().createUserAccount("ss", "ss", foodProviderEmployee, new FoodProviderRole());
        
  
        //Create Community
        Community Boylston = fdm.addCommunity("Boylston");
      // Populator populator = new PopulatorBuilder().build();
                       
        Employee few1 = Boylston.getCommunityOrganization().getEmployeeDirectory().createEmployee("FEW1",Boylston,new CommunityAdminEmployee() );
        Employee fcs = Boylston.getFoodCollectionOrganization().getEmployeeDirectory().createEmployee("fcs",Boylston, new FoodCollectionSupervisorEmployee());
        Employee fcd = Boylston.getFoodCollectionOrganization().getEmployeeDirectory().createEmployee("fcd",Boylston, new FoodCollectionDriverEmployee());
        Employee fds =  Boylston.getFoodDistributionOrganization().getEmployeeDirectory().createEmployee("fds",Boylston, new FoodDistributionSupervisorEmployee());
        Employee fss =  Boylston.getFoodStandardOrganization().getEmployeeDirectory().createEmployee("fss",Boylston, new FoodStandardSupervisorEmployee());
        Employee resident1 = Boylston.getResidentOrganization().getEmployeeDirectory().createEmployee("gauri", Boylston, new ResidentEmployee());
        resident1.setAddress("125 Park Drive, Boston, MA 02115");
        resident1.setEmailID("gauripatil@gmail.com");        
        Employee restaurant1 = Boylston.getRestaurantOrganization().getEmployeeDirectory().createEmployee("mumbai spice", Boylston, new RestaurantEmployee());
        restaurant1.setAddress("251 Massachusetts Ave, Boston, MA 02115");
        restaurant1.setEmailID("phaltankarvrushali@gmail.com");

        // Allocating current address to the driver in the starting.
        ((FoodCollectionDriverEmployee) fcd).setDriverCurrentAddress("44 Germain St, Boston, MA 02115");
        
        //UserAcc        
        Boylston.getCommunityOrganization().getUserAccountDirectory().createUserAccount("few1", "few1", few1, new CommunityAdminRole());
        Boylston.getFoodCollectionOrganization().getUserAccountDirectory().createUserAccount("fcs", "fcs", fcs, new FoodCollectionAdminRole());
        Boylston.getFoodCollectionOrganization().getUserAccountDirectory().createUserAccount("fcd", "fcd", fcd, new FoodCollectionDriverRole());
        Boylston.getFoodDistributionOrganization().getUserAccountDirectory().createUserAccount("fds", "fds", fds, new FoodDistributionAdminRole());
        Boylston.getFoodStandardOrganization().getUserAccountDirectory().createUserAccount("fss", "fss", fss, new FoodStandardAdminRole());
        Boylston.getResidentOrganization().getUserAccountDirectory().createUserAccount("gauri", "gauri", resident1, new ResidentRole());
        Boylston.getRestaurantOrganization().getUserAccountDirectory().createUserAccount("spice", "spice", restaurant1, new RestuarantRole());
     
        FridgeSimulation simulator = new FridgeSimulation();
        createFoodForEmployee(simulator,5,resident1);
        createFoodForEmployee(simulator,10, restaurant1);
        
        return system;        
    }
    
    
    private static void createFoodForEmployee( FridgeSimulation simulator,int count, Employee ee){
       
        if(ee instanceof ResidentEmployee){
            ResidentEmployee ce = (ResidentEmployee)ee;
            ArrayList<Food> foodItems =  simulator.generateFoodData(count);
            for(Food item: foodItems){
                ce.getFoodDirectory().addFood(item);
            }
        }
        else if (ee instanceof RestaurantEmployee){
            RestaurantEmployee re = (RestaurantEmployee)ee;
            ArrayList<Food> foodItems =  simulator.generateFoodData(count);
            for(Food item: foodItems){
                re.getFoodDirectory().addFood(item);
            }
            
        }
        
    }
    
    
    

    
    
}
