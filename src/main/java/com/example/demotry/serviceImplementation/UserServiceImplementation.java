package com.example.demotry.serviceImplementation;

import com.example.demotry.Model.User;
import com.example.demotry.repository.UserRepo;
import com.example.demotry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User updateUser) {

        Optional<User> existingUser = userRepo.findById(updateUser.getEmpId());

        if(existingUser.isPresent()){
            existingUser.get().setEmpName(updateUser.getEmpName());
            existingUser.get().setEmpContactNumber(updateUser.getEmpContactNumber());
            existingUser.get().setEmpAge(updateUser.getEmpAge());

            userRepo.save(existingUser.get());

            return updateUser;
        }
        return null;
    }

    @Override
    public String deleteUser(String empId) {
        if(userRepo.existsById(empId)){
            Optional<User> userToDelete = userRepo.findById(empId);
            System.out.println(userToDelete);
            userRepo.delete(userToDelete.get());
            return "user deleted";
        }else{
            return null;
        }
    }

    @Override
    public User saveUser(User user) {
        if (userRepo.existsById(user.getEmpId())) {
            return null;
        }
        return userRepo.save(user);
    }

}
