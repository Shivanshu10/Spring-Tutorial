package com.shivanshu.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() +": DOING MY WORK: ADDING MY ACCOUNT");
    }

    @Override
    public void addSillyMember() {
        System.out.println(getClass()+": Adding Silly Member");
    }
}
