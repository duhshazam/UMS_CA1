// ASSOCIATION: Office assigned to Faculty member
// One-to-One relationship
public class Office {
    private String officeId;
    private String building;
    private String roomNumber;
    private Professor occupant;
    private String officePhone;

    public Office(String officeId, String building, String roomNumber, String officePhone) {
        this.officeId = officeId;
        this.building = building;
        this.roomNumber = roomNumber;
        this.officePhone = officePhone;
    }

    // ASSOCIATION: Assign professor to office
    public void assignProfessor(Professor professor) {
        this.occupant = professor;
        System.out.println("[Facility] Office " + roomNumber + " assigned to Prof. " + professor.getName());
    }

    public String getOfficeId() { return officeId; }
    public Professor getOccupant() { return occupant; }
    public String getLocation() { return building + " - " + roomNumber; }

    public void displayOfficeInfo() {
        System.out.println("  Office: " + getLocation() + " | Phone: " + officePhone);
        if (occupant != null) {
            System.out.println("  Occupant: Prof. " + occupant.getName());
        }
    }
}
