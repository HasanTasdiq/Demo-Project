package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    public  UserService(UserRepository userRepository)
    {

        this.userRepository=userRepository;
    }
    public  void saveMyUser(User user)
    {
        System.out.println(userRepository.getAllEmail());
        userRepository.save(user);
    }

    public List<String> findUser(String userName, String password)
    {
        //System.out.println(userRepository.getAllEmail());
        return userRepository.findUser(userName, password);
    }
}
