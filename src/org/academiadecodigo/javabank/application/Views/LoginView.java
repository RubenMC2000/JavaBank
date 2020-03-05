package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Controllers.LoginController;
import org.academiadecodigo.javabank.application.Messages;

public class LoginView extends AbstractView {

    @Override
    public void show() {
        lc.setCurrentCustomerID(scanCustomerId());
    }

    private LoginController lc;

    private int scanCustomerId() {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(lc.getCustomerIDs());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        return p.getUserInput(scanner);
    }


    @Override
    public void setP(Prompt p) {
        super.setP(p);
    }
}
