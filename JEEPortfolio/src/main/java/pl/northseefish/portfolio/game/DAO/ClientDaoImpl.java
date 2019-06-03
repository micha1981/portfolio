package pl.northseefish.portfolio.game.DAO;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;






public class ClientDaoImpl implements ClientDao{

	private Session session=null;
	private SessionFactory sessionFactory=null;
	private Transaction tr=null;
	

	
	public ClientDaoImpl() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.northseefish.portfolio.game.DAO.ClientEntity.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientEntity getClientByLogin(String str) {
		session = sessionFactory.openSession();
		Query<ClientEntity> query = session.createQuery("from ClientEntity where login =:login ");
		query.setParameter("login", str);
		ClientEntity client = query.getSingleResult();
		session.close();
	
		return client;
	}

	@Override
	public Boolean saveClient(ClientEntity client) {
					try {
					session = sessionFactory.openSession();
					tr = session.beginTransaction();
					session.save(client);
					
					tr.commit();
					session.close();
					return true;
				} catch (Exception e) {
					tr.rollback();
					return false;
				}
		}

	@Override
	public Boolean tryClientIsOccure(ClientEntity client) {
		session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<ClientEntity> query = session.createQuery("from ClientEntity where login =:login ");
		query.setParameter("login", client.getLogin());
		try {
			query.getSingleResult();
			session.close();
			return true;
		} catch (Exception e) {
			session.close();
			return false;
		}finally {
			session.close();
			
		}
		
		
		
	}

	@Override
	public Boolean deleteAccount(ClientEntity client) {
		session = sessionFactory.openSession();
		
		try {
			tr = session.beginTransaction();
		session.remove(client);
		
			tr.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			tr.rollback();
			session.close();
			return false;
		}
		
	}

	@Override
	public Boolean updateClient(ClientEntity client) {
		session = sessionFactory.openSession();
		
		try {
			tr = session.beginTransaction();
			session.update(client);
		
			tr.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			tr.rollback();
			session.close();
			return false;
		}
	}
 
}
