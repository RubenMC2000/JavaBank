package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Controllers.MenuController;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;

public class MenuView implements View {

    MenuController mc;
    Prompt p;
    int userInput;

    @Override
    public void show() {
        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setMessage(Messages.ERROR_INVALID_OPTION);
        mainMenu.setError(Messages.MENU_WELCOME);
        userInput = p.getUserInput(mainMenu);
    }

    public void setMc(MenuController mc) {
        this.mc = mc;
    }

    public void setP(Prompt p) {
        this.p = p;
    }

    public int getUserInput() {
        return userInput;
    }
}
