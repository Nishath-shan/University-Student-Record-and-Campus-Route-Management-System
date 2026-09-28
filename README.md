# University Student Record and Campus Route Management System

## Project Description

The University Student Record and Campus Route Management System is a Java console-based application developed for the CIT300 Data Structures and Algorithms assignment.

The system demonstrates the practical implementation of different data structures to manage student records, service requests, actions, and campus routes.

## Implemented Data Structures

### 1. Linked List - Student Record Management
- Add student records
- Update student records
- Delete student records
- Display all student records

### 2. Stack - Action History Management
- Store recent system actions
- Display action history

### 3. Queue - Service Request Management
- Add student service requests
- Process next service request

### 4. Binary Search Tree (BST)
- Insert student records
- Search students using Student ID
- Display student traversal

### 5. Hash Table
- Store student records using hashing
- Search students efficiently using Student ID

### 6. Graph - Campus Route Management
- Add campus locations
- Remove campus locations
- Add campus connections/roads
- Remove campus connections/roads
- Display campus connections
- Perform BFS and DFS traversal


## System Menu

The system provides the following operations:

1. Add Student Record  
2. Update Student Record  
3. Delete Student Record  
4. Display All Records using Linked List  
5. Add Service Request to Queue  
6. Process Next Service Request  
7. Display Recent Actions using Stack  
8. Display Students using BST/AVL  
9. Search Student using Hashing  
10. Add Campus Location  
11. Remove Campus Location  
12. Add Campus Connection/Road  
13. Remove Campus Connection/Road  
14. Display Campus Connections  
15. Traverse Campus Locations using BFS or DFS  
16. Exit  


## Technologies Used

- Java
- Object-Oriented Programming
- Data Structures and Algorithms
- GitHub


## Project Structure

```
src/
│
├── student/
│   ├── Student.java
│   └── StudentLinkedList.java
│
├── stack/
│   └── ActionStack.java
│
├── queue/
│   └── ServiceQueue.java
│
├── tree/
│   └── StudentBST.java
│
├── hashing/
│   └── StudentHashTable.java
│
├── graph/
│   └── CampusGraph.java
│
└── Main.java
```


## Team Members

| Member | Responsibility |
|---|---|
| Mohammed Azam | Student Record Management using Linked List |
| M.I. Rimas Ahamad | Stack and Queue Implementation |
| H.K. Chathurika Harshani | BST and Hashing Implementation |
| Nishath | Graph Implementation, BFS/DFS, System Integration |


## How to Run

1. Open the project folder in Visual Studio Code.

2. Open terminal and go to the `src` folder.

3. Compile the project:

```
javac graph/*.java hashing/*.java queue/*.java stack/*.java student/*.java tree/*.java Main.java
```

4. Run the system:

```
java Main
```


## Conclusion

This project demonstrates the use of fundamental data structures in solving a university management system problem. Each data structure is integrated to perform efficient record management, searching, processing, and campus route operations.