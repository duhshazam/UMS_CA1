
abstract class Person {
    // ENCAPSULATION: Private fields - data is protected
    private String personId;
    private String name;
    private String email;
    private String phoneNumber;

    // Constructor
    public Person(String personId, String name, String email, String phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // ABSTRACT METHODS: Subclasses MUST implement these
    // DEMONSTRATES: ABSTRACTION
    abstract String getRole();
    abstract void displayDashboard();

    // Getters - ENCAPSULATION: Controlled access to private data
    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method: Display personal info
    public void displayPersonalInfo() {
        System.out.println("ID: " + personId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }
}
