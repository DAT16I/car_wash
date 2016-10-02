import java.util.*;
import java.io.*;

/*
This program simulates car washing terminal.
User can choose a wash or recharge his/her card
There are 3 washing options: Gold, Silver, Bronze as well as
four options for recharging wash card: 100, 200, 500, 1000kr.

Code is designed for a 10 active customers, user ID's and current balance is stored in data.txt file.



 */


public class Core {

    /*Object 'user' is created
      User is asked to insert card (simulated by pressing any button)
      Method MENU is called
     */
    public static void main(String arg[])throws IOException
    {
        Scanner input = new Scanner(System.in);
        putFile("welcome.txt");
        System.out.print("\n\n\n\n\n\n\n\n\n\nPlease insert your card! ");
        User presentUser = new User();
        input.nextLine();
        menu(presentUser);
    }




    /*
    Method used for printing welcome.txt file
     */
    public static void putFile(String nameFile)throws IOException
    {
        Scanner file = new Scanner(new File(nameFile));
        while (file.hasNextLine())
        {
            System.out.println(file.nextLine());
        }
    }





    /*
    User's current balance is displayed
    Menu is displayed and user chooses an option

    If user chooses wash program (gold, silver, bronze), then
    user's balance is checked for sufficient funds
    If balance is suffecient it calls washConfirmation method,
    if not it returns to main Menu

    If user chooses 'Recharge'
    Recharge options are displayed (100, 200, 500, 1000)
    If user chooses amount, then user is asked to confirm by inserting his credit card in card reader
    If card is inserted (simulated by tapping any button), user's balance is updated with selected amount.
    This is done by pay method with a negative value    i.e.  x - (-100) = x+100



     */
    public static void menu(User presentUser)throws IOException
    {
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        System.out.println("\nWelcome\nYour balance is: " + presentUser.getBalance());
        System.out.print("\nPlease choose your option:\n1.Wash Gold 200 dkk\n2.Wash Silver 150 dkk\n3.Wash Bronze 100 dkk\n4.Recharge\n5.Exit\n");
        Integer option = input.nextInt();

        switch(option)
        {
            case 1:
            {
                if(presentUser.getBalance()>200)
                {
                    washConfirmation(200,presentUser);
                }
                else{
                    System.out.println("Insufficient founds");
                    in.nextLine();
                    menu(presentUser);
                }
                break;
            }
            case 2:
            {
                if(presentUser.getBalance()>150)
                {
                    washConfirmation(150,presentUser);
                }
                else{
                    System.out.println("Insufficient founds");
                    in.nextLine();
                    menu(presentUser);
                }
                break;
            }
            case 3:
            {
                if(presentUser.getBalance()>100)
                {
                    washConfirmation(100,presentUser);
                }
                else{
                    System.out.println("Insufficient founds");
                    in.nextLine();
                    menu(presentUser);
                }
                break;
            }
            case 4:
            {

                System.out.println("Recharge option : 1. 100 dkk  2. 200 dkk  3. 500 dkk  4. 1000 dkk");
                System.out.println("Press 9 for menu ");
                Integer y = input.nextInt();
                Integer value=0;
                if(y==1)value=100;
                if(y==2)value=200;
                if(y==3)value=500;
                if(y==4)value=1000;

                if(y== 1 || y==2||y==3 ||y==4)
                {
                    System.out.println("Your about to recharge your card with " + value +"dkk");

                    System.out.println("Please insert your card and pin code in card reader to confirm.");
                    in.nextLine();
                    if(y==1)
                    {
                        presentUser.pay(-100);
                    }
                    if(y==2)
                    {
                        presentUser.pay(-200);
                    }
                    if(y==3)
                    {
                        presentUser.pay(-500);
                    }
                    if(y==4)
                    {
                        presentUser.pay(-1000);
                    }
                    menu(presentUser);
                }
                else
                {
                    menu(presentUser);
                }
                break;
            }
            case 5:
            {
                break;
            }

        }
    }






    public static void washConfirmation(Integer x, User userOne)throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println(x + " units will be deducted from your account.\n Are you sure ? (y/n)");

        if (input.nextLine().equals("y"))
        {
            wash(userOne, x);
        }
        else
        {
            menu(userOne);
        }
    }




    /*
    Pay method is called and wash cost is deducted from user's balance
    User is asked if receipt is needed

     */
    public static void wash(User presentUser, Integer x)throws IOException
    {
        Scanner input = new Scanner(System.in);
        presentUser.pay(x);
        System.out.println("Do you need a receipt ? (y/n)");
        if(input.nextLine().equals("y"))
        {
            System.out.println("Thank you !\nReceipt is printed. \nPlease park in the washing area !");
        }
        else
        {
            System.out.println("Thank you !\nPlease park in the washing area!");
        }
    }
}
