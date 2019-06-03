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
import pl.northseefish.portfolio.game.DAO.ScoresDAO;
import pl.northseefish.portfolio.game.DAO.ScoresDaoImpl;

import pl.northseefish.portfolio.game.beans.PlayerContainer;
import pl.northseefish.portfolio.game.beans.ScoreContainer;




@WebServlet("/ChangeUserData")
public class ChangeUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Inject
   PlayerContainer playerContainer;
   @Inject
   ScoreContainer scoreContainer;
   
    public ChangeUserData() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null&&playerContainer.getClientEntity()!=null) {
			String value = request.getParameter("value");
			String id = request.getParameter("id");
			System.out.println(id+value);
			ClientEntity client = new ClientEntity(value, "");
			ClientDao cD = new ClientDaoImpl();
			switch (id) {
			case "1":
				if(!cD.tryClientIsOccure(client)) {
					String oldNick = playerContainer.getClientEntity().getLogin();
					
						try {
							playerContainer.getClientEntity().setLogin(value);
							cD.updateClient(playerContainer.getClientEntity());
							ScoresDAO scDao = new ScoresDaoImpl();
							scDao.updateTableWithNewNick(oldNick, client.getLogin());
							scoreContainer.setScoresList(scDao.getBestScores());
							response.getWriter().write("name changed");
							
						} catch (Exception e) {
							System.out.println(e);
						}
					
					
					
					
				}else response.getWriter().write("player "+value+" already exists");
				break;
			case "2":
				playerContainer.getClientEntity().setEmail(value);
				response.getWriter().write("email changed");
				break;
			case "3":
				playerContainer.getClientEntity().setPassword(value);
				response.getWriter().write("password changed");
				break;

			default:
				break;
			}
			
			
		}else response.sendRedirect("/Index");
		
	}

}
