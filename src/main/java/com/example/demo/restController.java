package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class restController {
    @Autowired
    private UserService userService;
    private final UserRepository checkuser;

    public restController(UserRepository checkuser) {
        this.checkuser=checkuser;
    }

    @GetMapping("/")
    public  String hello(){
        return "this is homepage";
    }

    @GetMapping("/save-user")
    public  String saveUser(@RequestParam String username, @RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password){
        User user=new User(username,firstname,lastname,age,password);
        userService.saveMyUser(user);
        return "User saved";
    }
    @GetMapping("/login-user")
    public  String loginUser(@RequestParam String username,@RequestParam String password){
        List<String> user = userService.findUser(username, password);
        System.out.println(user.size());
        if(user.size()==0) return "login error";
        else return "login successful";
        //User user=new User(username,password);

        //Optional<User> usercheck=checkuser.findById(user);


  /*      if(usercheck.isPresent()){
            if(user.getPassword()==usercheck.get().getPassword())return "valid user ";

        }
*/





       // return usercheck.get().getPassword();
        //return "not valid";
    }


}
