import java.util.*;
import java.lang.*;
public class Ingredient
{
    private String name;
    private String units;
    private int count;
    public Ingredient(String name, String units, int count)
    {
        this.name = name;
        this.units = units;
        this.count = count;
    }

    public String getName()
    {
        return name;
    }

    public String getUnits(){
        return units;
    }

    public int getCount() {
        return count;
    }


}
