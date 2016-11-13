
package project;
import treepackage.*;
import StackAndQueuePackage.*;
import java.util.Comparator;
import arraysortrecursive.*;

public class Item implements Comparable<Item> {
   // private static int numberOfItems = 0;
    public Integer id;
    public String name;
    public String description;
    public String category;
    public Double price;

    public Item () {
        this (0, "", "", "", 0);
    }
    public Item (int itemID, String itemName, 
                 String itemDescription, String itemCategory, 
                 double itemPrice) {
        id = itemID;
        name = itemName;
        description = itemDescription;
        category = itemCategory;
        price = itemPrice;
       // numberOfItems++;
    }
    
     public static final Comparator<Item> BY_AGE_COMPARATOR = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.name.compareTo(o2.name)> 0 ? -1 : (o1.name.equals(o2.name) ? 0 : 1);
            }
        };
  
   // public int compare(Item a, Item other){
    //    return 0;
    //}
    
    @Override
    public String toString () {
        return (" ID= " + id +
                "\n Name= " + name +
                "\n Description= " + description +
                "\n Category= " + category +
                "\n Price= " + price +
                "\n" + "\n");
    }
    @Override
    public int compareTo (Item anItem) {
      
        
        if(this.name.compareTo(anItem.getName()) > 0){
            return 1;
        }
        else if(this.name ==  anItem.getName()){
            return 0;
        }
        else if(this.name.compareTo(anItem.getName()) < 0){
            return -1;
       }
        else 
           return 0;
    }
    
    
    public boolean equals(Object a){
        boolean found;
        Item o = (Item) a;
        if(a == null)
            return false;
        if(this.category.equals(o.category)){
            return found = true;
        }
        else 
            return found = false;
    }
    
    //public int equals
    public int comparePriceTo (Item anItem) {
        return price.compareTo(anItem.getPrice());
    }
    
    public void parseFields (String[] fields) {
        id = Integer.parseInt(fields[0]);
        name = fields[1];
        description = fields[2];
        category = fields[3];
        price = Double.parseDouble(fields[4]);
       
    }
    
    
      public Integer getID() {
        return id;
    }
      public void setID(int x){
          this.id = x;
      }
    public String getName() {
        return name;
    }
    public void setName(String e){
        this.name = e;
    }
    public String getDescription () {
        return description;
    }
    public String getCategory () {
        return category;
    }
    public void setCategory(String a){
        this.category = a;
    }
    public double getPrice () {
        return price;
    }
}