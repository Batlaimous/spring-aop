package com.besho.aopdemo.dao;

import com.besho.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Repository annotation make this class available for component scanning
@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String email;

    @Override
    public void addAccount(Account account,boolean isAdmin) {

        System.out.println(getClass() + ": Doing My DB work: Adding An Account");

    }

    public String getName() {
        System.out.println(getClass() + ": Inside get name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": Inside set name");
        this.name = name;
    }

    public String getEmail() {
        System.out.println(getClass() + ": Inside get email");
        return email;
    }

    public void setEmail(String email) {
        System.out.println(getClass() + ": Inside set email");
        this.email = email;
    }

    @Override
    public List<Account> findAccounts() {


        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("ERORR ERORR ERORR No Accounts here for you!!!! Go Out ERORR ERORR ERORR");
        }
        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account myAccount1 = new Account("Batlaimous","Selver");
        Account myAccount2 = new Account("Luca","Gold");
        Account myAccount3 = new Account("Mike","Platinum");

        // add them to myAccounts list
        myAccounts.add(myAccount1);
        myAccounts.add(myAccount2);
        myAccounts.add(myAccount3);

        return myAccounts;
    }
}
