package com.training.homework.model;

import com.training.homework.entity.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class UserModel {

    private static UserModel instance;
    private CopyOnWriteArrayList<User> userList;

    private UserModel() {
        this.userList = new CopyOnWriteArrayList<>();
    }

    public static UserModel getInstance() {
        if(instance == null){
            synchronized (UserModel.class) {
                instance = new UserModel();
            }
        }
        return instance;
    }

    public CopyOnWriteArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        if(user != null) {
            userList.add(user);
        } else {
            throw new NullPointerException();
        }
    }

}
