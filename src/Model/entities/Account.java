package Model.entities;

import Model.Exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Account implements Comparable<Account>{

    private Integer number;

    private String profession;
    private Double balance;
    private List<Account> list = new ArrayList<>();

    public Account(){}
    public Account(Integer number, String profession, Double balance) {
        this.number = number;
        this.profession = profession;
        this.balance = balance;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public void deposit(Double amount){
        balance += amount;
    }
    public void withdraw(Double amount) throws Exceptions{
        if(balance < amount || balance == 0){
            throw new Exceptions("Not enough balance");
        }
        else{
            balance -= amount;
        }
    }
    @Override
    public String toString() {
        return "New balance: " 
        + String.format("%.2f", getBalance());
    }
    public List<Account> getList() {
        return list;
    }
    public static Boolean hasNumber(List<Account> list, int number){
        Account acc = list.stream().filter(x -> x.getNumber() == number).findFirst().orElse(null);
        return acc != null;
    }

    @Override
    public int compareTo(Account o) {
        return number.compareTo(o.getNumber());
    }
}