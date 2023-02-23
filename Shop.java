/**
 * Class: 44-242 Data Structures
 * Author: Erik Kellgren
 * Description: Project 1: List Based Data Structures
 * Due: 2/26/2023
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any other student.
   I have not given my code to any other student and will not share this code
   with anyone under any circumstances.
*/
package shop.sim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class Shop {
    private HashMap<String, Double> inventory;
    private Queue<Customer> checker_line;
    
    public Shop() {
        inventory = new HashMap<>();
        checker_line = new LinkedList<>();
    }
    
    public Shop(String inv_filename) throws FileNotFoundException {
        inventory = new HashMap<>();
        checker_line = new LinkedList<>();
        restock(inv_filename);
    }
    
    public void restock(String fname) throws FileNotFoundException {
        File file = new File(fname);
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            inventory.put(input.next(), input.nextDouble());
    }
    }
    public double priceCheck(String item) throws OutOfStockException {
        if(inventory.containsKey(item)){
            return inventory.get(item);
        }
        else{
            throw new OutOfStockException();
        }
    }
    
    public void fillOrder(Customer c) {
        for(String item: c.getOrder()){
            if(inventory.containsKey(item)){
                c.putInCart(item);   
            }
        }
        c.updateOrder();
        checker_line.add(c);
    }
    
    public void checkout() {
        double price = 0.0;
        if(!checker_line.isEmpty()){
            Customer cust = checker_line.remove();
            for(String item: cust.getCart()){
                price += priceCheck(item); 
                }
            cust.pay(price);
            }
        }
    }
