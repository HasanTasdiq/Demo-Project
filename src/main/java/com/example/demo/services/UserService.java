package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final  RoleRepository roleRepository;
    public  UserService(UserRepository userRepository, RoleRepository roleRepository)
    {

        this.userRepository=userRepository;
        this.roleRepository = roleRepository;
    }
    public  void saveMyUser(User user)
    {
        System.out.println(userRepository.getAllEmail());
        userRepository.save(user);
    }

    public String findUser(String userName, String password)
    {
        //System.out.println(userRepository.getAllEmail());
        return userRepository.findUser(userName, password);
    }

    public String findType(int role_id)
    {
        //System.out.println(userRepository.getAllEmail());
        return  roleRepository.findType(role_id);
    }


}
