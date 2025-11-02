public class Passenger implements PassengerRequirements {
    
    private String name;

    /*
     * the constructor of passenger
     * @param name The name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void boardCar(Car c){
        c.addPassenger(this);
    }
    @Override
    public void getOffCar(Car c){
        c.removePassenger(this);
    }
}
