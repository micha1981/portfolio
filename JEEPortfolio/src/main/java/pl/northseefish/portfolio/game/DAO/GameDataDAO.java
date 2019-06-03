package pl.northseefish.portfolio.game.DAO;

import java.util.List;

public interface GameDataDAO {
	public GameDataEntity getById(int id);
	public List<GameDataEntity> getAll();

}
