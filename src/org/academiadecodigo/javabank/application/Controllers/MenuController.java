package org.academiadecodigo.javabank.application.Controllers;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.Views.MenuView;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class MenuController implements Controller {

    MenuView mv;
    Controller next;
    Map<Integer, Controller> map = new HashMap<>();

    @Override
    public void init() {
        mv.show();
        next.init();
    }

    @Override
    public void setBank(Bank b) {}

    private void nextOperation(){
        map.get(mv.getUserInput());
    }

    private void buildMap(){
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceController());
        map.put(UserOptions.DEPOSIT.getOption(), new DepositController());
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawController());
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountController());
    }


}
