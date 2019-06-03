package pl.northseefish.portfolio.game.beans;

import java.util.List;

//import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

import pl.northseefish.portfolio.game.DAO.GameDaoImpl;
import pl.northseefish.portfolio.game.DAO.GameDataDAO;
import pl.northseefish.portfolio.game.DAO.GameDataEntity;


//@ApplicationScoped
@Singleton
public class VerbsTable {

List<GameDataEntity> list = null;

public List<GameDataEntity> getList() {
	return list;
}

public void setList(List<GameDataEntity> list) {
	this.list = list;
}

public VerbsTable() {
	GameDataDAO dao = new GameDaoImpl();
	this.list = dao.getAll();
	
}
	
}
