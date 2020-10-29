package com.mindex.challenge.controller;


import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private CompensationService compensationService;


    @GetMapping("/compensation/read/{id}")
    public List<Compensation> read(@PathVariable String id){
        /**
         * Endpoint for getting the compensation as per the employee ID:
         */
        LOG.debug("Recieved Compensation for the GET request for the employee ID [{}]", id);
        return compensationService.GetCompensationByEmpID(id);
    }

    @PostMapping("/compensation/create")
    public Compensation create(@RequestBody Compensation com_employee) {
        /**
         *  Endpoint Created for creating the structure of the compensation.
         */
        LOG.debug("Compensation Recieved");
        LOG.debug("Received Compensation employee create request for [{}]", com_employee.toString());

        return compensationService.Create(com_employee);
    }
}
