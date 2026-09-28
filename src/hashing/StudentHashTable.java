package hashing;

public class StudentHashTable {
    private class HashNode {
        int studentID;
        HashNode next;

        public HashNode(int id) {
            this.studentID = id;
            this.next = null;
        }
    }

    private HashNode[] table;
    private int size;

    public StudentHashTable(int size) {
        this.size = size;
        this.table = new HashNode[size];
    }

    private int hashFunction(int id) {
        return id % size;
    }

    public void insert(int id) {
        int bucketIndex = hashFunction(id);
        HashNode newNode = new HashNode(id);
        if (table[bucketIndex] == null) {
            table[bucketIndex] = newNode;
        } else {
            HashNode temp = table[bucketIndex];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean searchByID(int id) {
        int bucketIndex = hashFunction(id);
        HashNode temp = table[bucketIndex];
        while (temp != null) {
            if (temp.studentID == id) return true;
            temp = temp.next;
        }
        return false;
    }

    public void remove(int id) {
        int bucketIndex = hashFunction(id);
        HashNode temp = table[bucketIndex];
        HashNode prev = null;

        while (temp != null && temp.studentID != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null) {
            table[bucketIndex] = temp.next;
        } else {
            prev.next = temp.next;
        }
    }

    public void displayTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode temp = table[i];
            while (temp != null) {
                System.out.print(temp.studentID + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}

