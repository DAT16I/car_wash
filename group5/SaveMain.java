import java.util.*;
import java.io.*;

public class SaveMain {
   
   public static void main (String args[]) {
      
      
      Costumer[] costumers = new Costumer[0];
      WashType[] washData = new WashType[0];
      
      
      try {
         costumers = SaveLoad.loadCostumers();
         
         for (int i = 0; i < costumers.length; i++) {
            System.out.print(costumers[i]);
         }
      } catch (FileNotFoundException e) {
         
      }
      
      try {
         SaveLoad.saveCostumer(costumers);
         
      } catch (FileNotFoundException e) {
         
      }
      
      
      try {
         washData = SaveLoad.loadWashData();
         
         for (int i = 0; i < washData.length; i++) {
            System.out.print(washData[i]);
         }
      } catch (FileNotFoundException e) {
         
      }
      
      try {
         SaveLoad.saveWashData(washData);
         
      } catch (FileNotFoundException e) {
         
      }
   }
}