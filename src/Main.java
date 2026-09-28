import java.util.Scanner;

import graph.CampusGraph;
import hashing.StudentHashTable;
import queue.ServiceQueue;
import stack.ActionStack;
import student.Student;
import student.StudentLinkedList;
import tree.StudentBST;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentLinkedList studentList = new StudentLinkedList();
    private static final ActionStack actionStack = new ActionStack();
    private static final ServiceQueue serviceQueue = new ServiceQueue();
    private static final StudentBST studentBST = new StudentBST();
    private static final StudentHashTable hashTable = new StudentHashTable(10);
    private static final CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        addSampleData();

        int choice;
        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentList.displayStudents();
                    break;
                case 5:
                    addServiceRequest();
                    break;
                case 6:
                    processNextServiceRequest();
                    break;
                case 7:
                    displayRecentActions();
                    break;
                case 8:
                    System.out.println("Students in BST in-order traversal (numeric IDs):");
                    studentBST.displayStudents();
                    break;
                case 9:
                    searchStudentUsingHashing();
                    break;
                case 10:
                    addCampusLocation();
                    break;
                case 11:
                    removeCampusLocation();
                    break;
                case 12:
                    addCampusConnection();
                    break;
                case 13:
                    removeCampusConnection();
                    break;
                case 14:
                    campusGraph.displayConnections();
                    break;
                case 15:
                    traverseCampusLocations();
                    break;
                case 16:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number from 1 to 16.");
            }
        } while (choice != 16);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nUniversity Student Record and Campus Route Management System");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST/AVL");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS or DFS");
        System.out.println("16. Exit");
    }

    private static void addSampleData() {
        addStudentRecord(new Student("1001", "Amina Patel", "Computer Science", 91.5));
        addStudentRecord(new Student("1002", "Noah Williams", "Information Systems", 87.0));

        campusGraph.addLocation("Main Gate");
        campusGraph.addLocation("Library");
        campusGraph.addLocation("Science Block");
        campusGraph.addLocation("Student Centre");
        campusGraph.addConnection("Main Gate", "Library");
        campusGraph.addConnection("Library", "Science Block");
        campusGraph.addConnection("Library", "Student Centre");
    }

    private static void addStudent() {
        String studentID = readText("Student ID: ");
        String name = readText("Name: ");
        String programme = readText("Programme: ");
        double marks = readDouble("Marks: ");

        if (addStudentRecord(new Student(studentID, name, programme, marks))) {
            System.out.println("Student record added.");
            recordAction("Added student record " + studentID);
        } else {
            System.out.println("A student with that ID already exists.");
        }
    }

    private static boolean addStudentRecord(Student student) {
        if (!studentList.addStudent(student)) {
            return false;
        }

        Integer numericID = parseNumericStudentID(student.getStudentID());
        if (numericID != null) {
            if (!studentBST.search(numericID)) {
                studentBST.insert(numericID);
            }
            if (!hashTable.searchByID(numericID)) {
                hashTable.insert(numericID);
            }
        }
        return true;
    }

    private static void updateStudent() {
        String studentID = readText("Student ID to update: ");
        if (studentList.searchStudent(studentID) == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readText("New name: ");
        String programme = readText("New programme: ");
        double marks = readDouble("New marks: ");
        if (studentList.updateStudent(studentID, name, programme, marks)) {
            System.out.println("Student record updated.");
            recordAction("Updated student record " + studentID);
        } else {
            System.out.println("Student record could not be updated.");
        }
    }

    private static void deleteStudent() {
        String studentID = readText("Student ID to delete: ");
        if (!studentList.deleteStudent(studentID)) {
            System.out.println("Student not found.");
            return;
        }

        Integer numericID = parseNumericStudentID(studentID);
        if (numericID != null) {
            studentBST.delete(numericID);
            hashTable.remove(numericID);
        }
        System.out.println("Student record deleted.");
        recordAction("Deleted student record " + studentID);
    }

    private static void addServiceRequest() {
        String request = readText("Service request: ");
        serviceQueue.enqueue(request);
        System.out.println("Service request added to the queue.");
        recordAction("Added service request: " + request);
    }

    private static void processNextServiceRequest() {
        if (serviceQueue.isEmpty()) {
            System.out.println("There are no service requests to process.");
            return;
        }

        String request = serviceQueue.dequeue();
        System.out.println("Processed request: " + request);
        recordAction("Processed service request: " + request);
    }

    private static void displayRecentActions() {
        if (actionStack.isEmpty()) {
            System.out.println("There are no recent actions.");
            return;
        }
        actionStack.displayHistory();
    }

    private static void searchStudentUsingHashing() {
        int studentID = readNonNegativeInt("Numeric student ID to search: ");
        if (hashTable.searchByID(studentID)) {
            System.out.println("Student ID " + studentID + " found in the hash table.");
            Student student = studentList.searchStudent(Integer.toString(studentID));
            if (student != null) {
                student.display();
            }
        } else {
            System.out.println("Student ID not found in the hash table.");
        }
    }

    private static void addCampusLocation() {
        String location = readText("Campus location name: ");
        campusGraph.addLocation(location);
        System.out.println("Location added if the name was valid.");
        recordAction("Added campus location: " + location);
    }

    private static void removeCampusLocation() {
        String location = readText("Campus location to remove: ");
        campusGraph.removeLocation(location);
        System.out.println("Location removed if it existed, along with its connections.");
        recordAction("Removed campus location: " + location);
    }

    private static void addCampusConnection() {
        String firstLocation = readText("First location: ");
        String secondLocation = readText("Second location: ");
        campusGraph.addConnection(firstLocation, secondLocation);
        System.out.println("Connection added if both locations exist and are different.");
        recordAction("Added campus connection: " + firstLocation + " - " + secondLocation);
    }

    private static void removeCampusConnection() {
        String firstLocation = readText("First location: ");
        String secondLocation = readText("Second location: ");
        campusGraph.removeConnection(firstLocation, secondLocation);
        System.out.println("Connection removed if it existed.");
        recordAction("Removed campus connection: " + firstLocation + " - " + secondLocation);
    }

    private static void traverseCampusLocations() {
        String traversalType;
        do {
            traversalType = readText("Choose traversal (BFS or DFS): ");
            if (!traversalType.equalsIgnoreCase("BFS") && !traversalType.equalsIgnoreCase("DFS")) {
                System.out.println("Enter BFS or DFS.");
            }
        } while (!traversalType.equalsIgnoreCase("BFS") && !traversalType.equalsIgnoreCase("DFS"));

        String startLocation = readText("Starting location: ");
        if (traversalType.equalsIgnoreCase("BFS")) {
            System.out.println("BFS traversal: " + campusGraph.bfs(startLocation));
        } else {
            System.out.println("DFS traversal: " + campusGraph.dfs(startLocation));
        }
    }

    private static void recordAction(String action) {
        actionStack.push(action);
    }

    private static Integer parseNumericStudentID(String studentID) {
        try {
            int numericID = Integer.parseInt(studentID);
            return numericID >= 0 ? numericID : null;
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static int readNonNegativeInt(String prompt) {
        int value;
        do {
            value = readInt(prompt);
            if (value < 0) {
                System.out.println("Please enter zero or a positive number.");
            }
        } while (value < 0);
        return value;
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}