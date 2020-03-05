package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.DepositView;

public class DepositController extends AbstractController{

    @Override
    public void init() {
        dv.show();
        mc.init();
    }

    private DepositView dv;
    private MenuController mc;

    

}
