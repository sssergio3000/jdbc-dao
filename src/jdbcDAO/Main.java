package jdbcDAO;




public class Main {

    public static void main(String[] args) {

        CarShopService carShopService = new CarShopService();

        // Use case 1. Test CRUD's 'Create' operation
        // carShopService.createNewCar();

        // Use case 2. Test CRUD's 'Read' operation
        // carShopService.readCar();

        // Use case 3. Test CRUD's 'Update' operation
        // carShopService.updateCar();

        // Use case 4. Test CRUD's 'Delete' operation
//        carShopService.deleteCar();
//        carShopService.addClient();
//        carShopService.deleteClient(3);
        carShopService.printAllClients();
//        carShopService.readClientByName("John");
//        carShopService.alterPhoneById(5, "666666666666");
    }
}
