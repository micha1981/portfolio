package pl.northseefish.portfolio.game.DAO;


import java.util.List;

import javax.inject.Inject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import pl.northseefish.portfolio.game.beans.PlayerContainer;
import pl.northseefish.portfolio.game.beans.ScoreContainer;

public class ScoresDaoImpl implements ScoresDAO {
	private Session session = null;
	private SessionFactory sessionFactory = null;
	private Transaction tr = null;

	int howManyScores = 5;

	@Inject
	ScoreContainer scoreContainer;
	@Inject
	PlayerContainer playerContainer;

	public ScoresDaoImpl() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.northseefish.portfolio.game.DAO.ScoresEntity.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public ScoresEntity getById(int id) {
		session = sessionFactory.openSession();
		ScoresEntity item = null;
		try {
			item = session.get(ScoresEntity.class, id);
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
	public List<ScoresEntity> getBestScores() {
		session = sessionFactory.openSession();
		Query<ScoresEntity> query = session.createQuery("FROM ScoresEntity s ORDER BY s.score DESC");
		query.setMaxResults(howManyScores);
		List<ScoresEntity> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public void updateTable(ScoresEntity entity) {
		session = sessionFactory.openSession();
		try {

			tr = session.beginTransaction();
			session.save(entity);
			tr.commit();
			session.close();
		} catch (Exception e) {
			session.close();
			tr.rollback();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateTableWithNewNick(String oldNick, String newNick) {
		session = sessionFactory.openSession();
		Query<ScoresEntity> query = session.createQuery("FROM ScoresEntity s WHERE s.nick = :nick");
		query.setParameter("nick", oldNick);

		List<ScoresEntity> list = query.getResultList();
			for (ScoresEntity sc : list) {
				
				try {
					sc.setNick(newNick);
					tr = session.beginTransaction();
					session.update(sc);
					

					tr.commit();
					
					
				} catch (Exception e) {
					System.out.println(e);
					tr.rollback();
					session.close();
				}
				
			}
			session.close();
			
			
	}

}
