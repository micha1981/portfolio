package pl.northseefish.portfolio.game.DAO;



public interface ClientDao {

	public ClientEntity getClientByLogin(String str);
	public Boolean saveClient(ClientEntity client);
	public Boolean tryClientIsOccure(ClientEntity client);
	public Boolean deleteAccount(ClientEntity client);
	public Boolean updateClient(ClientEntity client);
	
}
