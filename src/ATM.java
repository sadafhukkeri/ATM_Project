/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Dell
 */
import java.text.*;
import java.util.*;


class Account {

    Scanner sc = new Scanner(System.in);
    DecimalFormat df1 = new DecimalFormat("##,###0.00' Rupee'"); //format like 2000.00 Rupee 
    DecimalFormat df2 = new DecimalFormat("##,###0.00' Dollar'");

    int CN;
    int pn;
    double CB = 2000;
    double SB = 1000;

    void setCustomerNumber(int cn){ //setters
        CN =cn;
        
    }
    void setPINNumber(int pn) { //setters
        this.pn = pn;
    }
    int getCustomerNumber() {//getters
        return CN;
    }
    int getPINNumber() {//getters
        return pn;
    }
    void getCurrentBalance() {
        System.out.println("\nCurrent account balance is "+df1.format(CB));
    }
    void getSavingBalance() {
        System.out.println("\nSaving account balance is "+df2.format(SB));
    }
    void getCurrentWithdrawInput() {
        System.out.println("\nCurrent account balance is "+df1.format(CB));
        System.out.println("\nEnter the Amount you want to withdraw");
        double amount = sc.nextDouble();

        if((CB-amount)>=0) {
            calcCurrentWithdraw(amount);
            System.out.println("Transaction Successful");
            System.out.println("\nCurrent account balance is "+df1.format(CB));
        }else {
            System.out.println("Insufficient Balance");
        }
    }
    double calcCurrentWithdraw(double amount) {
        CB = CB - amount;
        return CB;
    }
    void getSavingWithdrawInput() {
        System.out.println("\nSaving account balance is "+df2.format(SB));
        System.out.println("\nEnter the Amount you want to withdraw");
        double amount = sc.nextDouble();

        if((CB-amount)>=0) {
            calcSavingWithdraw(amount);
            System.out.println("Transaction Successful");
            System.out.println("\nSaving account balance is "+df2.format(SB));
        }else {
            System.out.println("Insufficient Balance");
        }
    }
    double calcSavingWithdraw(double amount) {
        SB = SB - amount;
        return SB;
    }

    //deposit
    void getCurrentDepositInput() {
        System.out.println("\nCurrent account balance is "+df1.format(CB));
        System.out.println("\nEnter the Amount you want to Deposit : ");
        double amount = sc.nextDouble();

        if((CB+amount)>=0) {
            calcCurrentDeposit(amount);
            System.out.println("Transaction Successful");
            System.out.println("\nCurrent account balance is "+df1.format(CB));
        }else {
            System.out.println("Insufficient Balance");
        }
    }
    double calcCurrentDeposit(double amount) {
        CB = CB + amount;
        return CB;
    }
    void getSavingDepositInput() {
        System.out.println("\nSaving account balance is "+df2.format(SB));
        System.out.println("\nEnter the Amount you want to Deposit : ");
        double amount = sc.nextDouble();

        if((SB + amount)>=0) {
            calcSavingDeposit(amount);
            System.out.println("Transaction Successful");
            System.out.println("\nSaving account balance is "+df2.format(SB));
        }else {
            System.out.println("Insufficient Balance");
        }
    }
    double calcSavingDeposit(double amount) {
        SB = SB + amount;
        return SB;
    }
}
class OptionMenu extends Account {
    Scanner sc =  new Scanner(System.in);
    HashMap <Integer, Integer> map = new HashMap<>();
    void getLogin() {
        int i = 10;
        do{
        try {
        map.put(12345,1111);
        map.put(12346,2222);
        map.put(12347,3333);
        map.put(12348,1111);
        
        System.out.println("Welcome to the ATM");
        System.out.println("\nEnter Customer Number :");
        
        setCustomerNumber(sc.nextInt());
        System.out.print("\nEnter PIN Number   : ");
        
        setPINNumber(sc.nextInt());
        
        int P = getCustomerNumber();
        int Q = getPINNumber();
        
        if(map.containsKey(P) && map.get(P)==Q) {
            getAccountType();
        }else {
            System.out.println("Wrong PIN or CN");
        }
    } catch (InputMismatchException e) {
        System.out.print("\n Enter only Numbers");
            System.out.println("\nCharacters and symbols not allowed");
            sc.next();
            getLogin();
    }
    } while(i==10);
        } 
    void getAccountType() {
        System.out.println("\n Select the account type : ");
        System.out.println("Type 1 : Current Account");
        System.out.println("Type 2 : Saving Account");
        System.out.println("Type 3 : Exit");
        System.out.println("\nChoice : ");
        int ch = sc.nextInt();
        
        switch(ch){
                case 1:getCurrent();
                    break;
                case 2:getSaving();
                    break;
                case 3:System.out.println("\n Thank you for visiting");
                    System.out.println("VISIT AGAIN");
                    break;
                default: System.out.println("\nInvalid Choice");
                    System.out.println("Enter the valid choice");
                    getAccountType();
                    break;
        }
    }
    void getCurrent() {
        System.out.println("\nCurrent Account");
        System.out.println("\nType 1 : Balance Enquiry");
        System.out.println("\nType 2 : Withdraw Money");
        System.out.println("\nType 3 : Deposit Money");
        System.out.println("\nType 4 : Exit");
        System.out.println("\nChoice : ");
        
        int ch = sc.nextInt();
        switch(ch) {
            case 1:getCurrentBalance();
            getAccountType();
                break;
            case 2:getCurrentWithdrawInput();
            getAccountType();
                break;
            case 3:getCurrentDepositInput();
            getAccountType();
                break;
            case 4:System.out.println("\n Thank you for visiting");
                    System.out.println("VISIT AGAIN");
                    break;
            default: System.out.println("\nInvalid Choice");
                    System.out.println("Enter the valid choice");
                    getAccountType();
                    break;
        }
    }

    void getSaving() {
        System.out.println("\nSaving Account");
        System.out.println("\nType 1 : Balance Enquiry");
        System.out.println("\nType 2 : Withdraw Money");
        System.out.println("\nType 3 : Deposit Money");
        System.out.println("\nType 4 : Exit");
        System.out.println("\nChoice : ");
        
        int ch = sc.nextInt();
        switch(ch) {
            case 1:getSavingBalance();
            getAccountType();
                break;
            case 2:getSavingWithdrawInput();
            getAccountType();
                break;
            case 3:getSavingDepositInput();
            getAccountType();
                break;
            case 4:System.out.println("\n Thank you for visiting");
                    System.out.println("VISIT AGAIN");
                    break;
            default: System.out.println("\nInvalid Choice");
                    System.out.println("Enter the valid choice");
                    getAccountType();
                    break;
        }        
    }
}
public class ATM extends OptionMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OptionMenu menu = new OptionMenu();
        menu.getLogin();
    }
    
}
