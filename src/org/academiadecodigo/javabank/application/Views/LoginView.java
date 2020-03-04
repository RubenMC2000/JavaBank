package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Controllers.LoginController;
import org.academiadecodigo.javabank.application.Messages;

public class LoginView implements View{

    LoginController lc;
    Prompt p;

    @Override
    public void show() {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(lc.getCustomerIDs());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        p.getUserInput(scanner);

    }

    public void setLc(LoginController lc) {
        this.lc = lc;
    }

    public void setP(Prompt p) {
        this.p = p;
    }
}
