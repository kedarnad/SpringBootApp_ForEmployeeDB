package com.mindex.challenge.controller;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStruct;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Making a rest controller for the Reporting Struct
 */
@RestController
public class ReportingStructController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructController.class);

    @Autowired //creating an for the Employee Service
    private EmployeeService employeeService;

    @GetMapping("/reportingStruct/{id}") //because we would want to query on the id:
    public ReportingStruct read(@PathVariable String id){
        LOG.debug("Fetching a GET request for employee with id: [{}]", id);

        return employeeService.getReportingStructure(id);
    }



}
