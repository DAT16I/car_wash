public class Customer {
    public static double balance;
    public static double fastPrice = 69.99;
    public static double regularPrice = 99.99;
    public static double deepPrice = 159.99;
    public static double supershinePrice = 220;

    public static void getUpdatedAccountBalance(){
        System.out.println("Your account balance is now: " + balance);
        System.out.println();
    }

    public static void getAccountBalance(){
        System.out.println("Your account balance is: " + balance);
        System.out.println();
    }

    public static void chooseFast(){
        balance -= fastPrice;
        FileManager.writeBalanceToFile(Customer.balance);
        System.out.println("You have chosen: FAST");
    }
    public static void chooseRegular(){
        balance -= regularPrice;
        FileManager.writeBalanceToFile(Customer.balance);
        System.out.println("You have chosen: REGULAR");
    }
    public static void chooseDeep(){
        balance -= deepPrice;
        FileManager.writeBalanceToFile(Customer.balance);
        System.out.println("You have chosen: DEEP");
    }
    public static void chooseSupershine(){
        balance -= supershinePrice;
        FileManager.writeBalanceToFile(Customer.balance);
        System.out.println("You have chosen: SUPERSHINE");
    }
    public static void insufficientFunds(){
        System.out.println("Insufficient funds on account, please select another option.");
    }
}
