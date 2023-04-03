package jdbcDAO.dao;

import jdbcDAO.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {
    public void create(Client client);
    public void deleteByID(int id);
    public Client read(int id);
    public List<Client> getAll();
    public void updatePhone(int id, String phone);
}
