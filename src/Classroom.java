//associated with course
public class Classroom {
    private String classroomId;
    private String building;
    private String roomNumber;
    private int capacity;
    private boolean hasProjector;
    private boolean hasWhiteboard;
    private Course currentCourse; // Current course using this room

    public Classroom(String classroomId, String building, String roomNumber, int capacity,
                     boolean hasProjector, boolean hasWhiteboard) {
        this.classroomId = classroomId;
        this.building = building;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;
    }

    // ASSOCIATION: Assign course to classroom
    public void assignCourse(Course course) {
        if (capacity >= course.getEnrollmentCapacity()) {
            this.currentCourse = course;
            System.out.println("[Facility] Course " + course.getCourseCode() + " assigned to Room " + roomNumber);
        } else {
            System.out.println("[Facility] ERROR: Room capacity (" + capacity + ") insufficient for course");
        }
    }

    public void unassignCourse() {
        if (currentCourse != null) {
            System.out.println("[Facility] Course " + currentCourse.getCourseCode() + " unassigned from Room " + roomNumber);
            currentCourse = null;
        }
    }

    public String getClassroomId() { return classroomId; }
    public int getCapacity() { return capacity; }
    public Course getCurrentCourse() { return currentCourse; }
    public String getLocation() { return building + " - Room " + roomNumber; }

    public void displayClassroomInfo() {
        System.out.println("  Location: " + getLocation() + " | Capacity: " + capacity);
        System.out.println("  Projector: " + (hasProjector ? "Yes" : "No") + " | Whiteboard: " + (hasWhiteboard ? "Yes" : "No"));
        if (currentCourse != null) {
            System.out.println("  Current Course: " + currentCourse.getCourseCode());
        }
    }
}
