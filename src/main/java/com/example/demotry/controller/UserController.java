package com.example.demotry.controller;

import com.example.demotry.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> users = new ArrayList<>();

    // Constructor to add some initial users for testing
    public UserController(){
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

    // GET all users
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // POST a new user
    @PostMapping("/addUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        // Check if a user with the same EmpId already exists
        if (findUserByEmpId(user.getEmpId()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with EmpId " + user.getEmpId() + " already exists.");
        }

        // Add the new user
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully with EmpId: " + user.getEmpId());
    }

    // PUT update user details
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
        // Find the user by empId using the utility method
        User existingUser = findUserByEmpId(updatedUser.getEmpId());

        if (existingUser == null) {
            // If user is not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with EmpId " + updatedUser.getEmpId() + " not found.");
        }

        // Update the user details
        existingUser.setEmpName(updatedUser.getEmpName());
        existingUser.setEmpAge(updatedUser.getEmpAge());
        existingUser.setEmpContactNumber(updatedUser.getEmpContactNumber());

        // Return the updated user
        return ResponseEntity.status(HttpStatus.OK).body(existingUser);
    }

    // DELETE a user
    @DeleteMapping("/deleteUser/{empId}")
    public ResponseEntity<String> deleteUser(@PathVariable String empId) {
        // Find the user by empId using the utility method
        User userToDelete = findUserByEmpId(empId);

        if (userToDelete == null) {
            // If user is not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with EmpId " + empId + " not found.");
        }

        // Remove the user from the list
        users.remove(userToDelete);
        return ResponseEntity.status(HttpStatus.OK)
                .body("User with EmpId " + empId + " has been deleted.");
    }
}
