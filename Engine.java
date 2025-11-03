
public class Engine implements EngineRequirements {

    private FuelType fuelType;
    private double maxFuel;
    private double currentFuel;

    /**
     * constructor of train's engine
     * @param fuelType The type of fuel the train have
     * @param currentFual The amount of fuel the train have recently
     * @param fuelCapacity The maximum amount of fuel the train can hold
     */
    public Engine(FuelType fuelType, double currentFuel, double fuelCapacity){
        this.fuelType = fuelType;
        maxFuel = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    /**
     * accessor to the fuel type 
     * @return the type of fuel
     */ 
   @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * accessor to the maxFuel
     * @return The maximum amount of fuel that the engine can contain
     */
    @Override
    public double getMaxFuel() {
        return maxFuel;
    }

    /**
     * accessor to the currentFuel
     * @return The fuel left in the engine currently
     */
    @Override
    public double getCurrentFuel() {
        return currentFuel;
    }

    /**
     * refuel the engine
     */
    @Override
    public void refuel(){
        currentFuel = maxFuel;
    }
    
    /**
     * consume the fuel while the train is traveling, and return false when there's no more fuels to support traveling.
     * @return Whether the current engine can support the further traveling
     */
    @Override
    public Boolean go(){
        if (currentFuel > 0){
            currentFuel -= 1;
            return true;
        } else{
            return false;
        }
    }

    /**
     * make up an engine to check whether the previous methods work
     */
    public static void main(String[] args){
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}