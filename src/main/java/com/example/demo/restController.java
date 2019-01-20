package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

@Controller
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
    public  String saveUser(@RequestParam String username, @RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password,@RequestParam String role_id){
        User user=new User(username,firstname,lastname,age,password, role_id);
        userService.saveMyUser(user);
        return "User saved";
    }
    @GetMapping("/login-user")
    public  String loginUser(@RequestParam String username,@RequestParam String password){
        String user_role_id = userService.findUser(username, password);
        System.out.println(user_role_id);
        if(user_role_id==null) return "loginerror";
        else
        {


            String role_type=userService.findType(Integer.parseInt(user_role_id));
            if(role_type.equals("manager")){
                System.out.println(role_type);

                return "managerpage";
            }
            else if(role_type.equals("teamlead"))return  "teamlead";



        }
        return "welcomepage";
        //User user=new User(username,password);
//
        //Optional<User> usercheck=checkuser.findById(user);


  /*      if(usercheck.isPresent()){
            if(user.getPassword()==usercheck.get().getPassword())return "valid user ";

        }
*/





       // return usercheck.get().getPassword();
        //return "not valid";
    }


}
