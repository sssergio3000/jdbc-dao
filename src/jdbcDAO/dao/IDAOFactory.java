package jdbcDAO.dao;


public interface IDAOFactory {

    CarDAO getCarDAO();
    ClientDAO getClientDAO();
    CarDAO getFakeCarDAO();
}
