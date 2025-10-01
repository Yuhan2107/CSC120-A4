import java.util.ArrayList;

public class Train implements TrainRequirements {
    private Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType fuelType, double currentFuel, double fuelCapacity, int nCars, int passengerCapacity){
        cars = new ArrayList<>(nCars);
        engine = new Engine(fuelType, currentFuel, fuelCapacity);
        for (int i = 0; i < nCars; i++){
            cars.add(new Car(passengerCapacity));
        }
    }

    @Override
    public Engine getEngine(){ 
        return engine;
    }
    @Override
    public Car getCar(int i){
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }
        return null;
    }
    @Override
    public int getMaxCapacity(){
        int total = 0;
        for (Car car : cars) {
            total += car.getCapacity();
        }
        return total;
    }
    @Override
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for (int i = 0; i < cars.size(); i++){
            seatsRemaining += cars.get(i).seatsRemaining();
        }
        return seatsRemaining;
    }
    @Override
    public void printManifest(){
        System.out.println("Train Manifest:");
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + (i+1) + ":");
            cars.get(i).printManifest();
        }
    }

}
