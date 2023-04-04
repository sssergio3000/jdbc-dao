package jdbcDAO.dao;

import jdbcDAO.entity.Client;

import java.util.List;


public interface ClientDAO {
    public void createClient(Client client);
    public void deleteByID(int id);
    public List<Client> readByName(String name);
    public List<Client> getAll();
    public void updatePhoneById(int id, String phone);
}
