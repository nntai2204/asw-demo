package com.tainnt.awsdemo.controllers;

import com.tainnt.awsdemo.daos.Employee;
import com.tainnt.awsdemo.sevices.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private List<Integer> todoList;

    @PostConstruct
    public void init() {
        todoList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @GetMapping("/todo/{todoId}")
    public Integer getTodo(@PathVariable(name = "todoId") Integer todoId) {
        return todoList.get(todoId);
    }
    @GetMapping("/employee")
    public List<Employee> getEmployee()
    {
        return employeeService.getListEmployee();
    }
}
