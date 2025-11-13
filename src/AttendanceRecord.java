// BONUS: Track student attendance in courses
public class AttendanceRecord {
    private String attendanceId;
    private Student student;
    private Course course;
    private int totalClasses;
    private int attendedClasses;

    public AttendanceRecord(String attendanceId, Student student, Course course, int totalClasses) {
        this.attendanceId = attendanceId;
        this.student = student;
        this.course = course;
        this.totalClasses = totalClasses;
        this.attendedClasses = 0;
    }

    // Mark attendance
    public void markAttendance() {
        if (attendedClasses < totalClasses) {
            attendedClasses++;
        }
    }

    // Calculate attendance percentage
    public double getAttendancePercentage() {
        return (double) attendedClasses / totalClasses * 100;
    }

    public void displayAttendanceInfo() {
        System.out.println("  Course: " + course.getCourseCode() + " | Attendance: " + attendedClasses + "/" + totalClasses +
                " (" + String.format("%.1f", getAttendancePercentage()) + "%)");
    }
}
