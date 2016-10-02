import java.io.*;
import java.util.*;

public class CarWash {

   public static void main (String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
      
      System.out.print("Please insert your name: ");
      String userName = br.readLine();
   
      WashUser currentUser = new WashUser(userName);
   //currentUser.deductBalance(20, currentUser.Id());
   //currentUser.addBalance(100, currentUser.Id());
      if (currentUser.doesUserExist() == true) {   
      
         int yourOp = 1;
         String option;
         
         while(yourOp != 0){
            
            System.out.println("Welcome to the SuperShine Car Wash! Please choose from the \nlist below what would you like to do today...");
            System.out.println("1 - Services");
            System.out.println("2 - Recharge");
            System.out.println("3 - Wash Statistics");
            System.out.println("4 - Balance");
            System.out.println("5 - Exit");
            String yourOption = br.readLine();
            yourOp = Integer.parseInt(yourOption);
            //Begin user input for the main menu
            switch (yourOp){
            
               case 1: 
                  {  
                  
                     if (currentUser.hasUserBought() == false) {   
                     
                        option = "You have chosen services!";
                        System.out.println(option);
                        System.out.println("1 - Regular Wash - 200kr");
                        System.out.println("2 - Ocean Flush Wash - 400kr");
                        System.out.println("3 - Royal Wash - 500kr");
                        System.out.println("4 - Once In A Lifetime Wash - 550kr");
                     
                        String serviceChoiceString = br.readLine();
                        int serviceChoiceInt = Integer.parseInt(serviceChoiceString);
                        String serviceOption;
                     // Begin user input for the type of wash
                        switch(serviceChoiceInt){
                        
                           case 1: 
                              {
                              
                                 serviceOption = "You have chosen the regular wash.";
                                 System.out.println(serviceOption);
                                 currentUser.deductBalance(200, currentUser.Id());
                              
                                 break;
                              
                              }
                           
                           case 2: 
                              {
                              
                                 serviceOption = "You have chosen the ocean flush wash.";
                                 System.out.println(serviceOption);
                                 currentUser.deductBalance(400, currentUser.Id());
                              
                                 break;
                              
                              }
                           
                           case 3: 
                              {
                              
                                 serviceOption = "You have chosen the royal wash.";
                                 System.out.println(serviceOption);
                                 currentUser.deductBalance(500, currentUser.Id());
                              
                                 break;
                              
                              }
                           
                           case 4: 
                              {
                              
                                 serviceOption = "You have chosen the once in a lifetime wash.";
                                 System.out.println(serviceOption);
                                 currentUser.deductBalance(550, currentUser.Id());
                              
                                 break;
                              
                              }
                        
                        }
                     
                        break;
                     //End user input for services
                     }
                     
                     else {
                     
                        System.out.println("You have already bought a wash, please exit and proceed to the washing machine.");
                     
                        break;
                     }   
                  
                  }
               
               case 2: 
                  {
                  
                     option = "You have chose to recharge your balance! How much would you like to recharge for?" + 
                        "\nMax:1000 Min:200";
                     System.out.println(option);
                     String rechargeAmountString = br.readLine();
                     double rechargeAmountDouble = Double.parseDouble(rechargeAmountString);
                     currentUser.addBalance(rechargeAmountDouble, currentUser.Id());
                     
                     break;
                  
                  }
               
               case 3: 
                  {  
                  
                     option = "You have chosen to see your wash statistics";
                     System.out.println(option);
                  
                     break;
                  
                  }
               
               case 4: 
                  {  
                  
                     option = "You have chosen to see your balance!";
                     System.out.println(option);
                     System.out.println("Your current balance is: " + currentUser.getBalance());
                  
                     break;
                  
                  }
               
               case 5: 
                  {  
                  
                     option = "Have a nice day!";
                     System.out.println(option);
                     yourOp = 0;
                     
                     break;
                  
                  }
            //End user input for main menu
            }
         
         }
      
      }
   
   } 

}