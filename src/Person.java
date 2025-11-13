
abstract class Person {
    // ENCAPSULATION
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


    // ABSTRACTION
    abstract String getRole();
    abstract void displayDashboard();

    // ENCAPSULATION
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

    // Method
    public void displayPersonalInfo() {
        System.out.println("ID: " + personId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }
}
