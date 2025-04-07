package com.example.demotry.controller;

import com.example.demotry.dto.User;
import com.example.demotry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


//  GET all users
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {
        if(!userService.getAllUser().isEmpty()){
            return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Users Available", HttpStatus.BAD_REQUEST);
        }
    }

//  POST a new user
    @PostMapping("/addUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        if(userService.saveUser(user)!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Already Exists");
        }
    }

//   PUT update user details
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
        if(userService.updateUser(updatedUser)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Found With "+updatedUser.getEmpId());
        }else{
            User updateUserInList = userService.updateUser(updatedUser);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateUserInList);
        }
    }

//  DELETE a user
    @DeleteMapping("/deleteUser/{empId}")
    public ResponseEntity<String> deleteUser(@PathVariable String empId) {
            if(userService.deleteUser(empId)==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong UserId");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
            }
    }
}
