package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.BalanceView;
import org.academiadecodigo.javabank.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceController extends AbstractController {

    @Override
    public void init() {
        bv.show();
        mc.init();
    }

    private DecimalFormat df = new DecimalFormat("#.##");
    private BalanceView bv;
    private MenuController mc;


    public String getCustomerName(){
       return b.getCustomer(b.getCurrentCustomerID()).getName();
    }

    public double iterateAccounts(){
        double balance = 0;
        Set<Account> accounts = b.getCustomer(b.getCurrentCustomerID()).getAccounts();
        for(Account account : accounts) {
            balance += account.getBalance();
        }
        return balance;
    }

    public DecimalFormat getDf() {
        return df;
    }
}
