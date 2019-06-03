package pl.northseefish.portfolio.game.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="irregVerbs")
public class GameDataEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int iD;
	
	@Column(name="infinitive")
	private String infinitive;
	
	@Column(name="pastSimple")
	private String pastSimple;
	
	
	@Column(name="pastParticiple")
	private String pastParticiple;
	
	@Column(name="meaning")
	private String meaning;

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getInfinitive() {
		return infinitive;
	}

	public void setInfinitive(String infinitive) {
		this.infinitive = infinitive;
	}

	public String getPastSimple() {
		return pastSimple;
	}

	public void setPastSimple(String pastSimple) {
		this.pastSimple = pastSimple;
	}

	public String getPastParticiple() {
		return pastParticiple;
	}

	public void setPastParticiple(String pastParticiple) {
		this.pastParticiple = pastParticiple;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	
	
	
}
