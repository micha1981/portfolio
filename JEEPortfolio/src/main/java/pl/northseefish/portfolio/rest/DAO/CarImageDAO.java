package pl.northseefish.portfolio.rest.DAO;

import java.util.List;

public interface CarImageDAO {

	public Boolean saveCarImage(CarEntity car);
	public CarImageEntity getCarImageByID(Integer id);
	public List<CarImageEntity> getCarsByString(String query);
	public List<CarImageEntity> getAllCarsImages();
}
