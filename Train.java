import java.util.ArrayList;

public class Train implements TrainRequirements {
    
    ArrayList<Car> cars;
    Engine engine;
    FuelType fuelType;
    double currentFuel;
    double fuelCapacity;
    int nCars;
    int passengerCapacity;

    public Train(FuelType fuelType, double currentFuel, double fuelCapacity, int nCars, int passengerCapacity){
        cars = new ArrayList<>(nCars);
        engine = new Engine(fuelType, currentFuel, fuelCapacity);
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public Engine getEngine(){ 
        return engine;
    }
    @Override
    public Car getCar(int i){
        return cars.get(i);
    }
    @Override
    public int getMaxCapacity(){
        return nCars * passengerCapacity;
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
        for (int i = 0; i < cars.size(); i++){
            System.out.println("Car " + (i+1) + ":");
            cars.get(i).printManifest();
        }
    }

}
