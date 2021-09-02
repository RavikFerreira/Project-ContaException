package Application;

import java.io.*;
import java.util.*;

import Model.Exceptions.Exceptions;
import Model.entities.Account;

import static Model.entities.Account.hasNumber;

public class App {
    public static void main(String[] args) throws Exceptions {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String path = "/home/jose.moraes/Documentos/in.txt";

        List<Account> list = new ArrayList<>();

        System.out.println("Which option do you want? 1- Register user\n2- withdraw\n");
        int x = sc.nextInt();
        switch (x) {
            case 1:
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

                    for (int i = 1; i == 1; i++) {
                        System.out.println("Enter account data:");
                        System.out.print("Number: ");
                        int number = sc.nextInt();
                        while (hasNumber(list, number)) {
                            System.out.println("Number already taken. Try again: ");
                            number = sc.nextInt();
                        }
                        System.out.print("Holder: ");
                        sc.nextLine();
                        String holder = sc.nextLine();
                        System.out.print("Initial balance: ");
                        double balance = sc.nextDouble();
                        System.out.print("Withdraw limit: ");
                        double withdrawLimit = sc.nextDouble();

                        list.add(new Account(number, holder, balance, withdrawLimit));

                        BufferedReader br = new BufferedReader(new FileReader(path));

                        String accountCsv = br.readLine();
                        while (accountCsv != null) {
                            String[] fields = accountCsv.split(",");
                            list.add(new Account(Integer.parseInt(fields[0], fields[1], Double.parseDouble(fields[2]), Double.parseDouble(fields[3]))));
                            accountCsv = br.readLine();
                        }
                        Collections.sort(list);
                        for (Account acc : list) {
                            System.out.println(acc.getNumber() + ", " + acc.getHolder() + ", " + String.format("%.2f", acc.getBalance() + ", " + String.format("%.2f", acc.getWithdrawLimit())));
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 2:
                try {
                    Account account = new Account();
                    System.out.println("Make a withdrawal? s/n");
                    char ch = sc.next().charAt(0);
                    if (ch == 's') {
                        System.out.print("Enter amount for withdraw: ");
                        double amount = sc.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println(account);
                    }
                    break;

                }catch (Exceptions e){
                    System.out.println("Withdraw error: " + e.getMessage());
                }
            }

    }
}