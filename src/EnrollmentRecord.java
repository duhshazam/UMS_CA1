
class EnrollmentRecord {
    private java.util.ArrayList<Course> enrolledCourses;
    private java.util.ArrayList<String> enrollmentDates;

    public EnrollmentRecord() {
        this.enrolledCourses = new java.util.ArrayList<>();
        this.enrollmentDates = new java.util.ArrayList<>();
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
        enrollmentDates.add(new java.util.Date().toString());
    }

    public void removeCourse(Course course) {
        enrolledCourses.remove(course);
    }

    public int getEnrolledCoursesCount() {
        return enrolledCourses.size();
    }

    public java.util.ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void displayEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled");
            return;
        }
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseCode() + ": " + course.getCourseName());
        }
    }
}
