public class Project {
    private String name, description, startDate, endDate, manager, status;
    private double budget;

    public Project(String name, String description, String startDate, String endDate,
                   String manager, String status, double budget) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.manager = manager;
        this.status = status;
        this.budget = budget;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getManager() { return manager; }
    public String getStatus() { return status; }
    public double getBudget() { return budget; }
}
