package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The bank entity
 */
public class Bank {

    private AccountManager accountManager;
    //private Set<Customer> customers = new HashSet<>();
    private Map<Integer, Customer> customerMap= new HashMap<>();
    private int ID = 0;

    /**
     * Creates a new instance of Bank and initializes it with the given account manager
     *
     * @param accountManager the account manager
     */
    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * Adds a new customer to the bank
     *
     * @param customer the new bank customer
     * @see Customer#setAccountManager(AccountManager)
     */
    public void addCustomer(Customer customer) {
        //customers.add(customer);
        customerMap.put(ID++, customer);
        customer.setAccountManager(accountManager);
    }

    /**
     * Gets the total balance of the bank
     *
     * @return the bank total balance
     */
    public double getBalance() {

        double balance = 0;

        for (int i = 1; i <= ID; i++) {
           balance += customerMap.get(i).getBalance();
        }

        //for (Customer customer : customers) {
        //    balance += customer.getBalance();
        //}

        return balance;
    }

    public int getID() {
        return ID;
    }

    public Customer getCustomer(int ID){
        return customerMap.get(ID);
    }
}
