package pl.northseefish.portfolio.rest.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CarImageDAOImpl implements CarImageDAO{
	private Session session=null;
	private SessionFactory sessionFactory=null;
	
	
	 public CarImageDAOImpl() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(pl.northseefish.portfolio.rest.DAO.CarImageEntity.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}


	@Override
	public Boolean saveCarImage(CarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CarImageEntity getCarImageByID(Integer id) {
		session = sessionFactory.openSession();
		CarImageEntity carImage = null;
		try {
			carImage = session.get(CarImageEntity.class, id);
			
			session.close();
			return carImage;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.close();
			return null;
		}
	}


	@Override
	public List<CarImageEntity> getCarsByString(String query) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CarImageEntity> getAllCarsImages() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
