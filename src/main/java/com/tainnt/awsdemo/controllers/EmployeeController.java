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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private List<Integer> todoList;

    // bạn còn nhớ @PostConstruct dùng để làm gì chứ?
    // nếu không nhớ, hãy coi lại bài viết Spring Boot #3 nhé
    @PostConstruct
    public void init() {
        todoList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @GetMapping("/todo/{todoId}")
    public Integer getTodo(@PathVariable(name = "todoId") Integer todoId) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }
    @GetMapping("/employee")
    public List<Employee> getEmployee()
    {
        // return value.
        return employeeService.getListEmployee();
    }
}
