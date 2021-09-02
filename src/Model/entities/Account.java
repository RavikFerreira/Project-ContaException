package Model.entities;

import Model.Exceptions.*;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit; 

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.setNumber(number);
        this.setHolder(holder);
        this.setBalance(balance);
        this.setWithdrawLimit(withdrawLimit);
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
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
        if(amount > withdrawLimit){
            throw new Exceptions("The amount exceeds withdraw limit");
        }
        else if(balance < amount || balance == 0){
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
}