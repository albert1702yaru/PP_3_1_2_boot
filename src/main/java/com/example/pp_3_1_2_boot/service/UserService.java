package com.example.pp_3_1_2_boot.service;


import com.example.pp_3_1_2_boot.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    void saveUser(User user);

    User getUser(Long id);

    void updateUser(@Valid User user);

    void deleteUser(Long id);
}
