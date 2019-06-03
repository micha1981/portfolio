package pl.northseefish.portfolio.game.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GameDaoImpl implements GameDataDAO{
	private Session session=null;
	private SessionFactory sessionFactory=null;

	
	public GameDaoImpl() {
	

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.northseefish.portfolio.game.DAO.GameDataEntity.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	

	public GameDataEntity getById(int id) {
		session = sessionFactory.openSession();
		GameDataEntity item = null;
		try {
			item = session.get(GameDataEntity.class, id);
			
			session.close();
			return item;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.close();
			return item;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GameDataEntity> getAll() {
		session = sessionFactory.openSession();
		Query<GameDataEntity> query = session.createQuery("from GameDataEntity l");
		List<GameDataEntity> list = query.getResultList();
		session.close();
		return list;
	}

}
