package com.websystique.springmvc.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckPassword")
public class CheckPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckPassword() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");

        String userPass = request.getParameter("user_pass");
        String confirmPass = request.getParameter("confirm_pass");

        if (userPass.equals(confirmPass)) {
            response.getWriter().print(true);
        } else {
            response.getWriter().print(false);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
