package com.besho.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public Boolean addSillyMember() {
        System.out.println(getClass() + ": Doing My DB Work : Adding A Memebership account ");
        return true;
    }
}
