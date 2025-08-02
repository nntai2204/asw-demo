package com.tainnt.awsdemo.sevices;

import com.tainnt.awsdemo.daos.Employee;
import com.tainnt.awsdemo.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tai Nguyen
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public List<Employee> getListEmployee(){

        List<Employee> result = new ArrayList<>();
        Employee employeeFirst = new Employee();
        employeeFirst.setName("Tai");
        employeeFirst.setOld(30);

        Employee employeeSecond = new Employee();
        employeeSecond.setName("Ut");
        employeeSecond.setOld(29);

        result.add(employeeFirst);
        result.add(employeeSecond);

        List<Employee> list = employeeRepo.findAll();
        if (!list.isEmpty()) {
            return list;
        }
        return result;
    }
}
