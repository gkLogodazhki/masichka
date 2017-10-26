package usersReg.checkPhoneAndName;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/CheckName")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		if(name != null) {
			name = name.replaceAll("[^a-zA-Zà-ÿÀ-ß\b]", "");
			response.getWriter().print(new Gson().toJson(name));
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
