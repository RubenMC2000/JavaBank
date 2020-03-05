package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.View;
import org.academiadecodigo.javabank.domain.Bank;

public abstract class AbstractController implements Controller {

    protected Bank b;
    protected Controller c;
    protected View v;

    public void setB(Bank b) {
        this.b = b;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void setV(View v) {
        this.v = v;
    }
}
