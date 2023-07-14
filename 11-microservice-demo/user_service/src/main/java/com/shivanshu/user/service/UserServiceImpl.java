package com.shivanshu.user.service;

import com.shivanshu.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users = List.of(
            new User(1311L, "Shivanshu Mishra", "838383"),
            new User(1312L, "Ankit Tiwari", "98399378"),
            new User(1313L, "Ravi Tiwari", "98383378")
    );
    @Override
    public User getUser(Long id) {
        return this.users.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
