package org.example;

import java.util.Comparator;

public class Client implements Comparable<Client> {
    public int id;

    public String name;
    public String surname;
    public int balance;
    public int spending;

    public Client(int id, String name, String surname, int balance, int spending) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.spending = spending;
    }

    @Override
    public String toString() {
        return String.format("ID: %s , name: %s , surname: %s , balance: %d , spending: %d", this.id, this.name,
                this.surname, this.balance, this.spending);
    }

    @Override
    public int compareTo(Client cl) {
        return (this.id - cl.id);
    }

    public int getSpending() {
        return spending;
    }

    public static Comparator<Client> SpendingComparator = new Comparator<Client>() {

        @Override
        public int compare(Client cl1, Client cl2) {
            return Integer.compare(cl1.spending, cl2.spending);
        }
    };

}
