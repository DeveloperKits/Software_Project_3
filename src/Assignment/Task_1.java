/**
 * Assume a system and design the assumed system using java OOP.
 */

package Assignment;

import java.util.Scanner;

class Customer {
    public String name, number, email;
    public int which_kind_profit, Amount;

    public Customer(){}

    public Customer(String name, String number, String email, int which_kind_profit, int Amount) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.which_kind_profit = which_kind_profit;
        this.Amount = Amount;
    }

    void display() {
        System.out.println("\n------------------------------------- Result -------------------------------------" +
                "\nName : " + name + "\n" + "Email : " + email + "\n" + "Number : " + number + "\nThe amount of money you deposit: " + Amount);
    }
}

// abstraction
abstract class Profit{
    abstract void profit(int amount, float profit_range);
}

// Inheritance
class Bank{
    float getRateOfInterest(){return 0;}
}
class SBI extends Bank{
    float getRateOfInterest(){return 11.4f;}  // Multilevel Inheritance
}
class AXIS extends Bank{
    float getRateOfInterest(){return 13.7f;}  // Multilevel Inheritance
}

public class Task_1 extends Profit{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name, number, email;
        int which_kind_profit, Amount;
        float sbi, axis;

        Bank bank; // object
        Profit profit = new Task_1(); // create for abstraction class object

        bank = new SBI(); //upcasting || Runtime Polymorphism
        System.out.println("SBI Rate of Interest within 1000 TK : " + bank.getRateOfInterest());
        sbi = bank.getRateOfInterest();

        bank = new AXIS(); //upcasting || Runtime Polymorphism
        System.out.println("AXIS Rate of Interest within 1000 TK : " + bank.getRateOfInterest());
        axis = bank.getRateOfInterest();

        // Take Input
        System.out.print("\nEnter Your Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Your Email: ");
        email = scanner.nextLine();
        System.out.print("Enter Your Number: ");
        number = scanner.nextLine();
        System.out.print("The amount of money deposited: ");
        Amount = scanner.nextInt();
        System.out.print("What kind of Interest you want. If it's SBI then enter 1 otherwise enter 0: ");
        which_kind_profit = scanner.nextInt();

        Customer customer = new Customer(name, number, email, which_kind_profit, Amount);
        customer.display();

        if (which_kind_profit == 1){
            profit.profit(Amount, sbi); // call abstract method
        }else if (which_kind_profit == 0){
            profit.profit(Amount, axis); // call abstract method
        }else {
            System.out.println("You enter wrong profit type.");
        }
    }


    @Override
    void profit(int amount, float profit_range) {
        float result = amount+((amount/1000)*profit_range);
        System.out.println("Total Profit : " + result + " TK");
    }
}
