package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.LoginView;
import org.academiadecodigo.javabank.application.Views.View;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.Set;

public class LoginController implements Controller{

    LoginView lv;
    MenuController mc = new MenuController();
    Bank b;

    @Override
    public void init() {
        lv.show();
        mc.init();
    }

    @Override
    public void setBank(Bank b) {
        this.b = b;
    }

    public void setLv(LoginView lv) {
        this.lv = lv;
    }

    public Set<Integer> getCustomerIDs(){
        return b.getCustomerIds();
    }

    public void setMc(MenuController mc) {
        this.mc = mc;
    }
}
