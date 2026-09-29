# University Student Record and Campus Route Management System

## CIT300 - Data Structures and Algorithms  
### Graded Practical Assignment 1

---

# Project Description

The **University Student Record and Campus Route Management System** is a Java-based console application developed for the CIT300 Data Structures and Algorithms assignment.

The purpose of this project is to demonstrate the practical application of different data structures to solve a real-world university management problem.

The system manages:

- Student records
- Student service requests
- Recent system actions
- Student searching operations
- Campus locations and route connections

The project integrates multiple data structures to efficiently store, process, search, and manage information.

---

# Team Details

| No | Member Name | Student ID | GitHub Username | Email | Role |
|---|---|---|---|---|---|
| 1 | M.R.M. Nishath | 23DA2-1016 | Nishath-shan | nishathrizvi@gmail.com | Team Leader |
| 2 | Mohammed Azam | 23DA2-1044 | azamamanulla1970 | azamamanulla1970@gmail.com | Member |
| 3 | M.I. Rimas Ahamad | 23DA2-0828 | rimasahamad2003-ctrl | ahamadrimas32@gmail.com | Member |
| 4 | H.K. Chathurika Harshani | 23DA2-0886 | 23da2-0886-bit | 23da2-0886@sltc.ac.lk | Member |

---

# Individual Responsibilities

## M.R.M. Nishath

**Responsibility:**
Graph Implementation, BFS/DFS Traversal, and System Integration

**Contribution:**

- Implemented campus route management using Graph
- Developed campus location management
- Developed campus connection management
- Implemented BFS traversal
- Implemented DFS traversal
- Integrated all modules into the final system
- Performed final testing and debugging


---

## Mohammed Azam

**Responsibility:**
Linked List and Student Record Management

**Contribution:**

- Implemented Student Record Management module
- Created student record structure
- Implemented adding student records
- Implemented updating student records
- Implemented deleting student records
- Implemented displaying student records using Linked List


---

## M.I. Rimas Ahamad

**Responsibility:**
Stack and Queue Implementation

**Contribution:**

- Implemented Stack for action history management
- Implemented recent action storage
- Implemented displaying action history
- Implemented Queue for student service requests
- Implemented adding and processing service requests


---

## H.K. Chathurika Harshani

**Responsibility:**
BST and Hashing Implementation

**Contribution:**

- Implemented Binary Search Tree functionality
- Implemented student organization using Student ID
- Implemented BST searching and traversal
- Implemented Hash Table functionality
- Implemented student searching using hashing


---

# Implemented Data Structures

## 1. Linked List - Student Record Management

The Linked List is used to store and manage student records dynamically.

Each student record contains:

- Student ID
- Student Name
- Programme
- Marks

Functions:

- Add Student Record
- Update Student Record
- Delete Student Record
- Display All Records


---

## 2. Stack - Action History Management

The Stack stores recent actions performed in the system.

Functions:

- Store recent actions
- Display action history

Principle:

**LIFO (Last In First Out)**


---

## 3. Queue - Service Request Management

The Queue manages student service requests according to arrival order.

Functions:

- Add Service Request
- Process Next Service Request
- Display Requests

Principle:

**FIFO (First In First Out)**


---

## 4. Binary Search Tree (BST)

The BST organizes student records based on Student ID.

Functions:

- Insert Student Record
- Search Student
- Display Traversal


---

## 5. Hash Table

The Hash Table provides efficient student searching.

Functions:

- Insert Student Records
- Search Student using Student ID
- Display Records


---

## 6. Graph - Campus Route Management

The Graph represents campus locations and connections.

Representation:

- Locations are vertices
- Roads/connections are edges

Functions:

- Add Campus Location
- Remove Campus Location
- Add Campus Connection/Road
- Remove Campus Connection/Road
- Display Campus Connections
- BFS Traversal
- DFS Traversal


---

# System Menu

```
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
```

---

# Technologies Used

- Java Programming Language
- Object-Oriented Programming
- Data Structures and Algorithms
- Visual Studio Code
- GitHub

---

# Project Structure

```
src/

├── Main.java
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
└── graph/
    └── CampusGraph.java
```

---

# GitHub Repository

Repository Link:

https://github.com/Nishath-shan/University-Student-Record-and-Campus-Route-Management-System

---

# GitHub Collaboration

GitHub was used for collaborative development.

The team followed:

- Separate branches for each member
- Individual commits
- Pull Requests
- Code reviews
- Merging changes into the main branch

---

# How to Run

### Step 1

Open the project folder in Visual Studio Code.


### Step 2

Navigate to the `src` folder.

```
cd src
```


### Step 3

Compile the project.

```bash
javac graph/*.java hashing/*.java queue/*.java stack/*.java student/*.java tree/*.java Main.java
```


### Step 4

Run the application.

```bash
java Main
```

---

# Demonstration Video

The final demonstration video includes:

- Project introduction
- System overview
- Individual member contributions
- Complete system functionality


Demonstration order:

1. **M.R.M. Nishath**
   - Project Introduction
   - Team Introduction
   - Graph Implementation
   - BFS/DFS Traversal
   - System Integration


2. **Mohammed Azam**
   - Linked List
   - Student Record Management


3. **M.I. Rimas Ahamad**
   - Stack
   - Queue


4. **H.K. Chathurika Harshani**
   - BST
   - Hashing


---

# Conclusion

This project demonstrates the practical use of Data Structures and Algorithms in developing a university management system.

Each implemented data structure contributes to efficient student record management, searching, service processing, and campus route management.

Through teamwork and GitHub collaboration, the team successfully developed a complete Java console-based application applying fundamental data structures to solve a real-world problem.