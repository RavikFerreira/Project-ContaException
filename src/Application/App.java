package Application;

import java.util.Locale;
import java.util.Scanner;

import Model.Exceptions.Exceptions;
import Model.entities.Account;

public class App {
    public static void main(String[] args) throws Exceptions {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try{
            System.out.println("Enter acount data:");
            System.out.print("Number: "); 
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.println(account);
        }
        catch(Exceptions e){
            System.out.println("Withdraw Error: " + e.getMessage());

        }

        sc.close();
    }
}