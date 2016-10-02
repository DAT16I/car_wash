import java.io.*;
import java.util.*;


public class WashingSystem {
   
   public static void main (String args[]) throws IOException {
      
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
      
                     
      Card creditCard01 = new Card("Credit Card", 1234, 500);// Card type, pin, amount
      Card creditCard02 = new Card("Credit Card", 4545, 120);
      Card[] arrayCreditCard = {creditCard01, creditCard02};
       
      WashCard washCard01 = new WashCard ("Wash Card", 5678, 150, 26, false);// Card type, pin, amount, loyalty points
      WashCard washCard02 = new WashCard ("Wash Card", 2323, 250, 12, true);
      WashCard[] arrayWCard = {washCard01, washCard02};//All wash cards in array
       
      WashType express = new WashType ("Express", 100, 1); // Wash type, price, loyalty points
      WashType standard = new WashType ("Standard", 150, 1);
      WashType perfectWashShine = new WashType ("Perfect Wash Shine", 250, 2);
      
      WashType[] arrayWType = {express, standard, perfectWashShine }; //All wash types in array 
      
               
      
      //------------------START-------------------------------------------------
      
       System.out.println("Enter the card ID: ");
       int wPin = Integer.parseInt(input.readLine());
       washPinRecognition(wPin, arrayWCard, arrayWType);
       get(arrayWType, 1);   
     
              
    } 
    
    //-------------------------------------------------------------------------------------
    //------------------Out of main method-------------------------------------------------
    //-------------------------------------------------------------------------------------
    
    
    // Method returns washtype name by index from washtype array
    public static String get(WashType[] array, int index) {
      return array[index].getWashTypeName();
    }      
        
   
   // Method verifies wash card and directs that card to the menu   
   public static void washPinRecognition(int ePin, WashCard[] arrayWCard, WashType[] arrayWType ) throws IOException {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int id = -1;
        
         for (int i = 0; i <  arrayWCard.length ; i++) {
            if ( arrayWCard[i].getCardPin() == ePin){ //finds pin and card match
                  id = i;
                  break;
               
             } 
                             
         }  if (id != -1 ) { //prints cards info and passes its properties to Menu method
               System.out.println("id: " + id + ", " + arrayWCard[id].toString()); 
               Menu(id, arrayWCard[id], arrayWType);
            }
               else { //prints that card was not found
                  System.out.println("Card not recognized!\nTry again." );
                  int wPin = Integer.parseInt(input.readLine());
                  washPinRecognition(wPin, arrayWCard, arrayWType);
                  
            }  
                
   }
   
   public static void washCardInfo(int id, WashCard washCard, WashType[] arrayWType) throws IOException {
      System.out.println("********************\n********************");
      System.out.println("YOUR CARD INFO");
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(washCard.toString());
      System.out.println("********************\n********************");
      System.out.println("\n+++++++++++\nGO BACK to main MENU? Y/N"); 
      
      
      int ChoiceNr = 0;
      while (ChoiceNr==0){//while
         String optionStr = input.readLine(); 
         optionStr=optionStr.toUpperCase(); 
         System.out.println("********");   
            switch (optionStr) {//switch
                case "Y": ChoiceNr=1;
                         System.out.println("Returned");
                         Menu(id, washCard, arrayWType );
                         break;
   		       case "N": ChoiceNr=1;
            		       System.out.println("Canceled.Remember to take your card.");
                         break;   
               default:  System.out.print("Please choose a valid option");
                    		 break;
              }//end of switch
        }//end of whole
                            
    

   }
   
   // This method dedicts wash types price from wash card
   public static double transaction(double payAmount, WashCard cardAmount ) throws IOException {
       double balance = cardAmount.getCardAmount() - payAmount;
       System.out.println("Balance before: " + cardAmount.getCardAmount());
       System.out.println("Balance after: " + balance);
       return  balance;      
                
   }
   
   // this method returns the history of a specific card
   
  public static void history(String file_name, int id, WashCard washCard, WashType[] arrayWType) throws IOException {   
      System.out.println("INFO HISTORY");
      try {
         String tekst;
         
         File log = new File(file_name);
         Scanner yes = new Scanner(log);
         //ReadFile file = new ReadFile( file_name );
         //String[] aryLines = file.OpenFile();
         
        int i=0;
         while (yes.hasNextLine()) {
               tekst=yes.nextLine();
               if(tekst.equals("Card PIN: "+washCard.getCardPin())) {
                  tekst=yes.nextLine();System.out.println(tekst);tekst=yes.nextLine();System.out.println(tekst);tekst=yes.nextLine();System.out.println(tekst);   
               }            
            //System.out.println(aryLines[i]) ;
         }
       }
       catch (Exception e) {         
         System.out.println(e.getMessage());         
       }
      washCardInfo(id, washCard, arrayWType);

   }

   
   // This method passes recognized card (after using washPinRecognition method) to the Menu option
   public static void Menu(int id, WashCard washCard, WashType[] arrayWType ) throws IOException {
   
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                
      int ChoiceNr = 0;
      
      if (washCard.getAdmin()){
        System.out.println("\nMENU (Write number 1 to 5 to choose your option)." + 
         "\n 1.GO WASH\n 2.TOP UP\n 3.INFO\n 4.ADMIN PANEL\n 5.Cancel");
      while (ChoiceNr==0){//while
         String optionStr = input.readLine();  
         System.out.println("********");   
            switch (optionStr) {//switch
               case "1": ChoiceNr=1;
                         System.out.println("Option Go Wash");
                         washMenu(id, washCard, arrayWType);//sends card properties to wash types
                         break;
   				case "2": ChoiceNr=1;
            		       System.out.println("TOP UP");
                         topUp(id, washCard, arrayWType);//sends card properties to topUp method
                         break;
   			   case "3": ChoiceNr=1;
            		       System.out.println("Option Info");                  
                         String name_file = System.getProperty("user.dir") + "/history.txt";
                         history(name_file, id, washCard, arrayWType);                    
                         break;
               case "4": ChoiceNr=1;
                         AdminPanel(id, washCard, arrayWType);
                         break;
   				case "5": ChoiceNr=1;
          		          System.out.println("CANCELED.\nRemember to take your card.");//cancels session
                         break;        
               default:  System.out.print("Please choose a valid option\n ");
                    		 break;
              }//end of switch
        }//end of whole
    
      }//end of admin menu
       else {
      
      System.out.println("\nMENU (Write number 1 to 4 to choose your option)." + 
         "\n 1.GO WASH\n 2.TOP UP\n 3.INFO\n 4.Cancel");
      while (ChoiceNr==0){//while
         String optionStr = input.readLine();  
         System.out.println("********");   
            switch (optionStr) {//switch
               case "1": ChoiceNr=1;
                         System.out.println("Option Go Wash");
                         washMenu(id, washCard, arrayWType);//sends card properties to wash types
                         break;
   				case "2": ChoiceNr=1;
            		       System.out.println("TOP UP");
                         topUp(id, washCard, arrayWType);//sends card properties to topUp method
                         break;
   			   case "3": ChoiceNr=1;
            		       System.out.println("Option Info");                 
                         String name_file = System.getProperty("user.dir") + "/history.txt";
                         history(name_file, id, washCard, arrayWType);                                      
                         break;
   				case "4": ChoiceNr=1;
          		          System.out.println("CANCELED.\nRemember to take your card.");//cancels session
                         break;                
               default:  System.out.print("Please choose a valid option\n ");
                    		 break;
              }
        }
       }//end of else     
   
   }
   //Method let's to choose wash types, deducts wash price from the wash card and counts loyalty points
   public static void washMenu (int id, WashCard washCard, WashType[] arrayWType ) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      if (washCard.getDiscounts() != 0) {
         System.out.println("You have " + washCard.getDiscounts() + " discounts\nWould you like to use it? Y/N");
         
         
         int ChoiceNr = 0;
         while (ChoiceNr==0){//while
         String optionStr = input.readLine(); 
         optionStr=optionStr.toUpperCase();
         System.out.println("********");  
         switch (optionStr) {//switch
         case "Y": ChoiceNr=1;{
            System.out.println("You are using your discount.");
            System.out.println("Wash Type:" + get(arrayWType, 0) + ", Price " + 
            (arrayWType[0].getWashTypePrice() - arrayWType[0].getWashTypePrice()) + " DKK" +
               ", Loyalty points: " + (arrayWType[0].getWashTypePoints() - arrayWType[0].getWashTypePoints()));
               System.out.println("Press 1 to proceed, pres 2 to go back.");
               
               
               int ChoiceNur = 0;
      while (ChoiceNur==0){//while
         String optionSr = input.readLine();
 optionSr=optionSr.toUpperCase(); 
         System.out.println("********");   
            switch (optionSr) {//switch
                case "1": ChoiceNur=1; 
                     System.out.println("Starting " + arrayWType[0].getWashTypeName());                                   
                        double washCardBalance = washCard.getCardAmount();                        
                        System.out.println("\n================\nYour choice:\n1." + get(arrayWType, 0));
                        System.out.println("******\n" + 
                           "Your have paid " + (arrayWType[0].getWashTypePrice() - arrayWType[0].getWashTypePrice()) + " DKK" +
                           "\nYour Wash Card balance is: " + washCardBalance + " DKK" + 
                           "\nYou have collected loyalty points total: " + (washCard.getLoyaltyPoints()-10));
                        int lP = ((((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints()) - ((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints())%10))/10)-1);                  
                        System.out.println("You have discounts: " + 
                           ((((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints()) - 
                           ((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints())%10))/10)-1));                   
                        System.out.println("\n+++++++++++\nWould you like a receipt?Y/N");
                        
                        
                        
                                                   ChoiceNr = 0;
                                 while (ChoiceNr==0){//while
                                    optionStr = input.readLine();
                            optionStr=optionStr.toUpperCase(); 
                                    System.out.println("********");   
                                       switch (optionStr) {//switch
                                           case "Y": ChoiceNr=1;
                                                    int washTypeNr = 0;
                                                    receiptDis(id, washCard, arrayWType, washTypeNr);//Writes receipt
                                                    historyDis(id, washCard, arrayWType, washTypeNr);//Writes history                                                      
                                                    System.out.println("Your receipt is printed.\nRemember to take your card.\nDRIVE IN");                           
                                                    break;
                              		       case "N": ChoiceNr=1;                  		       
                                                    washTypeNr = 0;                           
                                                    history(id, washCard, arrayWType, washTypeNr);
                                                    System.out.println("Remember to take your card.\nDRIVE IN");
                                                    break;   
                                          default:  System.out.print("Please choose a valid option\n");
                                               		 break;
                                         }//end of switch
                                   }//end of whole
                                
                         break;
   		       case "2": ChoiceNur=1;
            		         System.out.println("Returned");
                           Menu(id, washCard, arrayWType); 
                           break;  
               default:  System.out.print("Please choose a valid option");
                    		 break;
              }//end of switch
        }//end of whole
                          
         } //end of if
         break;//end of USE THE DISCOUNT
         
          case "N": ChoiceNr=1; {//dont use the discount
            System.out.println("\n*****WASH MENU*****\n--Choose your Wash Type--");
            System.out.println(" 1." + get(arrayWType, 0) + " " + arrayWType[0].getWashTypePrice() + " DKK" +
               ", Loyalty points: " + arrayWType[0].getWashTypePoints() + 
               "\n 2." + get(arrayWType, 1) + " " + arrayWType[1].getWashTypePrice() + " DKK" + 
               ", Loyalty points: " + arrayWType[1].getWashTypePoints() +
               "\n 3." + get(arrayWType, 2) + " " + arrayWType[2].getWashTypePrice() + " DKK" +
               ", Loyalty points: " + arrayWType[2].getWashTypePoints() +
               "\n 4.Back");
           
            ChoiceNr = 0;
      while (ChoiceNr==0){//while
          optionStr = input.readLine();
 optionStr=optionStr.toUpperCase(); 
         System.out.println("********");   
            switch (optionStr) {//switch
                case "1": ChoiceNr=1;
                         if (washCard.getCardAmount() >= arrayWType[0].getWashTypePrice()) { 
                             /* System.out.println("You are choosing: " + arrayWType[0].getWashTypeName() + "?Y/N");
                              String answer = input.readLine();
                              
                              if  (answer.equals("N") || answer.equals("n") ){
                                   System.out.println("returned.");
                                   washMenu(id, washCard, arrayWType);
                                   return;
                                 }                        
                                    if (answer.equals("Y") || answer.equals("y") )*/
                                    {
                                       System.out.println("Starting " + arrayWType[0].getWashTypeName());
                                       
                                       double washCardBalance = washCard.getCardAmount() - arrayWType[0].getWashTypePrice();                        
                                       System.out.println("\n================\nYour choice:\n1." + get(arrayWType, 0));
                                       System.out.println("******\n" + 
                                          "Your have paid " + arrayWType[0].getWashTypePrice() + " DKK" +
                                          "\nYour Wash Card balance is: " + washCardBalance + " DKK" + 
                                          "\nYou have collected loyalty points total: " + (washCard.getLoyaltyPoints() +
                                          arrayWType[0].getWashTypePoints()));
                                          
                                       System.out.println("You have discounts: " + 
                                       (((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints()) - 
                                       ((washCard.getLoyaltyPoints() + arrayWType[0].getWashTypePoints())%10))/10));
                                                                 
                                       
                                       int washTypeNr = 0;
                                       printReceipt(id, washCard, arrayWType, washTypeNr);
                                    }
                                                      
                           } else {System.out.println("Not enought balance. TOP UP to continue.");
                                 Menu(id, washCard, arrayWType);
                             }
                           break;
   		       case "2": ChoiceNr=1;
            		 if (washCard.getCardAmount() >= arrayWType[1].getWashTypePrice()) { 
                             /* System.out.println("You are choosing: " + arrayWType[1].getWashTypeName() + "?Y/N");
                              String answer = input.readLine();
                              
                              if  (answer.equals("N") || answer.equals("n") ){
                                   System.out.println("returned.");
                                   washMenu(id, washCard, arrayWType);
                                   return;
                                 }                        
                                    if (answer.equals("Y") || answer.equals("y") )*/
                                    {
                                       System.out.println("Starting " + arrayWType[1].getWashTypeName());
                                       

                                       double washCardBalance = washCard.getCardAmount() - arrayWType[1].getWashTypePrice();                        
                                       System.out.println("\n================\nYour choice:\n2." + get(arrayWType, 1));
                                       System.out.println("******\n" + 
                                          "Your have paid " + arrayWType[1].getWashTypePrice() + " DKK" +
                                          "\nYour Wash Card balance is: " + washCardBalance + " DKK" + 
                                          "\nYou have collected loyalty points total: " + (washCard.getLoyaltyPoints() +
                                          arrayWType[1].getWashTypePoints()));
                                       
                                       System.out.println("You have discounts: " + 
                                       (((washCard.getLoyaltyPoints() + arrayWType[1].getWashTypePoints()) - 
                                       ((washCard.getLoyaltyPoints() + arrayWType[1].getWashTypePoints())%10))/10));
                                                                 
                                       
                                       int washTypeNr = 0;
                                       printReceipt(id, washCard, arrayWType, washTypeNr);
                                                                           }
                                                      
                           } else {System.out.println("Not enought balance. TOP UP to continue.");
                                 Menu(id, washCard, arrayWType);
                             }
                           break;
                case "3": ChoiceNr=1;
                         if (washCard.getCardAmount() >= arrayWType[2].getWashTypePrice()) { 
                            /*  System.out.println("You are choosing: " + arrayWType[2].getWashTypeName() + "?Y/N");
                              String answer = input.readLine();
                              
                              if  (answer.equals("N") || answer.equals("n") ){
                                   System.out.println("returned.");
                                   washMenu(id, washCard, arrayWType);
                                   return;
                                 }                        
                                    if (answer.equals("Y") || answer.equals("y") )*/
                                    {
                                       System.out.println("Starting " + arrayWType[2].getWashTypeName());
                                       
                                       double washCardBalance = washCard.getCardAmount() - arrayWType[0].getWashTypePrice();                        
                                       System.out.println("\n================\nYour choice:\n3." + get(arrayWType, 2));
                                       System.out.println("******\n" + 
                                          "Your have paid " + arrayWType[2].getWashTypePrice() + " DKK" +
                                          "\nYour Wash Card balance is: " + washCardBalance + " DKK" + 
                                          "\nYou have collected loyalty points total: " + (washCard.getLoyaltyPoints() +
                                          arrayWType[2].getWashTypePoints()));
                                       
                                       System.out.println("You have discounts: " + 
                                       (((washCard.getLoyaltyPoints() + arrayWType[2].getWashTypePoints()) - 
                                       ((washCard.getLoyaltyPoints() + arrayWType[2].getWashTypePoints())%10))/10));
                                                                 
                                       
                                       int washTypeNr = 0;
                                       printReceipt(id, washCard, arrayWType, washTypeNr);
                                    }
                                                      
                           } else {System.out.println("Not enought balance. TOP UP to continue.");}
                           Menu(id, washCard, arrayWType);
                           break;
                       case "4": ChoiceNr=1;
            		 System.out.println("Returned");
                           Menu(id, washCard, arrayWType ); 
                         break;   
               default:  System.out.print("Please choose a valid option\n");
                    		 break;
              }//end of switch
        }//end of whole                                     
            //end of switch
         }//end of dont use the discount
              }//end of switch
        }//end of whole
      }//end of out of discounts
      
   }//end of method   
   //receipt method
public static void printReceipt(int id,WashCard washCard,WashType[] arrayWType,int washTypeNr)throws IOException{
   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   System.out.println("\n+++++++++++\nWould you like a receipt?Y/N");
   int ChoiceNr=0;
      while (ChoiceNr==0){//while
         String optionStr = input.readLine();
 optionStr=optionStr.toUpperCase(); 
         System.out.println("********");   
            switch (optionStr) {//switch
                case "Y": ChoiceNr=1;
                                          
                                          receipt(id, washCard, arrayWType, washTypeNr);
                                          history(id, washCard, arrayWType, washTypeNr);
                                          System.out.println("Your receipt is printed.\nRemember to take your card.\nDRIVE IN");

                         break;
   		       case "N": ChoiceNr=1;
                                                                    
                                             history(id, washCard, arrayWType, washTypeNr);
                                             System.out.println("Remember to take your card.\nDRIVE IN");

                         break;   
               default:  System.out.print("Please choose a valid option\n");
                    		 break;
              }//end of switch
        }//end of while
   

   

   }
   
   public static void AdminPanel(int id, WashCard washCard, WashType[] arrayWType )throws IOException {
   BufferedReader inwrite = new BufferedReader(new InputStreamReader(System.in));          
      int ChoiceNur = 0; 
   System.out.println("\nMENU (Write number 1 to 3 to choose your option)." + 
         "\n 1.Statistics\n 2.Manage Services\n 3.Back");
      while (ChoiceNur==0){//while
         String optionSr = inwrite.readLine();  
         System.out.println("********");   
            switch (optionSr) {//switch
               case "1": ChoiceNur=1;
                         System.out.println("Option Statistics");
                         String file_name = System.getProperty("user.dir") + "/history.txt";
                         ReadF(file_name, id, washCard, arrayWType);//sends card properties to ReadF method 
                         break;
   				case "2": ChoiceNur=1;
            		       System.out.println("Not available, try again later please.");
                         delay(3000);
                         AdminPanel(id, washCard, arrayWType);
                         break; 
               case "3": ChoiceNur=1;
                         Menu(id, washCard, arrayWType);
                         break;       
               default:  System.out.print("Please choose a valid option\n ");
                    		 break;
              }//end of switch
        }//end of whole
   
   }
   //This method shortens code when trying to introduce a delay
   public static void delay(int d)   {
   try {
    Thread.sleep(d);                 
       } catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
                                        }
                                     }//end of delay   
   
   //Method writes wash history into history.txt file which is created
   // in the project folder
   public static void ReadF(String file_name, int id, WashCard washCard, WashType[] arrayWType) throws IOException {   
      System.out.println("INFO HISTORY");
      try {
         ReadFile file = new ReadFile( file_name );
         String[] aryLines = file.OpenFile();
         int i;
         for ( i=0; i < aryLines.length; i++ ) {            
            System.out.println(aryLines[i]) ;
         }
       }
       catch (IOException e) {         
         System.out.println(e.getMessage());         
       }
       //washCardInfo(id, washCard, arrayWType);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("********************\n********************");
      System.out.println("\n+++++++++++\nGO BACK to main MENU? Y/N");
      
      int ChoiceNr = 0;
      while (ChoiceNr==0){//while
         String optionStr = input.readLine();
 optionStr=optionStr.toUpperCase(); 
         System.out.println("********");   
            switch (optionStr) {//switch
                case "Y": ChoiceNr=1;
                         System.out.println("Returned"); 
                         AdminPanel(id, washCard, arrayWType); 
                         break;
   		       case "N": ChoiceNr=1;
            		       System.out.println("Canceled.Remember to take your card.");
                         break;   
               default:  System.out.print("Please choose a valid option\n");
                    		 break;
              }//end of switch
        }//end of while
      
       
   }//end of method
   //Method adds amount to wash card amount
   public static void topUp(int id, WashCard washCard, WashType[] arrayWType) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      double amount = washCard.getCardAmount();
      System.out.println("Your wash card amount is: " + amount);
      // -----
      System.out.println("Enter credit cards pin: ");
      int creditPin = Integer.parseInt(input.readLine());
      //creditCardCheck(creditPin, Card[] arrayCreditCard);
      System.out.println("Enter amount");
      
      double creditAmount = Double.parseDouble(input.readLine());
      //-----
      double topUpAmount = amount + creditAmount;
      washCard.setNewAmount(topUpAmount);
      System.out.println("You have transfered " + creditAmount + " DKK " + 
      "to your wash card" + "\nYour wash card amount is: " + washCard.getCardAmount() + " DKK" );
      Menu(id, washCard, arrayWType);     
   }  
   //Method writes Discount receipt to a file
   public static void receiptDis(int id, WashCard washCard, WashType[] arrayWType, int washType) throws IOException {
   
      //---RECEIPT writes to file start---
      int lP = ((((washCard.getLoyaltyPoints() + arrayWType[washType].getWashTypePoints()) - 
      ((washCard.getLoyaltyPoints() + arrayWType[washType].getWashTypePoints())%10))/10)-1);
      
      String dateWash = GettingCurrentDate.getDate();      
      String separator = System.getProperty("line.separator");      
      String workingDir = System.getProperty("user.dir");
      String receipt = workingDir + "/receipt.txt";
      System.out.println("Receipt created in: \n" + workingDir + "/receipt.txt");
      WriteFile dataReceipt = new WriteFile( receipt );
      dataReceipt.writeToFile("THIS IS YOUR RECEIPT" + separator + dateWash + separator + 
         "Card PIN: " + Integer.toString(washCard.getCardPin()) + separator +
         "Wash Type: " + arrayWType[washType].getWashTypeName() +
         separator + "Your have paid " + Integer.toString(arrayWType[washType].getWashTypePrice() - arrayWType[washType].getWashTypePrice()) + " DKK" + 
         separator + "\nYour Wash Card balance is: " + Double.toString(washCard.getCardAmount()) + " DKK" +
         separator + "\nYou have collected loyalty points total: " + Integer.toString((washCard.getLoyaltyPoints()-10)) +
         separator + "\nDiscounts: " + Integer.toString(lP) + separator
      );
      //----RECEIPT writes to file end----
   }
   
   //Method writes receipt to a file
   public static void receipt(int id, WashCard washCard, WashType[] arrayWType, int washType) throws IOException {
   
      //---RECEIPT writes to file start---
      int lP = (((((washCard.getLoyaltyPoints() + arrayWType[washType].getWashTypePoints()) - 
      (washCard.getLoyaltyPoints() + arrayWType[washType].getWashTypePoints())%10))/10));
      
      String dateWash = GettingCurrentDate.getDate();      
      String separator = System.getProperty("line.separator");      
      String workingDir = System.getProperty("user.dir");
      String receipt = workingDir + "/receipt.txt";
      System.out.println("Receipt created in: \n" + workingDir + "/receipt.txt");
      WriteFile dataReceipt = new WriteFile( receipt );
      dataReceipt.writeToFile("THIS IS YOUR RECEIPT" + separator + dateWash + separator + 
         "Card PIN: " + Integer.toString(washCard.getCardPin()) + separator + 
         "Wash Type: " + arrayWType[washType].getWashTypeName() + 
         separator + "Your have paid " + Integer.toString(arrayWType[washType].getWashTypePrice()) + " DKK" + 
         separator + "\nYour Wash Card balance is: " + Double.toString(washCard.getCardAmount() - arrayWType[washType].getWashTypePrice()) + " DKK" + 
         separator + "\nYou have collected loyalty points total: " + Integer.toString((washCard.getLoyaltyPoints()+arrayWType[washType].getWashTypePoints())) +
         separator + "\nDiscounts: " + Integer.toString(lP));
      //----RECEIPT writes to file end----
   }

   //Method writes history discount to a file
   public static void historyDis(int id, WashCard washCard, WashType[] arrayWType, int washType) throws IOException {
   
      //---History writes to file start----
      String separator = System.getProperty("line.separator");
      String workingDir = System.getProperty("user.dir");
      String file_name = workingDir + "/history.txt";
      WriteFile data = new WriteFile( file_name , true );
      String dateWash = GettingCurrentDate.getDate();
      data.writeToFile( "--------------------------" + separator +
         "Card PIN: " + Integer.toString(washCard.getCardPin()) + separator + dateWash + separator +
         "Wash type: " + arrayWType[washType].getWashTypeName() + separator +
         "Your have paid: " + Integer.toString(arrayWType[washType].getWashTypePrice() - arrayWType[washType].getWashTypePrice()) + " DKK"      
      );
      //---History writes to file end------
   
   }
   
   //Method writes history to a file
   public static void history(int id, WashCard washCard, WashType[] arrayWType, int washType) throws IOException {
   
      //---History writes to file start----
      String separator = System.getProperty("line.separator");
      String workingDir = System.getProperty("user.dir");
      String file_name = workingDir + "/history.txt";
      WriteFile data = new WriteFile( file_name , true );
      String dateWash = GettingCurrentDate.getDate();
     data.writeToFile( "--------------------------" + separator +
         "Card PIN: " + Integer.toString(washCard.getCardPin()) + separator + dateWash + separator +
         "Wash type: " + arrayWType[washType].getWashTypeName() + separator +
         "Your have paid: " + Integer.toString(arrayWType[washType].getWashTypePrice()) + " DKK"      
      );
      //---History writes to file end------
   
   }
       

}

