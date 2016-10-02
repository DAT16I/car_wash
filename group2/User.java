import java.util.*;
import java.io.*;


public class User
{
    /*
    We use private class fields for encapsulation
     */


    private Integer userId;
    private Integer amount;
    Random ran = new Random();



    /*
    Random number between 1 and 10 is created
    userID and balance are read from data.txt file
    presentUser is randomized from database of 10 users


     */
    public User()throws IOException
    {
        Integer x  = ran.nextInt(10)+1;
        Scanner file = new Scanner(new File("data.txt"));
        this.userId = x;


        for(int i=1; i<=x; i++)
        {
            /*
            First line reads userID
            Second User's balance
            We use this.amount twice to skip the user ID
             */
            this.amount = file.nextInt();
            this.amount = file.nextInt();
        }
    }





    public  int getBalance()
    {
        return this.amount;
    }




    /*
    Deducts price of wash or recharge from user's balance
    and updates it

     */
    public void pay(Integer price)throws IOException
    {
        this.amount-= price;
        update();
    }



    /*
    As we cannot read and write from the same file, thus we read from initial data.txt file
    and write to newly created data.txt file, which balance update is overwritting initial version.

    This method finds and overwrites present users balance
    Integer matrix 10x2 is created
    All data from data.txt is copied to matrix
    Present user's balance is overwritten in matrix with the new one.

    New file data.txt is created, previous file is overwritten and
    all data from the matrix is written to the new file.


     */
    public void update()throws IOException
    {
        Scanner file = new Scanner(new File("data.txt"));
        int[][] vec = new int[10][2];

        for(int i=0; i<10; i++)
        {
            for(int j=0; j<2; j++)
            {
                vec[i][j]=file.nextInt();
            }
        }
        file.close();

        for(int i=0; i<=9; i++)
        {
            if(this.userId == vec[i][0])
            {
                vec[i][1]=this.amount;
            }
        }

        Formatter write = new Formatter("data.txt");
        for(int i=0; i<=9; i++)
        {
            write.format("%d %d\n", vec[i][0], vec[i][1]);
        }
        write.close();

    }
}
