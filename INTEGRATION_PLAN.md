# Integration Plan

## Project

**University Student Record and Campus Route Management System**

## 1. Purpose of Integration

The purpose of integration is to combine the individual data-structure modules into one reliable Java console application. The final application will use `Main.java` as the entry point and provide a consistent menu through which users can manage student records, process services, search student information, and work with campus routes.

Integration should ensure that:

- Every module can be accessed through the application menu.
- Data is passed between modules consistently and safely.
- Each data structure is used for the task it was designed to support.
- User input is validated before it reaches the data structures.
- The complete application compiles, runs, and behaves as one system after all modules are merged.

## 2. How `Main.java` Will Connect the Modules

`Main.java` will create and manage the required objects, display the main menu, collect user input, and call the appropriate module operations. The module classes should retain responsibility for their own data-structure logic; `Main.java` should coordinate the workflow rather than duplicate that logic.

### Student Linked List

The student linked list will act as an ordered collection of student records.

`Main.java` will:

- Create a `StudentLinkedList` instance at application startup.
- Provide menu options to add, remove, display, and locate student records where supported.
- Validate student details before creating a `Student` object.
- Use the linked list as a source of student data for display and other workflows.

### Stack

The action stack will maintain a history of relevant user or system actions.

`Main.java` will:

- Create an `ActionStack` instance at startup.
- Record successful actions such as adding, removing, or updating a student record.
- Provide an option to view recent actions.
- Provide an undo option if undo behavior is implemented by the stack and supported by the application design.
- Ensure that only completed actions are added to the history.

### Queue

The service queue will manage student service requests in first-in, first-out order.

`Main.java` will:

- Create a `ServiceQueue` instance at startup.
- Allow a student or operator to add a service request.
- Display pending requests when requested.
- Process the next request in queue order.
- Handle an empty queue without terminating the application.

### Binary Search Tree

The binary search tree will support efficient ordered storage and searching of student records according to the agreed key, such as student ID.

`Main.java` will:

- Create a `StudentBST` instance at startup.
- Insert student records into the tree when they are added to the system.
- Use the tree for student search operations based on its ordering key.
- Provide traversal output where required, such as ascending student ID order.
- Keep the tree synchronized with supported student additions and removals.

### Hashing

The hash table will provide direct student lookup using a unique key, normally the student ID.

`Main.java` will:

- Create a `StudentHashTable` instance at startup.
- Insert each valid student record using its unique key.
- Use the hash table for fast record lookup.
- Handle duplicate keys according to the module's defined rules.
- Keep hash-table entries synchronized with supported student updates and removals.

### Graph

The campus graph will represent campus locations and the connections between them.

`Main.java` will:

- Create a `CampusGraph` instance at startup.
- Provide options to add or display campus locations and routes.
- Accept route information such as source location, destination location, and connection details where applicable.
- Call graph traversal or route-finding operations when a user requests a campus route.
- Validate that requested locations exist and handle unavailable routes clearly.

## 3. Final Menu Structure

The final console menu should use numbered options and return to the main menu after each completed operation. A proposed structure is:

```text
============================================
University Student Record and Campus Route
Management System
============================================
1. Student Records
2. Search Student by Hashing
3. Search Student Using BST
4. Display Students in Sorted Order
5. Service Queue
6. Action History and Undo
7. Campus Routes
8. Run System Summary
0. Exit
Enter your choice:
```

### Student Records Submenu

```text
1. Add student
2. Remove student
3. Display all students
4. Find student in linked list
0. Return to main menu
```

### Service Queue Submenu

```text
1. Add service request
2. View pending requests
3. Process next request
0. Return to main menu
```

### Action History Submenu

```text
1. View recent actions
2. Undo last supported action
0. Return to main menu
```

### Campus Routes Submenu

```text
1. Add campus location or connection
2. Display campus graph
3. Find route between locations
0. Return to main menu
```

The final menu may be adjusted to match the methods implemented by the modules, but every option must have a clear purpose and a safe return path.

## 4. Data Flow Explanation

The application will follow this general flow:

1. The program starts in `Main.main()`.
2. `Main.java` creates one instance of each data-structure class and initializes the console input mechanism.
3. The main menu is displayed and the user's selection is validated.
4. For a student-record operation, `Main.java` collects the required details and creates or identifies a `Student` object.
5. When a student is added successfully, the record is registered in the linked list, BST, and hash table as appropriate. A corresponding action is recorded in the stack.
6. When a student is searched, the user selects the appropriate search operation. The linked list, BST, or hash table performs the actual search and returns the result to `Main.java` for display.
7. When a service request is submitted, it is placed in the queue. Processing removes the next request according to FIFO order, and the action may be recorded in the stack.
8. For a campus-route operation, location and connection information is passed to the graph. Route requests call the graph's traversal or route-finding logic, and the result is displayed by `Main.java`.
9. After each operation, `Main.java` displays a success message, result, or validation error, then returns to the relevant menu.
10. The application continues until the user selects `0` to exit.

The student record modules should use the same unique student identifier and consistent record values. If a record is changed or removed, all structures that contain that record must be updated together so that searches and displays do not return stale information.

## 5. Testing Plan After Merging All Modules

Testing will be performed after each module has been merged into the integrated application and again before submission.

### Compilation and Startup

- Compile all Java source files together.
- Confirm that package declarations, imports, and class names are correct.
- Start the application and verify that the main menu is displayed.
- Confirm that selecting `0` exits cleanly.

### Module Integration Tests

- Add several valid student records and confirm that they appear in the linked list, BST, and hash table.
- Search for existing and non-existing students using each supported search method.
- Confirm that BST traversal produces the expected ordering.
- Test duplicate student IDs and verify that they are rejected or handled according to the agreed design.
- Remove a student and verify that the record is no longer returned by any search structure.
- Add multiple service requests and confirm FIFO processing order.
- Process an empty queue and verify that the program remains stable.
- Record actions and verify that action history reflects successful operations.
- Test supported undo operations and confirm that the affected data structures remain synchronized.
- Add campus locations and connections, then verify that graph display and route searches produce correct results.
- Request routes involving unknown locations and unavailable connections.

### Input and Boundary Tests

- Enter invalid menu choices, non-numeric input, blank values, and incorrectly formatted student details.
- Test empty data structures for every display, search, traversal, queue, stack, and graph operation.
- Test the smallest valid input and multiple records or connections.
- Confirm that invalid input produces a useful message and returns to a usable menu state.
- Confirm that no operation causes an unexpected application crash.

### Final End-to-End Test

Run a complete scenario in one session:

1. Add several students.
2. Search for them using hashing and the BST.
3. Display the linked-list records and sorted tree output.
4. Submit and process service requests.
5. Review the action history and test supported undo behavior.
6. Add campus locations and routes.
7. Find valid and invalid campus routes.
8. Remove or update a student and repeat the relevant searches.
9. Exit and restart the application to confirm clean startup behavior.

Record any defects found during testing, assign them to the appropriate team member, and rerun the affected tests after correction. The application should be considered ready for submission only when it compiles successfully, all main menu paths have been exercised, and the integrated modules produce consistent results.
