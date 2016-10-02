/**
 * Created by ${} on 9/26/2016.
 */
public class ArrayObject {

    private int accountNumber;
    private int accountBalance;
    private int bronzeWash;
    private int silverWash;
    private int goldWash;
    private int platiniumWash;


    public ArrayObject (int accountNumber,int accountBalance ,
                        int bronzeWash,int silverWash,int goldWash, int platiniumWash){

        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.bronzeWash = bronzeWash;
        this.silverWash = silverWash;
        this.goldWash = goldWash;
        this.platiniumWash = platiniumWash;

    }

    public String toString (){
        return "Account: " +this.accountNumber + this.accountBalance+
                this.bronzeWash + this.silverWash +this.goldWash + this.platiniumWash;
    }

}
