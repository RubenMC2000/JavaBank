package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View{

    protected Prompt p;

    public void setP(Prompt p) {
        this.p = p;
    }
}
