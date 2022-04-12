package com.africa.semicolon.learn.bankApp;

import java.util.ArrayList;

public class Branch {
    private String name;
  private ArrayList <Customer> customers = new ArrayList<Customer>();

  public Branch(String name){
      this.name = name;
  }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
      if(findCustomer(customerName)== null){
          this.customers.add(new Customer(customerName,initialAmount) );
          return true;
      }
      return false;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomerTransaction(String customerName, double initialAmount){
      Customer existingCustomer = findCustomer(customerName);

      if (existingCustomer != null){
          existingCustomer.addTransaction(initialAmount);
          return true;
      }
      return false;
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i < customers.size(); i++) {
           Customer customer = customers.get(i);
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }
}
