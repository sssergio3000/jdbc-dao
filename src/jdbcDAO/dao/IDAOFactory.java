package jdbcDAO.dao;

/**
 * Created by Asus on 31.01.2018.
 */
public interface IDAOFactory {

    CarDAO getCarDAO();
    ClientDAO getClientDAO();
    CarDAO getFakeCarDAO();
}
