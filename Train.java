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

    /*
     * accessor to the engine
     * @return The engine's information
     */
    @Override
    public Engine getEngine(){ 
        return engine;
    }

    /*
     * return cars' information in this train
     * @param i The amount of cars that the train have
     * @return The information of the cars in the train
     */
    @Override
    public Car getCar(int i){
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }
        return null;
    }

    /*
     * return the maximum capacity of the whole train by adding each car's maximum capacity individually
     * @return The maximum capacity of the whole train
     */
    @Override
    public int getMaxCapacity(){
        int total = 0;
        for (Car car : cars) {
            total += car.getCapacity();
        }
        return total;
    }

    /*
     * return the remaining number of seats that the train has
     * @return The remainning seats in the train
     */
    @Override
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for (int i = 0; i < cars.size(); i++){
            seatsRemaining += cars.get(i).seatsRemaining();
        }
        return seatsRemaining;
    }

    /*
     * print out the passengers in the train
     */
    @Override
    public void printManifest(){
        System.out.println("Train Manifest:");
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + (i+1) + ":");
            cars.get(i).printManifest();
        }
    }

}
