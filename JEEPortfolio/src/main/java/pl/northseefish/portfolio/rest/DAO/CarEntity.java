package pl.northseefish.portfolio.rest.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="cars")
public class CarEntity {
	private String pictureAdres=null;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="mark")
	private String mark;
	
	@Column(name="model")
	private String model;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="price")
	private Integer price;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	

	public String getPictureAdres() {
		return pictureAdres;
	}

	public void setPictureAdres(String pictureAdres) {
		this.pictureAdres = pictureAdres;
	}

	
	
}
