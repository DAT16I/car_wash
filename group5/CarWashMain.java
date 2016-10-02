
import java.util.Scanner;
import java.io.*;
public class CarWashMain {
    static Scanner scan;


    /**
     * Created by ${} on 9/25/2016.
     */

    public static void main (String[] args) throws IOException {


        scan = new Scanner(System.in);
        CarWashChooseAnOption carWashChooseAnOption = new CarWashChooseAnOption(3);
        CheckAccount checkAccount = new CheckAccount(99999);


        checkAccount.checkAccountNumber();
        carWashChooseAnOption.chooseOptionMainMenu();

        int balance = carWashChooseAnOption.getBalance();
        int bronze = carWashChooseAnOption.getBronzeWash();
        int silver = carWashChooseAnOption.getSilverWash();
        int gold = carWashChooseAnOption.getGoldWash();
        int platinium = carWashChooseAnOption.getPlatiniumWash();
        int accountNum = checkAccount.getAccountNumber();

        ArrayObject arrayObject = new ArrayObject(accountNum, balance, bronze, silver, gold, platinium);

        try{
        FileOutputStream fout = new FileOutputStream("AccountInformation");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(arrayObject);
        }
        catch (Exception e){

        }

    }

}
