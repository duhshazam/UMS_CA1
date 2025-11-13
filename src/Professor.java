
class Professor extends Faculty implements Researchable {
    private String specialization;
    private int yearsOfExperience;

    public Professor(String personId, String name, String email, String phoneNumber,
                     String department, double salary, String specialization, int yearsOfExperience) {
        super(personId, name, email, phoneNumber, department, salary);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    // POLYMORPHISM
    @Override
    void displayDashboard() {
        System.out.println("\n========== PROFESSOR DASHBOARD ==========");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getPersonId());
        System.out.println("Department: " + getDepartment());
        System.out.println("Specialization: " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println(getFinancialSummary());
        System.out.println("Papers Published: " + getResearchProfile().getPapersCount());
        System.out.println("=========================================");
    }

    // Researchable interface methods
    @Override
    public void publishPaper(String title) {
        getResearchProfile().addPaper(title);
        System.out.println(getName() + " published paper: " + title);
    }

    @Override
    public void conductResearch(String topic) {
        System.out.println(getName() + " is conducting research on: " + topic);
    }

    @Override
    public void applyForGrant(String grantName) {
        System.out.println(getName() + " applied for grant: " + grantName);
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
