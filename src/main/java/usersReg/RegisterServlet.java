package usersReg;

import java.io.IOException;
import java.time.LocalDate;

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
		String phoneNumber = request.getParameter("contact_no");
		String img = request.getParameter("img");
		
		LocalDate birthday = LocalDate.of(Integer.parseInt(request.getParameter("year"))
				, Integer.parseInt(request.getParameter("month"))
				, Integer.parseInt(request.getParameter("day")));
		
		String securityCode = request.getParameter("securityCode");
		String userCode = request.getParameter("userSecutityCode");
		
		boolean doesAgreeWithCommonTerms = request.getParameter("Agreements") == "1" ? true : false;
		boolean wantNotifications = request.getParameter("wantNotifications") == "1" ? true : false;
		
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(city);
		System.out.println(userPass);
		System.out.println(confirmPass);
		System.out.println(email);
		System.out.println(phoneNumber);
		System.out.println(img);
		System.out.println(birthday);
		System.out.println(securityCode);
		System.out.println(userCode);
		System.out.println(doesAgreeWithCommonTerms);
		System.out.println(wantNotifications);
		
		
	}

}
