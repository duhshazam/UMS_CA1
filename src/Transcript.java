// CLASS: Transcript - Student transcript
// DEMONSTRATES: COMPOSITION (owned by Student)
class Transcript {
    private java.util.HashMap<String, Character> grades; // courseCode -> grade

    public Transcript() {
        this.grades = new java.util.HashMap<>();
    }

    // Add grade to transcript
    public void addGrade(String courseCode, char grade) {
        grades.put(courseCode, grade);
    }

    // Calculate GPA based on grades
    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;

        double totalPoints = 0;
        int count = 0;

        for (char grade : grades.values()) {
            totalPoints += gradeToPoints(grade);
            count++;
        }

        return totalPoints / count;
    }

    // Convert letter grade to points (4.0 scale)
    private double gradeToPoints(char grade) {
        switch(grade) {
            case 'A': return 4.0;
            case 'B': return 3.0;
            case 'C': return 2.0;
            case 'D': return 1.0;
            case 'F': return 0.0;
            default: return 0.0;
        }
    }

    // Display transcript
    public void displayTranscript() {
        System.out.println("\n--- Transcript ---");
        for (String course : grades.keySet()) {
            System.out.println(course + ": " + grades.get(course));
        }
        System.out.println("GPA: " + String.format("%.2f", calculateGPA()));
    }

    public java.util.HashMap<String, Character> getGrades() {
        return grades;
    }
}
