// INTERFACE: Teachable - for faculty who can teach
interface Teachable {
    void teach(Course course);
    void assignGrades(Student student, Course course, char grade);
    void holdOfficeHours();
}
