package com.training.homework.servlet;

import com.training.homework.entity.User;
import com.training.homework.exception.DuplicateLoginException;
import com.training.homework.exception.IncorrectInputException;
import com.training.homework.model.UserModel;
import com.training.homework.util.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = UserModel.getInstance();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        try {
            checkInputCorrect(name, login);
        } catch (IncorrectInputException e) {
            returnToPrevPage(req, resp, e);
            return;
        }
        try {
            checkLogin(login);
        } catch (DuplicateLoginException e) {
            returnToPrevPage(req, resp, e);
            return;
        }
        userModel.addUser(new User(name, login));
        resp.sendRedirect(req.getContextPath() + "/");

    }

    private void checkInputCorrect(String name, String login) throws IncorrectInputException{
        if(!UserValidator.isCorrectData(name, login)){
            throw new IncorrectInputException();
        }
    }


    private void checkLogin(String login) throws DuplicateLoginException {
        if (!UserValidator.isLoginUnique(login)) {
            throw new DuplicateLoginException();
        }
    }

    private void returnToPrevPage(HttpServletRequest req, HttpServletResponse resp, Exception e) throws IOException {
        req.getSession().setAttribute("error", e.getMessage());
        resp.sendRedirect("/");
    }


}
