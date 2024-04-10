package ll;

// we "dont know" that what we "dont know"

import java.io.*;
import java.util.Scanner;

public class MyLinkedListTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101,"Jack",10000);
        Employee emp2 = new Employee(102,"Jane",20000);
        Employee emp3 = new Employee(103,"Jill",30000);
        Employee emp4 = new Employee(104,"Jaime",40000);
        Employee emp5 = new Employee(105,"Jocelyn",50000);
        Employee emp6 = new Employee(106,"John",60000);
        MyLinkedList list = new MyLinkedList();
        MyLinkedList list1 = new MyLinkedList();
//
//        list.add(emp1);
//        list.add(emp2);
//        list.add(emp3);
////        list.addFirst(emp4);
////        list.insertAt(emp5, 102);
////        list.add(emp6);
////        list.insertAt(emp4, 105);
//        list.printAll();
//        System.out.println();
//        list.saveFile(list);
         list1 = list.retrieveFile();
         list1.printAll();
////        list.deleteStart();
////        list.deleteEmpNumber(105);
////        list.deleteEnd();
////        list.deleteAll();
//        list.modify(104);
//        list.printAll();
//        list.modify(101);
//        list.printAll();

    }
}

class MyLinkedList implements Serializable
{
    Employee start=null;
    Employee current=null;

    void add(Employee node) {
        if(start==null) {
            start = node; //first object
            current = node;
            start.next = null;
            start.prev = null;
        }
        else {
            current.next = node; //2nd object
            node.prev = current;
            current = node;
        }
    }
    void addFirst(Employee node){
        Employee temp = null;
        if(start==null){
            start = node;
            current = node;
            start.next = null;
            start.prev = null;
        }
        else{
            temp = start;
            start = node;
            start.next = temp;
            start.prev = null;
            temp.prev = start;

        }
    }
    void insertAt(Employee node, int number) {
        Employee ptr = start;
        while (ptr != null) {
            if (ptr.getEmpNumber() == number) {
                Employee temp = ptr.next;
                ptr.next = node;
                node.prev = ptr;
                node.next = temp;
                if (temp != null) {
                    temp.prev = node;
                }
                break;
            } else {
                ptr = ptr.next;
            }
        }
    }

    void printAll() {
        Employee ptr = start;
        while(ptr!=null) {
            System.out.println(ptr.hashCode()+" "+ptr.show());
            ptr = ptr.next;
        }

    }
    void deleteStart() {
        if (start != null) {
            Employee ptr = start.next;
            if (ptr != null) {
                ptr.prev = null;
            }
            start = ptr;
        }
    }
    void deleteEmpNumber(int number) {
        Employee current = start;
        while (current != null) {
            if (current.getEmpNumber() == number) {
                Employee prevNode = current.prev;
                Employee nextNode = current.next;

                if (prevNode == null) {
                    start = nextNode;
                } else {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                current.prev = null;
                current.next = null;
                return;
            }
            current = current.next;
        }

    }
    void deleteEnd() {
        if (start == null) {
            System.out.println("Empty List");
        }

        if (start.next == null) {
            start = null;
            return;
        }

        Employee current = start;
        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;
    }
    void deleteAll() {
        Employee current = start;
        while (current != null) {
            Employee nextNode = current.next;
            current.prev = null;
            current.next = null;
            current = nextNode;
        }
        start = null;
    }

    void modify(int number) {
        Employee current = start;
        while (current != null) {
            if (current.getEmpNumber() == number) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter name: ");
                String username = scanner.nextLine();
                current.setEmpName(username);
                System.out.println("Enter Salary: ");
                float salary = scanner.nextFloat();
                current.setEmpSalary(salary);
                return;
            }
            current = current.next;
        }
    }
    void saveFile(MyLinkedList list){
//        Employee current = start;
//        while(current!=null){
            try {
                FileOutputStream stream = new FileOutputStream("file.ser");
                ObjectOutputStream outputStream = new ObjectOutputStream(stream);
                outputStream.writeObject(list);
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//        }

    }
    MyLinkedList retrieveFile(){
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream("file.ser"));
            MyLinkedList retrieved = (MyLinkedList) stream.readObject();
//            System.out.println(retrieved);
            return retrieved;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void joinLL(MyLinkedList list1, MyLinkedList list2){

    }
}

class Employee implements Serializable
{
    private int empNumber;
    private String empName;
    private float empSalary;

    @Override
    public String toString() {
        return "Employee{" +
                "empNumber=" + empNumber +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

    Employee next;
    Employee prev;

    public Employee(int empNumber, String empName, float empSalary) {
        super();
        this.empNumber = empNumber;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }


    public String show() {
        if(this.prev==null )
            return prev+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();
        else
        if(this.next==null)
            return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next;
        else
            return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();

    }


}