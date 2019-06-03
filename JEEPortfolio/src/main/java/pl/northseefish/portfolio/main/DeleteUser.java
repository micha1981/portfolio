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
import pl.northseefish.portfolio.game.beans.PlayerContainer;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteUser() {
        super();
       
    }
    @Inject PlayerContainer playerContainer;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			if(playerContainer.getClientEntity()!=null) {
				try {
					ClientDao cD = new ClientDaoImpl();
					cD.deleteAccount(playerContainer.getClientEntity());
					playerContainer.setClientEntity(null);
					playerContainer.setSignInStatus(false);
					response.getWriter().write("account deleted");
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			else response.sendRedirect("/Index");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
