
class Course {
    // ENCAPSULATION
    private String courseCode;
    private String courseName;
    private int creditHours;
    private int capacity;
    private int enrolledCount;

    // COMPOSITION
    private Syllabus syllabus;

    // AGGREGATION
    // ASSOCIATION
    private Professor instructor;
    private java.util.ArrayList<Student> enrolledStudents;
    private java.util.ArrayList<String> prerequisites;

    // Constructor
    public Course(String courseCode, String courseName, int creditHours, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.capacity = capacity;
        this.enrolledCount = 0;
        // COMPOSITION
        this.syllabus = new Syllabus(courseCode, courseName);
        this.instructor = null;
        this.enrolledStudents = new java.util.ArrayList<>();
        this.prerequisites = new java.util.ArrayList<>();
    }

    // ENCAPSULATION
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public Professor getInstructor() {
        return instructor;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    // AGGREGATION
    public void assignInstructor(Professor professor) {
        this.instructor = professor;
        System.out.println(professor.getName() + " assigned to teach " + courseName);
    }

    // Method to add prerequisite
    public void addPrerequisite(String courseCode) {
        prerequisites.add(courseCode);
    }

    // Method to check if course has prerequisites
    public boolean hasPrerequisites() {
        return !prerequisites.isEmpty();
    }

    public java.util.ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    // ENCAPSULATION
    public boolean addStudent(Student student) {
        if (enrolledCount < capacity) {
            enrolledStudents.add(student);
            enrolledCount++;
            return true;
        } else {
            System.out.println("Course " + courseName + " is full!");
            return false;
        }
    }

    // Remove student from course
    public void removeStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            enrolledCount--;
            System.out.println(student.getName() + " removed from " + courseName);
        }
    }

    // ASSOCIATION
    public java.util.ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Display course information
    public void displayCourseInfo() {
        System.out.println("\n--- Course: " + courseName + " ---");
        System.out.println("Code: " + courseCode);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Enrolled: " + enrolledCount + "/" + capacity);
        System.out.println("Instructor: " + (instructor != null ? instructor.getName() : "Not assigned"));
    }
}
