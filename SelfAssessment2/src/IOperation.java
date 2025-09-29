import java.util.*;
public class IOperation {
    //Attributes
    private String id;
    private String description;
    private double nominaltime;
    private List<AGV> resources;


    //Constructor
    IOperation(String id, String description, double nominaltime) {
        this.id = id;
        this.description = description;
        this.nominaltime = nominaltime;
        this.resources = new ArrayList<>();
    }

    //Methods
    public void addResource(AGV agv) {
        if (agv != null) resources.add(agv);
    }
    //getData
    public String getId() {return id;}
    public double getNominaltime() {return nominaltime;}
    public String getDescription() {return description;}
    public List<AGV> getResources() {return Collections.unmodifiableList(resources);}


    //Energy Consumption of Total AGVs in an Operation
    public double totalenergyconsumption(){
        double total = 0;
        for (AGV agv : resources){
            total += agv.Energyconsumption(nominaltime);
        }
            return total;
    }
    public String getResourceIds(){
        List<String> ids = new ArrayList<>();
        for (AGV a : resources) ids.add(a.getId());
        return String.join(", ", ids);}
}


