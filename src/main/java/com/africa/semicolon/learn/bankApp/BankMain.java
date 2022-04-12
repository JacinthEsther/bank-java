package com.africa.semicolon.learn.bankApp;

import com.africa.semicolon.learn.bankApp.Bank;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank("FCMB");
        bank.addBranch("Chemist");
        bank.addCustomer("Chemist","Esther", 32889999.00);
        bank.addCustomer("Chemist","Jacinth", 39999.00);
        bank.addCustomer("Chemist","Joy", 3288.00);


        bank.addBranch("Sabo");
        bank.addCustomer("Sabo","Pat",459000000.00);

        bank.addCustomerTransaction("Chemist","Esther",4555555.00);
        bank.addCustomerTransaction("Chemist","Jacinth", 39999.00);
        bank.addCustomerTransaction("Chemist","Joy", 3288.00);


        bank.listCustomer("Chemist",true);
        bank.listCustomer("Sabo", true);

        if(! bank.addCustomer("Lekki","Pat", 5.34)){
            System.out.println("Lekki does not exist");

        }
        if(! bank.addBranch("Sabo")){
            System.out.println("Sabo branch already exist");
        }
        if(! bank. addCustomerTransaction("Sabo","e", 56.9999)){
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addCustomer("Sabo","Pat",78000.00)){
            System.out.println("Customer Pat already exists");
        }
    }
}
