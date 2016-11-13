
package project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class comparator<name> implements Comparator<Item> {
    
    public int compare(Item o1, Item o2) {
        if (o1 == null || o2 ==null )
            return 0;
        if (o1 == null && o2 == null)
            return 0;
        else
           return (o1.getName().compareTo(o2.getName()) );
            }
}
