package pl.northseefish.portfolio.main;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.DAO.ClientDao;
import pl.northseefish.portfolio.game.DAO.ClientDaoImpl;
import pl.northseefish.portfolio.game.DAO.ClientEntity;
import pl.northseefish.portfolio.game.beans.PlayerContainer;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	PlayerContainer playerContainer;
	
    public SignIn() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(playerContainer.getClientEntity()==null) {
		request.getRequestDispatcher("WEB-INF/game/signInWindow.jsp").forward(request, response);
		
	}else response.sendRedirect("/Index");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession()!=null) {
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			if(!login.isEmpty()&&!password.isEmpty()) {
			ClientDao dao = new ClientDaoImpl();
			ClientEntity client = new ClientEntity(login,password);
			
			
			if(!dao.tryClientIsOccure(client)) {
				try {
					dao.saveClient(client);
					
					playerContainer.setSignInStatus(true);
					playerContainer.setClientEntity(client);
					response.sendRedirect("/Index");
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}else response.sendRedirect("/SignIn");
			}else request.getRequestDispatcher("WEB-INF/game/signInWindowEmptyFields.jsp").forward(request, response);
		
		}else response.sendRedirect("/Index");
	}

}
