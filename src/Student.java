
abstract class Student extends Person implements Enrollable, Payable {
    // COMPOSITION
    private Transcript transcript;
    private EnrollmentRecord enrollmentRecord;

    // ENCAPSULATION
    private String studentType;
    private double tuitionFees;
    private boolean isActive;

    // Constructor
    public Student(String personId, String name, String email, String phoneNumber, String studentType) {
        super(personId, name, email, phoneNumber);
        this.studentType = studentType;
        // COMPOSITION: Creating owned objects when student is created
        this.transcript = new Transcript();
        this.enrollmentRecord = new EnrollmentRecord();
        this.isActive = true;
    }

    // ENCAPSULATION
    public double getGPA() {
        return transcript.calculateGPA();
    }

    // POLYMORPHISM
    @Override
    String getRole() {
        return studentType;
    }

    // POLYMORPHISM
    @Override
    abstract void displayDashboard();

    // Enrollable interface methods
    @Override
    public void enrollInCourse(Course course) {
        if (enrollmentRecord.getEnrolledCoursesCount() < 6) {
            enrollmentRecord.addCourse(course);
            System.out.println(getName() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Cannot enroll: Maximum course limit reached!");
        }
    }

    @Override
    public void dropCourse(Course course) {
        enrollmentRecord.removeCourse(course);
        System.out.println(getName() + " dropped " + course.getCourseName());
    }

    @Override
    public void viewSchedule() {
        System.out.println("\n=== " + getName() + "'s Schedule ===");
        enrollmentRecord.displayEnrolledCourses();
    }

    // Payable interface methods
    @Override
    public void processPayment(double amount) {
        if (amount > 0) {
            tuitionFees -= amount;
            System.out.println(getName() + " paid $" + amount + ". Remaining: $" + tuitionFees);
        }
    }

    @Override
    public void generateInvoice() {
        System.out.println("\n=== Invoice for " + getName() + " ===");
        System.out.println("Outstanding Tuition: $" + tuitionFees);
    }

    @Override
    public String getFinancialSummary() {
        return "Outstanding Fees: $" + tuitionFees;
    }

    // Getter methods - ENCAPSULATION
    public Transcript getTranscript() {
        return transcript;
    }

    public EnrollmentRecord getEnrollmentRecord() {
        return enrollmentRecord;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    // Setter method - ENCAPSULATION: Controlled modification
    public void setTuitionFees(double fees) {
        if (fees > 0) {
            this.tuitionFees = fees;
        }
    }
}
