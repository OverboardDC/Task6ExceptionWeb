package com.training.homework.util;

import com.training.homework.entity.User;
import com.training.homework.model.UserModel;

import static com.training.homework.util.RegexConstants.*;

public class UserValidator {

    public static boolean isCorrectData(String name, String login) {
        return name.matches(NAME_REGEX) && login.matches(LOGIN_REGEX);
    }

    public static boolean isLoginUnique(String login){
        UserModel userModel = UserModel.getInstance();
        for(User user : userModel.getUserList()){
            if(user.getLogin().equals(login)){
                return false;
            }
        }
        return true;
    }
}
