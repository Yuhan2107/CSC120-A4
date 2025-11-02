import java.util.ArrayList;

public class Train implements TrainRequirements {
    private Engine engine;
    private ArrayList<Car> cars;

    /*
     * constructor of the train
     * @param fuelType The type of fuel does the train contain
     * @param currentFuel The amount of fuel the train currently have
     * @param fuelCapacity The maximum amount of fuel the train able to hold
     * @param nCars The number of car that the train has
     * @param passengerCapacity The maximum number of passenger that each car can hold
     */
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
