// MAIN CLASS: TechVerse University Management System
// PURPOSE: Demonstrates all 8 OOP concepts in action
// DEMONSTRATES: All concepts - ENCAPSULATION, INHERITANCE, POLYMORPHISM,
//               ABSTRACTION, INTERFACES, COMPOSITION, AGGREGATION, ASSOCIATION

public class Main {

    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("   WELCOME TO TECHVERSE UNIVERSITY MANAGEMENT SYSTEM");
        System.out.println("   Academic Operations Demo - All 8 OOP Concepts");
        System.out.println("=".repeat(70));

        // ===== STEP 1: Create Faculty Members (INHERITANCE, POLYMORPHISM) =====
        System.out.println("\n\n--- STEP 1: Creating Faculty Members ---");

        Professor prof1 = new Professor(
                "FAC001",
                "Dr. Robert Smith",
                "robert.smith@techverse.edu",
                "555-1001",
                "Computer Science",
                80000,
                "Artificial Intelligence",
                10
        );

        Professor prof2 = new Professor(
                "FAC002",
                "Dr. Sarah Johnson",
                "sarah.johnson@techverse.edu",
                "555-1002",
                "Computer Science",
                75000,
                "Database Systems",
                8
        );

        System.out.println("✓ Created Professor: " + prof1.getName());
        System.out.println("✓ Created Professor: " + prof2.getName());


        // ===== STEP 2: Create Courses (COMPOSITION, AGGREGATION) =====
        System.out.println("\n\n--- STEP 2: Creating Courses ---");

        // COMPOSITION: Course creates its own Syllabus (strong ownership)
        Course cs101 = new Course("CS101", "Introduction to Programming", 4, 30);
        Course cs201 = new Course("CS201", "Data Structures", 4, 25);
        Course cs301 = new Course("CS301", "Advanced Algorithms", 4, 20);

        // AGGREGATION: Assign professors to courses (professors exist independently)
        cs101.assignInstructor(prof1);
        cs201.assignInstructor(prof2);
        cs301.assignInstructor(prof1);

        // Add prerequisites (CS101 → CS201 → CS301)
        cs201.addPrerequisite("CS101");
        cs301.addPrerequisite("CS201");

        System.out.println("✓ Created Course: " + cs101.getCourseName());
        System.out.println("✓ Created Course: " + cs201.getCourseName());
        System.out.println("✓ Created Course: " + cs301.getCourseName());


        // ===== STEP 3: Create Students (INHERITANCE, ENCAPSULATION) =====
        System.out.println("\n\n--- STEP 3: Creating Students ---");

        // INHERITANCE: Create different types of students
        UndergraduateStudent student1 = new UndergraduateStudent(
                "STU001",
                "Alice Brown",
                "alice.brown@techverse.edu",
                "555-2001",
                "Computer Science"
        );

        UndergraduateStudent student2 = new UndergraduateStudent(
                "STU002",
                "Bob Davis",
                "bob.davis@techverse.edu",
                "555-2002",
                "Computer Science"
        );

        GraduateStudent student3 = new GraduateStudent(
                "STU003",
                "Carol Wilson",
                "carol.wilson@techverse.edu",
                "555-2003",
                "Data Science",
                "Machine Learning"
        );

        System.out.println("✓ Created Undergraduate Student: " + student1.getName());
        System.out.println("✓ Created Undergraduate Student: " + student2.getName());
        System.out.println("✓ Created Graduate Student: " + student3.getName());


        // ===== STEP 4: Student Enrollment (ASSOCIATION, ENCAPSULATION) =====
        System.out.println("\n\n--- STEP 4: Enrolling Students in Courses ---");

        // ASSOCIATION: Many-to-Many relationship (Students ↔ Courses)
        if (student1.enrollInCourse(cs101)) {
            System.out.println("✓ " + student1.getName() + " enrolled in " + cs101.getCourseName());
        }

        if (student2.enrollInCourse(cs101)) {
            System.out.println("✓ " + student2.getName() + " enrolled in " + cs101.getCourseName());
        }

        if (student3.enrollInCourse(cs201)) {
            System.out.println("✓ " + student3.getName() + " enrolled in " + cs201.getCourseName());
        }

        // ENCAPSULATION: Prevent enrollment due to capacity
        System.out.println("\n--- Testing Course Capacity Limit (CS101 capacity: 30) ---");
        if (student1.enrollInCourse(cs101)) {
            System.out.println("✓ Additional enrollment successful");
        }

        // Try to enroll student without meeting prerequisites
        System.out.println("\n--- Testing Prerequisite Checking ---");
        if (!student1.enrollInCourse(cs301)) {
            System.out.println("✗ Cannot enroll: Student hasn't completed CS201 prerequisite");
        }


        // ===== STEP 5: Recording Grades (ENCAPSULATION, COMPOSITION) =====
        System.out.println("\n\n--- STEP 5: Recording Grades ---");

        // COMPOSITION: Transcript is part of Student (strong ownership)
        // ENCAPSULATION: Cannot directly access transcript, must use updateGrade()
        student1.updateGrade("CS101", "A");
        student1.updateGrade("CS101", "A");  // Update with new grade

        student2.updateGrade("CS101", "B+");

        student3.updateGrade("CS201", "A-");

        System.out.println("✓ Grades recorded for students in their courses");


        // ===== STEP 6: Calculate GPA (ENCAPSULATION) =====
        System.out.println("\n\n--- STEP 6: Calculating GPA (Private Data Protection) ---");

        // ENCAPSULATION: Cannot access GPA directly, must call calculateGPA()
        double gpa1 = student1.getGPA();
        double gpa2 = student2.getGPA();
        double gpa3 = student3.getGPA();

        System.out.println("✓ " + student1.getName() + " GPA: " + String.format("%.2f", gpa1));
        System.out.println("✓ " + student2.getName() + " GPA: " + String.format("%.2f", gpa2));
        System.out.println("✓ " + student3.getName() + " GPA: " + String.format("%.2f", gpa3));


        // ===== STEP 7: Display Dashboards (POLYMORPHISM) =====
        System.out.println("\n\n--- STEP 7: Role-Specific Dashboards (POLYMORPHISM) ---");

        // POLYMORPHISM: Each class displays different dashboard
        student1.displayDashboard();
        student3.displayDashboard();
        prof1.displayDashboard();


        // ===== STEP 8: Financial Operations (INTERFACES, ENCAPSULATION) =====
        System.out.println("\n\n--- STEP 8: Financial Operations ---");

        // INTERFACES: Payable interface - students pay tuition
        System.out.println("\n[Student Payments - Payable Interface]");
        System.out.println(student1.getFinancialSummary());

        student1.recordPayment(5000);
        System.out.println("Payment recorded: $5000");
        System.out.println(student1.getFinancialSummary());

        // INTERFACES: Payable interface - faculty receive salaries
        System.out.println("\n[Faculty Salary - Payable Interface]");
        System.out.println(prof1.getFinancialSummary());


        // ===== STEP 9: Research Activities (INTERFACES) =====
        System.out.println("\n\n--- STEP 9: Research Activities (Researchable Interface) ---");

        // INTERFACES: Researchable interface - professors publish papers
        prof1.publishPaper("AI in Education: A Comprehensive Study");
        prof1.publishPaper("Deep Learning Applications");
        prof1.conductResearch("Neural Networks");
        prof1.applyForGrant("NSF Research Grant 2024");

        // INTERFACES: Researchable interface - graduate students can research too
        student3.publishPaper("Distributed Machine Learning Systems");
        student3.conductResearch("Federated Learning");

        System.out.println("\n✓ Research activities recorded");


        // ===== STEP 10: Display Course Information =====
        System.out.println("\n\n--- STEP 10: Course Information and Enrollment ---");

        cs101.displayCourseInfo();
        System.out.println("Enrolled students: " + cs101.getEnrolledStudents().size());
        for (Student student : cs101.getEnrolledStudents()) {
            System.out.println("  - " + student.getName());
        }


        // ===== STEP 11: Drop Course (ASSOCIATION) =====
        System.out.println("\n\n--- STEP 11: Dropping a Course ---");

        if (student2.dropCourse(cs101)) {
            System.out.println("✓ " + student2.getName() + " dropped " + cs101.getCourseName());
        }

        cs101.displayCourseInfo();


        // ===== STEP 12: Final Summary (All Concepts Demonstrated) =====
        System.out.println("\n\n" + "=".repeat(70));
        System.out.println("   SYSTEM SUMMARY - All 8 OOP Concepts Demonstrated");
        System.out.println("=".repeat(70));

        System.out.println("\n1. ENCAPSULATION: ");
        System.out.println("   ✓ Private GPA, salary, tuition - accessed only through methods");
        System.out.println("   ✓ updateGrade() method controls grade modifications");

        System.out.println("\n2. INHERITANCE:");
        System.out.println("   ✓ Student → UndergraduateStudent, GraduateStudent");
        System.out.println("   ✓ Faculty → Professor");
        System.out.println("   ✓ Person → Student, Faculty (hierarchy established)");

        System.out.println("\n3. POLYMORPHISM:");
        System.out.println("   ✓ displayDashboard() - different for each class");
        System.out.println("   ✓ getRole() - returns specific role per class");

        System.out.println("\n4. ABSTRACTION:");
        System.out.println("   ✓ Abstract Person and Faculty classes");
        System.out.println("   ✓ Cannot create generic Person objects directly");

        System.out.println("\n5. INTERFACES:");
        System.out.println("   ✓ Enrollable - implemented by Students");
        System.out.println("   ✓ Teachable - implemented by Professor");
        System.out.println("   ✓ Researchable - implemented by Professor and GraduateStudent");
        System.out.println("   ✓ Payable - implemented by Students and Faculty");

        System.out.println("\n6. COMPOSITION (Strong Ownership):");
        System.out.println("   ✓ Student HAS-A Transcript (dies with student)");
        System.out.println("   ✓ Course HAS-A Syllabus (dies with course)");
        System.out.println("   ✓ Faculty HAS-A ResearchProfile (dies with faculty)");

        System.out.println("\n7. AGGREGATION (Weak Ownership):");
        System.out.println("   ✓ Course HAS-A Professor (professor exists independently)");
        System.out.println("   ✓ Department HAS-A Faculty (faculty can change departments)");

        System.out.println("\n8. ASSOCIATION:");
        System.out.println("   ✓ Many-to-Many: Students ↔ Courses");
        System.out.println("   ✓ One-to-Many: Professor → Multiple Courses");
        System.out.println("   ✓ One-to-One: Student ↔ Transcript");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("   Academic Operations Completed Successfully!");
        System.out.println("=".repeat(70) + "\n");


        // ===== STEP 13: Department Management (COMPOSITION) =====
        System.out.println("\n\n--- STEP 13: Department Management (COMPOSITION) ---");

        // COMPOSITION: Department creates and owns Budget
        Department csDept = new Department("DEPT001", "Computer Science", prof1, 500000);

        // AGGREGATION: Add faculty members (they exist independently)
        csDept.addFaculty(prof1);
        csDept.addFaculty(prof2);

        // AGGREGATION: Add course offerings (courses exist independently)
        csDept.addCourseOffering(cs101);
        csDept.addCourseOffering(cs201);
        csDept.addCourseOffering(cs301);

        csDept.displayDepartmentInfo();

        // COMPOSITION: Access budget through department
        System.out.println("\n[Department Budget Operations]");
        csDept.getBudget().allocateBudget(50000); // Allocate for resources
        csDept.getBudget().allocateBudget(30000); // Allocate for scholarships


        // ===== STEP 14: Library System (AGGREGATION) =====
        System.out.println("\n\n--- STEP 14: Library Management (AGGREGATION) ---");

        // AGGREGATION: Library HAS-A Books (books exist independently)
        Library mainLibrary = new Library("LIB001", "TechVerse Central Library");

        // Add books to catalog
        Book book1 = new Book("B001", "Introduction to Algorithms", "Thomas Cormen", "978-0262033848", 5);
        Book book2 = new Book("B002", "Design Patterns", "Gang of Four", "978-0201633610", 3);
        Book book3 = new Book("B003", "Clean Code", "Robert Martin", "978-0132350884", 4);

        mainLibrary.addBook(book1);
        mainLibrary.addBook(book2);
        mainLibrary.addBook(book3);

        mainLibrary.displayLibraryCatalog();

        // ENCAPSULATION: Check borrowing limits by role
        System.out.println("\n[Borrowing Limits by Role]");
        System.out.println("Student Limit: " + mainLibrary.getBorrowingLimit("Student") + " books");
        System.out.println("Faculty Limit: " + mainLibrary.getBorrowingLimit("Faculty") + " books");
        System.out.println("PhD Limit: " + mainLibrary.getBorrowingLimit("PhD") + " books");

        // Student borrows book
        System.out.println("\n[Book Borrowing Process]");
        Book borrowedBook = mainLibrary.findBook("Introduction to Algorithms");
        if (borrowedBook != null && borrowedBook.borrowBook()) {
            Borrowing borrowing1 = new Borrowing("BOR001", student1, borrowedBook);
            System.out.println("✓ " + student1.getName() + " borrowed: " + borrowedBook.getTitle());
            borrowing1.displayBorrowingInfo();

            // Return book
            System.out.println("\n[Book Return Process]");
            borrowing1.returnBook();
        }


        // ===== STEP 15: Financial System - Scholarships =====
        System.out.println("\n\n--- STEP 15: Scholarship Management ---");

        // ENCAPSULATION: Create different types of scholarships
        Scholarship meritScholarship = new Scholarship("SCH001", "Dean's Merit Scholarship", "Merit-based", 2000);
        Scholarship needScholarship = new Scholarship("SCH002", "Need-based Aid", "Need-based", 1500);
        Scholarship researchScholarship = new Scholarship("SCH003", "Research Excellence", "Research", 3000);

        // Award scholarships to students
        meritScholarship.awardToStudent(student1);
        needScholarship.awardToStudent(student2);
        researchScholarship.awardToStudent(student3);

        System.out.println("\n[Active Scholarships]");
        meritScholarship.displayScholarshipInfo();
        needScholarship.displayScholarshipInfo();
        researchScholarship.displayScholarshipInfo();


        // ===== STEP 16: Financial System - Payments =====
        System.out.println("\n\n--- STEP 16: Payment Processing ---");

        // ENCAPSULATION: Create payment records
        Payment tuitionPayment = new Payment("PAY001", student1, 15000, "Tuition");
        Payment feePayment = new Payment("PAY002", student2, 500, "Lab Fee");

        System.out.println("\n[Before Payment Processing]");
        tuitionPayment.displayPaymentInfo();
        feePayment.displayPaymentInfo();

        System.out.println("\n[Processing Payments]");
        tuitionPayment.processPayment();
        feePayment.processPayment();

        System.out.println("\n[After Payment Processing]");
        tuitionPayment.displayPaymentInfo();
        feePayment.displayPaymentInfo();


        // ===== STEP 17: Facility Management - Classrooms =====
        System.out.println("\n\n--- STEP 17: Facility Management - Classrooms (ASSOCIATION) ---");

        // ASSOCIATION: One-to-Many (Classrooms assigned to Courses)
        Classroom room101 = new Classroom("ROOM001", "Science Building", "101", 30, true, true);
        Classroom room202 = new Classroom("ROOM002", "Engineering Building", "202", 25, true, false);

        System.out.println("\n[Classroom Information]");
        room101.displayClassroomInfo();
        room202.displayClassroomInfo();

        // Assign courses to classrooms
        System.out.println("\n[Assigning Courses to Classrooms]");
        room101.assignCourse(cs101);
        room202.assignCourse(cs201);


        // ===== STEP 18: Facility Management - Offices =====
        System.out.println("\n\n--- STEP 18: Facility Management - Offices (ASSOCIATION) ---");

        // ASSOCIATION: One-to-One (Offices assigned to Professors)
        Office office301 = new Office("OFF001", "Administration Building", "301", "555-3001");
        Office office302 = new Office("OFF002", "Administration Building", "302", "555-3002");

        System.out.println("\n[Office Assignments]");
        office301.assignProfessor(prof1);
        office302.assignProfessor(prof2);

        office301.displayOfficeInfo();
        office302.displayOfficeInfo();


        // ===== STEP 19: BONUS - Notification System =====
        System.out.println("\n\n--- STEP 19: BONUS - Notification System ---");

        Notification enrollmentNotif = new Notification("NOT001", student1.getName(), "Enrollment",
                "You have successfully enrolled in CS101: Introduction to Programming");

        Notification gradeNotif = new Notification("NOT002", student1.getName(), "Grade",
                "Your grade for CS101 has been updated: A");

        Notification paymentNotif = new Notification("NOT003", student1.getName(), "Payment",
                "Payment of $15000 received. Thank you!");

        System.out.println("\n[Sending Notifications]");
        enrollmentNotif.sendNotification();
        System.out.println();
        gradeNotif.sendNotification();
        System.out.println();
        paymentNotif.sendNotification();


        // ===== STEP 20: BONUS - Attendance Tracking =====
        System.out.println("\n\n--- STEP 20: BONUS - Attendance Tracking ---");

        AttendanceRecord attendance1 = new AttendanceRecord("ATT001", student1, cs101, 15);

        System.out.println("\n[Recording Attendance]");
        attendance1.markAttendance();
        attendance1.markAttendance();
        attendance1.markAttendance();
        attendance1.markAttendance();
        attendance1.markAttendance();

        System.out.println("✓ Attendance recorded for " + student1.getName() + " in " + cs101.getCourseCode());
        attendance1.displayAttendanceInfo();

        if (attendance1.getAttendancePercentage() >= 75) {
            System.out.println("✓ Attendance requirement met!");
        }


        // ===== STEP 21: BONUS - Waiting List Management =====
        System.out.println("\n\n--- STEP 21: BONUS - Waiting List Management ---");

        // Create a small capacity course to demonstrate waiting list
        Course cs102 = new Course("CS102", "Programming Advanced", 3, 2); // Only 2 seats
        cs102.assignInstructor(prof1);

        // Enroll students until full
        UndergraduateStudent tempStudent1 = new UndergraduateStudent("STU004", "Emma White", "emma@techverse.edu", "555-2004", "CS");
        UndergraduateStudent tempStudent2 = new UndergraduateStudent("STU005", "Frank Green", "frank@techverse.edu", "555-2005", "CS");
        UndergraduateStudent tempStudent3 = new UndergraduateStudent("STU006", "Grace Lee", "grace@techverse.edu", "555-2006", "CS");

        System.out.println("\n[Filling Course Capacity]");
        tempStudent1.enrollInCourse(cs102);
        tempStudent2.enrollInCourse(cs102);

        // Create waiting list
        WaitingList waitlist = new WaitingList("WL001", cs102);

        // Third student added to waiting list
        System.out.println("\n[Adding to Waiting List]");
        if (!tempStudent3.enrollInCourse(cs102)) {
            waitlist.addToWaitingList(tempStudent3);
        }

        System.out.println("✓ Waiting List Count: " + waitlist.getWaitingCount());


        // ===== STEP 22: BONUS - Alumni System =====
        System.out.println("\n\n--- STEP 22: BONUS - Alumni System ---");

        Alumni alumni1 = new Alumni("ALM001", "David Park", "2023", "Bachelor of Science in Computer Science");
        Alumni alumni2 = new Alumni("ALM002", "Lisa Zhang", "2022", "Master of Science in Data Science");

        System.out.println("\n[Alumni Records]");
        alumni1.updateEmployment("Google", "Software Engineer");
        alumni2.updateEmployment("Microsoft", "ML Engineer");

        alumni1.displayAlumniInfo();
        System.out.println();
        alumni2.displayAlumniInfo();


        // ===== STEP 23: BONUS - Schedule Conflict Detection =====
        System.out.println("\n\n--- STEP 23: BONUS - Schedule Conflict Detection ---");

        ScheduleConflictChecker conflictChecker = new ScheduleConflictChecker();

        // Create class sessions
        ClassSession session1 = new ClassSession("ROOM001", "FAC001", "Monday", "10:00 AM");
        ClassSession session2 = new ClassSession("ROOM001", "FAC002", "Monday", "11:00 AM");
        ClassSession session3 = new ClassSession("ROOM002", "FAC001", "Monday", "10:00 AM");

        conflictChecker.addSession(session1);
        conflictChecker.addSession(session2);
        conflictChecker.addSession(session3);

        System.out.println("\n[Checking for Schedule Conflicts]");

        if (conflictChecker.isClassroomAvailable("ROOM001", "Monday", "10:00 AM")) {
            System.out.println("✓ ROOM001 Monday 10:00 AM: Available");
        } else {
            System.out.println("✗ ROOM001 Monday 10:00 AM: CONFLICT DETECTED!");
        }

        if (conflictChecker.isClassroomAvailable("ROOM001", "Monday", "12:00 PM")) {
            System.out.println("✓ ROOM001 Monday 12:00 PM: Available");
        }

        if (conflictChecker.isProfessorAvailable("FAC001", "Monday", "10:00 AM")) {
            System.out.println("✓ FAC001 Monday 10:00 AM: Available");
        } else {
            System.out.println("✗ FAC001 Monday 10:00 AM: CONFLICT DETECTED!");
        }

        if (conflictChecker.isProfessorAvailable("FAC001", "Tuesday", "10:00 AM")) {
            System.out.println("✓ FAC001 Tuesday 10:00 AM: Available");
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("   Complete University Management System Demonstrated!");
        System.out.println("   All Core Systems + Department + Library + Financial +");
        System.out.println("   Facility Management + Bonus Features Implemented!");
        System.out.println("=".repeat(70) + "\n");
    }
}
