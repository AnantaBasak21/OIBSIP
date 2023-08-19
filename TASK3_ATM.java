import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;

class BankAccount{
    static void register() {
        Scanner sc= new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Enter you Name: ");
        ATM.name=sc.nextLine();
        System.out.println("Enter your User Name: ");
        String user=sc.nextLine();
        System.out.println("Enter your Password: ");
        String pass=sc.nextLine();
        System.out.println("Enter your Account Number : ");
        ATM.accnumber=sc.nextLine();
        System.out.println("REGISTRATION IS DONE SUCCESSFULLY!! ");
        System.out.println("-----------------------------------");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice == 1) {
                login(user,pass);
                break;
            }
            else{
                if(choice == 2){
                    System.exit(choice);;
                }
                else{
                    System.out.println("Bad value! Enter again!");
                }
            }
        }

    }
    static void display(String name){}
    static void login(String user, String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Enter the amount to be withdrawn : ");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdrawn successfully");
            System.out.println("-------------------------------");
        }
        else{
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("--------------------------------");
        }
        ATM.prompt();
    }
    static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Enter the amount to deposit : ");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("----------------------------------------");
        ATM.prompt();
    }
    static void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the receiving body: ");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiving body");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred : ");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance) {
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("---------------------------------------");
        }
        else{
            System.out.println("Insufficient balance to transfer the cash");
            System.out.println("---------------------------------------");
        }
    }
}
class check{
    static void checkbalance() {
        System.out.println("-------------------------------------------");
        System.out.println("The available balance in the bank account is : ");
        ATM.showbalance();
        System.out.println("----------------------------------------------");
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
        System.out.println("----------------------------");
        System.out.println("Transaction History : ");
        int k=0;
        if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.println(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("------------------------------");
            }
        }
        else{
            System.out.println("Your Account is Empty");
        }
        ATM.prompt();
    }
}

public class ATM{
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<String>();

    static void updatebalance(int dcash) { balance=balance+dcash; }
    static void showbalance() { System.out.println(balance); }
    public static void homepage() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE ATM INTERFACE");
        System.out.println("---------------------------------");
        System.out.println("Select Option : ");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();
        if(choice == 1) {
            BankAccount.register();
        }
        else {
            if(choice == 2){
                System.exit(choice);
            }
            else{
                System.out.println("Select a value only from the given options : ");
                homepage();
            }
        }
    }
    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO THE ATM SYSTEM");
        System.out.println("------------------------");
        System.out.println("Select Option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(choice);
        }
    }
    public static void main(String[] args) {
        homepage();
    }
}
