package usersReg.securityCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckSecurityCode")
public class CheckSecurityCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckSecurityCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String security = request.getParameter("securityCode");
		String input = request.getParameter("input");
		
		if(security.equals(input)){
			response.getWriter().print(true);
		}else {
			response.getWriter().print(false);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
