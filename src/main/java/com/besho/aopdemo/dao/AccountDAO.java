package com.besho.aopdemo.dao;

import com.besho.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account,boolean isAdmin);
    public String getName() ;
    public void setName(String name);
    public String getEmail() ;
    public void setEmail(String email) ;
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
