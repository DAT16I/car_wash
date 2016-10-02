/**
 * Created by Skuld on 9/26/2016.
 */
public class Premium extends Wax {
    private int dryClean;

    public Premium (int dryClean){
        super (100);
        this.dryClean=dryClean;


    }

    public String toString()
    {
        int dryCleaner =Integer.parseInt(super.toString())+ dryClean;
        return Integer.toString(dryCleaner);
    }
}
