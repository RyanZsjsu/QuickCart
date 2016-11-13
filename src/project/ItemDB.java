
package project;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import treepackage.*;
import StackAndQueuePackage.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import arraysortrecursive.*;

public class ItemDB extends Item {
    private static int numberOfItems = 0;
    private Item[] itemArray;
    private final int DEFAULT_CAPACITY = 10;
    private int searchIndex;
    SearchTreeInterface<Item> tree = new BinarySearchTree<>();
    String[] category;
    int x = 0;
    Item[] idArray; 
    private LinkedList linkedList = new LinkedList();
    private ArraySortRecursive e = new ArraySortRecursive();
  
    
    
    public ItemDB(){
        category = new String[DEFAULT_CAPACITY];
        itemArray = new Item[DEFAULT_CAPACITY];
        idArray = new Item[DEFAULT_CAPACITY];
    }
   
    
    public void importItems (String fileName) {
        Scanner input = new Scanner(System.in);
        String str;
        
        
        //System.out.println("Import Items ...");
        try {
            input = new Scanner (new File (fileName));
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
            System.exit(1);
        }
        
        while (input.hasNextLine()) {
            str = input.nextLine();
            // System.out.println(str);
            String[] fields = str.split(",");
            Item newItem = new Item();
            category[x] = fields[3];
            newItem.parseFields (fields);
            //System.out.println (newItem);
            x++;
           if (x == category.length) {
                String[] newArray = Arrays.copyOf(category, x + DEFAULT_CAPACITY);
                category = newArray;
            }
            //itemArray[numberOfItems] = newItem;
            //numberOfItems++;
            
            tree.add(newItem);
            
        }
     
    }
    
 
    public boolean search (String str) {
        boolean found = false;
        
        Item a = new Item();
        a.setName(str);
        
        return tree.Search(a);
    }
    
    public Item[] displayCategory(String a){
        Item e = new Item();
        e.setCategory(a);
        itemArray = (Item[]) tree.returnCategory(e);
         if (x == itemArray.length) {
                Item[] newArray = Arrays.copyOf(itemArray, x + DEFAULT_CAPACITY);
                itemArray = newArray;
            }
        return itemArray;
    }

    
    public String returnSearchResult(){
        
        return tree.getSearchEntry().toString();
    }
        
    public String returnCategories(){
        String s;
        List<String> al = new ArrayList<>();
        int j = 0;
        while (category[j] != null ){
           al.add(category[j]); 
           j++;
        }
        //removes any repeated elements
        Set<String> hs = new HashSet<>();
        hs.addAll(al);
        al.clear();
        al.addAll(hs);
        al.toString();
        //s = Arrays.toString(category);
        s = al.toString();

        return s;
    }
   
    public LinkedList searchId(int x){
        Item v = new Item();
        v.setID(x);
        //idArray = tree.returnId(v);
       linkedList = tree.returnId(v);
       return linkedList;
        //return idArray;
    }
    
    public LinkedList remove(int x){
        comparator2 n = new comparator2();
        Item y = new Item();
        y.setID(x);
        for(int i = 0; i<linkedList.size(); i++){
      
            if (n.compare( (Item)linkedList.get(i), y) == 0){
                linkedList.remove(i);
                
            }
           
                      
        }
    
        
        
        /*for(int j = 0; j < idArray.length; j++){
            if(idArray[j] != null){
                if(idArray[j].getID() == x){
                    idArray[j] = null;
                }
            }
            
        }
                */
        
        return linkedList;
    
    }
}

    


