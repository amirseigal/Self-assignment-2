public class AGV {
    //Attributes
    private String id;
    private double batteryload;
    private double consumptionrate;
    private double chargingtime;
    private Position position;
    private double maxspeed;
    private double actspeed;

    //constructor

    AGV(String id,double batteryload, double consumptionrate, double chargingtime,
    		Position position, double maxspeed,double actspeed){
        this.id = id;
        this.batteryload = batteryload;
        this.consumptionrate = consumptionrate;
        this.chargingtime = chargingtime;
        this.position = position;
        this.maxspeed = maxspeed;
        this.actspeed = actspeed;
    }
    //Methods

    //getData
    String getId(){return this.id;}
    double getBatteryload(){return this.batteryload;}
    double getConsumptionrate(){return this.consumptionrate;}
    double getChargingtime(){return this.chargingtime;}
    public Position getPosition() { return position; }
    double getMaxspeed() {return this.maxspeed;}
    double getActspeed() {return this.actspeed;}


    //calculate the total energyconsumption of a AGV in an operation
    public double Energyconsumption(double hours){
        return this.consumptionrate * hours;
    }
}