package org.launchcode.springbootAPI.service;

import org.launchcode.springbootAPI.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}
