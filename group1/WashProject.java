//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WashProject {
    public WashProject() {
    }

    public static void main(String[] args)  throws Exception{

        boolean balance = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert card...");
        boolean card = true;
        System.out.println("Your name :");
        String name = scanner.nextLine();
        System.out.println("SYSTEM: Please insert your balance:");
        int balance1 = scanner.nextInt();
        Card JAAA = new Card(balance1, name, card);
        System.out.println("Your name is: " + name);
        System.out.println("Your balance is: " + JAAA.balance);
        System.out.println("Chose Top-Up or Wash Car");
        String choic = scanner.nextLine();
        choic = scanner.nextLine();
        boolean n = false;
        if(choic.equals("Top-Up") || choic.equals("top-Up") || choic.equals("Top-up") || choic.equals("top-up")) {
            topup();
            System.out.println("Thank you for Topping Up the WashCard feel free to buy a Wash today");
            n = true;
        }

        if(choic.equals("Wash Car") || choic.equals("wash Car") || choic.equals("Wash car") || choic.equals("wash car") || n) {
            System.out.println("Simple: Water+Soap   120kr\nWax: Simple+Wax   220kr\nPremium: Wax+Dry Clean   400kr");
        }

        String washy = scanner.nextLine();
        int c=0;
        int receipt;
        String receipt1;
        if(washy.equals("Simple") || washy.equals("simple")) {
            washy = "Simple";
            System.out.println("Verifying your balance...");
            Simple totalp = new Simple(70, 50);
            c = Integer.parseInt(totalp.toString());
            if(balance1 - c < 0) {
                System.out.println("You don\'t have enough balance. Please top-up");
                receipt = topup();
                balance1 += receipt;
            } else {
                balance1 -= c;
                System.out.println("Your new balance is:" + balance1);
                System.out.println("Thank you for using SuperShine. Would you like a receipt?");
                receipt1 = scanner.nextLine();
                if(!receipt1.equals("yes") && !receipt1.equals("Yes")) {
                    System.out.println("Please drive in. Thank you for using SuperShine");
                } else {
                    System.out.println("Receipt is being printed. Please drive in your car. Thank you for using SuperShine");
                }
            }
        }

        if(washy.equals("Wax") || washy.equals("wax")) {
            washy = "Wax";
            System.out.println("Verifying your balance...");
            Wax totalp1 = new Wax(100);
            c = Integer.parseInt(totalp1.toString());
            if(balance1 - c < 0) {
                System.out.println("You don\'t have enough balance. Please top-up");
                receipt = topup();
                balance1 += receipt;
            } else {
                balance1 -= c;
                System.out.println("Your new balance is:" + balance1);
                System.out.println("Thank you for using SuperShine. Would you like a receipt?");
                receipt1 = scanner.nextLine();
                if(!receipt1.equals("yes") && !receipt1.equals("Yes")) {
                    System.out.println("Please drive in. Thank you for using SuperShine");
                } else {
                    System.out.println("Receipt is being printed. Please drive in your car. Thank you for using SuperShine");
                }
            }
        }

        if(washy.equals("Premium") || washy.equals("premium")) {
            System.out.println("Verifying your balance...");
            Premium totalp2 = new Premium(180);
            c = Integer.parseInt(totalp2.toString());
            if(balance1 - c < 0) {
                System.out.println("You don\'t have enough balance. Please top-up");
                receipt = topup();
                int var10000 = balance1 + receipt;
            } else {
                balance1 -= c;
                System.out.println("Your new balance is:" + balance1);
                System.out.println("Thank you for using SuperShine. Would you like a receipt?");
                receipt1 = scanner.nextLine();
                if(!receipt1.equals("yes") && !receipt1.equals("Yes")) {
                    System.out.println("Please drive in. Thank you for using SuperShine!");
                } else {
                    System.out.println("Receipt is being printed. Please drive in your car. Thank you for using SuperShine");
                }


                }

            }
        File f = new File("database");
        String timeStamp = (new SimpleDateFormat("dd.MM.yyyy - HH:mm")).format(Calendar.getInstance().getTime());
        String data = "\n"+name+" - " + washy + " - " +timeStamp;


        if(!f.exists())
        {
            System.out.println("No!");
            PrintStream writeFile = createFile("database");
            writeToFile(writeFile,name+" - " +washy + " - " +timeStamp);

        }
        FileWriter fileWriter = new FileWriter(f.getName(), true);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        bufferWriter.write(data);
        bufferWriter.close();

        }

    private static int topup() {
        System.out.println("Insert your credit card...");
        System.out.println("Insert the amount of money:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        return amount;
    }

    public static void readFile(File file)
            throws FileNotFoundException

    {
        Scanner input= new Scanner (file);
        while(input.hasNextLine()){
            System.out.println(input.nextLine());
        }
    }
    public static PrintStream createFile(String filePath)
            throws FileNotFoundException{
        System.out.println("Creating file...");
        return new PrintStream(new File(filePath));
    }

    public static void writeToFile(PrintStream file, String line){
        System.out.println("Writing to file...");
        file.print(line);
    }
}
