package com.training.homework.exception;

import com.training.homework.util.LocalUtil;

public class IncorrectInputException extends Exception {

    @Override
    public String getMessage() {
        return LocalUtil.getInstance().getMessage("input.incorrect");
    }
}
