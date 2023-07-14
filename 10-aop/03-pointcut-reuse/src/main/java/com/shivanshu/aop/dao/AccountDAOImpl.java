package com.shivanshu.aop.dao;

import com.shivanshu.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() +": DOING MY WORK: ADDING MY ACCOUNT");
    }

    @Override
    public void addAccountWithParam(Account account) {
        System.out.println(getClass() +": DOING MY WORK: ADDING MY ACCOUNT WITH PARAM");
    }

    @Override
    public void addAccountTwoParam(Account account, boolean vipPerson) {
        System.out.println(getClass() +": DOING MY WORK: ADDING MY ACCOUNT WITH TWO PARAM");
    }
}
