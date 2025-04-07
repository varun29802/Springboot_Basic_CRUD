package com.example.demotry.service;

import com.example.demotry.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUser();

    public User updateUser(User updateUser);

    public String deleteUser(String empId);

    public User saveUser(User user);
}
