import java.util.*;

class CallOprations {
    Scanner value1 = new Scanner(System.in);
    // pinNum => Pin NUmber, balance => total account balance and serviceNum =>
    // Switch Value To call functions
    double balance = 0;
    int pinNum, serviceNum;

    // This function is for Withdraw
    void withdraw() {
        System.out.print("Enter Money To Withdraw: ");
        int withdrawAmount = value1.nextInt();
        System.out.print("Are You Sure(Yes/No): ");
        String confirm = value1.next();
        if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
            if (balance < withdrawAmount) {
                System.out.println("Insufficient Balance");
                System.out.println("Balance: " + balance);
                service();
            } else {
                balance = balance - withdrawAmount;
                System.out.println("Balance: " + balance);
                service();
            }
        } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
            System.out.println("Exit");
            service();
        } else {
            System.out.println("Try Again");
            withdraw();
        }
    }

    // This function is for Deposite
    void deposite() {
        System.out.print("Enter Money To Deposite: ");
        int depositeAmount = value1.nextInt();
        System.out.print("Are You Sure(Yes/No): ");
        String confirm = value1.next();
        if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
            balance = balance + depositeAmount;
            System.out.println("Balance: " + balance);
            service();
        } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
            System.out.println("Exit");
        } else {
            System.out.println("Try Again");
            deposite();
        }
    }

    // This function is for Balance
    void balance() {
        System.out.println("Balance: " + balance);
        service();
    }

    // This functipn is for exit
    void exit() {
        System.out.println("Thank You Madam/Sir");
    }

    // First we need to confirm user pin number
    void checkPin() {
        while (true) {
            System.out.print("Please Enter Your Four Digit Pin Number: ");
            pinNum = value1.nextInt();
            if (pinNum > 999 && pinNum < 10000) {
                System.out.println("Welcome Madam/Sir");
                service();
                break; // Exit the loop on successful PIN entry
            } else {
                System.out.println("Please Enter Correct Pin Number");
            }
        }
    }

    // if pin number is correct than we will provide services
    void service() {
        System.out.println("-----------------------------------------------");
        System.out.println("For Withdraw Enter 1");
        System.out.println("For Deposite Enter 2");
        System.out.println("For Check Balance Enter 3");
        System.out.println("For Exit Enter 4");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter Number: ");
        serviceNum = value1.nextInt();
        switch (serviceNum) {
            case 1:
                withdraw();
                break;
            case 2:
                deposite();
                break;
            case 3:
                balance();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Please Enter Correct Number");
                break;
        }
    }
}

public class Atm {
    public static void main(String[] args) {
        CallOprations co = new CallOprations();
        co.checkPin();
    }
}