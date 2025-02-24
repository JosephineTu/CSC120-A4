import java.util.ArrayList;
import java.util.Arrays;
class Car implements CarRequirements{
    /**
     * Attributes
     */
    private ArrayList<Passenger> passengersOnBoard;
    private int maxCapacity;
    /**
     * Constructor
     * @param passengersOnBoard
     * @param maxCapacity
     */
    public Car (ArrayList<Passenger> passengersOnBoard, int maxCapacity){
        this.passengersOnBoard=passengersOnBoard;
        this.maxCapacity=maxCapacity;
    }
    /**
     * Accessor getCapacity()
     * @return num, the max capacity
     */
    public int getCapacity(){
        int num=this.maxCapacity;
        return num;
    }
    /**
     * Accessor seatsRemaining()
     * @return r, the number of seats remaining
     */
    public int seatsRemaining(){
        int r=this.maxCapacity-this.passengersOnBoard.size();
        return r;
    }
    /**
     * Setter addPassenger(Passenger p)
     * @param Passenger p, the passenger object
     * @return true or false, indicating whether successfully added or not
     */
    public Boolean addPassenger(Passenger p){
        if (this.passengersOnBoard.size()<this.maxCapacity){
            this.passengersOnBoard.add(p);
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Setter removePassenger(Passenger p)
     * 
     */
    public Boolean removePassenger(Passenger p){
        if (this.passengersOnBoard.contains(p)){
            this.passengersOnBoard.remove(p);
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Print the names of all the passengers on the car
     */
    public void printManifest(){
        int i=0;
        for (Passenger p: this.passengersOnBoard){
            System.out.println("Passenger"+(i+1)+": "+p.name);
            i++;
        }
    }
    /**
     * main 
     * @param args
     */
    public static void main(String[] args) {
        Passenger ada = new Passenger("Ada");
        Passenger bob = new Passenger("Bob");
        Passenger carmen = new Passenger("Carmen");
        // create a car object
        ArrayList<Passenger> passengersA = new ArrayList<Passenger>(Arrays.asList(ada, bob, carmen));
        Car a = new Car(passengersA, 5);
        // Test getCapacity()
        int capA = a.getCapacity();
        System.out.println("Car a, max capacity: " + capA);
        // Test seatsRemaining()
        int seatsA = a.seatsRemaining();
        System.out.println("Car a, seats remaining: " + seatsA);
        // Test addPassenger()
        Passenger dan = new Passenger("Dan");
        Boolean m = a.addPassenger(dan);
        // Test removePassenger()
        Boolean n = a.removePassenger(bob);  
        // Test printManifest()
        a.printManifest();
    }
}