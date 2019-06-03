package pl.northseefish.portfolio.game.app;

import java.io.IOException;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.DAO.ScoresDAO;
import pl.northseefish.portfolio.game.DAO.ScoresDaoImpl;
import pl.northseefish.portfolio.game.DAO.ScoresEntity;
import pl.northseefish.portfolio.game.beans.PlayerContainer;
import pl.northseefish.portfolio.game.beans.ScoreContainer;


@WebServlet("/GameOver")
public class GameOver extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GameOver() {
        super();
    
    }
    @Inject
    PlayerContainer playerContainer;
    
    @Inject
    ScoreContainer scoreContainer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null) {
		request.setAttribute("playerContainer", playerContainer);
		request.setAttribute("scoreContainer", scoreContainer);
		if(playerContainer.getClientEntity()!=null) {
			
		if(scoreContainer.getScoresList().get(scoreContainer.getScoresList().size()-1).getScore()<playerContainer.getScoreCounter()){
			
			ScoresDAO scores = new ScoresDaoImpl();
			ScoresEntity entity = new ScoresEntity(playerContainer.getClientEntity(), playerContainer.getScoreCounter());
			scores.updateTable(entity);
			scoreContainer.setScoresList(scores.getBestScores());
			
		}	
			
			
			
		
		request.getRequestDispatcher("WEB-INF/game/gameOver.jsp").forward(request, response);
		}else request.getRequestDispatcher("WEB-INF/game/gameOverLogout.jsp").forward(request, response);
		}else response.sendRedirect("gameInitial");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}		
}