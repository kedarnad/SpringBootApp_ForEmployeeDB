package com.mindex.challenge.data;

import org.springframework.data.annotation.Transient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compensation {

    private Employee employee;
    private int salary;

    private Date effectiveDateFinalFormat; // effective date in the date format
//
    @Transient
    private String TrueFormat = "MM-dd-yyyy"; // making a transient variable
//
    @Transient // created the transient variable for particular date type format
    private SimpleDateFormat dateFormat= new SimpleDateFormat(TrueFormat); // specifying the generic format of the
                                                                        // date composition


    private String effectiveDate;

    @Override
    public String toString() {
        return "Compensation{" +
                "employee=" + employee +
                ", salary=" + salary +
                ", effectiveDateFinalFormat=" + effectiveDateFinalFormat +
                ", pattern='" + TrueFormat + '\'' +
                ", dateFormat=" + dateFormat +
                ", effectiveDate='" + effectiveDate + '\'' +
                '}';
    }

    public Compensation(){
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        String effectiveDate = dateFormat.format(this.effectiveDateFinalFormat); // converts the date format to its
                                                                                 //string Composition
        return effectiveDate; // string composition:
    }

    public void setEffectiveDate(String effectiveDate) throws ParseException {
        this.effectiveDate = effectiveDate;
        this.effectiveDateFinalFormat=this.dateFormat.parse(this.effectiveDate); // parsing the date in the correct date format:
    }
}
