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

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author nathan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Shop foodMart = new Shop("inventory.txt");
        ArrayList<Customer> custs = new ArrayList<>();
        custs.add(new Customer("c1.txt"));
        custs.add(new Customer("c2.txt"));
        custs.add(new Customer("c3.txt"));
        
        for (int i=0; i< custs.size(); i++)
            System.out.println("Customer "+ i + " has $"+custs.get(i).getBudget());
        
        for (Customer c: custs)
            foodMart.fillOrder(c);
        
        for (int i=0; i<custs.size(); i++)
            foodMart.checkout();
        
        for (int i=0; i< custs.size(); i++)
        {
            System.out.print("Customer "+ i + " has $"+custs.get(i).getBudget());
            System.out.println(" remaining and bought " + custs.get(i).getCart());
        }
    }
    
}
