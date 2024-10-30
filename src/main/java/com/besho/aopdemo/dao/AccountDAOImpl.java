package com.besho.aopdemo.dao;

import com.besho.aopdemo.Account;
import org.springframework.stereotype.Repository;

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
}
