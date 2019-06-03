package pl.northseefish.portfolio.main;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.beans.PlayerContainer;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Logout() {
        super();
       
    }
    @Inject
    PlayerContainer playerContainer;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		playerContainer.setClientEntity(null);
		playerContainer.setSignInStatus(false);
		response.sendRedirect("/Index");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
