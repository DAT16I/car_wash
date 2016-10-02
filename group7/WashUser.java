import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WashUser {

   private String name;
   private double balance;
   private boolean userExists;
   private boolean hasBought = false;
   
 /*
 * WashUser represents the constructor. This method has several functions, besides the constructing one. 
 * First, the system checks if the person has an account (card).Using private variables, the users balance is checked.
 * Also, it checks the balance and welcomes the customer
 * @param name passes the system the name that you have entered. Based on this, the program will let you or not, to access the carwash.
 */
   public WashUser(String name) throws FileNotFoundException {
      
      
      File file = new File(name+".txt");
      
      if (file.exists()) {
            
         PrintStream statsFile = new PrintStream(name + "Stats.txt");
         System.out.println("Logged in on: " + getDate());
         writeToStatFile(statsFile, ("Logged in on: " + getDate()));
         this.userExists = true;
         Scanner input = new Scanner(file);
         String balanceString;
         double balanceDouble;
         balanceString = input.nextLine();
         balanceDouble = Double.parseDouble(balanceString);
         this.name = name;
         this.balance = balanceDouble;
         System.out.println("Hello Mr." + this.name + ", your current balance is: " + this.balance);
            
      }
         
      else {
            
         this.userExists = false;
         System.out.println("user not found");
            
      }
   
   }
   
   public String Id() {
   
      return this.name;
   
   }
/*
 * deductBalance is the method that subtracts from the users account money when he buys wash services.
 * However only if the user exists. the system will allow for further transactions. Aditionally, if the user has bought a program
 * the system will not allow him to buy another one in this session.
 * If the user does not have enough money, the system will show an error and ask the customer to recharge it.
 * At the end of it all, it will show the post transaction ballance.
 * @param amount has stored in it the amount of money that the customer wants to spend.
 * @param name has the function of keeping the name of the customer stored into a variable and use it to complete transactions.
 */
   public void deductBalance(double amount, String name) throws FileNotFoundException {
      
      if (this.userExists == true) {
      
         if (this.balance >= amount) {
         
            this.hasBought = true;
            this.balance = balance - amount;
            PrintStream writeFile = createFile(name + ".txt");
            double currentBalanceString = this.balance;
            String currentBalance = String.valueOf(currentBalanceString);
            writeToFile(writeFile, currentBalance);
            System.out.println("Transaction succesful! Please exit and proceed to the washing machine.");
            System.out.println("Post transaction balance: " + this.balance);
         
         }
         
         else {
         
            this.hasBought = false;
            System.out.println("Insufficient funds. Transaction unsuccesful. Please Recharge your balance.");
         
         }
      }
   }
/*
 * addBalance is the method that adds to the users account money when he recharges his account.
 * However, only if the user exists, the system will allow for further transactions.     
 * At the end of it all, it will show the post transaction ballance.
 * If the user does not inputs a value between 1000 and 200, the system will present an error
 * @param amount has stored in it the amount of money that the customer currently has on his account.
 * @param name has the function of keeping thee name of the customer stored into a variable and use it to complete transactions.
 */
   public void addBalance(double amount, String name) throws FileNotFoundException {
      
      if (this.userExists == true) {
         
         if (amount >= 200 && amount <= 1000){
         
            this.balance = balance + amount;
            PrintStream writeFile = createFile(name + ".txt");
            double currentBalanceString = this.balance;
            String currentBalance = String.valueOf(currentBalanceString);
            writeToFile(writeFile, currentBalance);
            System.out.println("Post transaction balance: " + this.balance);
         
         }
         
         else {
         
            System.out.println("Invalid amount.");
         
         }
      }
   }

   
   public static PrintStream createFile(String filePath) throws FileNotFoundException {
   
      System.out.println("Updating balance");
      return new PrintStream(new File(filePath));
      
   
   }
   
   public static void writeToFile(PrintStream file, String line) {
   
      file.println(line);
      System.out.println("Balance updated.");
      file.close();
   
   }
   
   public static void writeToStatFile(PrintStream file, String line) {
   
      file.println(line);
      System.out.println("Statistics updated.");
      file.close();
   
   }

   
   public boolean doesUserExist() {
   
      return this.userExists;
   
   }
   
   public boolean hasUserBought() {
   
      return this.hasBought;
   
   }
   
   public double getBalance() {
   
      return this.balance;
   
   }
   
   public String getDate() {
   
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      //get current date time with Date()
      Date date = new Date();
      String currentTime = dateFormat.format(date);
      
      return currentTime;
   
   }
   
   




}
