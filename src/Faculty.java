
abstract class Faculty extends Person implements Teachable, Payable {
    // ENCAPSULATION
    private double salary;
    private String department;
    private String employmentStatus;

    // COMPOSITION
    private ResearchProfile researchProfile;

    // Constructor
    public Faculty(String personId, String name, String email, String phoneNumber, String department, double salary) {
        super(personId, name, email, phoneNumber);
        this.department = department;
        this.salary = salary;
        this.employmentStatus = "Active";
        // COMPOSITION: Creating owned object
        this.researchProfile = new ResearchProfile();
    }

    // POLYMORPHISM
    @Override
    String getRole() {
        return "Faculty";
    }

    // POLYMORPHISM
    @Override
    abstract void displayDashboard();

    // Teachable interface methods
    @Override
    public void teach(Course course) {
        System.out.println(getName() + " is teaching " + course.getCourseName());
    }

    @Override
    public void assignGrades(Student student, Course course, char grade) {
        // ENCAPSULATION: Add grade to student's transcript through controlled method
        student.getTranscript().addGrade(course.getCourseCode(), grade);
        System.out.println("Grade " + grade + " assigned to " + student.getName() + " for " + course.getCourseName());
    }

    @Override
    public void holdOfficeHours() {
        System.out.println(getName() + " is holding office hours");
    }

    // Payable interface methods
    @Override
    public void processPayment(double amount) {
        System.out.println(getName() + " salary payment processed: $" + amount);
    }

    @Override
    public void generateInvoice() {
        System.out.println("\n=== Salary Invoice for " + getName() + " ===");
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }

    @Override
    public String getFinancialSummary() {
        return "Salary: $" + salary;
    }

    // ENCAPSULATION]
    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public ResearchProfile getResearchProfile() {
        return researchProfile;
    }

    // ENCAPSULATION
    protected void setSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        }
    }
}
