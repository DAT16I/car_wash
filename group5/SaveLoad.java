import java.util.*;
import java.io.*;

public class SaveLoad {
   
   private static String costumerPath = "AccountInformation.txt";
   private static String washPath = "WashData";
   
   public SaveLoad() {
      
   }
   
   public static Costumer[] loadCostumers() throws FileNotFoundException {
      
      Costumer[] costumers = new Costumer[0];
      File f = new File(costumerPath);
      
      if (f.exists()) {
         
         System.out.println("Costumer file exists");
         
         Scanner input = new Scanner(f);
         int costumerAmount = 0;
         
         while (input.hasNextLine()) {
         
            if (input.nextLine().equals("-")) {
               costumerAmount++;
            }
         }
         
         input = new Scanner(f);
         costumers = new Costumer[costumerAmount];
         
         for (int i=0; i < costumerAmount; i++) {
               
            costumers[i] = new Costumer();
            
            int cardID = Integer.parseInt(input.nextLine());
            costumers[i].setCardID(cardID);
            
            int cardBalance = Integer.parseInt(input.nextLine());
            costumers[i].setCardBalance(cardBalance);
            
            input.nextLine();
         }
      }
      else {
         System.out.println("Costumer file not found");
      }
      
      return costumers;
   }
   
   public static void saveCostumer(Costumer[] costumers) throws FileNotFoundException {
         
      PrintStream output = new PrintStream(new File(outputPath));
      
      for (int i = 0; i < costumers.length; i++) {
         output.print(costumers[i]);
      }
   }
   
   public static WashType[] loadWashData() throws FileNotFoundException {
      
      WashType[] washData = new WashType[0];
      
      File f = new File(washPath);
      
      if(f.exists()) {
         System.out.println("Wash data file exists");
         
         Scanner input = new Scanner(f);
         int WashTypesAmount = 0;
         
         while (input.hasNextLine()) {
         
            if (input.nextLine().equals("-")) {
               WashTypesAmount++;
            }
         }

         input = new Scanner(f);
         washData = new WashType[WashTypesAmount];
         
         for (int i=0; i < WashTypesAmount; i++) {
               
            washData[i] = new WashType();
            
            String washName = input.nextLine();
            washData[i].setWashName(washName);
            
            int timesUsed = Integer.parseInt(input.nextLine());
            washData[i].setTimesUsed(timesUsed);
            
            input.nextLine();
         } 
      }
      else {
         System.out.println("Wash data file not found");
      }
      
      return washData;
   }
   
   public static void saveWashData(WashType[] washData) throws FileNotFoundException {
         
      PrintStream output = new PrintStream(new File(outputPath));
      
      for (int i = 0; i < washData.length; i++) {
         output.print(washData[i]);
      }
   }
}