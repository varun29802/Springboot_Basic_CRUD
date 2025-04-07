package com.example.demotry.serviceImplementation;

import com.example.demotry.dto.User;
import com.example.demotry.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService {

    private List<User> users = new ArrayList<>();

    // Constructor to add some initial users for testing
    public UserServiceImplementation(){
        System.out.println("List is initialize");
        users.add(new User("2718139", "varun", 12345, 12));
        users.add(new User("2718081", "sambhav", 54321, 22));
    }

    // Utility method to search for a user by empId
    private User findUserByEmpId(String empId) {
        for (User user : users) {
            if (Objects.equals(user.getEmpId(), empId)) {
                return user; // Return the found user
            }
        }
        return null; // Return null if no user is found
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public User updateUser(User updateUser) {

        // Find the user by empId using the utility method
        User existingUser = findUserByEmpId(updateUser.getEmpId());

        if (existingUser == null) {
            // If user is not found
            return null;
        }

        // Update the user details
        existingUser.setEmpName(updateUser.getEmpName());
        existingUser.setEmpAge(updateUser.getEmpAge());
        existingUser.setEmpContactNumber(updateUser.getEmpContactNumber());

        // Return the updated user
        return existingUser;
    }

    @Override
    public String deleteUser(String empId) {
        // Find the user by empId using the utility method
        User userToDelete = findUserByEmpId(empId);

        if (userToDelete == null) {
            // If user is not found
            return null;
        }

        // Remove the user from the list
        users.remove(userToDelete);
        return "user removed";
    }

    @Override
    public User saveUser(User user) {
        // Check if a user with the same EmpId already exists
        if (findUserByEmpId(user.getEmpId()) != null) {
            return null;
        }
        // Add the new user
        users.add(user);
        return user;

    }

}
