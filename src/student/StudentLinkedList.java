package student;

/** Stores student records in a linked-list structure. */
public class StudentLinkedList {
	private static class Node {
		private final Student student;
		private Node next;

		private Node(Student student) {
			this.student = student;
		}
	}

	private Node head;
	private int size;

	public boolean addStudent(Student student) {
		if (student == null || student.getStudentID() == null || searchStudent(student.getStudentID()) != null) {
			return false;
		}

		Node newNode = new Node(student);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
		return true;
	}

	public boolean updateStudent(String studentID, String name, String programme, double marks) {
		Student student = searchStudent(studentID);
		if (student == null) {
			return false;
		}

		student.setName(name);
		student.setProgramme(programme);
		student.setMarks(marks);
		return true;
	}

	public boolean deleteStudent(String studentID) {
		if (studentID == null || head == null) {
			return false;
		}

		if (head.student.getStudentID().equals(studentID)) {
			head = head.next;
			size--;
			return true;
		}

		Node previous = head;
		Node current = head.next;
		while (current != null) {
			if (current.student.getStudentID().equals(studentID)) {
				previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	public Student searchStudent(String studentID) {
		if (studentID == null) {
			return null;
		}

		Node current = head;
		while (current != null) {
			if (studentID.equals(current.student.getStudentID())) {
				return current.student;
			}
			current = current.next;
		}
		return null;
	}

	public void displayStudents() {
		if (head == null) {
			System.out.println("No student records.");
			return;
		}

		Node current = head;
		while (current != null) {
			current.student.display();
			current = current.next;
		}
	}

	public int size() {
		return size;
	}
}
