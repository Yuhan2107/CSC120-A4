import java.util.ArrayList;

public class Car implements CarRequirements {

    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /*
     * the constructor of the car
     * @param passengerCapacity The maximum number of passengers that the car could contain
     */
    public Car(int passengerCapacity){
        passengers = new ArrayList<>();
        maxCapacity = passengerCapacity;
    }

    /*
     * accessor to the maxCapacity
     * @return The maximum capacity of the car
     */
    @Override
    public int getCapacity(){
        return maxCapacity;
    }

    /*
     * calculate the seats that remains in the car
     * @return The number of seats remaining in the car
     */
    @Override
    public int seatsRemaining(){
        return maxCapacity - passengers.size();
    }

    /*
     * check whether a new passenger can onboard the car. If it can, do so
     * @param p The new passenger onboarding the car
     * @return Whether the passenger can get on to the car
     */
    @Override
    public Boolean addPassenger(Passenger p){
        int seatsRemaining = seatsRemaining();
        if (seatsRemaining > 0){
            if (!passengers.contains(p))
                passengers.add(p);
            return true;
        } else{
            return false;
        }
    }

    /*
     * check whether there's a specific passenger that can get off from the car
     * @param p The name of the passenger
     * @return Whether the passenger is originally on the car
     */
    @Override
    public Boolean removePassenger(Passenger p){
        if (passengers.contains(p)){
            passengers.remove(p);
            return true;
        } else{
            return false;
        }
    }

    /*
     * print out the passengers name 
     */
    @Override
    public void printManifest(){
        if (passengers.size() == 0){
            System.out.println("This car is empty.");
        } else{
            System.out.println("Passenger Manifest:");
            for (Passenger p : passengers) {
                System.out.println(p.getName());
            }
        }
    }
}