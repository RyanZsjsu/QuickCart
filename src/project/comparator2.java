
package project;

import java.util.Comparator;


public class comparator2 implements Comparator<Item>{
    
    public int compare(Item o1, Item o2) {
        if (o1 == null || o2 ==null )
            return 0;
        if (o1 == null && o2 == null)
            return 0;
        if(o1.getID() > o2.getID())
            return 1;
        if(o1.getID() == o2.getID())
            return 0;
        else
            return -1;
        
            }
}
