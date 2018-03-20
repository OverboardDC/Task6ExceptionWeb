package com.training.homework.servlet;

import com.training.homework.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class GetMainPageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        UserModel userModel = UserModel.getInstance();
        req.setAttribute("users", userModel.getUserList());
        req.getRequestDispatcher("WEB-INF/view/index.jsp").forward(req, resp);
    }
}
