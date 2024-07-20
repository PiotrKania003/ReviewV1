package org.example.review1.controllers;

import org.example.review1.module.User;
import org.example.review1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("addUser")
    public String addUser(@ModelAttribute User user, Model m){

        if(user.getuName().isEmpty() || user.getuSurname().isEmpty()){
            m.addAttribute("message", "Failed to add user to DB, inputs cant be blank!");
            return "index";
        }

        try {
            int compSize = userRepo.getAll().size();
            userRepo.save(user);
            int size = userRepo.getAll().size();



            if (size != compSize) {
                m.addAttribute("message", "Successfuly added user to DB");
            } else {
                m.addAttribute("message", "Failed to add User to DB");
            }
        }catch(Exception e){
            System.out.println(e.fillInStackTrace().toString());
        }
        return "index";
    }

    @GetMapping("getUsers")
    public String getUsers(Model m){

        m.addAttribute("userList", userRepo.getAll());

        return "index";
    }


    @GetMapping("getUserById")
    public String getUserById(Model m, @RequestParam("id") int id){

        m.addAttribute("userList", userRepo.getById(id));
        return "index";
    }

    @GetMapping("getUserByName")
    public String getUserByName(Model m, @RequestParam("name") String name){

        m.addAttribute("userList", userRepo.getByName(name));
        return "index";
    }
}
