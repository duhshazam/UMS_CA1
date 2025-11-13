//owned by graduate students
public class Alumni {
    private String alumniId;
    private String name;
    private String graduationYear;
    private String degree;
    private String currentEmployment;
    private String email;

    public Alumni(String alumniId, String name, String graduationYear, String degree) {
        this.alumniId = alumniId;
        this.name = name;
        this.graduationYear = graduationYear;
        this.degree = degree;
        this.currentEmployment = "Unknown";
    }

    // Update employment information
    public void updateEmployment(String company, String position) {
        this.currentEmployment = position + " at " + company;
        System.out.println("[Alumni] " + name + " employment updated: " + currentEmployment);
    }

    public void displayAlumniInfo() {
        System.out.println("  Alumnus: " + name + " (" + graduationYear + ")");
        System.out.println("  Degree: " + degree);
        System.out.println("  Employment: " + currentEmployment);
    }

    public String getName() { return name; }
    public String getDegree() { return degree; }
}
AC