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
public class OutOfStockException extends RuntimeException{
    public OutOfStockException(){
        super();
    }
    public OutOfStockException(String mesg){
        super (mesg);
    }
}
