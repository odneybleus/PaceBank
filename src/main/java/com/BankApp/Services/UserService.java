package com.BankApp.Services;

import com.BankApp.DAO.UserDAO;
import com.BankApp.Exceptions.Users.UserExists;
import com.BankApp.Exceptions.Users.UserNotFound;
import com.BankApp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    //TODO GET ALL USERS
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }
     //TODO Create User
    public User createUser(User user) throws UserExists {
        if(userDAO.findById(user.getUserID()).isPresent()){
            throw new UserExists("User Already Exists");
        }
        return userDAO.save(user);
    }
     //TODO Fet user by username
    public Optional<User> getUserByUserName(String username) throws UserNotFound{
        if(userDAO.getUserByUserName(username).isEmpty()){
            throw new UserNotFound("Username Does Not Exist");
        }
        return userDAO.getUserByUserName(username);
    }
     //TODO Get User By ID
    public Optional<User> getUserByID(int id) throws UserNotFound{
        if(userDAO.findById(id).isEmpty()){
            throw new UserNotFound("User ID Does Not Exist");
        }
        return userDAO.findById(id);
    }

     //TODO Delete User
    public void deleteUser(User user) throws UserNotFound {
        if(userDAO.findById(user.getUserID()).isEmpty()){
            throw new UserNotFound("User Does Not Exist");
        }
         userDAO.delete(user);
    }
     //TODO Authenticate User
    public User loginUser(String username, String password){
        Optional<User> possibleUser = userDAO.getUserByUserName(username);
        if(possibleUser.isEmpty()){
            return null;
        }
        User actualUser = possibleUser.get();
        if(actualUser.getUserPassword().equals(password)){
            return actualUser;
        }
        return null;
    }


}
