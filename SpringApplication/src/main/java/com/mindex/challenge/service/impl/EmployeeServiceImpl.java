package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStruct;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);
        if(employee.getEmployeeId()==null)
            employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    @Override
    public ReportingStruct getReportingStructure(String id) {
        if(id==null|| id.isEmpty())
            throw new NullPointerException("No Employee id.");

        Employee employee = read(id);
        // if no employee found in the DB with this id we move ahead.
        if(employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        int numOfDirectReports = getDistinct_Direct_Emp_Reports(employee);

        ReportingStruct reportingStruct = new ReportingStruct();
        reportingStruct.setEmployee(employee);
        reportingStruct.setNumberOfReports(numOfDirectReports);
        return reportingStruct; // returning the reporting struct variable:

    }




    /**
     *
     * @param emp: employee
     * @return : returning total direct reports
     */
    private int getDistinct_Direct_Emp_Reports(Employee emp) {
//        Employee employee = read(id);
        int totdirectReports =0; // base case is 0

        // the assumption here is that no two employees on the same level report to eachother:
        // hierarchy of the employee is maintained.
        // the boss doesnt report his subordinates : so no cycles are to be found in the graph:

        List<Employee> TotalDirectReports_list = emp.getDirectReports();

        // performing a DFS operation on the number of employees present:
        if(TotalDirectReports_list==null || TotalDirectReports_list.isEmpty())
            return totdirectReports;
        else{
            totdirectReports+=emp.getDirectReports().size();
            for(Employee emp_temp: TotalDirectReports_list){
//                totdirectReports=totdirectReports+1+getDistinct_Direct_Emp_Reports(emp.getEmployeeId());
                totdirectReports+=getDistinct_Direct_Emp_Reports(read(emp_temp.getEmployeeId()))
;            }
        }
        // returning a total direct distinct report
        return totdirectReports;
    }
}
