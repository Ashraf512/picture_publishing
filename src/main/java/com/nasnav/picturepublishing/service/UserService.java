package com.nasnav.picturepublishing.service;

import com.nasnav.picturepublishing.dto.LoginRequestDTO;
import com.nasnav.picturepublishing.dto.UserDTO;
import com.nasnav.picturepublishing.entity.Users;
import com.nasnav.picturepublishing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO register(UserDTO userDTO) {

        Users user = new Users();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;

    }

    public String login(LoginRequestDTO loginRequestDTO) {
        String response = "";
        int counter = 0 ;
        String username = loginRequestDTO.getUsername();
        String password = loginRequestDTO.getPassword();
        List<Users> user = userRepository.findByUsernameAndPassword(username, password);
        for (Users usr : user) {
            if (usr.getUsername().equals("admin") && usr.getPassword().equals("admin123")){
                 counter =+ 1;
                return "admin";}
            if (usr.getUsername().equals(username) && usr.getPassword().equals(password)){
                counter =+ 1;
                return "valid";

            }

    }
        if (counter ==0)
            return "invalid";
        return  null;}

    public String adminRegister() {
            Users user = new Users();
            user.setName("admin");
            user.setUsername("admin");
            user.setPassword("admin123");
            userRepository.save(user);
            return "Admin Register successfully";
        }
    }
