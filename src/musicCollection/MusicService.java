package musicCollection;

//import jdbcDAO.dao.CarDAO;
//import jdbcDAO.dao.ClientDAO;
//import jdbcDAO.dao.DAOFactory;
//import jdbcDAO.dao.IDAOFactory;
//import jdbcDAO.entity.Car;
//import jdbcDAO.entity.Client;
import musicCollection.dao.ComposerDAO;
import musicCollection.dao.IDAOFactory;
import musicCollection.dao.*;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class MusicService {
    private IDAOFactory factory;
    private ComposerDAO composerDAO;
    private DiscInfoDAO discInfoDAO ;
    private DiscDAO discDAO;
    private StyleDAO styleDAO;

    private CompositionDAO compositionDAO;




    public MusicService() {
        factory = DAOFactory.getInstance();
        composerDAO = factory.getComposerDAO();
        compositionDAO = factory.getCompositionDAO();
        discDAO = factory.getDiscDAO();
        discInfoDAO = factory.getDiscInfoDAO();
        styleDAO = factory.getStyleDAO();

        // carDAO = factory.getFakeCarDAO();
    }

    public void createNewCar() {

        System.out.println("All cars BEFORE insert:");
        printAllCars();

        // TODO: print also car makes before and after new car(s) addition

        // A car with existing in db make
        Car car = new Car(0L, "Audi", "Q7", 77000);
        carDAO.create(car);

        // A car with non-existing in db make
        car = new Car(0L, "Chevrolet", "Corvette", 75000);
        carDAO.create(car);

        System.out.println("\nAll cars AFTER insert:");
        printAllCars();
    }

    public void readCar() {
        Car car = carDAO.read(1);
        System.out.println(car);
    }

    public void updateCar() {
        System.out.println("All cars BEFORE update:");
        printAllCars();

        carDAO.updatePrice(55000, 1);
        carDAO.updatePrice(90000, 2);

        System.out.println("\nAll cars AFTER update:");
        printAllCars();
    }

    public void deleteCar() {
        System.out.println("All cars BEFORE delete:");
        printAllCars();

        // FK should be 'ON UPDATE CASCADE ON DELETE CASCADE'
        carDAO.deleteByMake("Porsche");

        System.out.println("\nAll cars AFTER delete:");
        printAllCars();
    }

    private void printAllCars() {
        List<Car> cars = carDAO.getAll();
        Collections.sort(cars, comparing(Car::getId));
        for(Car car : cars) {
            System.out.println(car);
        }
    }

    public void printAllClients (){
        List<Client> clients = clientDAO.getAll();
        Collections.sort(clients, comparing(Client::getId));
        for(Client client : clients) {
            System.out.println(client);
        }
    }
    public void addClient(){

        System.out.println("Clients before addition:");

        printAllClients();

        clientDAO.createClient(new Client(0,"Vasja", 55,"09822222222"));

        System.out.println("Clients after addition:");

        printAllClients();

    }

    public void deleteClient (int id){
        System.out.println("Clients before addition:");

        printAllClients();

        clientDAO.deleteByID(id);

        System.out.println("Clients after addition:");

        printAllClients();

    }

    public void readClientByName(String nameParam) {
        List<Client> list = clientDAO.readByName(nameParam);

        for (Client client : list) {
            System.out.println(client);


        }

    }
    public void alterPhoneById(int id, String phone){
        System.out.println("all records before modification: ");
        printAllClients();

        clientDAO.updatePhoneById(id, phone);

        System.out.println("all records after modification: ");
        printAllClients();


    }



}



}
