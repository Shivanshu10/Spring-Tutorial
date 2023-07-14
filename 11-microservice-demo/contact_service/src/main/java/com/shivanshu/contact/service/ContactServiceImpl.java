package com.shivanshu.contact.service;

import com.shivanshu.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{
    List<Contact> contacts = List.of(
            new Contact(1L, "amit@gmail.com", "Amit", 1311L),
            new Contact(2L, "anil@gmail.com", "Anil", 1312L),
            new Contact(3L, "rohan@gmail.com", "Rohan", 1313L),
            new Contact(4L, "sameer@gmail.com", "Sameer", 1314L)
    );

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return contacts.stream().filter(contact -> contact.getUser_id().equals(userId)).collect(Collectors.toList());
    }
}
