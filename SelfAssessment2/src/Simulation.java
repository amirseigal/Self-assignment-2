import java.util.*;
public class Simulation {
    public static void main(String[] args) {
        AGV agv1 = new AGV("AGV-1", 80.0, 0.5, 30.0, new Position(0,0), 1.5f, 1.2f);
        AGV agv2 = new AGV("AGV-2", 60.0, 0.6, 40.0,new Position(1,1), 1.4f, 1.1f);
        AGV agv3 = new AGV("AGV-3", 90.0, 0.4, 25.0, new Position(2,2), 1.6f, 1.3f);
        AGV agv4 = new AGV("AGV-4", 50.0, 0.55, 35.0, new Position(3,1), 1.3f, 1.0f);

        IOperation opA = new IOperation("Op-A", "Unload pallets", 15.0);
        opA.addResource(agv1);
        opA.addResource(agv2);

        IOperation opB = new IOperation("Op-B", "Move to storage", 30.0);
        opB.addResource(agv2);
        opB.addResource(agv3);

        IOperation opC = new IOperation("Op-C", "Sort items", 20.0);
        opC.addResource(agv3);

        IOperation opD = new IOperation("Op-D", "Load truck", 25.0);
        opD.addResource(agv1);
        opD.addResource(agv4);

        IndustrialProcess p1 = new IndustrialProcess("Process-1");
        p1.addOperation(opA);
        p1.addOperation(opB);
        p1.addOperation(opC);

        IndustrialProcess p2 = new IndustrialProcess("Process-2");
        p2.addOperation(opB);
        p2.addOperation(opD);

        List<IndustrialProcess> processes = Arrays.asList(p1, p2);

        for (IndustrialProcess p : processes) {
            System.out.println("========================================");
            System.out.println("Industrial Process: " + p.getId());
            System.out.printf("Total duration (min): %.2f%n", p.processDuration());
            System.out.println("Required AGV count (max simultaneous): " + p.requiredAGVCount());
            System.out.printf("Total energy consumption (unit): %.2f%n", p.totalEnergyConsumption());
            System.out.println("Detailed operations:");
            int idx=1;
            for (IOperation op : p.getOperations()) {
                System.out.printf("  %d) %s - duration: %.1f min - resources: %s - energy: %.2f%n",
                        idx++,
                        op.getId(),
                        op.getNominaltime(),
                        op.getResourceIds(),
                        op.totalenergyconsumption()
                );
            }
        }
    }
}

