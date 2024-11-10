import java.util.Random;

enum WorkPriority {NON_ESSENTIAL, MODERATE, ESSENTIAL;

    public String getDescription() {
        return "PLACEHOLDER";
    }
}

public class WorkAssignment {

    private String name;
    private double percentComplete;
    private final WorkPriority workPriority;
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public WorkAssignment(String name, WorkPriority workPriority) {
        this.name = name;
        this.workPriority = workPriority;
    }

    public String getName() {
        return name;
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(double percentComplete) {
        this.percentComplete = percentComplete;
    }

    public WorkPriority getWorkPriority() {
        return workPriority;
    }

    public static WorkAssignment getRandomWorkAssignment() {
        Random random = new Random();
        String rn = alphabet.charAt(random.nextInt(alphabet.length())) + "" + random.nextInt(2222, 8888);
        WorkPriority wp = WorkPriority.values()[random.nextInt(WorkPriority.values().length)];
        WorkAssignment wa = new WorkAssignment(rn, wp);
        wa.setPercentComplete(random.nextDouble(1, 100));
        return wa;
    }
}
