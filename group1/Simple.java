/**
 * Created by Skuld on 9/26/2016.
 */
public class Simple {
    private int water;
    private int soap;

    public Simple(int water,int soap)
    {
        this.water=water;
        this.soap=soap;
    }
    public String toString()
    {
        return Integer.toString(this.water+this.soap);
    }
}
