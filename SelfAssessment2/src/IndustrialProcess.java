import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndustrialProcess {
    private String id;
    private List<IOperation> operations;

    //constructor
    public IndustrialProcess(String id){
        this.id = id;
        this.operations = new ArrayList<>();
    }

    public String getId() { return id; }
    public void addOperation(IOperation op) { if (op != null) operations.add(op); }
    public List<IOperation> getOperations() { return Collections.unmodifiableList(operations); }

    //total time of operations
    public double processDuration() {
        double total = 0.0;
        for (IOperation op : operations) total += op.getNominaltime();
        return total;
    }

    //total energy of Industrial Process
    public double IndustrialProcessEnergy(){
        double total = 0;
        for(IOperation op : operations){
            total += op.totalenergyconsumption();
        }
        return total;
    }

    public double totalEnergyConsumption() {
        double sum = 0.0;
        for (IOperation op : operations) sum += op.totalenergyconsumption();
        return sum;
    }

    public int requiredAGVCount() {
        int max = 0;
        for (IOperation op : operations) {
            int s = op.getResources().size();
            if (s > max) max = s;
        }
        return max;
    }






}
