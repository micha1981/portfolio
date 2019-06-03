package pl.northseefish.portfolio.game.app;

import java.io.IOException;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.beans.PlayerContainer;


@WebServlet("/GameViewer")
public class GameViewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GameViewer() {
        super();
    
    }
    @Inject
    PlayerContainer playerContainer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null) {
		if(playerContainer.getUserVerbsTable()==null)response.sendRedirect("/GameInitial");
		if(playerContainer.getCurentVerbs()==null)playerContainer.getRandomToCurrentVerbs();
		
		
		request.setAttribute("playerContainer", playerContainer);
		if(playerContainer.getLives()<=0)   response.sendRedirect("/GameOver");
		request.getRequestDispatcher("WEB-INF/game/gameWindow.jsp").forward(request, response);	
		}else response.sendRedirect("/GameInitial");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession()!=null) {
		try {
			
				playerContainer.setClientAnswers(request.getParameter("pastSimple"), request.getParameter("pastParticiple"));
				request.setAttribute("playerContainer", playerContainer);
				playerContainer.increaseStageCounter();
				request.getRequestDispatcher("WEB-INF/game/showAnswers.jsp").forward(request, response);
				playerContainer.setCurentVerbs(null);
			
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("GameViewer");
		}
		}else response.sendRedirect("/GameInitial");

}
}