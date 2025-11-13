
class GraduateStudent extends Student {
    // COMPOSITION
    private Professor thesis;
    private String researchTopic;

    public GraduateStudent(String personId, String name, String email, String phoneNumber, String researchTopic) {
        super(personId, name, email, phoneNumber, "Graduate");
        this.researchTopic = researchTopic;
        this.thesis = null;
        this.setTuitionFees(18000); // Graduate tuition
    }

    // POLYMORPHISM
    @Override
    void displayDashboard() {
        System.out.println("\n========== GRADUATE STUDENT DASHBOARD ==========");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getPersonId());
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("GPA: " + String.format("%.2f", getGPA()));
        System.out.println("Courses Enrolled: " + getEnrollmentRecord().getEnrolledCoursesCount());
        System.out.println("Thesis Advisor: " + (thesis != null ? thesis.getName() : "Not assigned"));
        System.out.println(getFinancialSummary());
        System.out.println("===============================================");
    }

    public void assignThesisAdvisor(Professor advisor) {
        this.thesis = advisor;
        System.out.println(getName() + "'s thesis advisor assigned: " + advisor.getName());
    }

    public Professor getThesisAdvisor() {
        return thesis;
    }

    public String getResearchTopic() {
        return researchTopic;
    }
}
