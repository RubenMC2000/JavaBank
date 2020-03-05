package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.Views.MenuView;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;

import java.util.HashMap;
import java.util.Map;

public class MenuController extends AbstractController {

    @Override
    public void init() {
        buildControllerMap();
        mv.show();
        getNext();
        next.init();
    }

    private MenuView mv;
    private Controller next;
    private Map<Integer, Controller> controllerMap;
    private int userChoice;

    private void buildControllerMap() {

        controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), new BalanceController());
        controllerMap.put(UserOptions.DEPOSIT.getOption(), new DepositController());
        controllerMap.put(UserOptions.WITHDRAW.getOption(), new WithdrawController());
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountController());
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public void getNext(){
        next = controllerMap.get(userChoice);
    }
}
