package ll;
public class LLNew {
    public static void main(String[] args) {

    }
}
class MyLinkedListNew {
    EmployeeNew start = null;
    EmployeeNew current = null;
    void add(EmployeeNew node){

    }

}
class EmployeeNew {
    private int empNumber;
    private String empName;
    private float empSalary;

    EmployeeNew next;
    EmployeeNew prev;

    public EmployeeNew() {
    }

    public EmployeeNew(int empNumber, String empName, float empSalary) {
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
}
