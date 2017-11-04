package com.websystique.springmvc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/CheckAlphabetics")
public class CheckAlphabeticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckAlphabeticsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		String number = request.getParameter("contact_no");
		if(number != null && number.length() >= 6) {
			String text = number.substring(5);
			number = "(+359)" + text.replaceAll("[^0-9]", "");
		}
		response.getWriter().print(new Gson().toJson(number));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
