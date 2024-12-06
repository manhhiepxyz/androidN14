package com.example.nhom14didong.DAO.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhom14didong.DAO.UserDao;
import com.example.nhom14didong.DatabaseHelper;
import com.example.nhom14didong.Model.User;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DatabaseHelper databaseHelper;
    public UserDaoImpl(Context context) {
        databaseHelper= new DatabaseHelper(context);
    }
    @Override
    public boolean addUser(User item) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        return false;
    }

    @Override
    public boolean updateUser(User item) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByName(String name, String pass) {
        return null;
    }

    @Override
    public List<User> getALllUsers() {
        return Collections.emptyList();
    }
}
