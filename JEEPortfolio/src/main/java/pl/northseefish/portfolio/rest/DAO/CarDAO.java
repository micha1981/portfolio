package pl.northseefish.portfolio.rest.DAO;

import java.util.List;

public interface CarDAO {

	public Boolean saveCar(CarEntity car);
	public CarEntity getCarByID(Integer id);
	public List<CarEntity> getCarsByString(String mark);
	public List<CarEntity> getAllCars();
}
