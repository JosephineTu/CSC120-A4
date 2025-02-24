import java.util.ArrayList;
import java.util.Arrays;
class Car implements CarRequirements{
    /**
     * Attributes
     */
    private ArrayList<Passenger> passengersOnBoard;
    private int maxCapacity;

    public Car (ArrayList<Passenger> passengersOnBoard, int maxCapacity){
        this.passengersOnBoard=passengersOnBoard;
        this.maxCapacity=maxCapacity;
    }
    public int getCapacity(){
        int num=this.maxCapacity;
        return num;
    }
    public int seatsRemaining(){
        int r=this.maxCapacity-this.passengersOnBoard.size();
        return r;
    }
    public Boolean addPassenger(Passenger p){
        if (this.passengersOnBoard.size()<this.maxCapacity){
            this.passengersOnBoard.add(p);
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean removePassenger(Passenger p){
        if (this.passengersOnBoard.contains(p)){
            this.passengersOnBoard.remove(p);
            return true;
        }
        else{
            return false;
        }
    }
    public void printManifest(){
        int i=0;
        for (Passenger p: this.passengersOnBoard){
            System.out.println(p.name);
            i++;
        }
    }
    public static void main(String[] args) {
        Passenger ada = new Passenger("Ada");
        Passenger bob = new Passenger("Bob");
        Passenger carmen = new Passenger("Carmen");

        
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