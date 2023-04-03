package jdbcDAO.dao;

import jdbcDAO.entity.*;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface CarDAO {


    void create(Car car);

    Car read(long id);

    void updatePrice(int price, int carId);

    void deleteByMake(String make);

    List<Car> getAll();

}
