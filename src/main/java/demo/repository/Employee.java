package demo.repository;


import javax.persistence.*;



/**
 * Created by Naveen Bensily on 6/20/15.
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {


    public Employee(){

    }


    public Employee(String employeeText){
        this.employeeText=employeeText;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public String getEmployeeText() {
        return employeeText;
    }

    public void setEmployeeText(String employeeText) {
        this.employeeText = employeeText;
    }

    @Column(name="employee_text")
    private String employeeText;






}
