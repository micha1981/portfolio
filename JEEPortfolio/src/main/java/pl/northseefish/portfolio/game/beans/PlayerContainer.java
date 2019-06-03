package pl.northseefish.portfolio.game.beans;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.enterprise.context.SessionScoped;


import pl.northseefish.portfolio.game.DAO.ClientEntity;
import pl.northseefish.portfolio.game.DAO.GameDataEntity;

@SessionScoped
public class PlayerContainer implements Serializable{

	private static final long serialVersionUID = 1287685294073467530L;

	private Boolean signInStatus=false;

	private List<GameDataEntity> userVerbsTable=null;
	private int stageCounter=1;
	private int lives = 5;
	private GameDataEntity curentVerbs=null;
	private int randomVerb;
	private String[] clientAnswers= new String[2];
	private int faultAnswereCounter=0;
	private int scoreCounter = 0;
	private int stageRecordCounter=0;
	
	private ClientEntity clientEntity=null;
	
	//constructor

	public PlayerContainer() {
		
	}
	
	//methods
	public void getRandomToCurrentVerbs() {
		if(curentVerbs!=null)userVerbsTable.remove(randomVerb);
		Random r = new Random();
		int t =r.nextInt(userVerbsTable.size());
		this.curentVerbs = userVerbsTable.get(t);
		this.randomVerb=t;
	}
	
	
	public void increaseStageCounter() {
		this.stageCounter++;
	}
	

	public void initPlayetTable(List<GameDataEntity> list) {
		userVerbsTable = new ArrayList<GameDataEntity>(list);
	}
	
	public Map<String, String> checkAnswares(String[] clientAnswares, GameDataEntity currentRandomVerbs){
		stageRecordCounter=0;
		Map<String, String> map = new HashMap<String, String>();
		if(clientAnswares[0].equals(currentRandomVerbs.getPastSimple())) {
			map.put("pastSimple", "green");
			stageRecordCounter=stageRecordCounter+100;
			
		}else {map.put("pastSimple", "red");
		faultAnswereCounter++;
		lives--;
		}
		if(clientAnswares[1].equals(currentRandomVerbs.getPastParticiple())) {
			map.put("pastParticiple", "green");
			stageRecordCounter=stageRecordCounter+100;
			
		}else {map.put("pastParticiple", "red");
		faultAnswereCounter++;
		lives--;
		}
		scoreCounter=scoreCounter+stageRecordCounter;
		return map;
	}
	
	public void gameInit() {
		stageCounter=1;
		randomVerb=0;
		faultAnswereCounter=0;
		scoreCounter=0;
		lives = 5;
	}
		
	public String printUserSignStatus(){
		if(this.signInStatus)return "<img src=\"../img/account.png\" style=\"width:40px; height:40px\" alt=\"\" >";
		else return "Log in";
	}
	
	
	
	//getters and setters
	
	



	public List<GameDataEntity> getUserVerbsTable() {
		return userVerbsTable;
	}

	public void setUserVerbsTable(List<GameDataEntity> userVerbsTable) {
		this.userVerbsTable = userVerbsTable;
	}
	
	public int getStageCounter() {
		return stageCounter;
	}


	public void setStageCounter(int stageCounter) {
		this.stageCounter = stageCounter;
	}

	public GameDataEntity getCurentVerbs() {
		return curentVerbs;
	}

	public void setCurentVerbs(GameDataEntity curentVerbs) {
		this.curentVerbs = curentVerbs;
	}

	public int getRandomVerb() {
		return randomVerb;
	}

	public void setRandomVerb(int randomVerb) {
		this.randomVerb = randomVerb;
	}

	public String[] getClientAnswers() {
		return clientAnswers;
	}

	public void setClientAnswers(String pastSimple, String pastParticiple) {
		this.clientAnswers[0] = pastSimple.toLowerCase();
		this.clientAnswers[1] = pastParticiple.toLowerCase();
	}

	public int getFaultAnswereCounter() {
		return faultAnswereCounter;
	}

	public void setFaultAnswereCounter(int faultAnswereCounter) {
		this.faultAnswereCounter = faultAnswereCounter;
	}

	public int getScoreCounter() {
		return scoreCounter;
	}

	public void setScoreCounter(int correctAnswereCounter) {
		this.scoreCounter = correctAnswereCounter;
	}

	public void setClientAnswers(String[] clientAnswers) {
		this.clientAnswers = clientAnswers;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public Boolean getSignInStatus() {
		return signInStatus;
	}

	public void setSignInStatus(Boolean signInStatus) {
		this.signInStatus = signInStatus;
	}

	public int getStageRecordCounter() {
		return stageRecordCounter;
	}

	public void setStageRecordCounter(int stageRecordCounter) {
		this.stageRecordCounter = stageRecordCounter;
	}

	public ClientEntity getClientEntity() {
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}
	
	
	
}
