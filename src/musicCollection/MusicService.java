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
import musicCollection.entity.Composer;

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


    }

    public void createNewComposer(Composer composerParam) {

        System.out.println("All composers BEFORE insert:");
        printAllComposers();

             composerDAO.create(composerParam);


        // A car with non-existing in db make


        System.out.println("\n All composers After insert:");
        printAllComposers();
    }

//    private void printAllComposers() {
//    }
//
//    public void readCar() {
//        Car car = carDAO.read(1);
//        System.out.println(car);
//    }
//
//    public void updateCar() {
//        System.out.println("All cars BEFORE update:");
//        printAllCars();
//
//        carDAO.updatePrice(55000, 1);
//        carDAO.updatePrice(90000, 2);
//
//        System.out.println("\nAll cars AFTER update:");
//        printAllCars();
//    }
//
//    public void deleteCar() {
//        System.out.println("All cars BEFORE delete:");
//        printAllCars();
//
//        // FK should be 'ON UPDATE CASCADE ON DELETE CASCADE'
//        carDAO.deleteByMake("Porsche");
//
//        System.out.println("\nAll cars AFTER delete:");
//        printAllCars();
//    }
//
//    private void printAllCars() {
//        List<Car> cars = carDAO.getAll();
//        Collections.sort(cars, comparing(Car::getId));
//        for(Car car : cars) {
//            System.out.println(car);
//        }
//    }
//
    public void printAllComposers (){
        List<Composer> composers = composerDAO.getAll();
        Collections.sort(composers, comparing(Composer::getName));
        for(Composer composer : composers) {
            System.out.println(composer);
        }
    }
//    public void addClient(){
//
//        System.out.println("Clients before addition:");
//
//        printAllClients();
//
//        clientDAO.createClient(new Client(0,"Vasja", 55,"09822222222"));
//
//        System.out.println("Clients after addition:");
//
//        printAllClients();
//
//    }
//
//    public void deleteClient (int id){
//        System.out.println("Clients before addition:");
//
//        printAllClients();
//
//        clientDAO.deleteByID(id);
//
//        System.out.println("Clients after addition:");
//
//        printAllClients();
//
//    }
//
//    public void readClientByName(String nameParam) {
//        List<Client> list = clientDAO.readByName(nameParam);
//
//        for (Client client : list) {
//            System.out.println(client);
//
//
//        }
//
//    }
//    public void alterPhoneById(int id, String phone){
//        System.out.println("all records before modification: ");
//        printAllClients();
//
//        clientDAO.updatePhoneById(id, phone);
//
//        System.out.println("all records after modification: ");
//        printAllClients();
//
//
//    }



}




