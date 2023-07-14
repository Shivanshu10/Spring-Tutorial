package com.shivanshu.user.controller;

import com.shivanshu.user.entity.Contact;
import com.shivanshu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shivanshu.user.entity.User;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = this.userService.getUser(userId);

        // desearile rest data to list obj
        List<Contact> contacts = this.restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);

        user.setContacts(contacts);
        return user;
    }
}
