package usersReg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String city = request.getParameter("city");
		String userPass = request.getParameter("user_password");
		String confirmPass = request.getParameter("confirm_password");
		String email = request.getParameter("E-Mail");
		
		
		
		
	}

}
