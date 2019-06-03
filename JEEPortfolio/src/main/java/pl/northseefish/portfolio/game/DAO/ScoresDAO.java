package pl.northseefish.portfolio.game.DAO;

import java.util.List;

public interface ScoresDAO {

	public ScoresEntity getById(int id);
	public List<ScoresEntity> getBestScores();
	public void updateTable(ScoresEntity entity);
	public void updateTableWithNewNick(String oldNick, String newNick);
	
	
}
