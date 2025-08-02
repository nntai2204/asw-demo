package com.tainnt.awsdemo.repositories;

import com.tainnt.awsdemo.daos.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Tùy ý thêm method custom tại đây
}
