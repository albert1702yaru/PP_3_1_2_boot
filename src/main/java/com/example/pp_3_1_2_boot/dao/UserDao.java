package com.example.pp_3_1_2_boot.dao;


import com.example.pp_3_1_2_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void saveUser(User user);

    User getUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
