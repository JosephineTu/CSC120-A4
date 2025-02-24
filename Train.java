import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Train implements TrainRequirements{
    private FuelType fuelType;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;
    private Engine engine;
    private ArrayList<Car> cars;
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.nCars=nCars;
        this.passengerCapacity=passengerCapacity;
        this.engine=new Engine(fuelType,fuelCapacity,fuelCapacity);
        this.cars=new ArrayList<Car>();
        for (int i=0;i<nCars;i++){
            ArrayList<Passenger> passengers=new ArrayList<Passenger>();
            Car c=new Car(passengers,passengerCapacity);
            this.cars.add(c);
        }
    }
    public Engine getEngine(){
        return this.engine;
    }
    public Car getCar(int i){
        Car car=this.cars.get(i);
        return car;
    }
    public int getMaxCapacity(){
        int max=this.nCars * this.passengerCapacity;
        return max;
    }
    public int seatsRemaining(){
        int remain=0;
        for (int i=0;i<this.cars.size();i++){
            remain+=this.cars.get(i).seatsRemaining();
        }
        return remain;
    }
    public void printManifest(){
        for (int i=1;i<this.nCars+1;i++){
            System.out.println("Car"+i);
            this.getCar(i-1).printManifest();
        }
        
    }
    public void boardTrain(Passenger p){
        if (this.seatsRemaining()>0){
            Scanner input=new Scanner(System.in);
            Boolean onBoard=false;
            while(onBoard==false){
                System.out.println("Which train do you want to board: ");
                int i=input.nextInt();
                if (this.getCar(i-1).seatsRemaining()==0 || i>this.nCars){
                    System.out.println("The current choice is unavailable.");
                }
                else{
                    this.getCar(i-1).addPassenger(p);
                    onBoard=true;
                }
            }
        }
        else{
            System.out.println("Car currently full.");
        }
    }
    public void getoffTrain(Passenger p){
        Boolean removed=false;
        while (removed==false){
            int i=0;
            Car car=this.getCar(i);
            removed=car.removePassenger(p);
            i++;
        }
    }
    public static void main(String[] args){
        Train myTrain=new Train(FuelType.ELECTRIC,50.0,3,2);
        Scanner inputStr1=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name1=inputStr1.nextLine();
        Passenger p1=new Passenger(name1);
        myTrain.boardTrain(p1);
        Scanner inputStr2=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name2=inputStr2.nextLine();
        Passenger p2=new Passenger(name2);
        myTrain.boardTrain(p2);
        Scanner inputStr3=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name3=inputStr3.nextLine();
        Passenger p3=new Passenger(name3);
        myTrain.boardTrain(p3);
        myTrain.printManifest();
        Random rand=new Random();
        int stops=rand.nextInt(7);
        for(int i=0;i<stops;i++){
            if(myTrain.engine.go()==true){
                myTrain.engine.go();
                System.out.println("Going...");
            }
            else{
                System.out.println("Refueling...");
                myTrain.engine.refuel();
                myTrain.engine.go();
                System.out.println("Going...");
            }
            System.out.println("Here we are!");
        }
        myTrain.getoffTrain(p1);
        myTrain.printManifest();


    }

}



