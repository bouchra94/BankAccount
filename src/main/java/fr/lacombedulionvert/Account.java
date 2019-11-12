package fr.lacombedulionvert;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t | AMOUNT \t | BALANCE";

    private int balance;
    private String statement;

    public Account() {
        balance = 0;
        statement = STATEMENT_HEADER;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        statement += "\n2019/11/12 \t | 500 \t | 500";
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String printStatement() {
        return statement;
    }
}
