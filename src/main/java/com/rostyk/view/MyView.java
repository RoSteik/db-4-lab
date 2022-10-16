/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk.view
 * Class: MyView
 */

package com.rostyk.view;

import com.rostyk.controller.CarController;
import com.rostyk.controller.DriverController;
import com.rostyk.controller.TripController;
import com.rostyk.controller.UserController;
import com.rostyk.domain.Car;
import com.rostyk.domain.Driver;
import com.rostyk.domain.Trip;
import com.rostyk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private CarController carController;

    @Autowired
    private UserController userController;

    @Autowired
    private DriverController driverController;

    @Autowired
    private TripController tripController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final Car nullCar = new Car(null, null, null);
    final Driver nullDriver = new Driver(null, null, null, null, null);
    final User nullUser = new User(null, null);
    final Trip nullTrip = new Trip(null, null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Car");
        menu.put("11", "  11 - Create Car");
        menu.put("12", "  12 - Update Car");
        menu.put("13", "  13 - Delete from Car");
        menu.put("14", "  14 - Find all Cars");
        menu.put("15", "  15 - Find Car by ID");
        menu.put("16", "  16 - Find Car by brand");
        menu.put("17", "  17 - Find Car by clas");

        menu.put("2", "   2 - Table: User");
        menu.put("21", "  21 - Create User");
        menu.put("22", "  22 - Update User");
        menu.put("23", "  23 - Delete from User");
        menu.put("24", "  24 - Find all Users");
        menu.put("25", "  25 - Find User by ID");

        menu.put("3", "   3 - Table: Driver");
        menu.put("31", "  31 - Create Driver");
        menu.put("32", "  32 - Update Driver");
        menu.put("33", "  33 - Delete from Driver");
        menu.put("34", "  34 - Find all Drivers");
        menu.put("35", "  35 - Find Driver by ID");
        menu.put("36", "  36 - Find all Cars by Driver ID");

        menu.put("4", "   4 - Table: Trip");
        menu.put("41", "  41 - Create Trip");
        menu.put("42", "  42 - Update Trip");
        menu.put("43", "  43 - Delete from Trip");
        menu.put("44", "  44 - Find all Trips");
        menu.put("45", "  45 - Find Trip by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createCar);
        methodsMenu.put("12", this::updateCar);
        methodsMenu.put("13", this::deleteFromCar);
        methodsMenu.put("14", this::findAllCars);
        methodsMenu.put("15", this::findCarById);
        methodsMenu.put("16", this::findCarByCarBrand);
        methodsMenu.put("17", this::findCarByCarClas);

        methodsMenu.put("21", this::createUser);
        methodsMenu.put("22", this::updateUser);
        methodsMenu.put("23", this::deleteFromUser);
        methodsMenu.put("24", this::findAllUsers);
        methodsMenu.put("25", this::findUserById);

        methodsMenu.put("31", this::createDriver);
        methodsMenu.put("32", this::updateDriver);
        methodsMenu.put("33", this::deleteFromDriver);
        methodsMenu.put("34", this::findAllDrivers);
        methodsMenu.put("35", this::findDriverById);
        methodsMenu.put("36", this::findAllCarsById);

        methodsMenu.put("41", this::createTrip);
        methodsMenu.put("42", this::updateTrip);
        methodsMenu.put("43", this::deleteFromTrip);
        methodsMenu.put("44", this::findAllTrips);
        methodsMenu.put("45", this::findTripById);
    }

    private void selectAllTable() {
        findAllCars();
        findAllUsers();
        findAllDrivers();
        findAllTrips();
    }

    // region CAR ---------------------------------------------------
    private void createCar() {
        System.out.println("Input 'car brand': ");
        String brand = input.nextLine();
        System.out.println("Input 'clas': ");
        String clas = input.nextLine();
        Car car = new Car(null, brand, clas);

        int count = carController.create(car);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCar() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'brand': ");
        String brand = input.nextLine();
        System.out.println("Input new 'clas': ");
        String clas = input.nextLine();
        Car car = new Car(null, brand, clas);

        int count = carController.update(id, car);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCar() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = carController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCars() {
        System.out.println("\nTable: CAR");
        List<Car> cars = carController.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void findCarById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Car> car = carController.findById(id);
        System.out.println(car.orElse(nullCar));
    }

    private void findCarByCarBrand() {
        System.out.println("Input 'car brand': ");
        String brand = input.nextLine();

        Optional<Car> car = carController.findByCarBrand(brand);
        System.out.println(car.orElse(nullCar));
    }

    private void findCarByCarClas() {
        System.out.println("Input 'clas': ");
        String clas = input.nextLine();

        Optional<Car> car = carController.findByCarClas(clas);
        System.out.println(car.orElse(nullCar));
    }
    //endregion CAR


    // region USER ------------------------------------------
    private void createUser() {
        System.out.println("Input 'user name': ");
        String name = input.nextLine();
        System.out.println("Input 'user rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));

        User user = new User(name, rating);

        int count = userController.create(user);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUser() {
        System.out.println("Input 'user new name': ");
        String name = input.nextLine();

        System.out.println("Input 'user new rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));

        User user = new User(name, rating);

        int count = userController.update(name, user);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromUser() {
        System.out.println("Input 'user name': ");
        String name = input.nextLine();

        int count = userController.delete(name);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUsers() {
        System.out.println("\nTable: USER");
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void findUserById() {
        System.out.println("Input 'user name': ");
        String name = input.nextLine();

        Optional<User> user = userController.findById(name);
        System.out.println(user.orElse(nullUser));
    }
    //endregion USER


    // region DRIVER -------------------------------------------------
    private void createDriver() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'completed orders': ");
        Integer completedOrders = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'is driver vacant(0 - false, 1 - true)': ");
        Integer isVacant = Integer.valueOf((input.nextLine()));

        Driver driver = new Driver(null, name, rating,
                completedOrders, isVacant);

        int count = driverController.create(driver);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDriver() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'completed orders': ");
        Integer completedOrders = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'is driver vacant(0 - false, 1 - true)': ");
        Integer isVacant = Integer.valueOf((input.nextLine()));

        Driver driver = new Driver(null, name, rating, completedOrders, isVacant);

        int count = driverController.update(id, driver);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromDriver() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = driverController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDrivers() {
        System.out.println("\nTable: DRIVER");
        List<Driver> drivers = driverController.findAll();
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }

    private void findDriverById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Driver> driver = driverController.findById(id);
        System.out.println(driver.orElse(nullDriver));
    }

    private void findAllCarsById() {
        System.out.println("Input 'driver id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<Car> cars = driverController.findAllCarsBy(id);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    //endregion DRIVER


    // region TRIP
    private void createTrip() {
        System.out.println("Input 'start_point': ");
        String startPoint = input.nextLine();
        System.out.println("Input 'end_point': ");
        String endPoint = input.nextLine();
        System.out.println("Input 'driver_id': ");
        Integer driverId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user name the driver drives with': ");
        String userName = input.nextLine();

        Trip trip = new Trip(null, startPoint, endPoint, driverId, userName);

        int count = tripController.create(trip);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTrip() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'start_point': ");
        String startPoint = input.nextLine();
        System.out.println("Input 'end_point': ");
        String endPoint = input.nextLine();
        System.out.println("Input 'driver_id': ");
        Integer driverId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user name the driver drives with': ");
        String userName = input.nextLine();

        Trip trip = new Trip(null, startPoint, endPoint, driverId, userName);

        int count = tripController.update(id, trip);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromTrip() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = tripController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllTrips() {
        System.out.println("\nTable: TRIP");
        List<Trip> trips = tripController.findAll();
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }

    private void findTripById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Trip> trip = tripController.findById(id);
        System.out.println(trip.orElse(nullTrip));
    }
    // endregion TRIP

    //-------------------------------------------------------------------------

    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
    //endregion output

}
