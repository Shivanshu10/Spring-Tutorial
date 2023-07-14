package com.shivanshu.contact.service;

import com.shivanshu.contact.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactsOfUser(Long userId);
}
