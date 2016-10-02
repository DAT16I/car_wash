import java.util.Scanner;
/**
 * Created by ${} on 9/25/2016.
 */

public class CarWashChooseAnOption {

    private Scanner scan;

    private int howManyOptions;
    private int input;
    private int userInput;
    private int balance;
    private int bronzeWash =0;
    private int silverWash =0;
    private int goldWash =0;
    private int platiniumWash =0;

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        balance -= bronzeWash - silverWash - goldWash - platiniumWash;
        this.balance = balance;
    }

    public int getBronzeWash() {
        return bronzeWash;
    }

    public int getSilverWash() {
        return silverWash;
    }

    public int getGoldWash() {
        return goldWash;
    }

    public int getPlatiniumWash() {
        return platiniumWash;
    }

    public CarWashChooseAnOption(int howManyOptions) {
        this.howManyOptions = howManyOptions;
        scan = new Scanner(System.in);
    }

    public void setChooseAnOption(int input) {
        this.input = input;
    }

    public int getChoseAnOption() {
        return this.input;
    }

    public int numOfOptions() {
        return this.howManyOptions;
    }

    public void chooseOptionMainMenu() {

        write("\nChoose an option: \n" +
                "1.   Choose wash type\n" +
                "2.   Check WashCard balance\n" +
                "3.   Recharge WashCard\n");

        do {
            try {
                write("Press the number of the option you want ");
                setChooseAnOption(Integer.parseInt(scan.nextLine()));
            }catch (Exception e){

            }
        }while(
                getChoseAnOption()<1 ||
                        getChoseAnOption() > numOfOptions());

        switch (getChoseAnOption()) {
            case 1:
                chooseWashType();
                break;

            case 2:
                checkBalanceChooseOption();
                break;

            case 3:
                chooseRechargeCard();
                break;
        }
    }

    public static void write(Object line) {
        System.out.println(line);
    }

    public int chooseWashType() {
        write("Witch  wash type do you want:? \n" +
                "\n" +
                "1. Bronze  -  50 kr.\n" +
                "     - high pressure wash\n" +
                "     - spot free rinse\n" +
                "2. Silver  -  100 kr.\n" +
                "     - Bronze\n" +
                "     - + high pressure undercariage\n" +
                "     - + power dry\n" +
                "3. Gold  -  150 kr.\n" +
                "     - Silver\n" +
                "     - + clear coat protection\n" +
                "4. Platinium  -  200 kr.\n" +
                "     - Gold\n" +
                "     - + trifoam polish\n");

        do {
            try{
            write("Choose by presing wash type number");
            userInput = Integer.parseInt(scan.nextLine());
            }catch (Exception e){

            }
        }
        while (userInput < 1 || userInput > 4);

        switch (userInput) {
            case 1:
                bronzeWash += 1;
                break;

            case 2:
                silverWash += 1;
                break;

            case 3:
                goldWash += 1;
                break;

            case 4:
                platiniumWash += 1;
                break;

        }

        write("Wash starts");
        return userInput;
    }

    public void checkBalanceChooseOption() {
        write("Your balance is:  " +
                "\nChoose an option:\n" +
                "\n" +
                "1. Recharge WashCard\n" +
                "2. Back ");

        do {
            try{
            write("Choose by presing wash type number");
            userInput = Integer.parseInt(scan.nextLine());
            }catch (Exception e){

            }
        }
        while (userInput < 1 || userInput > 2);

        switch (userInput){
            case 1:
                chooseRechargeCard();
                break;

            case 2:
                chooseOptionMainMenu();
                break;

        }
    }

    public void chooseRechargeCard() {
        write("Choose an amount:\n" +
                "1. 100 kr.\n" +
                "2. 200 kr.\n" +
                "3. 500 kr.\n" +
                "4. 1000 kr.\n");

        do {
            try{
            write("Choose by presing the number of the option");
            userInput = Integer.parseInt(scan.nextLine());
            }catch (Exception e){

            }
        }
        while (userInput < 1 || userInput > 4);

        switch (userInput) {
            case 1:
                write("The WashCard was succesfuly recharged !!!");
                chooseOptionMainMenu();
                break;

            case 2:
                write("The WashCard was succesfuly recharged !!!");
                chooseOptionMainMenu();
                break;

            case 3:
                write("The WashCard was succesfuly recharged !!!");
                chooseOptionMainMenu();
                break;

            case 4:
                write("The WashCard was succesfuly recharged !!!");
                chooseOptionMainMenu();
                break;
        }

    }


}
