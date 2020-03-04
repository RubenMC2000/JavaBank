import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class PromptView {

    public static void main(String[] args){
        PromptView promptView = new PromptView();
    }

    /*
    Properties
     */
    private Prompt prompt = new Prompt(System.in, System.out);
    private boolean quit = false;
    private Map<Integer, Customer> map = new HashMap<>();
    private int ID = 0;
    private AccountManager manager = new AccountManager();
    private Bank bank = new Bank(manager);
    private Customer customer1 = new Customer();
    private Customer customer2 = new Customer();
    private Customer customer3 = new Customer();

    /*
    Constructor
     */
    public PromptView(){
        addCustomer();
        bankMenu();
    }


    /*
    Methods
     */
    public void addCustomer(){
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);
        map.put(ID++, customer1);
        map.put(ID++, customer2);
        map.put(ID++, customer3);
    }

    public int askID(){
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Customer ID: ");
        int IDasked = Integer.parseInt(prompt.getUserInput(question));
        if(IDasked <= 0){
            System.out.println("Customer ID can't be negative or equal to zero");
            askID();
        }else if(IDasked > ID){
            System.out.println("This Customer ID doesn't exist");
            askID();
        }
        return ID;
    }

    public void bankMenu(){
        int ID = askID();
        String[] options = {"Add new account", "View accounts", "Deposit money on account", "Withdraw money on account", "Get balance", "Quit"};
        while(!quit){
            MenuInputScanner menu = new MenuInputScanner(options);
            menu.setMessage("Welcome to JavaBank Blyat");
            int answer = prompt.getUserInput(menu);

            switch (answer){
                //ADD ACCOUNT
                case 1:
                    customer1.openAccount(AccountType.CHECKING);
                    break;
                //VIEW ACCOUNTS
                case 2:
                    System.out.println(customer1.getAccounts());
                    break;
                //DEPOSIT
                case 3:
                    IntegerInputScanner question1 = new IntegerInputScanner();
                    DoubleInputScanner question2 = new DoubleInputScanner();
                    question1.setMessage("In which account do you want to deposit? ");
                    question2.setMessage("How much money to deposit? ");
                    manager.withdraw(prompt.getUserInput(question1), prompt.getUserInput(question2));
                    break;
                //WITHDRAW
                case 4:
                    IntegerInputScanner question3 = new IntegerInputScanner();
                    DoubleInputScanner question4 = new DoubleInputScanner();
                    question3.setMessage("In which account do you want to withdraw? ");
                    question4.setMessage("How much money to withdraw? ");
                    manager.withdraw(prompt.getUserInput(question3), prompt.getUserInput(question4));
                    break;
                //BALANCE
                case 5:
                    customer1.getBalance();
                    break;
                //QUIT
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }


}
