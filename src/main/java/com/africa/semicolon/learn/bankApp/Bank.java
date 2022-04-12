package com.africa.semicolon.learn.bankApp;

import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName)== null){
            branches.add(new Branch(branchName));
            return true; 
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){return branch.newCustomer(customerName, amount);}
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){return branch.addCustomerTransaction(customerName, amount);}
        return false;
    }

    private Branch findBranch(String branchName){
        for (int i = 0; i < branches.size(); i++) {
           Branch branch = branches.get(i);
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransaction){
        Branch branch = findBranch(branchName);
        if(branch!= null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer "+ branchCustomer.getName() + "("+ (i+1) + ")" );

                if(showTransaction){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();

                    for (int j = 0; j< transactions.size(); j++){
                        System.out.println("("+ (j+1) + ") Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
                else return false;
    }
}
