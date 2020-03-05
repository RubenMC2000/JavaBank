package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.LoginView;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.Set;

public class LoginController extends AbstractController {

    @Override
    public void init() {
        lv.show();
        b.setCurrentCustomerID(currentCustomerID);
        mc.init();
    }
    private LoginView lv;
    private MenuController mc;
    private int currentCustomerID;

    public Set<Integer> getCustomerIDs(){
        return b.getCustomerIds();
    }

    public void setCurrentCustomerID(int currentCustomerID) {
        this.currentCustomerID = currentCustomerID;
    }

    @Override
    public void setB(Bank b) {
        super.setB(b);
    }
}
