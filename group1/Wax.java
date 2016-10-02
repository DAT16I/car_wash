/**
 * Created by Skuld on 9/26/2016.
 */
public class Wax extends Simple{
    public int wa;

    public Wax(int wa)
    {
        super(50,70);
        this.wa=wa;
    }

    public String toString()
    {
        int simpleone=Integer.parseInt(super.toString())+wa;
        return Integer.toString(simpleone);
    }
}
