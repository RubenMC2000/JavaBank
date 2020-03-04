import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
//import org.academiadecodigo.javabank.MenuPrompt.*;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args){
        App promptView = new App();
    }

    /*
    Properties
     */
    private Prompt prompt = new Prompt(System.in, System.out);
    private Map<Integer, Customer> map = new HashMap<>();
    //private Map<Integer, Menu> commands = new HashMap<>();
    private Bank bank = new Bank(new AccountManager());
    private Customer customer1 = new Customer();
    private Customer customer2 = new Customer();
    private Customer customer3 = new Customer();

    /*
    Constructor
     */
    public App(){
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
    }

    public int askID(){
        StringInputScanner question = new StringInputScanner();
        question.setMessage("Customer ID: ");
        int IDasked = Integer.parseInt(prompt.getUserInput(question));
        if(IDasked <= 0){
            System.out.println("Customer ID can't be negative or equal to zero");
            askID();
        }else if(IDasked > bank.getID()){
            System.out.println("This Customer ID doesn't exist");
            askID();
        }
        return IDasked;
    }

    /*public void addCommands(){
        commands.put(1, new CreateAccount());
        commands.put(2, new ViewAccounts());
        commands.put(3, new Deposit());
        commands.put(4, new Withdraw());
        commands.put(5, new Balance());
        commands.put(6, new Quit());
    }*/

    public void bankMenu(){
        int ID = askID();
        String[] options = {"Create account", "View accounts", "Deposit", "Withdraw", "Get balance", "Quit"};
        while(true){
            MenuInputScanner menu = new MenuInputScanner(options);
            menu.setMessage("Welcome to JavaBank");
            int answer = prompt.getUserInput(menu);

            switch (answer){
                //ADD ACCOUNT
                case 1:

                  bank.getCustomer(ID).openAccount(AccountType.CHECKING);
                    break;
                //VIEW ACCOUNTS
                case 2:
                    System.out.println(bank.getCustomer(ID).getAccounts());
                    break;
                //DEPOSIT
                case 3:
                    IntegerInputScanner question1 = new IntegerInputScanner();
                    DoubleInputScanner question2 = new DoubleInputScanner();
                    question1.setMessage("In which account do you want to deposit? ");
                    question2.setMessage("How much money to deposit? ");
                    bank.getCustomer(ID).getAccountManager().withdraw(prompt.getUserInput(question1), prompt.getUserInput(question2));
                    break;
                //WITHDRAW
                case 4:
                    IntegerInputScanner question3 = new IntegerInputScanner();
                    DoubleInputScanner question4 = new DoubleInputScanner();
                    question3.setMessage("In which account do you want to withdraw? ");
                    question4.setMessage("How much money to withdraw? ");
                    bank.getCustomer(ID).getAccountManager().withdraw(prompt.getUserInput(question3), prompt.getUserInput(question4));
                    break;
                //BALANCE
                case 5:
                    bank.getCustomer(ID).getBalance();
                    break;
                //QUIT
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }


}
