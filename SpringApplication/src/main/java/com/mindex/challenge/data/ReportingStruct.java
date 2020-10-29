package com.mindex.challenge.data;

public class ReportingStruct {

    /**
     * Number of reports should be the total reports under the employee which contains the number of direct reports and
     * distinct reports of all the employees under him.
     */
    private Employee employee;
    private int numberOfReports;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
