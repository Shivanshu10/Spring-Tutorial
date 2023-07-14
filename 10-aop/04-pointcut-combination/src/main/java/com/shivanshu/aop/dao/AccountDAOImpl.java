package com.shivanshu.aop.dao;

import com.shivanshu.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

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

    public String getName() {
        System.out.println("Method called: getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("Method called: setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Method called: getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Method called: setServiceCode");
        this.serviceCode = serviceCode;
    }
}
