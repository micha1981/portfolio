package pl.northseefish.portfolio.main;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.beans.PlayerContainer;


@WebServlet("/UserAccount")
public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject PlayerContainer playerContainer;
    
    public UserAccount() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null&&playerContainer.getClientEntity()!=null) {
			request.setAttribute("playerContainer", playerContainer);
			request.getRequestDispatcher("WEB-INF/main/userAccount.jsp").forward(request, response);	
			
			
		}else response.sendRedirect("/Index");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
