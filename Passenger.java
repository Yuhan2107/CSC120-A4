public class Passenger implements PassengerRequirements {
    
    private String name;

    /*
     * the constructor of passenger
     * @param name The name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /*
     * accessor to passenger's name
     * @return The name of the passenger
     */
    public String getName() {
        return name;
    }

    /*
     * add a passenger to the car
     * @param c The car that that a new passenger is onboarding
     */
    @Override
    public void boardCar(Car c){
        c.addPassenger(this);
    }

    /*
     * remove a passenger from the car
     * @param c The car that the passenger is getting off
     */
    @Override
    public void getOffCar(Car c){
        c.removePassenger(this);
    }
}
