import java.util.Scanner;
/**
 * Created by ${} on 9/25/2016.
 */
public class CheckAccount extends CarWashChooseAnOption{

    private Scanner scan;
    private int numberOfAccount;

    public CheckAccount(int numberOfOptions) {
        super(numberOfOptions);
        scan = new Scanner(System.in);

    }
    public void checkAccountNumber () {

        write(" Insert your WashCard pleace:\n" +
                "   or enter WashCard number\n");

        do {
            try {
                write("Enter the 5 digits on the bag side !!!");
                setChooseAnOption(Integer.parseInt(scan.nextLine()));
            } catch (Exception e) {

            }

        } while (
                getChoseAnOption() < 10000 ||
                        getChoseAnOption() > numOfOptions());

        this.numberOfAccount = getChoseAnOption();
    }

    public int getAccountNumber (){
        return this.numberOfAccount;
    }


}
