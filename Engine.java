
public class Engine implements EngineRequirements {

    private FuelType fuelType;
    private double maxFuel;
    private double currentFuel;

    public Engine(FuelType fuelType, double currentFuel, double fuelCapacity){
        this.fuelType = fuelType;
        maxFuel = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    //accessors
   @Override
    public FuelType getFuelType() {
        return fuelType;
    }
    @Override
    public double getMaxFuel() {
        return maxFuel;
    }
    @Override
    public double getCurrentFuel() {
        return currentFuel;
    }

    @Override
    public void refuel(){
        currentFuel = maxFuel;
    }
    
    @Override
    public Boolean go(){
        if (currentFuel > 0){
            currentFuel -= 1;
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}