package pl.northseefish.portfolio.rest.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;




public class CarDAOImpl implements CarDAO{
	private Session session=null;
	private SessionFactory sessionFactory=null;
	
	
	 public CarDAOImpl() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.northseefish.portfolio.rest.DAO.CarEntity.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public Boolean saveCar(CarEntity car) {
		
		return null;
	}

	@Override
	public CarEntity getCarByID(Integer id) {
		session = sessionFactory.openSession();
		CarEntity car = null;
		try {
			car = session.get(CarEntity.class, id);
			
			session.close();
			return car;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.close();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarEntity> getCarsByString(String mark) {
		session = sessionFactory.openSession();
		try {
			Query<CarEntity> query = session.createQuery("from CarEntity where mark =:mark OR model =:mark"  );
			query.setParameter("mark", mark);
		      List<CarEntity> carList = query.getResultList();
			
			
			
			session.close();
			return carList;
			
		} catch (Exception e) {	
			e.printStackTrace();
			session.close();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarEntity> getAllCars() {
	
		session = sessionFactory.openSession();
	
		try {
			Query<CarEntity> query = session.createQuery("from CarEntity l");
			List<CarEntity> list = query.getResultList();
			session.close();
			return list;
			
		} catch (Exception e) {	
			e.printStackTrace();
			session.close();
			return null;
		}
	}
}


