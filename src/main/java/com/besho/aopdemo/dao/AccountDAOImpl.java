package com.besho.aopdemo.dao;

import com.besho.aopdemo.Account;
import org.springframework.stereotype.Repository;

// Repository annotation make this class available for component scanning
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account,boolean isAdmin) {

        System.out.println(getClass() + ": Doing My DB work: Adding An Account");

    }
}
