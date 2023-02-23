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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Customer{

    private Double budget;
    private HashSet<String> order;
    private ArrayList<String> cart;
    

    public Customer() {
        budget = 0.0;
        order = new HashSet<>();
        cart = new ArrayList<>();
    }

    public Customer(String filename) throws FileNotFoundException {
        budget = 0.0;
        order = new HashSet<>();
        cart = new ArrayList<>();
        loadCustomer(filename);
    }

    public void loadCustomer(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        budget = input.nextDouble();
        while(input.hasNext()){
            order.add(input.next());
        }
    }

    public HashSet<String> getOrder() {
        return order;
    }

    public Double getBudget() {
        return budget;
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public void pay(Double amt) {
        budget = budget - amt;
    }

    public void putInCart(String item) {
        if(order.contains(item))
            cart.add(item);
    }

    public void updateOrder() {
        for(int i=0; i<cart.size(); i++){
            if(order.contains(cart.get(i))){
                order.remove(cart.get(i));
            }
        
        }
    }
}
