package org.academiadecodigo.javabank.application.Views;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Controllers.MenuController;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;

public class MenuView extends AbstractView {

    @Override
    public void show() {
        menu();
    }

    private MenuController mc;

    private MenuInputScanner buildMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    private void menu() {

        int userChoice = p.getUserInput(buildMainMenu());

        if (userChoice == UserOptions.QUIT.getOption()) {
            System.exit(0);
        }
        mc.setUserChoice(userChoice);
    }
}
