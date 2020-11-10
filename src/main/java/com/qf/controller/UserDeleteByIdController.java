package com.qf.controller;


import com.qf.dao.UserDao;
import com.qf.tools.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteById")
public class UserDeleteByIdController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDao userDao = Tools.getUserDao();
        int i = userDao.deleteById(Integer.parseInt(id));
        Tools.close();
        if (i>0){
            resp.sendRedirect("/findAll");
//            req.getRequestDispatcher("/findALl").forward(req,resp);
        }
    }
}
