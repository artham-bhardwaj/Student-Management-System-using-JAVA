/*
 * Problem: Student Management System
 * 
 * This program is designed to manage basic student records. The system provides
 * functionalities such as:
 * 1. Adding a new student with their ID, name, age, and marks.
 * 2. Displaying all the students currently in the system.
 * 3. Finding the student with the highest marks.
 * 4. Calculating the average marks of all students.
 * 5. Deleting a student by their ID.
 * 
 * Approach:
 * - We use an ArrayList to store student objects dynamically, as it allows for easy
 *   addition and removal of students.
 * - The Student class encapsulates all relevant details for each student (ID, name, age, marks).
 * - A menu-driven interface is provided to the user for selecting different operations.
 * - For each operation, a separate method is implemented, ensuring clean and modular code:
 *    - `addStudent()` to add a new student.
 *    - `displayAllStudents()` to list all students.
 *    - `findHighestMarks()` to find and display the student with the highest marks.
 *    - `calculateAverageMarks()` to compute the class average.
 *    - `deleteStudentById()` to remove a student from the list based on their ID.
 * - Input is handled using the Scanner class, and the program loops until the user decides to exit.
 * 
 * This system is extendable and can be improved by adding features like persistence, editing details,
 * or advanced search functionalities.
 */


import java.util.ArrayList;
import java.util.Scanner;

// Class representing a student
class Student {
    int id;
    String name;
    int age;
    double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}

// Main class to manage students
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student with Highest Marks");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    findHighestMarks();
                    break;
                case 4:
                    calculateAverageMarks();
                    break;
                case 5:
                    deleteStudentById();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Method to add a new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, age, marks));
        System.out.println("Student added successfully!");
    }

    // Method to display all students
    public static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                student.display();
            }
        }
    }

    // Method to find the student with the highest marks
    public static void findHighestMarks() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.marks > topStudent.marks) {
                topStudent = student;
            }
        }

        System.out.println("Student with highest marks:");
        topStudent.display();
    }

    // Method to calculate the average marks of all students
    public static void calculateAverageMarks() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.marks;
        }

        double averageMarks = totalMarks / students.size();
        System.out.println("Average marks of the class: " + averageMarks);
    }

    // Method to delete a student by ID
    public static void deleteStudentById() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
