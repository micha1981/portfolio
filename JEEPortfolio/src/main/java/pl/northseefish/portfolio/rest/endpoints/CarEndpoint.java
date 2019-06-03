package pl.northseefish.portfolio.rest.endpoints;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.northseefish.portfolio.rest.DAO.CarDAO;
import pl.northseefish.portfolio.rest.DAO.CarDAOImpl;
import pl.northseefish.portfolio.rest.DAO.CarEntity;
import pl.northseefish.portfolio.rest.DAO.CarImageDAO;
import pl.northseefish.portfolio.rest.DAO.CarImageDAOImpl;
import pl.northseefish.portfolio.rest.DAO.CarImageEntity;


@Path("/car")

public class CarEndpoint {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CarEntity> getAllCars() {
		try {
			CarDAO carDAO = new CarDAOImpl();
			List<CarEntity> carsList = carDAO.getAllCars();
			for(CarEntity ls: carsList) {
				ls.setPictureAdres("/api/car/"+ls.getId()+"/img");
			}
		 return carsList;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@GET
	@Path("/{id}/img")
    @Produces("image/png")
	public byte[] getCarPhoto(@PathParam("id")Integer id) {
		try {
			CarImageDAO carImageDAO = new CarImageDAOImpl();
			CarImageEntity carImg = carImageDAO.getCarImageByID(id);
			return carImg.getPicture();
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarEntity getCarById(@PathParam("id") Integer id) {
		try {
			CarDAO carDAO = new CarDAOImpl();
			CarEntity car = carDAO.getCarByID(id);
			car.setPictureAdres("/api/car/"+id+"/img");
			return car;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@GET
	@Path("/search/{string}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<CarEntity> getCarByString(@PathParam("string")String string) {
		try {
			CarDAO carDao = new CarDAOImpl();
			List<CarEntity> list = carDao.getCarsByString(string.toLowerCase());
			for(CarEntity ls: list) {
				ls.setPictureAdres("/api/car/"+ls.getId()+"/img");
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}



}
