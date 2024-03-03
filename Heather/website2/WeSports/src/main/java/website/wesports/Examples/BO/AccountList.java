package website.wesports.Examples.BO;

/*
 * Class: CIST2373 Java Programming 3
 * Term: Spring 2024
 * Instructor: Chris Bishop
 * Description: Solution to Lab #5
 * Author: Heather Papp
 * I wrote this code myself...
 */

import website.wesports.Examples.BO.Account;

public class AccountList {
    /************* Properties *************/
    public int count = 0;
    public Account accountArray[] = new Account[10];

    /************* Constructors *************/
    public AccountList() { }
    /************* Methods *************/
    public void addAccount(Account a1) {
        accountArray[count] = a1;
        count++;
    } // END addAccount()
    public void displayList() {
        System.out.println("Account List Display");
        for (int i = 0; i < count; i++) {
            accountArray[i].displayADB();
        }
    } // END displayList()
    public static void main(String[] args) {
        AccountList accountList = new AccountList();

        Account a = new Account("98888", "3001", "SAV", 500.00);
        Account b = new Account("97777", "3002", "CHK", 700.00);
        accountList.addAccount(a);
        accountList.addAccount(b);
        accountList.displayList();

    } // END main
} // END class
