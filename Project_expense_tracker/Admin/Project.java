public class Project {
    private int id;
    private String name, description, startDate, endDate, manager, status, specialRequirements, clientInfo;
    private double budget;

    public Project(String name, String description, String startDate, String endDate, String manager, String status, double budget, String specialRequirements, String clientInfo) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.manager = manager;
        this.status = status;
        this.budget = budget;
        this.specialRequirements = specialRequirements;
        this.clientInfo = clientInfo;
    }

    // Add getters and setters here...
}
