package pl.northseefish.portfolio.game.beans;

import java.util.List;

import javax.inject.Singleton;

import pl.northseefish.portfolio.game.DAO.ScoresDAO;
import pl.northseefish.portfolio.game.DAO.ScoresDaoImpl;
import pl.northseefish.portfolio.game.DAO.ScoresEntity;

@Singleton
public class ScoreContainer {
	private List<ScoresEntity> scoresList=null;
	
	
	public ScoreContainer(){
	ScoresDAO scores = new ScoresDaoImpl();
	scoresList=scores.getBestScores();
	}
	
	public void print() {
		for(ScoresEntity scr:scoresList) {
			System.out.println(scr.getNick());
		}
	}

	public List<ScoresEntity> getScoresList() {
		return scoresList;
	}

	public void setScoresList(List<ScoresEntity> scoresList) {
		this.scoresList = scoresList;
	}
	
	
}
