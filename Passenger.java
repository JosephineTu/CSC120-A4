class Passenger implements PassengerRequirements{
    /**
     * Attributes
     */
    public String name;
    /**
     * Constructor
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }
    /**
     * boardCar
     * @param Car c
     * @return none
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            c.addPassenger(this);
        }
        else{
            System.out.println("Error: Car full.");
        }
    }
    /**
     * boardCar
     * @param Car c
     * @return none
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            c.removePassenger(this);
        }
        else{
            System.out.println("Error: Passenger not found.");
        }
    }
}
