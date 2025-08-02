package com.tainnt.awsdemo.daos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * @author Tai Nguyen
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private int old;
}
