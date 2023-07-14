package com.shivanshu.aop.dao;

import com.shivanshu.aop.Account;

public interface AccountDAO {
    void addAccount();
    void addAccountWithParam(Account account);

    void addAccountTwoParam(Account account, boolean vipPerson);

    String getName();

    String getServiceCode();

    void setName(String name);

    void setServiceCode(String serviceCode);
}
