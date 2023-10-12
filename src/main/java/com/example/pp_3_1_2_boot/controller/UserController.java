package com.example.pp_3_1_2_boot.controller;

import com.example.pp_3_1_2_boot.model.User;
import com.example.pp_3_1_2_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(ModelMap model) {
        model.addAttribute("allUser", userService.getUserList());
        return "all-user";
    }

    @RequestMapping("/addUsers")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/upUser")
    public String upUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") Long id, Model model) {
        User user = userService.getUser(id);
        user.setId(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
