# Project Guidelines

## 1. Project Purpose

The **University Student Record and Campus Route Management System** is a Java console application developed for the CIT300 Data Structures and Algorithms assignment. The system is intended to manage student records and campus routes while demonstrating the practical use of fundamental data structures and algorithms.

The project should provide clear, reliable, and maintainable implementations for:

- Student record storage and management
- Searching and sorting student information
- Campus graph and route management
- Service request processing
- Action history and undo functionality

All features should support the academic objectives of the assignment and be implemented with appropriate data structures rather than unnecessary external frameworks.

## 2. Java Technology

- Use Java as the primary programming language.
- Use a Java version agreed upon by the team and configured consistently across all development environments.
- Keep the project compatible with standard Java libraries unless the team and lecturer approve additional dependencies.
- Follow object-oriented programming principles, including encapsulation, abstraction, and clear separation of responsibilities.
- Use meaningful class, method, and variable names that follow standard Java naming conventions.
- Add comments and documentation where they clarify algorithms, data-structure decisions, or non-obvious logic.
- Ensure the application can be compiled and run from the command line or the team's agreed development environment.

## 3. Folder Structure

Keep source files organized according to their responsibility:

```text
src/
├── Main.java
├── graph/
│   └── CampusGraph.java
├── hashing/
│   └── StudentHashTable.java
├── queue/
│   └── ServiceQueue.java
├── stack/
│   └── ActionStack.java
├── student/
│   ├── Student.java
│   └── StudentLinkedList.java
└── tree/
    └── StudentBST.java
```

Folder rules:

- Place the application entry point in `src/Main.java`.
- Place each data-structure implementation in the package folder that describes it.
- Place shared student-domain classes in `src/student/`.
- Keep tests, if added, in a separate test folder or in the structure agreed upon by the team.
- Do not place generated files, compiled `.class` files, IDE configuration files, or temporary files in the source folders.
- Update this document if the team adopts a significant structural change.

## 4. Team Member Responsibilities

Each team member should have a clearly assigned area of responsibility. Responsibilities may be shared, but ownership must be agreed upon before implementation begins.

- **Project coordination:** Maintain the task list, coordinate deadlines, and ensure the final system meets the assignment requirements.
- **Student records:** Develop and maintain `Student`, `StudentLinkedList`, and related student-record operations.
- **Hashing and searching:** Develop and test `StudentHashTable` and its collision-handling and lookup behavior.
- **Trees and sorting:** Develop and test `StudentBST` and its traversal or search operations.
- **Campus routes:** Develop and test `CampusGraph`, including vertices, edges, and route-related operations.
- **Queues and stacks:** Develop and test `ServiceQueue` and `ActionStack`, including their expected insertion, removal, and history behavior.
- **Integration and documentation:** Coordinate integration with `Main.java`, maintain project documentation, and support final testing.

Every member is responsible for reviewing their own changes, communicating blockers early, and helping test integrated functionality.

## 5. Git Branch Rules

- Keep the `main` branch stable and suitable for demonstration or submission.
- Create a separate branch for each feature, bug fix, or documentation task.
- Use descriptive branch names in lowercase with hyphens, for example:
  - `feature/student-search`
  - `feature/campus-route-management`
  - `fix/queue-removal`
  - `docs/project-guidelines`
- Do not commit unfinished or untested work directly to `main`.
- Keep branches focused on one logical task whenever possible.
- Pull the latest `main` changes before opening a pull request or merging.
- Use pull requests for team review when the repository workflow supports them.
- Delete merged branches when they are no longer needed.

## 6. Commit Message Rules

Write commit messages that explain the change clearly and briefly.

Use the following format:

```text
<type>: <short description>
```

Recommended types include:

- `feat`: Adds a new feature
- `fix`: Corrects a defect
- `refactor`: Changes implementation without changing behavior
- `test`: Adds or updates tests
- `docs`: Updates documentation
- `chore`: Performs maintenance or configuration work

Examples:

```text
feat: add student hash table lookup
fix: handle empty service queue
refactor: improve campus graph traversal

docs: add project contribution guidelines
```

Commit message rules:

- Use the imperative mood, such as `add`, `fix`, or `update`.
- Keep the subject line concise, preferably under 72 characters.
- Describe one logical change per commit.
- Do not commit generated files, credentials, or unrelated personal configuration.
- Confirm that the project builds before committing when the change affects source code.

## 7. Integration Rules

- Integrate changes into `main` only after the relevant code has been reviewed and tested.
- Before merging, update the branch from `main` and resolve conflicts carefully.
- Preserve existing functionality when adding new features.
- Check that package declarations, imports, class names, and method signatures remain consistent.
- Compile and run the complete application after integration.
- Test normal cases, empty collections, duplicate values, invalid input, and boundary conditions where relevant.
- Ensure that all data structures work together through `Main.java` without bypassing their intended interfaces.
- Do not merge code that fails to compile, introduces unresolved merge-conflict markers, or has known serious defects.
- Record significant design or integration decisions in the README or appropriate project documentation.
- The team should perform a final end-to-end review before submission to confirm that every member's contribution is included and the application meets the assignment requirements.
