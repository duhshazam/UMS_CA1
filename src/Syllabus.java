//owned by course
class Syllabus {
    private String courseCode;
    private String courseName;
    private String description;
    private java.util.ArrayList<String> topics;

    public Syllabus(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = "";
        this.topics = new java.util.ArrayList<>();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTopic(String topic) {
        topics.add(topic);
    }

    public void displaySyllabus() {
        System.out.println("\n=== Syllabus for " + courseName + " ===");
        System.out.println("Description: " + description);
        System.out.println("Topics: " + topics);
    }
}
