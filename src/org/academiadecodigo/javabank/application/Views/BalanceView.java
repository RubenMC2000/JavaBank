package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.javabank.application.Controllers.BalanceController;
import org.academiadecodigo.javabank.application.Messages;

public class BalanceView extends AbstractView {

    @Override
    public void show() {
        System.out.println("\n" + bc.getCustomerName() + Messages.BALANCE_MESSAGE + "\n");
        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + bc.getDf().format(bc.iterateAccounts()));
    }

    private BalanceController bc;

}
