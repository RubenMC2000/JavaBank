package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.Views.View;
import org.academiadecodigo.javabank.domain.Bank;

public interface Controller {

    void init();
    void setBank(Bank b);
}
