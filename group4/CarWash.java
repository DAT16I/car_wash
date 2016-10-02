import java.util.*;
public class CarWash{

    //start start of the program
    public static void main(String[] args){
        System.out.println("Please insert your card");
        Scanner sc = new Scanner(System.in);
        String confirmation = sc.nextLine();
        //just press enter to continue

        FileManager.readAccountInfo(); //show balance
        Customer.getAccountBalance();
        System.out.println();
        if (Customer.balance < Customer.fastPrice) {
            System.out.println("Insufficient funds detected!\nYou need to recharge your account to use the wash.\n");
            rechargeAccount();
        } else {
            System.out.println("Do you want to recharge your balance or continue washing?");
            System.out.println("1. RECHARGE / 2. CONTINUE");
            Scanner sca = new Scanner(System.in);
            String recharge = sca.nextLine();
            //recharge or continues
            if (recharge.equals("RECHARGE") || recharge.equals("1") || recharge.equals("recharge")) {
                rechargeAccount();
            }
            else {
                Customer.getAccountBalance();
            }
        }
        if (Customer.balance > Customer.fastPrice) {
            chooseWashingTypes();
        } else {
            System.out.println("Insufficient funds detected!\nYou need to recharge your account to use the wash.");
            System.out.println("A minimum of " + Customer.fastPrice + " is required.");
            rechargeAccount();
        }
    }

    private static void exitApplication(){
        System.out.println("Thank you for using the Supershine Car Wash System");
        System.out.println("Please drive your car into the wash");
        System.exit(1);
    }

    private static void rechargeAccount(){
        System.out.println("Please insert your credit card");
        Scanner scanCC = new Scanner(System.in);
        String confirmationCC = scanCC.nextLine();
        //just press enter to continue
        Customer.getAccountBalance();
        System.out.println();
        System.out.println("How much would you like to recharge?");

        while (true) {
            try {
                Scanner rechargeInput = new Scanner(System.in);
                String amountToRecharge = rechargeInput.nextLine();
                double rechargedAmount = Double.parseDouble(amountToRecharge);
                if (rechargedAmount > 0.0) {
                    Customer.balance += rechargedAmount;
                    FileManager.writeBalanceToFile(Customer.balance);
                    break;
                }
                else {
                    System.out.println("Please type a number greater than 0");
                }
            }
            catch(Exception e) {
                System.out.println("Please type a number greater than 0");
            }

        }
        Customer.getUpdatedAccountBalance();
        chooseWashingTypes();
    }

    private static void chooseWashingTypes(){
        if (Customer.balance > Customer.fastPrice) {
            // washing types
            System.out.println("Choose the type of washing!");
            System.out.println();
            System.out.println("FAST \t REGULAR \t DEEP \t SUPERSHINE");
            System.out.println("water \t water \t\t water \t water");
            System.out.println("soap \t soap \t\t soap \t soap ");
            System.out.println("steam \t steam \t\t steam \t steam ");
            System.out.println("\t\t\t\t\t polish  high-pressure wax");
            System.out.println("\t\t\t\t\t water cleaning buffing wheel and polish");
            System.out.println("69,93 \t 99,99 \t\t 159,59  220");
//they choose from fast/regular/deep/supershine
            while (true) {
                Scanner washingTypes = new Scanner(System.in);
                String chooseWash = washingTypes.nextLine();
//use washingTypes for displaying what they chose
                if (chooseWash.equals("FAST") || chooseWash.equals("1") || chooseWash.equals("fast")){
                    if (Customer.balance > Customer.fastPrice) {
                        Customer.chooseFast();
                        Customer.getUpdatedAccountBalance();
                        exitApplication();
                        break;
                    } else{
                        Customer.insufficientFunds();
                    }

                }
                else if (chooseWash.equals("REGULAR") || chooseWash.equals("2") || chooseWash.equals("regular")){
                    if (Customer.balance > Customer.regularPrice) {
                        Customer.chooseRegular();
                        Customer.getUpdatedAccountBalance();
                        exitApplication();
                        break;
                    } else{
                        Customer.insufficientFunds();
                    }
                }
                else if (chooseWash.equals("DEEP") || chooseWash.equals("3") || chooseWash.equals("deep")){
                    if (Customer.balance > Customer.deepPrice) {
                        Customer.chooseDeep();
                        Customer.getUpdatedAccountBalance();
                        exitApplication();
                        break;
                    } else{
                        Customer.insufficientFunds();
                    }
                }
                else if (chooseWash.equals("SUPERSHINE") || chooseWash.equals("4") || chooseWash.equals("supershine")){
                    if (Customer.balance > Customer.supershinePrice) {
                        Customer.chooseSupershine();
                        Customer.getUpdatedAccountBalance();
                        exitApplication();
                        break;
                    } else{
                        Customer.insufficientFunds();
                    }
                }
                else{
                    System.out.println("Please choose between the options available!");
                }
            }
        } else {
            System.out.println("Insufficient funds detected!\nYou need to recharge your account to use the wash.");
            System.out.println("A minimum of " + Customer.fastPrice + " is required.");
            rechargeAccount();
        }
    }
}


