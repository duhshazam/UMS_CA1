import java.util.ArrayList;
import java.util.List;


public class Department {
    private String departmentId;
    private String departmentName;
    private Professor departmentHead;
    private List<Professor> facultyMembers;
    private List<Course> courseOfferings;
    private Budget budget; // COMPOSITION: Department owns Budget

    // creates Department with Budget
    public Department(String departmentId, String departmentName, Professor head, double initialBudget) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHead = head;
        this.facultyMembers = new ArrayList<>();
        this.courseOfferings = new ArrayList<>();
        this.budget = new Budget(initialBudget); // COMPOSITION: Budget created with Department
    }

    //  Control faculty addition
    public void addFaculty(Professor professor) {
        if (!facultyMembers.contains(professor)) {
            facultyMembers.add(professor);
            System.out.println("[Department] " + professor.getName() + " added to " + departmentName);
        }
    }

    //  Control course offerings
    public void addCourseOffering(Course course) {
        if (!courseOfferings.contains(course)) {
            courseOfferings.add(course);
            System.out.println("[Department] " + course.getCourseCode() + " added to " + departmentName);
        }
    }

    //  Get faculty list (read-only)
    public List<Professor> getFacultyMembers() {
        return new ArrayList<>(facultyMembers); // Return copy to prevent external modification
    }

    // Get courses (read-only)
    public List<Course> getCourseOfferings() {
        return new ArrayList<>(courseOfferings);
    }

    //  Access budget through Department
    public Budget getBudget() {
        return budget;
    }

    // Display department info
    public void displayDepartmentInfo() {
        System.out.println("\n========== DEPARTMENT: " + departmentName + " ==========");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Head: " + departmentHead.getName());
        System.out.println("Faculty Members: " + facultyMembers.size());
        System.out.println("Courses Offered: " + courseOfferings.size());
        budget.displayBudgetInfo();
    }

    // Getters
    public String getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public Professor getDepartmentHead() { return departmentHead; }
}
