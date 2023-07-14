package com.shivanshu.aop.dao;

import com.shivanshu.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Trip Wire");
        }

        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platnium");
        Account temp3 = new Account("Luca", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }
}
