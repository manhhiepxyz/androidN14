package com.example.nhom14didong.DAO;

import com.example.nhom14didong.Model.User;

import java.util.List;

public interface UserDao {
   boolean addUser(User item);
   boolean updateUser(User item);
   boolean deleteUser(int id);
   User getUserById(int id);
   User getUserByName(String name,String pass);

   List<User> getALllUsers();
}
