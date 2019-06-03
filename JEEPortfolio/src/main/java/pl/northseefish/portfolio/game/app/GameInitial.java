package pl.northseefish.portfolio.game.app;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.northseefish.portfolio.game.beans.PlayerContainer;
import pl.northseefish.portfolio.game.beans.ScoreContainer;
import pl.northseefish.portfolio.game.beans.VerbsTable;

@WebServlet("/GameInitial")
public class GameInitial extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Inject
	VerbsTable verbsTable;
	
	@Inject
	PlayerContainer playerContainer;
	
	@Inject
	ScoreContainer scoreContainer;
    public GameInitial() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		playerContainer.gameInit();
		
		playerContainer.initPlayetTable(verbsTable.getList());
		request.setAttribute("playerContainer", playerContainer);
		request.getRequestDispatcher("WEB-INF/game/gameInit.jsp").forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
