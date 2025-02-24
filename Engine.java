class Engine implements EngineRequirements{
    /**
     * Attributes
     */
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;
    /**
     * Constructor
     * @param f,currentFuelLevel,maxFuelLevel
     */
    Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f=f;
        this.currentFuelLevel=currentFuelLevel;
        this.maxFuelLevel=maxFuelLevel;
    }
    /**
     * getFuelType
     * @return FuelType
     */
    public FuelType getFuelType(){
        return this.f;
    }
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }
    public void refuel(){
        this.currentFuelLevel=this.maxFuelLevel;
    }
    public Boolean go(){
        this.currentFuelLevel-=10.0;
        if(this.currentFuelLevel>0.0){
            System.out.println("Fuel remaining:"+this.currentFuelLevel);
            return true;
        }
        else{
            System.out.println("Not enough fuel. Please refuel.");
            return false;
        }
        
    
    }
    public String toString(){
        return ("Engine has fuel type"+this.f+"Max fuel level"+this.maxFuelLevel+"Current fuel level"+this.currentFuelLevel);
    }
    public static void main(String[] args){
        Engine myEngine=new Engine(FuelType.ELECTRIC,0.0,1.0);
        String out=myEngine.toString();
        System.out.println(out);
    }
}