package com.qf.controller;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.tools.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateById")
public class UserUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        User user = new User(Integer.parseInt(id), name, password, gender, email);
        UserDao userDao = Tools.getUserDao();
        int i = userDao.updateUser(user);
        if (i>0){
            resp.sendRedirect("/findAll");
        }
    }
}
