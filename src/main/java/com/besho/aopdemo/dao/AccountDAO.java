package com.besho.aopdemo.dao;

import com.besho.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account,boolean isAdmin);

}
