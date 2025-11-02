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

    @Override
    public int getCapacity(){
        return maxCapacity;
    }
    @Override
    public int seatsRemaining(){
        return maxCapacity - passengers.size();

    }
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
    @Override
    public Boolean removePassenger(Passenger p){
        if (passengers.contains(p)){
            passengers.remove(p);
            return true;
        } else{
            return false;
        }
    }
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