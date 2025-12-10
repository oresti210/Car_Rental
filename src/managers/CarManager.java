package managers;

import model.Car;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("[CarManager] Added car: " + car.getBrand() + " " + car.getModel());
    }

    public void removeCar(int carId) {
        cars.removeIf(c -> c.getId() == carId);
    }

    public Car findCarById(int id) {
        for (Car c : cars) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).collect(Collectors.toList());
    }

    public List<Car> getUnavailableCars() {
        return cars.stream().filter(c -> !c.isAvailable()).collect(Collectors.toList());
    }

    public List<Car> getCarsByBrand(String brand) {
        return cars.stream()
                .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByPriceRange(double min, double max) {
        return cars.stream()
                .filter(c -> c.calculateRentalCost(1) >= min && c.calculateRentalCost(1) <= max)
                .collect(Collectors.toList());
    }

    public void sortCarsByPrice(boolean ascending) {
        if (ascending)
            cars.sort(Comparator.comparingDouble(c -> c.calculateRentalCost(1)));
        else
            cars.sort(Comparator.comparingDouble((Car c) -> c.calculateRentalCost(1)).reversed());
    }

    public void displayAllCars() {
        if (cars.isEmpty()) {
            System.out.println("[CarManager] No cars available.");
            return;
        }
        for (Car c : cars) {
            c.displayInfo();
            System.out.println("----------------------------");
        }
    }

    public int getTotalCars() {
        return cars.size();
    }
}
