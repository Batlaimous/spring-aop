package com.besho.aopdemo.dao;

import org.springframework.stereotype.Repository;

// Repository annotation make this class available for component scanning
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Doing My DB work: Adding An Account");


    }
}