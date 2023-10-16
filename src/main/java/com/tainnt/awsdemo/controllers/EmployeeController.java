package com.tainnt.awsdemo.controllers;

import com.tainnt.awsdemo.daos.Employee;
import com.tainnt.awsdemo.sevices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployee()
    {
        // return value.
        return employeeService.getListEmployee();
    }
}
