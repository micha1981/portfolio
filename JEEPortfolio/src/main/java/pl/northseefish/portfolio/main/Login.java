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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login() {
        super();
      
    }
    @Inject
    PlayerContainer playerContainer;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null) {
			if(playerContainer.getClientEntity()==null) request.getRequestDispatcher("WEB-INF/game/logInWindow.jsp").forward(request, response);
			else response.sendRedirect("Index");
		}else response.sendRedirect("Index");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession()!=null) {
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			if(!login.isEmpty()&&!password.isEmpty()) {
			ClientDao dao = new ClientDaoImpl();
			ClientEntity client = playerContainer.getClientEntity();
			
			try {
				client = dao.getClientByLogin(login);
				if(client.getPassword().equals(password)) {
					playerContainer.setClientEntity(client);
					
					playerContainer.setSignInStatus(true);
					response.sendRedirect("/Index");
					System.out.println("client log in");
				}else {
					System.out.println("login data incorect");
					response.sendRedirect("/Login");
				}
			} catch (Exception e) {
				System.out.println(e);
				response.sendRedirect("/Login");
			}
			}else request.getRequestDispatcher("WEB-INF/game/loginWindowEmptyFields.jsp").forward(request, response);
		}else response.sendRedirect("/Index");
		
	}

}
