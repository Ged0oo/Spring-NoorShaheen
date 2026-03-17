package com.global.hr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {
	
	@Id
	@Column("ssn")
    private Long id;
	
    @Column("fname")
	private String name;
    
    @Column("salary")
    private Double salary;

    // Default Constructor
    public Employee() {
    }

    // Full Constructor
    public Employee(Long id, String name, Double salary) { 
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}