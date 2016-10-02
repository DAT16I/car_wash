import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {

    public static String accFile = "Accounts.txt";

    public static void cr8AccountFile(){
        File file = new File(accFile);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch(Exception e) {
            System.out.println("Problem creating file");
        }
    }
    public static void readAccountInfo(){
        File f = new File(accFile);

        if (f.exists()) {
            try {
                Scanner scanner = new Scanner(new File(accFile));
                    while (scanner.hasNext()) {
                        //System.out.println(scanner.nextLine());
                        Customer.balance = (scanner.nextDouble());
                    }
            }catch(Exception e){
                System.out.println("Problem reading file");
            }
        } else {
            cr8AccountFile();
        }
    }
    public static void writeBalanceToFile(double amount){
        try{
        PrintWriter writer = new PrintWriter(accFile, "UTF-8");
        writer.println(amount);
        writer.close();
    } catch (Exception e) {
            System.out.println("Unable to read/write to file");
        }
    }
}
